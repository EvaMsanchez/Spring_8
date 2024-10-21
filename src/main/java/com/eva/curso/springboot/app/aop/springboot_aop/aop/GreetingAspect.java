package com.eva.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingAspect 
{
    // Con esto podemos registrar los eventos
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // Registre un loggin antes de llamar al método
    // JoinPoint: punto de unión. Une el aspecto con el método
    @Before("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))") // punto de corte
    public void loggerBefore(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes: " + method + " con los argumentos " + args);
    }
}
