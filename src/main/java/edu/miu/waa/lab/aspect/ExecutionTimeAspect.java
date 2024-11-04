package edu.miu.waa.lab.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Around("@annotation(edu.miu.waa.lab.aspect.annotation.ExecutionTime)")
    Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        Object res = proceedingJoinPoint.proceed();
        long end = System.nanoTime();
        System.out.printf("%s taken %d ns\n", proceedingJoinPoint.getSignature(), end - start);
        return res;
    }
}
