package com.lnson.temp.aspect.sections;

import com.lnson.temp.aspect.config.PointcutOptions;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面
 */
@Aspect
public class ServiceAdvice {

    /**
     * 切点
     */
    @Pointcut(value = PointcutOptions.POINTCUT_SERVICE)
    public void pointcut() {
    }

    /**
     * 前置通知
     */
    @Before(value = "pointcut()")
    public void beforeAdvice() {
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    @After(value = "pointcut()")
    public void afterAdvice() {
        System.out.println("后置通知");
    }

    /**
     * 返回通知
     */
    @AfterReturning(value = "pointcut()")
    public void afterReturningAdvice() {
        System.out.println("返回通知");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "pointcut()")
    public void afterThrowingAdvice() {
        System.out.println("异常通知");
    }

    /**
     * 环绕通知
     */
    @Around(value = "pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕通知");

        Object obj = null;

        // 获得目标对象（被代理的对象）
        Object target = jp.getTarget();
        System.out.println(target);

        // 执行被拦截的方法
        obj = jp.proceed(jp.getArgs());

        return obj;
    }

}
