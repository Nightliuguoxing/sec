package com.example.sec.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 16:48
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Setter
@Getter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_role")
public class SRole implements GrantedAuthority {

    @Id
    private String id;

    private String rolename;


    @Override
    public String getAuthority() {
        return this.rolename;
    }
}
