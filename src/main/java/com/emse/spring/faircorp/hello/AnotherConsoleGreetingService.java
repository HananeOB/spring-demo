package com.emse.spring.faircorp.hello;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary @Service
public class AnotherConsoleGreetingService implements GreetingService {

    public void greet(String name) {
        System.out.print("Bonjour2, "+name+"!");
    }
}
