package greetingservice;


import greetingrepository.GreetingRepository;
import model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GreetingService {
    public Greeting getSimpleGreeting() {
        return new Greeting(0L, "Hello World");
    }

    public Greeting createGreeting(String firstName, String lastName) {
        String message = "Hello";
        if (firstName != null && !firstName.isEmpty()) {
            message += " " + firstName;
        }
        if (lastName != null && !lastName.isEmpty()) {
            message += " " + lastName;
        }
        if (firstName == null && lastName == null) {
            message = "Hello World";
        }
        return new Greeting(1L, message);
    }

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public Greeting findGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public List<Greeting> listAllGreetings() {
        List<Greeting> greetings = new ArrayList<>();
        greetingRepository.findAll().forEach(greetings::add);
        return greetings;
    }

    public Greeting editGreeting(Long id, String newMessage) {
        Greeting greeting = greetingRepository.findById(id).orElse(null);
        if (greeting != null) {
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null;
    }

    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
