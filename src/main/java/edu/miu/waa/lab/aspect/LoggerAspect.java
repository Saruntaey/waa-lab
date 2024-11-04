package edu.miu.waa.lab.aspect;

import edu.miu.waa.lab.entity.Logger;
import edu.miu.waa.lab.repository.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LoggerAspect {
    @Autowired
    LoggerRepository loggerRepository;

    @Before("execution(* edu.miu.waa.lab.controller.*.*(..))")
    void log(JoinPoint jointPoint) {
        Logger logger = new Logger();
        logger.setTime(LocalDateTime.now());
        logger.setPrinciple("user");
        logger.setOperation(jointPoint.getSignature().toString());
        loggerRepository.save(logger);
    }
}
