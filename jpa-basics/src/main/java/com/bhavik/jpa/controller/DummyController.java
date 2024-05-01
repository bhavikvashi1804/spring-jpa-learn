package com.bhavik.jpa.controller;


import com.bhavik.jpa.config.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "dummy")
public class DummyController {

    @Autowired
    MailProperties mailProperties;

    @GetMapping("mail-props")
    public String getMailProps(){
        return mailProperties.toString();
    }
}
