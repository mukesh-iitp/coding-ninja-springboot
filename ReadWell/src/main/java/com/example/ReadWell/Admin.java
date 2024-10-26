package com.example.ReadWell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Admin implements User {
	
	String name;
	@Autowired
	BookList bookList;

	@Override
	public void setDetails(String userName) {
		this.name = userName;
	}

	@Override
	public List<Book> getAllBooks() {
		return this.bookList.getAllBooks();
	}

	@Override
	public void issueOrAddBooks(Book book) {
		this.bookList.addBook(book);
	}

}
