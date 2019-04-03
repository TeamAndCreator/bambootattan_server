package com.ahau.repository.system.user;

import com.ahau.entity.system.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AuthorityRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {
    void deleteByRoleIdIn(List<Integer> ids);
}
