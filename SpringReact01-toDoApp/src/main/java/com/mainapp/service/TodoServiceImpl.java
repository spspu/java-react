package com.mainapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mainapp.entity.TodoEntity;
import com.mainapp.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	private TodoRepository todoRepo;

	@Override
	public List<TodoEntity> getAllTodos() {
		return todoRepo.findAll();
	}

	@Override
	public TodoEntity createTodo(TodoEntity todo) {
		return todoRepo.save(todo);
	}

	@Override
	public void deleteTodo(Long id) throws Exception {
		TodoEntity todo=todoRepo.findById(id).orElseThrow(()->new Exception("todo not exist"));
		todoRepo.delete(todo);
	}

}
