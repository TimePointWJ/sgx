package com.jtzh.common.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
public class DruidAutoConfig implements EnvironmentAware {
    @Autowired
    private DruidProperties properties;


    /**
     * 配置数据库(数据源使用alibaba的druid)
     *
     * @return
     */
    @Bean()
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setValidationQuery(properties.getValidationQuery());
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        return dataSource;
    }

    @Override
    public void setEnvironment(Environment env) {
        if (!StringUtils.isEmpty(env.getProperty("jdbc.url"))) {
            properties.setUrl(env.getProperty("jdbc.url"));
        }
        if (!StringUtils.isEmpty(env.getProperty("jdbc.user"))) {
            properties.setUsername(env.getProperty("jdbc.user"));
        }
        if (!StringUtils.isEmpty(env.getProperty("jdbc.password"))) {
            properties.setPassword(env.getProperty("jdbc.password"));
        }
    }
}
