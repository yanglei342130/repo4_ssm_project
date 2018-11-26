package cn.itcast.controller;

import cn.itcast.domain.SysLog;
import cn.itcast.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop1 {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ISysLogService sysLogService;
    private Date visitTime;

    @Pointcut("execution(* cn.itcast.controller.*.*(..))")
    public void pt() {
    }

    @Before("pt()")
    public void doBefore(JoinPoint jp) {
        visitTime = new Date();
    }

    @After("pt()")
    public void doAfter(JoinPoint jp) {
        if (!"SysLogController".equals(jp.getSignature().getDeclaringType().getSimpleName())) {
            SysLog sysLog = new SysLog();
            sysLog.setVisitTime(visitTime);
            //获取security容器
            SecurityContext context = SecurityContextHolder.getContext();
            //获取认证对象
            Authentication authentication = context.getAuthentication();
            //获取当前用户信息封装对象
            User user = (User) authentication.getPrincipal();
            //获取当前登录用户的用户名
            String username = user.getUsername();
            sysLog.setUsername(username);
            //获取访问的ip
            String ip = request.getRemoteAddr();
            sysLog.setIp(ip);
            //获取访问的uri
            String uri = request.getRequestURI();
            sysLog.setUrl(uri);
            long executionTime = new Date().getTime() - visitTime.getTime();
            sysLog.setExecutionTime(executionTime);
            //获取访问的类名
            String className = jp.getSignature().getDeclaringTypeName();
            //获取访问的方法名
            String methodName = jp.getSignature().getName();
            sysLog.setMethod("[类名]" + className + "[方法名]" + methodName);
            sysLogService.save(sysLog);
        }
    }
}
