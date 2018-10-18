package com.jtzh.common.page;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 *
 * ClassName: PagePlugin <br/>
 * Function: 分页插件. <br/>
 * Date: 2016年3月10日 下午5:11:06 <br/>
 *
 * @author qiaocf
 * @version 1.0
 * @since JDK 1.7
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagePlugin implements Interceptor {

    /** 日志 **/
    private static final Log LOG = LogFactory.getLog(PagePlugin.class);

    /** 数据库方言 **/
    private static String dialect = "mysql";
    /** mapper.xml中需要拦截的ID(正则匹配) **/
    private static String pageSqlId = ".*PageList.*";

    /**
     *
     * intercept,(intercept). <br/>
     * Author: qiaocf <br/>
     * Create Date: 2016年3月10日 <br/>
     * =============================================================== <br/>
     * Modifier: qiaocf <br/>
     * Modify Date: 2016年3月10日 <br/>
     * Modify Description: <br/>
     * =============================================================== <br/>
     *
     * @param ivk ivk
     * @return Object
     * @throws Throwable 异常
     * @since JDK 1.7
     */
    @Override
    public Object intercept(Invocation ivk) throws Throwable {
        if (ivk.getTarget() instanceof RoutingStatementHandler) {
            RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk.getTarget();
            BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");

            if (mappedStatement.getId().matches(pageSqlId)) { // 拦截需要分页的SQL
                BoundSql boundSql = delegate.getBoundSql();
                Object parameterObject = boundSql.getParameterObject(); // 分页SQL<select>中parameterType属性对应的实体参数，即Mapper接口中执行分页方法的参数,该参数不得为空
                if (parameterObject == null) {
                    throw new NullPointerException("parameterObject尚未实例化！");
                } else {
                    Connection connection = (Connection) ivk.getArgs()[0];
                    String sql = boundSql.getSql();
                    String countSql = "select count(0) from (" + sql + ") temp"; // 记录统计
                    LOG.debug(countSql);
                    PreparedStatement countStmt = connection.prepareStatement(countSql);
                    BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql, boundSql.getParameterMappings(), parameterObject);
                    setParameters(countStmt, mappedStatement, countBS, parameterObject);
                    ResultSet rs = countStmt.executeQuery();
                    int count = 0;
                    if (rs.next()) {
                        count = rs.getInt(1);
                    }
                    rs.close();
                    countStmt.close();
                    Page page = null;
                    if (parameterObject instanceof Page) { // 参数就是Page实体
                        page = (Page) parameterObject;
                        page.setTotal(count);
                    } else { // 参数为某个实体，该实体拥有Page属性
                        Field pageField = ReflectHelper.getFieldByFieldName(parameterObject, "page");
                        if (pageField != null) {
                            page = (Page) ReflectHelper.getValueByFieldName(parameterObject, "page");
                            if (page == null) {
                                page = new Page();
                            }
                            page.setTotal(count);
                            ReflectHelper.setValueByFieldName(parameterObject, "page", page); // 通过反射，对实体对象设置分页对象
                        } else {
                            throw new NoSuchFieldException(parameterObject.getClass().getName() + "不存在 page 属性！");
                        }
                    }
                    String pageSql = generatePageSql(sql, page);
                    ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); // 将分页sql语句反射回BoundSql.
                }
            }
        }
        return ivk.proceed();
    }

    /**
     * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter. DefaultParameterHandler
     *
     * @param ps ps
     * @param mappedStatement mappedStatement
     * @param boundSql boundSql
     * @param parameterObject parameterObject
     * @throws SQLException 异常
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
        ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        if (parameterMappings != null) {
            Configuration configuration = mappedStatement.getConfiguration();
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    PropertyTokenizer prop = new PropertyTokenizer(propertyName);
                    if (parameterObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                        value = parameterObject;
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX) && boundSql.hasAdditionalParameter(prop.getName())) {
                        value = boundSql.getAdditionalParameter(prop.getName());
                        if (value != null) {
                            value = configuration.newMetaObject(value).getValue(propertyName.substring(prop.getName().length()));
                        }
                    } else {
                        value = metaObject == null ? null : metaObject.getValue(propertyName);
                    }
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    if (typeHandler == null) {
                        throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName + " of statement " + mappedStatement.getId());
                    }
                    typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
                }
            }
        }
    }

    /**
     * 根据数据库方言，生成特定的分页sql
     *
     * @param sql sql
     * @param page page
     * @return String
     */
    private String generatePageSql(String sql, Page page) {
        if (page != null && StringUtils.isNotEmpty(dialect)) {
            StringBuffer pageSql = new StringBuffer();
            if ("mysql".equals(dialect)) {
                pageSql.append(sql);
                pageSql.append(" limit " + page.getStart() + "," + (page.getEnd() - page.getStart() + 1));
            } else if ("oracle".equals(dialect)) {
                pageSql.append("select * from (select tmp_tb.*,ROWNUM row_id from (");
                pageSql.append(sql);
                pageSql.append(") tmp_tb where ROWNUM<=");
                pageSql.append(page.getEnd() + 1);
                pageSql.append(") where row_id>");
                pageSql.append(page.getStart());
            }
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    @Override
    public Object plugin(Object arg0) {
        return Plugin.wrap(arg0, this);
    }

    @Override
    public void setProperties(Properties arg0) {

    }

}
