package com.educational.MyForumHub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("initial")
public class HelloController {

    @GetMapping
    public void hello(){
        System.out.println("Olá,mundo!");
    }

}


