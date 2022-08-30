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
        String str = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMVUNJRkVSIiwiaWQiOiIyIiwibmFtZSI6InVzZXIiLCJyb2xlcyI6IlJPTEVfVVNFUiIsImlhdCI6MTY2MTgyNzc1MiwiZXhwIjoxNjYyNDMyNTUyfQ.-RPKyPg-5UX-4KBWdhP31IpnuGM62wv9oK7bPQSpZBlXrzHibv-XMgJOXQRdkxO7j3OoMka8WDH8q2t0LcG5fg";
        String token = str.substring(7);
        System.out.println(token);
    }
}
