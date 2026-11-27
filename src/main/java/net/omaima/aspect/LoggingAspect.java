package net.omaima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(public * net.omaima..*(..))"
            + " && !within(net.omaima.aspect..*)")

    public Object logMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        String method = joinPoint.getSignature().toShortString();

        log.info("Entering {}", method);
        try {
            Object result = joinPoint.proceed();
            log.info("Exiting {}", method);
            return result;
        } catch (Throwable e) {
            log.error("Exception in {}", method, e);
            throw e;
        } finally {
            long duration = System.currentTimeMillis() - start;
            log.info("{} executed in {} ms", method, duration);
        }
    }
}
