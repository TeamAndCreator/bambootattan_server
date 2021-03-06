package com.ahau.service.system.user;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.system.user.Authority;
import com.ahau.entity.system.user.Role;
import com.ahau.repository.system.user.AuthorityRepository;
import com.ahau.repository.system.user.RoleRepository;
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
import java.lang.reflect.Array;
import java.util.*;

@Transactional
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * 查询所有角色
     * @return
     */
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    /**
     * 查询一个角色
     * @param id
     * @return
     */
    public Role findById(int id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        Role role = new Role();
        if (roleOptional.isPresent()) {
            role = roleOptional.get();
        }else {
            LOGGER.debug("no exit!");
        }
        return role;
    }

    /**
     * 更新
     * @param role
     * @return
     */
    public Role update(Role role) {
        return  roleRepository.save(role);
    }

    public void delete(int id) {
        roleRepository.deleteById(id);
    }

    /**
     * 添加一个角色
     * @param role
     * @return
     */
    public Role save(Role role) {
        Set<Authority> authorities =role.getAuthorities();
        Set<Authority> authoritiesEmpty=new HashSet<>();
        role.setAuthorities(authoritiesEmpty);
        roleRepository.save(role);
        Authority[] arr=new  Authority[authorities.size()];
        authorities.toArray(arr);
        for (int i = 0; i <arr.length ; i++) {
            Role iRole=new Role();
            iRole.setRoleId(role.getRoleId());
            arr[i].setRole(iRole);
        }
        role.setAuthorities(new HashSet<>(Arrays.asList(arr)));
        update(role);
        return role;
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    public Page<Role> findRoleNoQuery(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return roleRepository.findAll(pageable);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    public Page<Role> findRoleQuery(Integer page, Integer size, String search) {
        Pageable pageable = PageRequest.of(page, size);
        if (!StringUtils.isEmpty(search)) {
            return roleRepository.findAll((Specification<Role>) (root, criteriaQuery, criteriaBuilder) -> {

                //用于暂时存放查询条件的集合
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.like(root.get("roleName").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("remark").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("sortNum").as(String.class), "%" + search + "%"));
                list.add(criteriaBuilder.like(root.get("canDel").as(String.class), "%" + search + "%"));

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.or(list.toArray(p));
            },pageable);
        } else {
            return roleRepository.findAll(pageable);
        }
    }

    /**
     * 批量删除
     * @param ids
     */
    public  void  deleteByIds(List<Integer> ids){
        roleRepository.deleteByRoleIdIn(ids);
    }

    public List<Role> findByRoleIdIn(List<Long> roleIds){
        return roleRepository.findByRoleIdIn(roleIds);
    }
}
