package com.lambdaschool.todos.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue
  @Column(name = "userid", nullable = false)
  private int id;

  @Column(name = "username", nullable = false)
  private String name;

  @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
  private Set<Todo> todos;

  public User() {}
}
