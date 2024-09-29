package com.akimi.hibernate_sandbox_mvn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final Books books;

    @Autowired
    public BookController(Books books) {
	this.books = books;
    }
    
    @GetMapping
    public List<Book> getBooks() {
	return books.findAll();
    }
    
    @PostMapping
    public void addBook(@RequestBody Book book) {
	books.save(book);
    }
    
}
