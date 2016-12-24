package com.spring.cloud.controller;

import com.spring.cloud.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    // @Autowired
    // RestTemplate restTemplate;
    //
    // @RequestMapping(value = "/add", method = RequestMethod.GET)
    // public String add() {
    //     return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    // }

    @Autowired
    private ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.addService();
    }


}