package com.ahau.controller.System;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.system.Role;
import com.ahau.entity.system.User;
import com.ahau.service.system.RoleService;
import com.ahau.service.system.UserService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;

/**
 * 超级管理员接口
 * Created by: zhangli
 */
@RestController
@Api(description = "超级管理员接口")
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 添加用户
     * @param user
     * @param idList
     * @return
     */
    @ApiOperation(value = "添加用户", notes = "根据User对象添加用户")
    @PostMapping("save")
    public Result save(User user, @ApiParam(value = "给用户分配的角色Id", required = true) @RequestParam List<Integer> idList) {
        try {
            if (userService.findByUserName(user.getUserName()) != null)
                return ResultUtil.error(500, "用户名已存在");
            //对密码进行md5两次加密，不加盐
            Object password = new SimpleHash("MD5", user.getUserPwd(), null, 2);
            user.setUserPwd(String.valueOf(password));
            //添加注册时间
            Date time = new Date();
            Timestamp timestamp = new Timestamp(time.getTime());
            user.setCreateTime(timestamp);
            //添加角色
            List<Role> roleList = roleService.findAll();
            Set<Role> roleSet = new HashSet<>();
            for (int id : idList) {
                for (Role role : roleList) {
                    if (role.getRoleId() == id)
                        roleSet.add(role);
                }
            }
            if (roleSet.size() == 0)
                return ResultUtil.error(500, "至少需要添加一个角色");
            user.setRoles(roleSet);
            //初始状态为有效
            user.setActiveFlag(Byte.valueOf("1"));
            //将用户存入数据库
            userService.save(user);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.hashCode(), e.getMessage());
        }
    }

    @ApiOperation(value = "更新用户信息", notes = "根据url的id来指定更新用户信息")
    @PutMapping("update")
    public Result update(User user, @ApiParam(value = "给用户分配的角色Id", required = true) @RequestParam List<Integer> idList) {
        try{
            User user1 = userService.findById(user.getUserId());
            if (user1 == null)
                return ResultUtil.error(500,"不存在该用户，请从新输入正确的用户id！");
            Object password = new SimpleHash("MD5", user.getUserPwd(), null, 2);
            user.setUserPwd(String.valueOf(password));
            //添加注册时间
            Date time = new Date();
            Timestamp timestamp = new Timestamp(time.getTime());
            user.setCreateTime(timestamp);
            //添加角色
            List<Role> roleList = roleService.findAll();
            Set<Role> roleSet = new HashSet<>();
            for (int id : idList) {
                for (Role role : roleList) {
                    if (role.getRoleId() == id)
                        roleSet.add(role);
                }
            }
            if (roleSet.size() == 0)
                return ResultUtil.error(500, "至少需要添加一个角色");
            user.setRoles(roleSet);
            //初始状态为有效
           user.setActiveFlag(Byte.valueOf("1"));
            //将用户存入数据库
            userService.update(user);
            return ResultUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error(e.hashCode(), e.getMessage());
        }

    }





}
