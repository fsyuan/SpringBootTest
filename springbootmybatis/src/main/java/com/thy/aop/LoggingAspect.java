package com.thy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author thy
 * AOP 日志输出工具
 */
@Aspect
@Component
public class LoggingAspect {
    //transient 不加入序列化
    private static transient Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.thy.controller..*.*(..))")
    private void controllerMethod() {
    }



    @Before("controllerMethod()") //在切入点的方法run之前的工作
    public void logBeforeController(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();//这个RequestContextHolder是Springmvc提供来获得请求的东西
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // 记录下请求内容
        logger.info("请求参数");
        logger.info("################URL : " + request.getRequestURL().toString());
        logger.info("################HTTP_METHOD : " + request.getMethod());
        logger.info("################IP : " + request.getRemoteAddr());
        logger.info("################THE ARGS OF THE CONTROLLER : " + Arrays.toString(joinPoint.getArgs()));
        //下面这个getSignature().getDeclaringTypeName()是获取包+类名的   然后后面的joinPoint.getSignature.getName()获取了方法名
        logger.info("执行对象及方法");
        logger.info("################TARGET: " + joinPoint.getTarget());//返回的是需要加强的目标类的对象
        logger.info("################CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "controllerMethod()", returning = "returnValue")
    public void logMethodCall(JoinPoint joinPoint, Object returnValue) throws Throwable {
        logger.info("返回值");
        logger.info("################RESULT : " + returnValue);
        logger.info("################OVER : " + "结束");
    }


}