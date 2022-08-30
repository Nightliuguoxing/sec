package com.example.sec.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 18:03
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Component
public class NoLoginHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write("{\"message\":\"" + exception.getMessage() + "\"}");
    }
}
