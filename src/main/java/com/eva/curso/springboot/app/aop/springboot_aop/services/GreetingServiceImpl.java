package com.eva.curso.springboot.app.aop.springboot_aop.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService
{
    @Override
    public String sayHello(String person, String phrase) 
    {
        String greeting = phrase + " " + person;
        System.out.println(greeting);
        return greeting;
    }

}