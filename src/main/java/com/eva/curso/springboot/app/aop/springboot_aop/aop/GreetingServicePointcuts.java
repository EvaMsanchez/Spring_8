package com.eva.curso.springboot.app.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Clase para los puntos de cortes(Poincut)
@Component
@Aspect
public class GreetingServicePointcuts 
{
    // Para reutilizar código, definiendo el punto de corte
    @Pointcut("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){}

    // Para reutilizar código, definiendo el punto de corte
    @Pointcut("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingFooLoggerPointCut(){}
}
