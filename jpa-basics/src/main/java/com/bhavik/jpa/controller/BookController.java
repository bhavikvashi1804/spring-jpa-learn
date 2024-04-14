package com.bhavik.jpa.controller;

import com.bhavik.jpa.entity.Book;
import com.bhavik.jpa.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String field,
                                  @RequestParam(required = false) Sort.Direction direction){

        if(field != null && direction != null){
            Sort sort = Sort.by(direction, field);
            return  bookRepo.findAll(sort);
        }
        return bookRepo.findAll();
    }

    @GetMapping("/test/asc")
    public Sort.Direction getDirection(){
        return Sort.Direction.ASC;
    }

    @GetMapping("/test/desc")
    public Sort.Direction getDirection1(){
        return Sort.Direction.DESC;
    }

}
