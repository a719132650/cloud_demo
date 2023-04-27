package org.example.service.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author:
 * @Description:
 * @Date: create in 2023/4/21 8:52
 */
@RestController
@RefreshScope
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
        System.out.println("get param from service:"+param);
//        String s2 = restTemplate.getForObject("http://sys-user/user/connectTest",String.class);
//        System.out.println(s2);
//        return s;
        return userService.connectTest(param);
    }


    @RequestMapping("/f1")
    public String f1(){
        System.out.println("============ in f1 ============");
        int i = 100/0;
        return "f1";
    }

    @Value("${config.info}")
    private String config;

    @RequestMapping("/f2")
    public String f2(){
        System.out.println("============ in f2 ============");
        return config;
    }

    @RequestMapping("/f3")
    @SentinelResource(value = "f3",blockHandler = "dealBlock")
    public String f3(@RequestParam("key")String key){
        return key;
    }

    public String dealBlock(String key, BlockException exception){
        return ("this is block fullback for key: "+key);
    }


}
