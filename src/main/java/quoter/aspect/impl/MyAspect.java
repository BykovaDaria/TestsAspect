package quoter.aspect.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by dasha on 03.05.18.
 */
@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* *(..))")
    private void allMethods() {
    }

    @Around("allMethods() && @annotation(bpp.quoter.aspect.annotation.ProfilingMethodA")
    private Object watchTime(ProceedingJoinPoint proceedingJoinPoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + proceedingJoinPoint.getSignature().toShortString() + " >>");
        Object output = null;

        for (Object object : proceedingJoinPoint.getArgs()) {
            System.out.println("Param : " + object);
        }

        try {
            output = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("Method end: " + proceedingJoinPoint.getSignature().toShortString() + ", time = " + time + " ms <<");

        return output;
    }
}
