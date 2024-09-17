package br.edu.ifrs.loja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping("/")
    public String getGreeting(){
        return "Hello World!";
    }
}
