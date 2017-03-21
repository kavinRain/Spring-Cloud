package com.spring.cloud.dao;

import com.spring.cloud.common.QueryResult;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

/**
 * Created by 柯伟 on 2017/3/21.
 */
@Transactional
abstract class DaoSupport<T, ID> implements BaseDao<T, ID> {

    @PersistenceContext
    private EntityManager em;

    public void clear() {
        em.clear();
    }

    public <T> void delete(Class<T> entityClass, Object entityId) {
        delete(entityClass, new Object[]{entityId});
    }

    public <T> void delete(Class<T> entityClass, Object[] entityIds) {
        for (Object id : entityIds) {
            em.remove(em.getReference(entityClass, id));
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> T find(Class<T> entityClass, Object entityId) {
        return em.find(entityClass, entityId);
    }

    public void save(Object entity) {
        em.persist(entity);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> long getCount(Class<T> entityClass) {
        return Long.valueOf(em.createQuery(String.format("select count(%s) from %s o", getCountField(entityClass),
                getEntityName(entityClass))).getSingleResult().toString());
    }

    public void update(Object entity) {
        em.merge(entity);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass,
                                            int firstIndex, int maxResult, LinkedHashMap<String, String> orderBy) {
        return getScrollData(entityClass, firstIndex, maxResult, null, null, orderBy);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass,
                                            int firstIndex, int maxResult, String whereJpQl, Object[] queryParams) {
        return getScrollData(entityClass, firstIndex, maxResult, whereJpQl, queryParams, null);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult) {
        return getScrollData(entityClass, firstIndex, maxResult, null, null, null);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass) {
        return getScrollData(entityClass, -1, -1);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult
            , String whereJpQl, Object[] queryParams, LinkedHashMap<String, String> orderBy) {
        QueryResult qr = new QueryResult<T>();
        String entityName = getEntityName(entityClass);
        Query query = em.createQuery(String.format("select o from %s o %s %s", entityName,
                (whereJpQl == null ? "" : String.format("where %s", whereJpQl)), buildOrderBy(orderBy)));
        setQueryParams(query, queryParams);
        if (firstIndex != -1 && maxResult != -1) {
            query.setFirstResult(firstIndex).setMaxResults(maxResult);
        }
        qr.setResultList(query.getResultList());
        query = em.createQuery(String.format("select count(%s) from %s o %s", getCountField(entityClass), entityName,
                (whereJpQl == null ? "" : String.format("where %s", whereJpQl))));
        setQueryParams(query, queryParams);
        qr.setTotalRecord((Long) query.getSingleResult());
        return qr;
    }

    private void setQueryParams(Query query, Object[] queryParams) {
        if (queryParams != null && queryParams.length > 0) {
            for (int i = 0; i < queryParams.length; i++) {
                query.setParameter(i + 1, queryParams[i]);
            }
        }
    }

    /**
     * 组装order by语句
     *
     * @param orderBy
     * @return
     */
    private String buildOrderBy(LinkedHashMap<String, String> orderBy) {
        StringBuilder orderByQl = new StringBuilder("");
        if (orderBy != null && orderBy.size() > 0) {
            orderByQl.append(" order by ");
            for (String key : orderBy.keySet()) {
                orderByQl.append("o.").append(key).append(" ").append(orderBy.get(key)).append(",");
            }
            orderByQl.deleteCharAt(orderByQl.length() - 1);
        }
        return orderByQl.toString();
    }

    /**
     * 获取实体的名称
     *
     * @param <T>
     * @param entityClass 实体类
     * @return
     */
    private <T> String getEntityName(Class<T> entityClass) {
        String entityName = entityClass.getSimpleName();
        Entity entity = entityClass.getAnnotation(Entity.class);
        if (!"".equals(entity.name())) {
            entityName = entity.name();
        }
        return entityName;
    }

    private <T> String getCountField(Class<T> clazz) {
        String out = "o";
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
            for (PropertyDescriptor propertyDesc : propertyDescriptors) {
                Method method = propertyDesc.getReadMethod();
                if (method != null && method.isAnnotationPresent(EmbeddedId.class)) {
                    PropertyDescriptor[] ps = Introspector.getBeanInfo(propertyDesc.getPropertyType()).getPropertyDescriptors();
                    out = "o." + propertyDesc.getName() + "." + (!ps[1].getName().equals("class") ? ps[1].getName() : ps[0].getName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}
