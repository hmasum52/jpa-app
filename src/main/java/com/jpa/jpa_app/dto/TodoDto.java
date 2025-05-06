package com.jpa.jpa_app.dto;

import lombok.Data;

@Data
public class TodoDto {
  private String title;

  private String description;

  private boolean completed;
}
