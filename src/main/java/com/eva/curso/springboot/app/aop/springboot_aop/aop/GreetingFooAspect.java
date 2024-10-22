package com.eva.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1) // ordenar los aspectos
@Component
@Aspect

public class GreetingFooAspect 
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    // Para reutilizar código, definiendo el punto de corte
    @Pointcut("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))")
    private void greetingFooLoggerPointCut(){}


    @Before("greetingFooLoggerPointCut()") // punto de corte
    public void loggerBefore(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes Primero: " + method + " invocado con los parámetros " + args);
    }


    @After("greetingFooLoggerPointCut()") // punto de corte
    public void loggerAfter(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Después Primero: " + method + " invocado con los parámetros " + args);
    }
}
