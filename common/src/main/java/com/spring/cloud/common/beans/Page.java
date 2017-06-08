package com.spring.cloud.common.beans;

import lombok.Data;

/**
 * Created by Administrator on 2017/6/7.
 */
@Data
public class Page<T> {

    private Integer pageIndex;

    private Integer pageSize;
}
