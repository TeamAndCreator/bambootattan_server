package com.ahau.controller.System;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.system.User;
import com.ahau.service.system.UserService;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(description = "用户接口")
@RequestMapping(value = "/user")
public class UserController {

//    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户登录密码会先被MD5两次加密后再和数据库比对，
     * 所以数据库中的密码应是MD5两次加密后的密码
     *
     * @param userName
     * @param password
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping(value = "login")
    @RequiresGuest
    public Result login(String userName, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        User user = null;
        String jsessionid = (String) currentUser.getSession().getId();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(false);
        try {
            currentUser.login(token);
        } catch (UnknownAccountException ua) {
            System.out.println("未知账户！（提示：若已成功注册，请联系管理员查看用户是否已激活。）：" + ua.getMessage());
            return ResultUtil.error(500, "未知账户！（提示：若已成功注册，请联系管理员查看用户是否已激活。）");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("错误的凭证！：" + ice.getMessage());
            return ResultUtil.error(500, "错误的凭证!");
        } catch (LockedAccountException lae) {
            System.out.println("账户已锁定！：" + lae.getMessage());
            return ResultUtil.error(500, "账户已锁定!");
        } catch (ExcessiveAttemptsException eae) {
            System.out.println("错误次数过多！：" + eae.getMessage());
            return ResultUtil.error(500, "错误次数过多!");
        } catch (AuthenticationException ae) {
            System.out.println("验证未通过！:" + ae.getMessage());
//                return Msg.fail();
            return ResultUtil.error(500, "验证未通过!");
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
    public Result findByUserName(String userName) {
        User user = userService.findByUserName(userName);
        return ResultUtil.success("" + user);
    }

    /**
     * 查询所有用户列表
     * @return
     */
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户列表")
    @GetMapping(value = "findAll")
    @RequiresRoles(value = "admin")
    public Result findAll() {
        return ResultUtil.success(userService.findAll());
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @ApiOperation(value = "更新用户信息", notes = "根据url的id来指定更新用户信息")
    @PutMapping("update")
    public Result update(@ApiParam(name = "user", value = "要修改的用户详细实体user", required = true) @RequestBody User user) {
        return ResultUtil.success(userService.update(user));
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @PostMapping("save")
    public Result save(@ApiParam(name = "user", value = "要添加的用户详细实体user", required = true) @RequestBody User user) {
        return ResultUtil.success(userService.save(user));
    }

    @ApiOperation(value = "登出")
    @PostMapping(value = "logout")
    @RequiresAuthentication
    public Result logout() {
        try {
            Subject currentSubject = SecurityUtils.getSubject();
            currentSubject.logout();
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.error();
        }
    }

    @GetMapping(value = "pleaseLogin")
    @ApiOperation(value = "提示登录")
    public Result loginError() {
        return ResultUtil.error(500, "请登录");
    }













//    /**
//     * 获取验证码图片
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @RequestMapping(value="/getImage",method=RequestMethod.GET)
//    public void authImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setHeader("Pragma", "No-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
//        response.setContentType("image/jpeg");
//        // 生成随机字串
//        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
//        // 存入会话session
//        HttpSession session = request.getSession(true);
//        // 删除以前的
//        session.removeAttribute("verCode");
//        session.removeAttribute("codeTime");
//        session.setAttribute("verCode", verifyCode.toLowerCase());
//        session.setAttribute("codeTime", LocalDateTime.now());
//        // 生成图片
//        int w = 100, h = 30;
//        OutputStream out = response.getOutputStream();
//        VerifyCodeUtils.outputImage(w, h, out, verifyCode);
//    }

//    /**
//     * 核对验证码
//     * @param request
//     * @param session
//     * @return
//     */
//    @RequestMapping(value="validImage",method=RequestMethod.GET)
//    public String validImage(HttpServletRequest request,HttpSession session){
//        String code = request.getParameter("code");
//        Object verCode = session.getAttribute("verCode");
//        if (null == verCode) {
//            request.setAttribute("errmsg", "验证码已失效，请重新输入");
//            return "验证码已失效，请重新输入";
//        }
//        String verCodeStr = verCode.toString();
//        LocalDateTime localDateTime = (LocalDateTime)session.getAttribute("codeTime");
//        long past = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        long now = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//        if(verCodeStr == null || code == null || code.isEmpty() || !verCodeStr.equalsIgnoreCase(code)){
//            request.setAttribute("errmsg", "验证码错误");
//            return "验证码错误";
//        } else if((now-past)/1000/60>5){
//            request.setAttribute("errmsg", "验证码已过期，重新获取");
//            return "验证码已过期，重新获取";
//        } else {
//            //验证成功，删除存储的验证码
//            session.removeAttribute("verCode");
//            return "200";
//        }
//    }
}
