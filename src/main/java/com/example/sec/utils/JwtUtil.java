package com.example.sec.utils;

import com.example.sec.entity.SRole;
import com.example.sec.entity.SUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 20:57
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
public class JwtUtil {

    private static final String SUBJECT = "LUCIFER";
    private static final String SECRET_KEY = "LUCIFER-LGX";
    private static final long EXPIRE = 1000 * 24 * 60 * 60 * 7;

    public static String genJwtToken(SUser user) {
        String roles = Optional.ofNullable(user.getRoles())
                .orElse(new ArrayList<>()).stream()
                .map(SRole::getRolename)
                .collect(Collectors.joining(","));
        String token = Jwts
                .builder()
                .setSubject(SUBJECT)
                .claim("id", user.getId())
                .claim("name", user.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
        return token;
    }

    public static SUser getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        String name = claims.get("name").toString();
        if (name != null && !name.isEmpty()) {
            SUser user = new SUser();
            user.setUsername(name);
            user.setId(claims.get("id").toString());
            String roles = claims.get("roles").toString();
            if (roles != null && !roles.isEmpty()) {
                List<SRole> roleList = Stream.of(roles.split(",")).filter(v -> !StringUtils.isEmpty(v)).map(v -> {
                    SRole role = new SRole();
                    role.setRolename(v);
                    return role;
                }).collect(Collectors.toList());
                user.setRoles(roleList);
            }
            return user;
        }
        return null;
    }
}
