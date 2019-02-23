package com.ahau.aspect;


import com.ahau.entity.system.log.Log;
import com.ahau.service.system.log.LogService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

    private LogService logService;

    private static final Logger LOGGER = LogManager.getLogger(HttpAspect.class);



    @Pointcut("execution(public * com.ahau.controller.*.*.*.*(..))")
    public void log() {


    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        Log log=new Log();
        log.setOptUrl(request.getRequestURI());
//        log.setOptUser(request.getSession().getAttribute("username"));
//        log.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.setOptIp(request.getRemoteAddr());
        LOGGER.info(log.toString());
//        log.setRequestParam(joinPoint.getArgs().toString());
        logService.save(log);
//        LOGGER.info("name={},url={},method={},ip={},class_method={},args={}",request.getSession().getAttribute("username"), request.getRequestURI(),request.getMethod(),
//                request.getRemoteAddr(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
//                , joinPoint.getArgs());
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfter(Object object) {
        LOGGER.info("response={}",object);

    }
}
