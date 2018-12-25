package com.ahau.controller.System;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.system.User;
import com.ahau.service.system.UserService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "用户接口")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录密码会先被MD5两次加密后再和数据库比对，
     * 所以数据库中的密码应是MD5两次加密后的密码
     * @param userName
     * @param password
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping(value = "login")
    @RequiresGuest
    public Result login(String userName,String password){
        Subject currentUser = SecurityUtils.getSubject();
        User user = null;
        String jsessionid= (String) currentUser.getSession().getId();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        token.setRememberMe(true);
        try {
            currentUser.login(token);
        } catch (UnknownAccountException ua) {
            System.out.println("未知账户！（提示：若已成功注册，请联系管理员查看用户是否已激活。）：" + ua.getMessage());
            return ResultUtil.error(500,"未知账户！（提示：若已成功注册，请联系管理员查看用户是否已激活。）");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("错误的凭证！：" + ice.getMessage());
            return ResultUtil.error(500,"错误的凭证!");
        } catch (LockedAccountException lae) {
            System.out.println("账户已锁定！：" + lae.getMessage());
            return ResultUtil.error(500,"账户已锁定!");
        } catch (ExcessiveAttemptsException eae) {
            System.out.println("错误次数过多！：" + eae.getMessage());
            return ResultUtil.error(500,"错误次数过多!");
        } catch (AuthenticationException ae) {
            System.out.println("验证未通过！:" + ae.getMessage());
//                return Msg.fail();
            return ResultUtil.error(500,"验证未通过!");
        }
        return ResultUtil.success(jsessionid);
    }


    @ApiOperation(value = "根据用户名查询用户")
    @GetMapping(value = "findByUserName")
    @RequiresRoles(value = "admin")
    //@RequiresAuthentication:使用该注解标注的类，实例，方法在访问或调用时，当前Subject(即用户)必须在当前session中已经过认证。
    //@RequiresGuest:使用该注解标注的类，实例，方法在访问或调用时，当前Subject可以是“gust”身份，不需要经过认证或者在原先的session中存在记录。
    //@RequiresRoles:当前Subject必须拥有所有指定的角色时，才能访问被该注解标注的方法。如果当天Subject不同时拥有所有指定角色，则方法不会执行还会抛出AuthorizationException异常。
    //@RequiresUser:当前Subject必须是应用的用户，才能访问或调用被该注解标注的类，实例，方法。
    public Result findByUserName(String userName){
        User user=userService.findByUserName(userName);
        return ResultUtil.success(user);
    }

    @GetMapping(value = "pleaseLogin")
    @ApiOperation(value = "提示登录")
    public Result loginError(){
        return ResultUtil.error(500,"请登录");
    }

}
