package com.example.sec.mapper;

import com.example.sec.entity.SUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author LUCIFER-LGX
 * @Date 2022/8/29 16:57
 * @Copyright(c) 2022 , 青枫网络工作室
 * @Description:
 */
@Repository
public interface UserMapper extends JpaRepository<SUser, String>, JpaSpecificationExecutor<SUser> {

    @Query(value = "SELECT u FROM SUser u WHERE u.username = ?1")
    public SUser findUserByName(String username);
}
