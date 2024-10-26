package com.example.ReadWell;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class MyBookList implements BookList {
	
	List<Book> bookList = new ArrayList<>();

	@Override
	public List<Book> getAllBooks() {
		return this.bookList;
	}

	@Override
	public void addBook(Book book) {
		this.bookList.add(book);
	}
	
	@PostConstruct
	private void init() {
		this.bookList.add(new MyBook("The Martian"));
        this.bookList.add(new MyBook("Sapiens"));
        this.bookList.add(new MyBook("Harry Potter"));
        this.bookList.add(new MyBook("Introduction to Algorithms"));

	}

}
