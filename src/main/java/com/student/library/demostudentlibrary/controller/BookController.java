package com.student.library.demostudentlibrary.controller;

import com.student.library.demostudentlibrary.model.Book;
import com.student.library.demostudentlibrary.service.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping(value = "/createBook")
    public ResponseEntity createBook(@RequestBody() Book book) {
        bookService.createBook(book);
        return new ResponseEntity("book is created successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/getBooksByAuthor/{name}")
    public ResponseEntity getBooksByAuthor(@PathVariable("name") String authorName) {
        List<Book> bookList = bookService.findBooksByAuthor(authorName);
        return new ResponseEntity(bookList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/getBooksByAuthorAndAvailableFlag")
    public ResponseEntity getBooksByAuthorAndAvailableFlag(@RequestParam("authorName") String authorName, @RequestParam("available") boolean available) {
        List<Book> bookList = bookService.findBooksByAuthorAndAvailableFlag(authorName, available);
        return new ResponseEntity(bookList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "getBooksByTitle")
    public ResponseEntity getBookByTitle(@RequestParam("title") String bookTitle) {
        List<Book> bookList = bookService.findBooksByTitle(bookTitle);
        return new ResponseEntity(bookList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "getBooksByGenre")
    public ResponseEntity getBooksByGenre(@RequestParam("genre") String genre) {
        List<Book> bookList = bookService.findBooksByGenre(genre);
        return new ResponseEntity(bookList, HttpStatus.ACCEPTED);
    }

//    this will create a problem as there are multiple combinations of author, title, available, etc., and if the user gives different combinations the api will fail
    @GetMapping("/getBooks")
    public ResponseEntity getBooks(@RequestParam(value = "authorName", required = false) String authorName,
                                   @RequestParam(value = "available", required = false) boolean available,
                                   @RequestParam(value = "title", required = false) String bookTitle,
                                   @RequestParam(value = "genre", required = false) String genre) {
        List<Book> bookList = null;
        if (authorName != null && (available == true || available == false)) {
            bookList = bookService.findBooksByAuthorAndAvailableFlag(authorName, available);
        } else if (authorName != null) {
            bookList = bookService.findBooksByAuthor(authorName);
        } else if (bookTitle!=null) {
            bookList = bookService.findBooksByTitle(bookTitle);
        }else if (genre!=null){
            bookList = bookService.findBooksByGenre(genre);
        }
        return new ResponseEntity(bookList, HttpStatus.ACCEPTED);
    }


}
