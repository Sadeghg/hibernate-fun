package io.mars.hibernateindepth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndpoint {

    @GetMapping("/greet")
    public String greet(){
        return "greet";
    }

    @GetMapping("/do")
    public String doIt(){
        return "greet";
    }
}
