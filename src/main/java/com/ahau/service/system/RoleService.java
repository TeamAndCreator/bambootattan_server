package com.ahau.service.system;

import com.ahau.BambootattanServerApplication;
import com.ahau.entity.system.Role;
import com.ahau.repository.system.RoleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private static final Logger LOGGER = LogManager.getLogger(BambootattanServerApplication.class);

    @Autowired
    public RoleService(RoleRepository roleRepository) {this.roleRepository = roleRepository;}

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
    public Role findById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        Role role = new Role();
        if (roleOptional.isPresent()) {
            role = roleOptional.get();
        }else {
            LOGGER.debug("no exit!");
        }
        return role;
    }
}
