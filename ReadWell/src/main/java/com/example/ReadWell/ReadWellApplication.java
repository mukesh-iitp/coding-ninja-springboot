package com.example.ReadWell;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ReadWellApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ReadWellApplication.class, args);
		Scanner scanner =  new Scanner(System.in);
		System.out.println("Welcome to the Library Application");
		while(true) {
			System.out.println("Please choose your user type:\n1. Admin\n2. Student\n3. Exit");
			int userChoice = scanner.nextInt();
			String userType = null;
			switch (userChoice) {
			case 1 -> userType = "Admin";
			case 2 -> userType = "Student";
			default -> {
				System.out.println("Exiting...");
				System.exit(0);
				}
			}
			scanner.nextLine();
			System.out.print("Please enter your name: ");
			String name = scanner.nextLine();
			if (userType.equals("Admin")) {
				User user = context.getBean(Admin.class);
				while (true) {
					System.out.println("Do you want to add books\n1. Yes\n2. No");
					int choice = scanner.nextInt();
					scanner.nextLine();
					if (choice == 1) {
						System.out.println("Enter the name of book");
						String bookName = scanner.nextLine();
						Book book = context.getBean(Book.class);
						book.setBookName(bookName);
						user.getAllBooks().add(book);
					} else {
						System.out.println("The List of books are:");
						List<Book> bookList = user.getAllBooks();
						for (int i = 0; i < bookList.size(); i++) {
							if (!bookList.get(i).isIssued())
								System.out.println(bookList.get(i).getBookName() + " id:" + i);
						}
						break;
					}
				}
			} else if(userType.equals("Student")){
				User user = context.getBean(Student.class);
				user.setDetails(name);
				while(true) {
					System.out.println("List of all available books:");
					List<Book> bookList = user.getAllBooks();
					for (int i = 0; i < bookList.size(); i++) {
						if (!bookList.get(i).isIssued())
							System.out.println(bookList.get(i).getBookName() + " id:" + i);
					}
					System.out.println("Do you want to issue books:\n1. Yes\n2. No");
					int studentChoice = scanner.nextInt();
					if(studentChoice == 1) {
						System.out.println("Enter the book number which you want to issue: ");
						int bookNumber = scanner.nextInt();
						if(bookList.size() == 0 || bookNumber >= bookList.size() || bookNumber < 0) {
							System.out.println("Invalild book number");
						}
						else user.issueOrAddBooks(bookList.get(bookNumber));
					}
					else break;
				}
			}
			else break;
		}
		scanner.close();

	}

}
