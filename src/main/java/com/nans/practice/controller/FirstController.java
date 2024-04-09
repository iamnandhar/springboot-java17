package com.nans.practice.controller;

import com.nans.practice.service.FirstService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class FirstController {

    private final FirstService firstService;

    @RequestMapping("/hello")
    public String sayHello() {
        firstService.firstMethod();
        return "Hello Nanda, This is your first Spring io appln";
    }
}
