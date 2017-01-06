package com.spring.cloud.mapper;

import com.spring.cloud.entity.BaseEntity;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Administrator on 2017/1/6.
 */
public interface Base2Mapper<T extends BaseEntity> extends Mapper<T>, MySqlMapper<T> {
}
