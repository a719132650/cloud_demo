package org.example.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient("sys-user")
public interface UserService {

    @RequestMapping("/user/connectTest")
    String connectTest(String param);
}