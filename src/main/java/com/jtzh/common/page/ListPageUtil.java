/**
 * Project Name:zxkf-common
 * File Name:ListPageUtil.java
 * Package Name:com.wdcloud.zxkf.common.utils.page
 * Date:2017年4月18日上午9:22:41
 *
 */

package com.jtzh.common.page;


import com.jtzh.pojo.ViewKfglZzh;

import java.util.Collections;
import java.util.List;


/**
 * ClassName:ListPageUtil <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年4月18日 上午9:22:41 <br/>
 * 
 * @author 2016
 * @version
 * @since JDK 1.7
 * @see
 */
public class ListPageUtil<T> {

    /** 原集合 */
    private List<T> data;

    /** 上一页 */
    private int lastPage;

    /** 当前页 */
    private int nowPage;

    /** 下一页 */
    private int nextPage;

    /** 每页条数 */
    private int pageSize;

    /** 总页数 */
    private int totalPage;

    /** 总数据条数 */
    private int totalCount;

    public ListPageUtil(List<ViewKfglZzh> viewKfglZzhs, int nowPage, int pageSize) {
        if (viewKfglZzhs == null || viewKfglZzhs.isEmpty()) {
            throw new IllegalArgumentException("data must be not empty!");
        }

        this.data = (List<T>) viewKfglZzhs;
        this.pageSize = pageSize;
        /*this.totalPage = data.size()/pageSize;
        if(data.size()%pageSize!=0){
            this.totalPage++;
        }*/

        this.nowPage = nowPage;
        this.totalCount = viewKfglZzhs.size();
        this.totalPage = (totalCount + pageSize - 1) / pageSize;
        this.lastPage = nowPage - 1 > 1 ? nowPage - 1 : 1;
        this.nextPage = nowPage >= totalPage ? totalPage : nowPage + 1;

    }

    public List<T> getPagedList() {
        int fromIndex = (nowPage - 1) * pageSize;
        if (fromIndex >= data.size()) {
            return Collections.emptyList();//空数组
        }
        if (fromIndex < 0) {
            return Collections.emptyList();//空数组
        }
        int toIndex = nowPage * pageSize;
        if (toIndex >= data.size()) {
            toIndex = data.size();
        }
        return data.subList(fromIndex, toIndex);
    }

    public int getPageSize() {
        return pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getNowPage() {
        return nowPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

}
