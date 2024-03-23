package com.bhavik.demo.controller;


import com.bhavik.demo.entity.Person;
import com.bhavik.demo.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping()
    public List<Person> getPersonList(@RequestParam(required = false) Optional<Long> id){
        List<Person> personList = new ArrayList<>();
        if(id.isPresent()){
            personList = personRepo.getPersonById(id.get());
        }
        else{
            personList = personRepo.getAllPerson();
        }
        return  personList;
    }
}
