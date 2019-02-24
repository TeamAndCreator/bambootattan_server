package com.ahau.aspect;


import com.ahau.entity.system.log.Log;
import com.ahau.service.system.log.LogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    @Autowired
    private LogService logService;

    private static final Logger LOGGER = LogManager.getLogger(HttpAspect.class);


    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("execution(public * com.ahau.controller.*.*.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        Log log = new Log();
        log.setOptUrl(request.getRequestURI());
        log.setOptUser((String) request.getSession().getAttribute("username"));
        log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.setOptIp(request.getRemoteAddr());
        LOGGER.info(log.toString());
        log.setRequestParam(joinPoint.getArgs().toString());
        logService.save(log);
        LOGGER.info("name={},url={},method={},ip={},class_method={},args={}",request.getSession().getAttribute("username"), request.getRequestURI(),request.getMethod(),
                request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
                , joinPoint.getArgs());
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfter(Object object) {
        LOGGER.info("response={}",object);

    }
}


//        String url=new String(request.getRequestURL());
//        String method=request.getMethod();
//        String ip= IpUtil.getClinetIpByReq(request);
//        String class_method=joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
//        String args= Arrays.toString(joinPoint.getArgs());
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
////        String userId = request.getSession().getAttribute("userId");//这个地方取你们存贮userId的值
//        String userId = null;//这个地方取你们存贮userId的值
//        LOGGER.info("url={} method={} ip={} class_method={} args={}", url, method
//                , ip, class_method
//                , joinPoint.getArgs());
//        Log log=new Log(url,userId,timestamp,IpUtil.getAddressByIP(ip),args,class_method);
//        logService.save(log);
//    }






//    //切面 配置通知
//    @AfterReturning("log()")
//    public void saveSysLog(JoinPoint joinPoint) {
//        System.out.println("切面。。。。。");
//        //保存日志
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
//        Log Log = new Log();
//
//        //从切面织入点处通过反射机制获取织入点处的方法
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        //获取切入点所在的方法
//        Method method = signature.getMethod();
//
//        //获取操作
//        OperationLog operationLog = method.getAnnotation(OperationLog.class);
//        if (operationLog != null) {
//            String value = operationLog.value();
//            Log.setOperation(value);//保存获取的操作
//        }
//
//        //获取请求的类名
//        String className = joinPoint.getTarget().getClass().getName();
//        //获取请求的方法名
//        String methodName = method.getName();
//        Log.setClassMethod(className + "." + methodName);
//
//        //请求的参数
//        Object[] args = joinPoint.getArgs();
//        //将参数所在的数组转换成json
//        String params = JSON.toJSONString(args);
//        Log.setRequestParam(params);
//
//        //Log.setOptTime((new Date());
//        //获取用户名
//        Log.setOptUser((String) request.getSession().getAttribute("username"));
////        Log.setOptUser(ShiroUtils.getUserEntity().getUsername());
//        //获取用户ip地址
//        Log.setOptIp(request.getRemoteAddr());
////        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
////        Log.setOptIp(IPUtils.getIpAddr(request));
//
//        //调用service保存Log实体类到数据库
//        logService.save(Log);
//        LOGGER.info("name={},url={},method={},ip={},class_method={},args={}",request.getSession().getAttribute("username"), request.getRequestURI(),request.getMethod(),
//                request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
//                , joinPoint.getArgs());
//    }
//
//
//
//
//    @Before("log()")
//    public void doBefore(JoinPoint joinPoint) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
//        Log log=new Log();
//        log.setOptUrl(request.getRequestURI());
//        log.setOptUser(request.getSession().getAttribute("username"));
//        log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.setOptIp(request.getRemoteAddr());
//        LOGGER.info(log.toString());
//        log.setRequestParam(joinPoint.getArgs().toString());
//        logService.save(log);
//        LOGGER.info("name={},url={},method={},ip={},class_method={},args={}",request.getSession().getAttribute("username"), request.getRequestURI(),request.getMethod(),
//                request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
//                , joinPoint.getArgs());
//    }
//
//    @AfterReturning(returning = "object",pointcut = "log()")
//    public void doAfter(Object object) {
//        LOGGER.info("response={}",object);
//
//    }



