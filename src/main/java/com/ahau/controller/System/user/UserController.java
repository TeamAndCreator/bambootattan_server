package com.ahau.controller.System.user;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.entity.system.user.Role;
import com.ahau.entity.system.user.User;
import com.ahau.service.system.user.RoleService;
import com.ahau.service.system.user.UserService;
import com.ahau.utils.MailSendUtil;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;


@RestController
@Api(description = "用户接口")
@RequestMapping(value = "/user")
public class UserController {

//    private static final Logger LOGGER = LogManager.getLogger(UserController.class);


    private final MailSendUtil mailSendUtil;
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public UserController(MailSendUtil mailSendUtil, UserService userService, RoleService roleService) {
        this.mailSendUtil = mailSendUtil;
        this.userService = userService;
        this.roleService = roleService;
    }

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
        String jsessionid = (String) currentUser.getSession().getId();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(false);
        try {
            currentUser.login(token);
            currentUser.getSession().setAttribute("username",userName);
        } catch (UnknownAccountException ua) {
            System.out.println("未知账号！（提示：若已成功注册，请联系管理员查看用户是否已激活。）：" + ua.getMessage());
            return ResultUtil.error(500, "未知账号！（提示：若已成功注册，请联系管理员查看用户是否已激活。）");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("错误的凭证！：" + ice.getMessage());
            return ResultUtil.error(500, "错误的凭证!");
        } catch (LockedAccountException lae) {
            System.out.println("账号未激活！：" + lae.getMessage());
            return ResultUtil.error(500, "账号未激活!");
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
//    @GetMapping(value = "findByUserName")
    @GetMapping(value = "findByUserName/{userName}")
    @RequiresRoles(value = "admin")
    //@RequiresAuthentication:使用该注解标注的类，实例，方法在访问或调用时，当前Subject(即用户)必须在当前session中已经过认证。
    //@RequiresGuest:使用该注解标注的类，实例，方法在访问或调用时，当前Subject可以是“gust”身份，不需要经过认证或者在原先的session中存在记录。
    //@RequiresRoles:当前Subject必须拥有所有指定的角色时，才能访问被该注解标注的方法。如果当天Subject不同时拥有所有指定角色，则方法不会执行还会抛出AuthorizationException异常。
    //@RequiresUser:当前Subject必须是应用的用户，才能访问或调用被该注解标注的类，实例，方法。
//    public Result findByUserName(String userName) {
//        User user = userService.findByUserName(userName);
//        return ResultUtil.success("" + user);
//    }
    public Result findByUserName(@ApiParam(name = "userName", value = "需要查找的用户的名字", required = true) @PathVariable("userName") String userName) {
        return ResultUtil.success(userService.findByUserName(userName));
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
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @GetMapping("findId/{userId}")
    public Result findById(@ApiParam(name = "userId", value = "需要查找的用户的id", required = true) @PathVariable("userId") Long userId) {
        return ResultUtil.success(userService.findById(userId));
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
     * 用户注册
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @PostMapping("save")
    public Result save(User user,@ApiParam(value = "给用户分配的角色Id", required = true) @RequestParam List<Integer> idList) {
        try {
            if (userService.findByUserName(user.getUserName())!=null)
                return ResultUtil.error(500,"用户名已存在");
            //对密码进行md5两次加密，不加盐
            Object password = new SimpleHash("MD5", user.getUserPwd(), null, 2);
            user.setUserPwd(String.valueOf(password));
            //添加注册时间
            Date time = new Date();
            Timestamp timestamp=new Timestamp(time.getTime());
            user.setCreateTime(timestamp);
            //添加角色
            List<Role> roleList=roleService.findAll();
            Set<Role> roleSet=new HashSet<>();
            for (int id:idList){
                for (Role role: roleList){
                    if (role.getRoleId()==id)
                        roleSet.add(role);
                }
            }
            if (roleSet.size()==0)
                return ResultUtil.error(500,"至少需要添加一个角色");
            user.setRoles(roleSet);
            //初始状态为无效
            user.setActiveFlag(Byte.valueOf("2"));
            //生成激活码
            String code= UUID.randomUUID().toString();
            user.setCode(code);
            //将用户存入数据库
            userService.save(user);
            //发送邮件激活用户
            mailSendUtil.sendHTMLMail("2574325794@qq.com",code,user);
            return ResultUtil.success();
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(e.hashCode(),e.getMessage());
        }
    }

//    /**
//     * 修改密码
//     * @param userId
//     * @param password
//     * @return
//     */
//    @ApiOperation(value = "修改密码", notes = "根据User对象修改密码")
//    @PutMapping("changePassword")
//    public Result changePassword(Long userId, String password) {
//            Object md5Password = new SimpleHash("MD5", password, null, 1);
//            userService.changePassword(userId, String.valueOf(md5Password));
//            return ResultUtil.success();
//        }

    @ApiOperation(value = "激活账号")
    @GetMapping("active")
    public Result active(String code){
        try {
            User user=userService.findByCode(code);
            if (user!=null){
                userService.updateActiveFlag(user.getUserId());
                return ResultUtil.success("激活成功");
            }
            return ResultUtil.error(500,"激活错误");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
    }

//    @ApiOperation(value = "更新激活状态")
//    @GetMapping("updateActiveFlag")
//    public Result updateActiveFlag(Long userId) {
//        try {
//            userService.updateActiveFlag(userId);
//            return ResultUtil.success();
//        }catch (Exception e) {
//            return ResultUtil.error(500,e.getMessage());
//        }
//    }


//    @ApiOperation(value = "登出")
//    @PostMapping(value = "logout")
//    @RequiresAuthentication
//    public Result logout() {
//        try {
//            Subject currentSubject = SecurityUtils.getSubject();
//            currentSubject.getSession().removeAttribute("username");
//            currentSubject.logout();
//            return ResultUtil.success();
//        } catch (Exception e) {
//            return ResultUtil.error();
//        }
//    }


    @ApiOperation(value = "登出")
    @PostMapping(value = "logOut")
    //@RequiresAuthentication
    @ResponseBody
    @ApiResponses({
            @ApiResponse(code = 201, message = "已创建"),
            @ApiResponse(code = 400, message = "请求参数填写错误 "),
            @ApiResponse(code = 401, message = "访问被拒绝"),
            @ApiResponse(code = 403, message = "禁止访问"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径错误")
    })
    public Result logOut() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            try {
                currentUser.logout();
            } catch (Exception e) {
                return ResultUtil.error(500, e.getMessage());
            }
        }
        return ResultUtil.success();
    }


    @GetMapping(value = "pleaseLogin")
    @ApiOperation(value = "提示登录")
    public Result loginError() {
        return ResultUtil.error(500, "请登录");
    }

    /**
     * 分页无条件查找
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "分页无条件查找", notes = "分页无条件查找")
    @GetMapping("findAllNoQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
    })
    public Result findUserNoQuery(@RequestParam Integer page, @RequestParam Integer size) {

        Page<User> userPage = userService.findUserNoQuery(page, size);

        return ResultUtil.success(userPage);
    }

    /**
     * 分页有条件查找
     * @param page
     * @param size
     * @param search
     * @return
     */
    @ApiOperation(value = "分页有条件查找", notes = "分页有条件查找")
    @GetMapping("findAllQuery")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, value = "页数", paramType = "query"),
            @ApiImplicitParam(name = "size", required = true, value = "条数", paramType = "query"),
            @ApiImplicitParam(name = "search", value = "查询关键字", paramType = "query"),
    })
    public Result findUserQuery(@RequestParam Integer page, @RequestParam Integer size, String search) {

        Page<User> userPage = userService.findUserQuery(page, size, search);

        return ResultUtil.success(userPage);
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除用户")
    @DeleteMapping("delete/{userId}")
    public Result delete(@ApiParam(name = "userId", value = "需删除用户的ID", required = true)
                         @PathVariable("userId") Long userId) {
        userService.delete(userId);
        return ResultUtil.success();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ApiOperation(value = "批量删除", notes = "根据id数组来批量删除用户")
    @DeleteMapping("deleteByIds")
    public Result deleteByIds(@ApiParam(name = "ids", value = "需删除用户的id数组", required = true) @RequestParam List<Long> ids) {
        userService.deleteByIds(ids);
        return ResultUtil.success();
    }

    /**
     * 修改密码
     * @param userName
     * @param old_password
     * @param new_Password
     * @return
     */
    @ApiOperation(value = "密码修改")
    @PostMapping(value = "changePassword")
    public Result changePassword(String userName, String old_password, String new_Password) {
        try {
            User user = userService.findByUserName(userName);
            //判断用户名是否正确
            if (user == null) {
                return ResultUtil.error(500,"用户名错误");
            }
            //判断密码是否正确
            if (user.getUserPwd().equals(String.valueOf(new SimpleHash("MD5", old_password, null, 2)))){
                userService.updateUserPwd(user.getUserId(),String.valueOf(new SimpleHash("MD5", new_Password, null, 2)));
                return ResultUtil.success("密码修改成功");
            }else {
                return ResultUtil.error(500,"密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error(500,e.getMessage());
        }
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