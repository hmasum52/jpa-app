package com.jpa.jpa_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpa.jpa_app.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
  List<Todo> findByCompletedFalse();

  @Query("SELECT t FROM Todo t WHERE LOWER(t.description) LIKE LOWER(CONCAT('%', :description, '%'))")
  List<Todo> searchByDescription(String description);
}


