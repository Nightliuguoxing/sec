package com.example.sec.service;

import com.example.sec.entity.SRole;
import com.example.sec.entity.SUser;
import com.example.sec.entity.SUserRole;
import com.example.sec.mapper.RoleMapper;
import com.example.sec.mapper.UserMapper;
import com.example.sec.mapper.UserRoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 17:00
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper urMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("用户名不能为空");
        }
        SUser user = userMapper.findUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<SUserRole> urs = urMapper.findURByUserId(user.getId());
        List<SRole> roles = new ArrayList<>();
        for(SUserRole ur : urs){
            SRole r = roleMapper.findById(ur.getRoleId()).orElse(null);
            roles.add(r);
        }
        user.setRoles(roles);
        return user;
    }
}
