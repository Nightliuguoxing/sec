package com.example.sec.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 17:23
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        String password = "user";
        String news = new BCryptPasswordEncoder().encode(password);
        System.out.println(news);
        // .anyRequest().access("@authService.canAccess(request, authentication)")
    }
}
