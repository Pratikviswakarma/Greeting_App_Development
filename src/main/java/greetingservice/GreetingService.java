package greetingservice;


import model.Greeting;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {
    private Map<Long, Greeting> greetingRepo = new HashMap<>();
    private Long idCounter = 1L;

}
