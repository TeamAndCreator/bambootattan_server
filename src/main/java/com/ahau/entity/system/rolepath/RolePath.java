package com.ahau.entity.system.rolepath;

import org.springframework.context.annotation.Role;
import org.springframework.data.jpa.domain.JpaSort;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 实体类：（rolepath table）
 * created by: 张理
 * 2018-10-28 20：00
 */
@Entity
public class RolePath {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String Roleid;
    private String pathId;

//    private Role role;
//
//    private JpaSort.Path path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleid() {
        return Roleid;
    }

    public void setRoleid(String roleid) {
        Roleid = roleid;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public JpaSort.Path getPath() {
//        return path;
//    }
//
//    public void setPath(JpaSort.Path path) {
//        this.path = path;
//    }
}
