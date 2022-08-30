package com.example.sec.mapper;

import com.example.sec.entity.SRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 16:59
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Repository
public interface RoleMapper extends JpaRepository<SRole, String>, JpaSpecificationExecutor<SRole> {

}
