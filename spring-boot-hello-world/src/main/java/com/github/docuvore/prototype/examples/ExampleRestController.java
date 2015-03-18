package com.github.docuvore.prototype.examples;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleRestController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}