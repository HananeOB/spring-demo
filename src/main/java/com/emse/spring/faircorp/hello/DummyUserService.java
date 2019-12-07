package com.emse.spring.faircorp.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DummyUserService implements UserService {

    @Autowired
    private GreetingService GS;

    public void greetAll() {
        ArrayList<String> List = new ArrayList<>();
        List.add("Elodie");
        List.add("Charles");
        for(String e : List) {
            GS.greet(e);
        }
    }


}
