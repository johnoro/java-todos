package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "todos")
public class Todo {
  @Id
  @GeneratedValue
  @Column(name = "todoid", nullable = false)
  private int id;

  @Column(nullable = false)
  private String description;

  // dateStarted, completed

  @ManyToOne
  @JoinColumn(name = "userid", nullable = false)
  @JsonIgnore
  private User user;

  public Todo() {}
}
