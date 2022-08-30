package com.example.sec.service;

import com.example.sec.entity.SPerms;
import com.example.sec.entity.SRole;
import com.example.sec.entity.SRolePerms;
import com.example.sec.mapper.PermsMapper;
import com.example.sec.mapper.RoleMapper;
import com.example.sec.mapper.RolePermsMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 22:48
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Service
public class AuthService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermsMapper permsMapper;

    @Autowired
    private RolePermsMapper rpMapper;

    public boolean canAccess(HttpServletRequest req, Authentication authentication) {
        String uri = req.getRequestURI();
        List<SRole> roles = findRolesByUri(uri);
        if (roles != null || !roles.isEmpty()) {
            for (SRole role : roles) {
                for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                    if (role.getAuthority().equals(grantedAuthority.getAuthority())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private List<SRole> findRolesByUri(String uri) {
        if (StringUtils.isEmpty(uri)) {
            return Collections.emptyList();
        }
        SPerms perms = permsMapper.findPermsByUri(uri);
        if (perms == null) {
            return Collections.emptyList();
        }
        List<SRolePerms> rps = rpMapper.findRPByPermsId(perms.getId());
        if (rps == null || rps.isEmpty()) {
            return Collections.emptyList();
        }
        List<SRole> roles = new ArrayList<>();
        for (SRolePerms rp : rps) {
            SRole r = roleMapper.findById(rp.getRoleId()).orElse(null);
            roles.add(r);
        }
        return roles;
    }


}
