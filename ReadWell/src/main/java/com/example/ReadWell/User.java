package com.example.ReadWell;

import java.util.List;

public interface User {
	
	void setDetails(String userName);
	List<Book> getAllBooks();
	void issueOrAddBooks(Book book);

}
