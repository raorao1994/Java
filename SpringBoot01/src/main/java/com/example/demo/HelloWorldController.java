package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/hellow")
public class HelloWorldController {  
    
	@RequestMapping("/index")
    public String index() {  
        return "Hello World";  
    }
	
	
}
