package com.spring.cloud.sso.service;

import com.spring.cloud.common.beans.Result;
import com.spring.cloud.common.enums.ResultType;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/6/3.
 */
@Service
public class LoginService {

    public Result<String> login(String username, String password) {
        return new Result<>(ResultType.SUCCESS,"jhcapscsacjhsapipiowerpfewjpj=2134921r3-rf-ref=asc=ic=sadsad=acx");
    }
}
