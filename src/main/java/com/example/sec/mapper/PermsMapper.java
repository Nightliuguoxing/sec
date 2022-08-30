package com.example.sec.mapper;

import com.example.sec.entity.SPerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 22:45
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Repository
public interface PermsMapper extends JpaRepository<SPerms, String>, JpaSpecificationExecutor<SPerms> {

    @Query(value = "SELECT p FROM SPerms p WHERE p.url = ?1")
    public SPerms findPermsByUri(String uri);
}
