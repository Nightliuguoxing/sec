package com.example.sec.mapper;

import com.example.sec.entity.SRolePerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 22:47
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Repository
public interface RolePermsMapper extends JpaRepository<SRolePerms, String>, JpaSpecificationExecutor<SRolePerms> {

    @Query(value = "SELECT rp FROM SRolePerms rp WHERE rp.permsId = ?1")
    public List<SRolePerms> findRPByPermsId(String permsId);
}
