package com.mainapp.service;

import java.util.List;

import com.mainapp.entity.TodoEntity;

public interface TodoService {
	
	List<TodoEntity> getAllTodos();
	TodoEntity createTodo(TodoEntity todo);
	void deleteTodo(Long id) throws Exception;

}
