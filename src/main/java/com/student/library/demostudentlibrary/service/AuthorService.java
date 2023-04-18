package com.student.library.demostudentlibrary.service;

import com.student.library.demostudentlibrary.model.Author;
import com.student.library.demostudentlibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.updateAuthor(author);
    }
}
