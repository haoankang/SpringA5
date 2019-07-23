package ank.hao.lwt;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class DemoAspect {

    @Pointcut("execution(public * ank.hao.lwt.Demo.run())")
    public void pointcut1(){}

    @Around("pointcut1()")
    public Object profile(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        StopWatch stopWatch = new StopWatch(getClass().getSimpleName());
        try {
            stopWatch.start(proceedingJoinPoint.getSignature().getName());
            return proceedingJoinPoint.proceed();
        }finally {
            stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
        }
    }
}
