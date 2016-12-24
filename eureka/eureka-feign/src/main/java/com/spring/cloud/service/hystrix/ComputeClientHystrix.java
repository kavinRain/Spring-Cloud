package com.spring.cloud.service.hystrix;

import com.spring.cloud.service.ComputeClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2016/12/24.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
