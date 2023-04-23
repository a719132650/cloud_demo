package org.example.service.controller;

import org.example.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author:
 * @Description:
 * @Date: create in 2023/4/21 8:52
 */
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired

    public ServiceController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/connectTest")
    public String connectTest(String param){
//        String s = "********** connect success **********";
//        System.out.println("provider:"+s);
//        System.out.println("get param:"+param);
//        String s2 = restTemplate.getForObject("http://sys-user/user/connectTest",String.class);
//        System.out.println(s2);
//        return s;
        return userService.connectTest(param);
    }

}
