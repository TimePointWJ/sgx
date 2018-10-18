package com.jtzh.common.page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * ClassName: Page <br/>
 * Function: 分页类. <br/>
 * Date: 2016年3月10日 下午5:06:54 <br/>
 *
 * @author qiaocf
 * @version 1.0
 * @since JDK 1.7
 */
public class Page implements Serializable {

    /** 序列化id **/
    private static final long serialVersionUID = 1L;

    /** 常量 **/
    private static final int NUMBER = 10;

    /** 总条数 **/
    private int total;

    /** 开始 **/
    private int start;

    /** 结束 **/
    private int end;

    /** 当前页 **/
    private int currPage = 1;

    /** 每页条数 **/
    private int pageSize = NUMBER;

    /** 总页数 **/
    private int pageCnt = 0;

    /** 额外属性 **/
    private Map<String, Object> map;

    /** 分页结果 **/
    private List<?> data;

    /** 查询条件实体 **/
    private Object param;

    public Object getParam() {
        return param;
    }

    /** 查询条件实体 设置 @param param 实体 **/
    public void setParam(Object param) {
        this.param = param;
    }

    public int getTotal() {
        return total;
    }

    /** 设置总数 @param total 总数 **/
    public void setTotal(int total) {
        this.total = total;
        calPageCnt();
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<?> getData() {
        return data;
    }

    /** 分页结果 设置 @param data 数据 **/
    public void setData(List<?> data) {
        this.data = data;
    }

    public int getCurrPage() {
        return currPage;
    }

    /** 当前页设置 @param currPage 当前页数 **/
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
        calPageInfo();
    }

    public int getPageSize() {
        return pageSize;
    }

    /** 页大小设置 @param pageSize 页面大小 **/
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        calPageInfo();
        calPageCnt();
    }

    /**
     *
     * calPageInfo,(calPageInfo). <br/>
     * Author: qiaocf <br/>
     * Create Date: 2016年3月10日 <br/>
     * ===============================================================<br/>
     * Modifier: qiaocf <br/>
     * Modify Date: 2016年3月10日 <br/>
     * Modify Description: <br/>
     * ===============================================================<br/>
     * String
     *
     * @since JDK 1.7
     */
    private void calPageInfo() {
        this.start = (this.currPage - 1) * this.pageSize;
        this.end = this.currPage * this.pageSize - 1;
    }

    /**
     *
     * calPageCnt,(calPageCnt). <br/>
     * Author: qiaocf <br/>
     * Create Date: 2016年3月10日 <br/>
     * ===============================================================<br/>
     * Modifier: qiaocf <br/>
     * Modify Date: 2016年3月10日 <br/>
     * Modify Description: <br/>
     * ===============================================================<br/>
     *
     * @since JDK 1.7
     */
    private void calPageCnt() {
        int rest = this.total % this.pageSize;
        this.pageCnt = rest > 0 ? this.total / this.pageSize + 1 : this.total / this.pageSize;
    }

    public int getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(int pageCnt) {
        this.pageCnt = pageCnt;
    }

}
