package com.eva.curso.springboot.app.aop.springboot_aop.services;

public interface GreetingService 
{
    // Método decir hola
    String sayHello(String person, String phrase);

    // Simular un error
    String sayHelloError(String person, String phrase);
}
