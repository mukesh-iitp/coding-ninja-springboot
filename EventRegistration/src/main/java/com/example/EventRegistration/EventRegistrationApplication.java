package com.example.EventRegistration;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		// Import scanner and take ClassPathXmlApplicationContext.
		Scanner scanner = new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		College myCollege = (College) context.getBean("myCollege");
//		System.out.println("Welcome to the Graduation Ceremony Registration Application");
		System.out.println("Welcome to the Graduation Ceremony Registration Application for " + myCollege.getCollegeName());

		// Take the college event bean from the application context.
		CollegeEvent event = myCollege.getCollegeEvent();

		//event.printEventDetails();
		myCollege.getCollegeEvent().printEventDetails();
		
		// Print the event details.
		while (true) {
			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
			int input = scanner.nextInt();
			if (input == 1) {
				/*
				 1. Take attendee details from the console.
				 2. Get studentAttendee bean from context and set the attendee details
				 3. Register the attendee for the event.
				 4. Print the registration confirmation.
				 */
				System.out.println("Please enter your name");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Please enter your department");
				String department = scanner.nextLine();
				System.out.println("In which year did you pass out?");
				int batch = scanner.nextInt();
				Attendee studentAttendee = (Attendee) context.getBean("student");
				studentAttendee.setAttendeeDetails(name, department, batch);
				event.setAttendee(studentAttendee);
//				myCollege.getCollegeEvent().setAttendee(studentAttendee);
				event.registerStudent(studentAttendee);
//				myCollege.getCollegeEvent().registerStudent(studentAttendee);
				studentAttendee.printRegistrationConfirmation();
				
			} else if(input == 2) {
				break;
			} else {
				System.out.println("Invalid Choice");
				return;
			}
		}

		// Get the number of attendees and print along with the statement below
		System.out.println("No. of attendees registered are: " + event.getAttendeeCount());
		System.out.println("The list of attendees are:");
		// Print all the attendee names with their reference ids as given in the sample output..
		for(Attendee attendee : event.getAllAttendees() ) {
			int attendeeSize = attendee.toString().length();
			System.out.println(attendee.getAttendeeName()+ "\t Reference id: " + attendee.toString().substring(attendeeSize - 9, attendeeSize));
			}

	}

}
