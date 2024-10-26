package com.example.SocialMedia;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SocialMediaApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SocialMediaApplication.class, args);
		//get the context from xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Post post = (Post) context.getBean("simplePost");
		
		//get the user
		User user = (User) context.getBean("simpleUser");
		
		//prompt the user
		System.out.println("Social Media app! start");
		
		//setup scanner
		Scanner scanner = new Scanner(System.in);
		
		//get name of the user
		System.out.println("Please enter your name:");
		String userName = scanner.nextLine();
		user.setUserName(userName);
		
		//infinite post loop
		while(true) {
			//fetch a post list
			//PostList postList = (PostList) context.getBean("simplePostList");
			PostList postList = user.getPostList();
			
			System.out.println("The reference of postlist"+postList.toString());;
			
			//prompt user for different option
			System.out.println("1. Make new post \n2. Show all posts \n3. Exit");
			int menuItem = scanner.nextInt();
			
			switch(menuItem) {
			case 1: 
				Post post = (Post) context.getBean("simplePost");
				System.out.println("Please enter a post:");
				scanner.nextLine(); //getting the \n and moving to next input
				String message = scanner.nextLine();
				post.setMessage(message);
				postList.setPost(post);
				break;
				
			case 2:
				System.out.println("All the posts !");
				for(int i=0; i<postList.size(); i++) {
					System.out.println("Ther reference of post"+postList.getPost(i).toString());
					System.out.println((i+1)+") "+user.getUserName()+": "+postList.getPost(i).getMessage());
				}
				break;
							
			case 3:
				System.out.println("Exiting...");
				break;
				
			default: 
				System.out.println("Error...");
			
			}
			
			if(menuItem == 3)
				break;

		}
		scanner.close();
		context.close();
		
	}

}
