package com.ahau.controller.System.user;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.system.user.Role;
import com.ahau.entity.system.user.User;
import com.ahau.service.system.user.RoleService;
import com.ahau.service.system.user.UserService;
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

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

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

//    @PostMapping("changPwd")
//    @ResponseBody
//    public String userUpdateHandler(@ModelAttribute(value = "user") User user, HttpServletRequest request) {
//        //获取新密码
//        String newPassword = request.getParameter("newPassword");
//        //获取修改前用户信息
//        User user1 = (User) request.getSession().getAttribute("user");
//        //比较输入的旧密码是否和修改前的密码相等
//        if (user1.getUserPwd().equals(user.getUserPwd())) {
//            //把用户原用户密码在前端修改
//            user1.setUserPwd(newPassword);
//            //通过业务逻辑层给数据库修改
//            if (userService.update(user1)) {
//                //把修改了的用户信息重新存入session
//                request.getSession().setAttribute("user",user1);
//                return "修改成功";
//            }
//        }else{
//            return "旧密码错误";
//        }
//
//        return "修改失败";
//    }

//    /**
//     * 修改密码
//     * @param userId
//     * @param userPwd
//     * @return
//     */
//    @ApiOperation(value = "修改密码", notes = "根据User对象修改密码")
//    @PutMapping("changePassword")
//    public Result changeUserPwd(Long userId, String userPwd) {
//            Object md5Password = new SimpleHash("MD5", userPwd, null, 1);
//            userService.changeUserPwd(userId, String.valueOf(md5Password));
//            return ResultUtil.success();
//        }






}
