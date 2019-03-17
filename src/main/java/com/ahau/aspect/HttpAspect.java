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
import java.util.Arrays;


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
        log.setRequestParam(Arrays.toString(joinPoint.getArgs()));
        logService.save(log);
        LOGGER.info(log.toString());

    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfter(Object object) {
        LOGGER.info("response={}",object);

    }
}




