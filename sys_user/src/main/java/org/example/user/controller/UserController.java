package org.example.user.controller;

import org.example.common.util.Params;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/connectTest")
    public String connectTest(String param){
        String s = "********** connect success **********";
        System.out.println("provider:"+s);
        System.out.println("get param:"+param);
        System.out.println(Params.CONNECT_SUCCESS);
        return s;
    }

}
