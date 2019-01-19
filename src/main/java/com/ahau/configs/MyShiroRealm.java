package com.ahau.configs;

import com.ahau.entity.system.Role;
import com.ahau.entity.system.User;
import com.ahau.service.system.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * 自定义权限匹配和账号密码匹配
 */
public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = (String) principals.getPrimaryPrincipal();
        User user=userService.findByUserName(username);
        for (Role role : user.getRoles()) {
            authorizationInfo.addRole(role.getRoleName());
        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
        UsernamePasswordToken usernamePasswordToken =(UsernamePasswordToken) token;
        String username=usernamePasswordToken.getUsername();
        User user = userService.findByUserName(username);
        if (user == null) {
            return null;
        }else if (user.getActiveFlag() == 2) { //账户未激活
            throw new LockedAccountException();
        } else {
            SimpleAuthenticationInfo info = null;
            info = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPwd(), getName());
            return info;
        }
    }

}
