package com.gaokun.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author gaokun
 * @version 1.0
 * @date 2023/6/10 20:10
 */
@Aspect
@Component
public class CountTimeAspect {

    @Pointcut("@annotation(com.gaokun.aop.CountTime)")
    public void countTime() {

    }

    @Around("countTime()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = null;
        try {
            long start = System.currentTimeMillis();
            obj = joinPoint.proceed();
            // 方法名
            String name = joinPoint.getSignature().getName();
            // 获取类名
            String className = joinPoint.getTarget().getClass().getName();
            // 获取参数
            Object[] args = joinPoint.getArgs();
            // 参数序列化
            String argsString = "";
            for (Object arg : args) {
                argsString += arg.toString();
            }
            long end = System.currentTimeMillis();
            System.out.println("方法名：" + name + "，类名：" + className + "，参数：" + argsString + "，耗时：" + (end - start) + "ms");
        } catch (Throwable e) {
            throw e;
        }
        return obj;
    }

}
