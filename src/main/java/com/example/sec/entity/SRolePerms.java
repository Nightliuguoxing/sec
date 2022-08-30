package com.example.sec.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 22:43
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_role_perms")
public class SRolePerms {

    @Id
    private String id;

    private String roleId;

    private String permsId;
}
