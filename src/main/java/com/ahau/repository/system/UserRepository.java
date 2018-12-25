package com.ahau.repository.system;

import com.ahau.entity.system.Role;
import com.ahau.entity.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

/**
 * 用户
 * Created by: 张岩松
 * 2018-12-22
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {

    User findByUserName(String userName);


}
