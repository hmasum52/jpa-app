package com.jpa.jpa_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.jpa_app.dto.TodoDto;
import com.jpa.jpa_app.model.Todo;
import com.jpa.jpa_app.service.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todo")
@RequiredArgsConstructor
public class TodoController {
  private final TodoService todoService;

  @PostMapping
  public Todo createTodo(@RequestBody TodoDto dto) {
    return todoService.createTodo(dto);
  }

  @GetMapping("")
  public List<Todo> getAllTodos() {
    return todoService.getAllTodos();
  }

  @GetMapping("/{id}")
  public Todo getTodoById(@PathVariable Long id) {
    return todoService.getTodoById(id);
  }

  @PutMapping("/{id}")
  public Todo updateTodo(@PathVariable Long id, @RequestBody TodoDto dto) {
    return todoService.updateTodo(id, dto);
  }

  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Long id) {
    todoService.deleteTodo(id);
  }



}
