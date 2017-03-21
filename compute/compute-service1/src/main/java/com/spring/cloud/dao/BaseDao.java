package com.spring.cloud.dao;

import com.spring.cloud.common.QueryResult;

import java.util.LinkedHashMap;

/**
 * Created by 柯伟 on 2017/3/21.
 */
interface BaseDao<T, ID> {

    /**
     * 获取记录总数
     *
     * @param entityClass 实体类
     * @return
     */
    public <T> long getCount(Class<T> entityClass);

    /**
     * 清除一级缓存的数据
     */
    public void clear();

    /**
     * 保存实体
     *
     * @param entity 实体id
     */
    public void save(Object entity);

    /**
     * 更新实体
     *
     * @param entity 实体id
     */
    public void update(Object entity);

    /**
     * 删除实体
     *
     * @param entityClass 实体类
     * @param entityId    实体id
     */
    public <T> void delete(Class<T> entityClass, Object entityId);

    /**
     * 删除实体
     *
     * @param entityClass 实体类
     * @param entityIds   实体id数组
     */
    public <T> void delete(Class<T> entityClass, Object[] entityIds);

    /**
     * 获取实体
     *
     * @param <T>
     * @param entityClass 实体类
     * @param entityId    实体id
     * @return
     */
    public <T> T find(Class<T> entityClass, Object entityId);

    /**
     * 获取分页数据
     *
     * @param <T>
     * @param entityClass 实体类
     * @param firstIndex  开始索引
     * @param maxResult   需要获取的记录数
     * @return
     */
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult
            , String wherejpql, Object[] queryParams, LinkedHashMap<String, String> orderBy);

    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult
            , String wherejpql, Object[] queryParams);

    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult
            , LinkedHashMap<String, String> orderBy);

    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult);

    public <T> QueryResult<T> getScrollData(Class<T> entityClass);
}
