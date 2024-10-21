package com.eva.curso.springboot.app.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

    // Se ejecuta ANTES de llamar al método (ejemplo loggin de prueba en el terminal)
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


    // Se ejecuta DESPUÉS de llamar al método, SIEMPRE, haya o no error
    @After("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") // punto de corte
    public void loggerAfter(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Después: " + method + " con los argumentos " + args);
    }


    // Se ejecuta DESPUÉS de llamar al método, siempre que NO haya errores. Y antes que el After.
    @AfterReturning("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") // punto de corte
    public void loggerAfterReturning(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Después de retornar: " + method + " con los argumentos " + args);
    }


    // Se ejecuta DESPUÉS de llamar al método, pero siempre que HAYA errores. También antes que el After
    @AfterThrowing("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.GreetingService.*(..))") // punto de corte
    public void loggerAfterThrowing(JoinPoint joinPoint)
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        logger.info("Después de lanzar la excepción: " + method + " con los argumentos " + args);
    }


    // Anida todo. se ejecuta ANTES y DESPUÉS de llamar al método, como un before y after a la vez en uno. Si hay before, antes del before y después del after
    // Devuelve un objeto, con la ejecución del método
    @Around("execution(* com.eva.curso.springboot.app.aop.springboot_aop.services.*.*(..))")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        // Obtener el nombre del método
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try 
        {
            logger.info("El método " + method + "() con los argumentos " + args);
            result = joinPoint.proceed(); // ejecución del método
            logger.info("El método " + method + "() retorna el resultado " + result); // si da error no se ejecuta

            return result;
        } 
        catch (Throwable e) // en caso de error
        {
          
            logger.error("Error en la llamada del método " + method + "()");
            throw e;
        }

    }
}
