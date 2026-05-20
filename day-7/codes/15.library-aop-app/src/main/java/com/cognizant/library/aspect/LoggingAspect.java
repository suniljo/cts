package com.cognizant.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
	// Pointcut expression to match all methods in the com.cognizant.library.services package
	@Before("execution(* com.cognizant.library.services.*.*(..))")
	public void logBeforeMethodExecution(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("LOGGING ASPECT: Before executing method: " + methodName);
		log.info("LOGGING ASPECT: Before executing method: {}", methodName);
	}
	
	@After("execution(* com.cognizant.library.services.LibraryServices.saveNewBook(..))")
	public void logAfterExecution(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		log.info("LOGGING ASPECT: After executing method: {}", methodName);
	}	

    @Around("execution(* com.cognizant.library.services.LibraryServices.saveNewBook(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // 1. Logic before method execution
        System.out.println("Starting execution: " + joinPoint.getSignature());

        try {
            // 2. Proceed with the actual method execution
            Object result = joinPoint.proceed();
            
            // 3. Logic after successful execution
            long executionTime = System.currentTimeMillis() - start;
            System.out.println(joinPoint.getSignature() + " completed in " + executionTime + "ms");
            
            return result;
        } catch (Throwable throwable) {
            // 4. Logic if an exception occurs
            System.err.println("Method failed: " + joinPoint.getSignature());
            throw throwable;
        }
    }
}
