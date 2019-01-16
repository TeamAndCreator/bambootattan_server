package com.ahau.repository.system;

import com.ahau.entity.system.User;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 用户
 * Created by: 张岩松
 * 2018-12-22
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {

    User findByUserName(String userName);

    @Query(value = "update user set active_flag=1 where user_id=:id", nativeQuery = true)
    @Modifying
    void updateActiveFlag(@Param(value = "id") Long id);

    User findUserByCode(String code);
}
