package greetingcontroller;

import greetingservice.GreetingService;
import model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    // GET Request - Simple Greeting
    @GetMapping("/hello")
    public Greeting getGreeting() {
        return new Greeting(0L, "Hello from GET Method");
    }

    // POST Request - Simple Greeting
    @PostMapping("/hello")
    public Greeting postGreeting() {
        return new Greeting(1L, "Hello from POST Method");
    }

    // PUT Request - Simple Greeting
    @PutMapping("/hello")
    public Greeting putGreeting() {
        return new Greeting(2L, "Hello from PUT Method");
    }

    // DELETE Request - Simple Greeting
    @DeleteMapping("/hello")
    public Greeting deleteGreeting() {
        return new Greeting(3L, "Hello from DELETE Method");
    }

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/simple")
    public Greeting getSimpleGreeting() {
        return greetingService.getSimpleGreeting();
    }
}

