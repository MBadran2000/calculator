package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {
    Calculator calculator = new Calculator();
    @GetMapping("/calc")
    public String calc(@RequestParam(name = "operand",required = true)String operand, @RequestParam(name = "operator",required = true)String operator){
        return calculator.calc(operand,operator);
    }
    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }
}
