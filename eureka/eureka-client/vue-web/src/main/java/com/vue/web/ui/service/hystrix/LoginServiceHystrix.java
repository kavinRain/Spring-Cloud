package com.vue.web.ui.service.hystrix;

import com.spring.cloud.common.beans.Result;
import com.spring.cloud.common.enums.ResultType;
import com.vue.web.ui.service.LoginService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/12/24.
 */
@Component
public class LoginServiceHystrix implements LoginService {

    @Override
    public Result<String> login(String username, String password) {
        return new Result<>(ResultType.FAIL, null);
    }
}
