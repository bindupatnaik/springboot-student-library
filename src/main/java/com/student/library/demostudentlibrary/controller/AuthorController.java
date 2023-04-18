package com.student.library.demostudentlibrary.controller;

import com.student.library.demostudentlibrary.model.Author;
import com.student.library.demostudentlibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping(value = "/createAuthor")
    public ResponseEntity createAuthor(@RequestBody() Author author){
        authorService.createAuthor(author);
        return new ResponseEntity("author is created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateAuthor")
    public ResponseEntity updateAuthor(@RequestBody() Author author){
        authorService.updateAuthor(author);
        return new ResponseEntity("author is updated ", HttpStatus.CREATED);
    }
}
