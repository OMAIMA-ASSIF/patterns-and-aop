package net.omaima.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private final AuthorizationService authorizationService;

    public SecurityAspect(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Around("@annotation(rule)")
    public Object checkAuthorization(ProceedingJoinPoint joinPoint, RequiresRole rule) throws Throwable {
        if (!authorizationService.hasRole(rule.value())) {
            throw new SecurityException("Access denied: role '" + rule.value() + "' required");
        }
        return joinPoint.proceed();
    }
}
