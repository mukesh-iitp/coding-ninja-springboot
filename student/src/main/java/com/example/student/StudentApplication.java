package com.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);
		
		StudentService studentService = context.getBean(StudentService.class);
		
		Student student = new Student("Elon Musk", "College Droput");
		studentService.save(student);
		
		
		
	}

}
