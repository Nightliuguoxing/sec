package com.example.sec.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 16:37
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Tag(name = "测试类")
@RestController
public class TestController {

    @GetMapping("/index")
    @Operation(summary = "index", description = "测试")
    public Object index(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @GetMapping("/admin")
    public String admin(){
        return "This is Admin";
    }

    @GetMapping("/user")
    public String user(){
        return "This is User";
    }

}
