package ank.hao.spring_aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopProxy {

    @Pointcut("execution(* ank.hao.spring_aop.Tenant.rent(..))")
    public void rent(){}

    @Around("rent()")
    public Object rentProxy(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("spring aop proxy start..");
        Object invoke = proceedingJoinPoint.proceed();
        System.out.println("spring aop proxy end..");
        return invoke;
    }
}
