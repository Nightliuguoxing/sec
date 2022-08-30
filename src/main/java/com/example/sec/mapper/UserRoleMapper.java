package com.example.sec.mapper;

import com.example.sec.entity.SUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 17:01
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Repository
public interface UserRoleMapper extends JpaRepository<SUserRole, String>, JpaSpecificationExecutor<SUserRole> {


    @Query(value = "SELECT ur FROM SUserRole ur WHERE ur.userId = ?1")
    public List<SUserRole> findURByUserId(String userId);
}