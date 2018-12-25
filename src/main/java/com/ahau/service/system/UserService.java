package com.ahau.service.system;

import com.ahau.entity.system.Role;
import com.ahau.entity.system.User;
import com.ahau.repository.system.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户名查找用户
     * @return
     */
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }


}
