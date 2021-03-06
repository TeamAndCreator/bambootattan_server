package com.ahau.repository.system.user;

import com.ahau.entity.system.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    Role findByRoleId(int roleId);
    Role findByRoleName(String roleName);
    List findByRoleIdIn(List<Long> roleIds);

    void deleteByRoleIdIn(List<Integer> ids);
}
