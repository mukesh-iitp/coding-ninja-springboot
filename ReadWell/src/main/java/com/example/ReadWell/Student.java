package com.example.ReadWell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student implements User {

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
	public void issueOrAddBooks(Book mybook) throws IndexOutOfBoundsException{
		for(Book book : this.bookList.getAllBooks()){
			if(book.getBookName().equals(mybook.getBookName()) && book.isIssued() == false){
				System.out.println("Book: " + book.getBookName() + " is issued to " +  this.name);
				book.issue();
				break;
			}
		}
	}


}
