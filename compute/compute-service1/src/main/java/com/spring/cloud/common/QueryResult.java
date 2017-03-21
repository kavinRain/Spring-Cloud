package com.spring.cloud.common;

import java.util.List;

/**
 * Created by 柯伟 on 2017/3/21.
 */
public class QueryResult<T> {

    /**
     * 返回结果集合
     */
    private List<T> resultList;

    /**
     * 返回总记录数
     */
    private Long totalRecord;

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }
}
