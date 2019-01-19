package com.ahau.repository.system;

import com.ahau.entity.system.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    Role findByRoleId(int roleId);
    Role findByRoleName(String roleName);

    void deleteByRoleIdIn(List<Integer> ids);
}
