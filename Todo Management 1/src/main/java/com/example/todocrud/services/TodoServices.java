package com.example.todocrud.services;

import com.example.todocrud.entity.Todo;
import com.example.todocrud.entity.Users;
import com.example.todocrud.repository.ToDoRepository;
import com.example.todocrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TodoServices {

    @Autowired
     UserServices userServices;
    @Autowired
    ToDoRepository toDoRepository;
    @Autowired
     UserRepository userRepository;

    public Todo getTodoById(Long todoId){
        // write code
        return toDoRepository.findById(todoId).get();
    }

    public void addTodo(Long userId, Todo todo){
    	Users user = userRepository.findById(userId).get();
    	if(user != null) {
    		List<Todo> todos = user.getTodoList();
    		if(todos == null) {
    			todos = new ArrayList<>();
    		}
    		todos.add(todo);
    		user.setTodoList(todos);
    		userRepository.save(user);
    	}
    	
    }
    public void deleteTodo(Long userId,Long todoId){
//    	Users user = userServices.getUserById(userId);
//    	List<Todo> todoList = user.getTodoList();
//    	todoList.remove(toDoRepository.findById(todoId).get());
//    	user.setTodoList(todoList);
//    	userRepository.save(user);
    	Todo removedTodo = new Todo();
    	Users user = userServices.getUserById(userId);
    	Todo todo = this.getTodoById(todoId);
    	for(int i=0; i<user.getTodoList().size(); i++) {
    		 if(user.getTodoList().get(i).getId() == todo.getId()){
    			 removedTodo = user.getTodoList().remove(i);
             }
    	}
    	
    	System.out.println("removed todo -> " + removedTodo.getId() + " | " + removedTodo.getContent());
    	userRepository.save(user);
        toDoRepository.deleteById(todoId);


    }

    public void toggleTodoCompleted(Long todoId){
        Todo todo = this.getTodoById(todoId);
        todo.setCompleted(!todo.getCompleted());
        toDoRepository.save(todo);
    }

    public void updateTodo(Todo todo) {
    	toDoRepository.save(todo);
    }

}
