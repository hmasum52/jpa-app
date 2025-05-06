package com.jpa.jpa_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo {
  @Id
  @GeneratedValue ( strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(columnDefinition = "text")
  private String description;

  private boolean completed;
}
