package com.spring.cloud.service;

import com.spring.cloud.entity.BaseEntity;
import com.spring.cloud.mapper.Base2Mapper;
import com.spring.cloud.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/1/6.
 */
public abstract class BaseService<T extends BaseEntity> {

//    @Autowired
//    private BaseMapper<T, Integer> baseMapper;
//
//
//
//    public T findById(Integer id) {
//        return baseMapper.getById(id);
//    }

    @Autowired
    private Base2Mapper<T> base2Mapper;

    public T find2ById(T t) {
        return base2Mapper.selectByPrimaryKey(t);
    }
}
