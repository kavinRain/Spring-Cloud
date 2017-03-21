package com.spring.cloud.service;

import com.spring.cloud.dao.SysUserDao;
import com.spring.cloud.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 柯伟 on 2017/3/21.
 */
@Service
public class LoginService extends BaseService {

    @Autowired
    private SysUserDao sysUserDao;

    public SysUser login(String userName, String password) {
        return sysUserDao.find(SysUser.class, 1L);
    }
}
