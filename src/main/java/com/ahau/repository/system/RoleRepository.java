package com.ahau.repository.system;

import com.ahau.entity.system.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    Role findByRoleId(Long roleId);
    Role findByRoleName(String roleName);
<<<<<<< HEAD
=======

    void deleteByRoleIdIn(List<Long> ids);
>>>>>>> develop
}
