package com.example.sec.filter;

import com.example.sec.entity.SUser;
import com.example.sec.entity.vo.LoginVo;
import com.example.sec.utils.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 17:32
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
public class JsonAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public JsonAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException, IOException, ServletException {
        try {
            LoginVo data = new ObjectMapper().readValue(req.getInputStream(), LoginVo.class);
            Authentication authenticate  = getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword())
            );
            if (authenticate.isAuthenticated()) {
                SUser user = (SUser) authenticate.getPrincipal();
                String token = JwtUtil.genJwtToken(user);
                user.setToken(token);
            }
            return authenticate;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
