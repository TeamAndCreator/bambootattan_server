package com.ahau.service.system;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.system.User;
import com.ahau.repository.system.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    private UserRepository userRepository;

    public void updateActiveFlag(Long id){
        userRepository.updateActiveFlag(id);
    }

    public User findByCode(String code){
        return userRepository.findUserByCode(code);
    }

    @Autowired
    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    /**
     * 根据用户名查找用户
     * @return
     */
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    /**
     * 根据用户ID查找用户
     * @param id
     * @return
     */
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = new User();
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }else {
            LOGGER.debug("no exit!");
        }
        return user;
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

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<User> findUserNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<User> findUserQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return userRepository.findAll((Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("userAcct").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("userName").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("userPwd").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("activeFlag").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("dftTheme").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("createTime").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("pcOnlineFlag").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("errCount").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("errTime").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("orgName").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("orgPhone").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("roles").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("code").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return userRepository.findAll(pageable);
        }
    }

    /**
     * 删除
     * @param id
     */
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    public  void  deleteByIds(List<Long> ids){
        userRepository.deleteByUserIdIn(ids);
    }















//    /**
//     * 修改密码
//     * @param userId
//     * @param password
//     * @return
//     */
//    public User changePassword(Long userId, String password) {
//        return userRepository.changePassword(userId, password);
//    }

//    /**
//     * 验证密码
//     * @param userId
//     * @param password
//     * @return
//     */
//    public int verifyPassword(Long userId,String password){
//        Object md5Password = new SimpleHash("MD5", password, null, 1);
//        password=String.valueOf(md5Password);
//        String password1=userRepository.findPassword(userId);
//        if (password.equals(password1)){
//            return 1;
//        }else{
//            return 0;
//        }
//    }

//    public String findPassWord(Long userId){
//        return userRepository.findPassword(userId);
//    }




}
