package com.student.library.demostudentlibrary.controller;

import com.student.library.demostudentlibrary.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value="/issueABook")
    public ResponseEntity issueBook(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId){
        String transactionId = transactionService.issueBook(cardId, bookId);
        if (transactionId.contains("Card")){
            return new ResponseEntity<>(transactionId, HttpStatus.INTERNAL_SERVER_ERROR);
        }else if(transactionId.contains("Book")|| transactionId.contains("book")){
            return new ResponseEntity<>(transactionId, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(transactionId, HttpStatus.OK);
        }
    }

    @PostMapping(value="/returnABook")
    public ResponseEntity returnBook(@RequestParam("cardId")int cardId, @RequestParam("bookId") int bookId) throws Exception {
        String transactionId = transactionService.returnBook(cardId, bookId);
        if (transactionId.contains("Card")){
            return new ResponseEntity<>(transactionId, HttpStatus.INTERNAL_SERVER_ERROR);
        }else if(transactionId.contains("Book")){
            return new ResponseEntity<>(transactionId, HttpStatus.INTERNAL_SERVER_ERROR);
        }else{
            return new ResponseEntity<>(transactionId, HttpStatus.OK);
        }
    }

}
