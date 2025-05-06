package com.jpa.jpa_app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.jpa_app.dto.TodoDto;
import com.jpa.jpa_app.model.Todo;
import com.jpa.jpa_app.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final TodoRepository todoRepository;

  public Todo createTodo(TodoDto dto) {
    Todo todo = Todo.builder()
        .title(dto.getTitle())
        .description(dto.getDescription())
        .completed(dto.isCompleted())
        .build();
    return todoRepository.save(todo);
  }

  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }

  public Todo getTodoById(Long id) {
    return todoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Todo not found"));
  }

  public Todo updateTodo(Long id, TodoDto dto) {
    Todo todo = getTodoById(id);
    todo.setTitle(dto.getTitle());
    todo.setDescription(dto.getDescription());
    todo.setCompleted(dto.isCompleted());
    return todoRepository.save(todo);
  }

  public void deleteTodo(Long id) {
    Todo todo = getTodoById(id);
    todoRepository.delete(todo);
  }

  public List<Todo> getPendingTodos(){
    return todoRepository.findByCompletedFalse();
  }

  public List<Todo> searchByDescription(String description) {
    return todoRepository.searchByDescription(description);
  }
}
