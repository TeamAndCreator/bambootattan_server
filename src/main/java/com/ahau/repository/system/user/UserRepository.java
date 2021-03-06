package com.ahau.repository.system.user;

import com.ahau.entity.system.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


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

    @Query(value = "update user set user_pwd=:pwd where user_id=:id", nativeQuery = true)
    @Modifying
    void updateUserPwd(@Param(value = "pwd") String pwd,@Param(value = "id") Long id);

    User findUserByCode(String code);

    void deleteByUserIdIn(List<Long> ids);

    User findByUserId(Long userId);

//    int updateUser(User user);

    //void changeUserPwd(Long userId, String userPwd);
}
