package com.bywin.aspect;

import com.alibaba.fastjson.JSON;
import io.micrometer.core.instrument.util.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yeric
 * @description:
 * @date 2021/1/8 15:26
 */
@Aspect
@Component
public class LogAspect {
    /**
     * slf4j日志
     */
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * Pointcut 切入点
     * 匹配cn.controller包下面的所有方法
     */
    @Pointcut("execution(public * com.bywin.download.controller.BatchHandleController.testAspect(..))")
    public void webLog(){}

    /**
     * 环绕通知
     */
    @Around(value = "webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        try {
            logger.info("1、Around：方法环绕开始.....");
            Object o =  pjp.proceed();
            logger.info("3、Around：方法环绕结束，结果是 :" + o);
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String uri = request.getRequestURI().replace(request.getContextPath(), "");
            Object result = pjp.proceed();
                String inPutParam = preHandle(pjp, request);
                String outPutParam = postHandle(result);
                String ip = getRemoteHost(request);
            System.out.println(request);
            return o;
        } catch (Throwable e) {
            logger.error(pjp.getSignature() + " 出现异常： ", e);
            throw new RuntimeException("arround");
        }
    }

    private String preHandle(ProceedingJoinPoint joinPoint, HttpServletRequest request) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Annotation[] annotations = targetMethod.getAnnotations();
        StringBuffer sb = new StringBuffer();
        String token = request.getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            sb.append("heander-token:" + token + ",");
        }
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().toString().indexOf("org.springframework.web.bind.annotation") == -1) {
                continue;
            }
            sb.append(JSON.toJSONString(request.getParameterMap()));
        }
        return sb.toString();
    }

    /**
     * 返回数据
     *
     * @param retVal
     * @return
     */
    private String postHandle(Object retVal) {
        if (null == retVal) {
            return "";
        }
        return JSON.toJSONString(retVal);
    }

    private String getRemoteHost(HttpServletRequest request) {
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }


    /**
     * 方法执行前
     */
    @Before(value = "webLog()")
    public void before(JoinPoint joinPoint){
        logger.info("2、Before：方法执行开始...");
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
    }

    /**
     * 方法执行结束，不管是抛出异常或者正常退出都会执行
     */
    @After(value = "webLog()")
    public void after(JoinPoint joinPoint){
        logger.info("4、After：方法最后执行.....");
    }

    /**
     * 方法执行结束，增强处理
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        // 处理完请求，返回内容
        logger.info("5、AfterReturning：方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing(value = "webLog()")
    public void throwss(JoinPoint joinPoint){
        logger.error("AfterThrowing：方法异常时执行.....");
    }
}
