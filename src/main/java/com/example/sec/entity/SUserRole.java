package com.example.sec.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 16:53
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Setter
@Getter
@Entity
@Table(name = "tb_user_role")
public class SUserRole {

    @Id
    private String id;

    private String userId;

    private String roleId;

}
