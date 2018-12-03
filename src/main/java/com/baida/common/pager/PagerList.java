package com.baida.common.pager;

import java.util.List;

/**
 * @author ShiQing_Chen
 * @date 2018/12/3 10:42
 */

public class PagerList<T> {

    private Pager pager;
    private List<T> dataList;

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
