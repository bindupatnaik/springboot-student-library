package com.student.library.demostudentlibrary.service;

import com.student.library.demostudentlibrary.model.Book;
import com.student.library.demostudentlibrary.model.Genre;
import com.student.library.demostudentlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findBooksByAuthor(String authorName) {
        return bookRepository.findBooksByAuthor(authorName);
    }

    public List<Book> findBooksByAuthorAndAvailableFlag(String authorName, boolean available) {
        return bookRepository.findBooksByAuthorAndAvailableFlag(authorName, available);
    }

    public List<Book> findBooksByTitle(String bookTitle) {
        return bookRepository.findByBookName(bookTitle);
    }

    public List<Book> findBooksByGenre(String genre) {
        return bookRepository.findByGenre(Genre.valueOf(genre));
    }
}
