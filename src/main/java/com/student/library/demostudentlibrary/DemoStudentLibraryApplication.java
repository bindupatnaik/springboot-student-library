package com.student.library.demostudentlibrary;

import com.student.library.demostudentlibrary.model.*;
import com.student.library.demostudentlibrary.repository.AuthorRepository;
import com.student.library.demostudentlibrary.repository.BookRepository;
import com.student.library.demostudentlibrary.repository.CardRepository;
import com.student.library.demostudentlibrary.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoStudentLibraryApplication implements CommandLineRunner {
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoStudentLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Card card = new Card();
//		card.setCardStatus(CardStatus.ACTIVATED);
//		Student student = new Student("Arvind", 30, "USA", "arvind@gmail.com");
//		card.setStudent(student);
//		student.setCard(card);
//		cardRepository.save(card);
//
//		Author author = new Author("Hemamalini", 30, "India", "hemamalini@gmal.com");
//		Book book = new Book("Hypothesis of Science", Genre.NON_FICTIONAL, true, author ); //author is set here already.
//		List<Book> bookList = new ArrayList<>();
//		bookList.add(book);
//		author.setBooksList(bookList);
//		authorRepository.save(author);
//		bookRepository.save(book);
	}
}
