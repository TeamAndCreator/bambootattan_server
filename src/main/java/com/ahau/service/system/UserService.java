package com.ahau.service.system;

import com.ahau.entity.system.Role;
import com.ahau.entity.system.User;
import com.ahau.repository.system.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void updateActiveFlag(Long id){
        userRepository.updateActiveFlag(id);
    }

    public User findByCode(String code){
        return userRepository.findUserByCode(code);
    }

    /**
     * 根据用户名查找用户
     * @return
     */
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    public User update(User user) {
        userRepository.save(user);
        return user;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public User save(User user) {
        return userRepository.save(user);
    }




}
