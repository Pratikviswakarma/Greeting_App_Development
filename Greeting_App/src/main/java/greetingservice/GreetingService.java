package greetingservice;


import model.Greeting;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {
    public Greeting getSimpleGreeting() {
        return new Greeting(0L, "Hello World");
    }
}
