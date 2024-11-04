package com.codingninjas.jpaqueries.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.jpaqueries.entities.Course;
import com.codingninjas.jpaqueries.entities.Student;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByName(String course);
	
	/*
	 * Write a JPQL Query which returns the List of courses_name by the student id'
	 */
	
	//JPQL
	//@Query("SELECT c.courses FROM Student c WHERE c.id=?1")
	@Query("SELECT c.name from Course c where :student MEMBER OF c.students")
	List<String> getCoursesNameByStudentId(Student student);
	//List<String> getCoursesNameByStudentId(@Param("student")Student student);

	
}
