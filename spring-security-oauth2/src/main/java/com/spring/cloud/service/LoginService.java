package com.spring.cloud.service;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/22.
 */
@Service
public class LoginService {

    public Object login(String userName, String password) {
        return Boolean.TRUE;
    }
}
