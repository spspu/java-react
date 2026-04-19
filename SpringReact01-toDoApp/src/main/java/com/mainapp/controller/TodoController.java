package com.mainapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mainapp.ApiResponse;
import com.mainapp.entity.TodoEntity;
import com.mainapp.service.TodoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping
	public ApiResponse homeController() {
		ApiResponse res = new ApiResponse();
		res.setMsg("welcome to todo application");
		res.setStatus(true);
		return res;
	}
	
	@GetMapping("/todoapp")
	public  List<TodoEntity> getAllTodos(){
		return todoService.getAllTodos();
	}
	
	@PostMapping("/todoapp")
	public TodoEntity createTodo(@RequestBody TodoEntity todo){
		return todoService.createTodo(todo);
	}
	
	@DeleteMapping("/todoapp/{id}")
	public ApiResponse deleteTodo(@PathVariable Long id) throws Exception {
		todoService.deleteTodo(id);
		ApiResponse res = new ApiResponse();
		res.setMsg("todo delete successfully");
		res.setStatus(true);
		return res;
	}

}
