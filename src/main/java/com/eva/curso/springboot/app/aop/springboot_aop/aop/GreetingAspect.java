package com.eva.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
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

    // Registre un loggin ANTES de llamar al método
    // JoinPoint: punto de unión. Une el aspecto con el método
    // @Before("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.*.*(..))") // se aplica a cualquier clase dentro de la carpeta service y a cualquier método de esa clase
    // @Before("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.sayHello(..))") // punto de corte
    @Before("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") // punto de corte
    public void loggerBefore(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Antes: " + method + " con los argumentos " + args);
    }


    // Realiza algo DESPUÉS de llamar al método, SIEMPRE, haya o no error
    @After("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") // punto de corte
    public void loggerAfter(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Después: " + method + " con los argumentos " + args);
    }
}
