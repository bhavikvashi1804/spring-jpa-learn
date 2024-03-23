package com.bhavik.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "home")
public class HomeController {

    @GetMapping()
    public String getHomeData(){
        return "home data";
    }

    @GetMapping("data")
    public String getData(){
        return  "Data Page";
    }
}
