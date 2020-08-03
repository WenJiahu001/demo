package com.wjh.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @Auther: Wen Jiahu
 * @Date: 2019/04/15
 * @Description: 日志管理
 */
@Aspect
@Component
public class LoggerAdvice {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String n = System.getProperty("line.separator");

    @Before("within(com.wjh.demo.controller..*)")
//    @annotation(loggerManage)
    public void addBeforeLogger(JoinPoint joinPoint) {
//        logger.info("controller之前，在这里搞点事情");
    }

    @AfterReturning("within(com.wjh.demo.controller..*) ")
    public void addAfterReturningLogger(JoinPoint joinPoint) {
//        logger.info("controller return 之后，在这里事情");
    }

    @AfterThrowing(pointcut = "within(com.wjh.demo.controller..*)", throwing = "ex")
    public void addAfterThrowingLogger(JoinPoint joinPoint, Exception ex) {
        //如果异常了，在这里搞点事情
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer sb = new StringBuffer();
        String method = request.getMethod();
        sb.append("请求发生异常：" + ex.getMessage() + n);
        sb.append("请求Url地址=" + method + request.getRequestURI());


        if (method.equals("GET")) {
            sb.append("请求query:");
            //获取Get参数方法：
            Enumeration<String> enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                String paraName = enu.nextElement();
                sb.append(paraName + "= " + request.getParameter(paraName) + " ");
            }
        } else {
            sb.append("请求body: " + Arrays.toString(joinPoint.getArgs()) + n);
        }
        logger.info(sb.toString());
    }


}
