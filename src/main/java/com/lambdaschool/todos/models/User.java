package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @JsonIgnore
  private Set<Todo> todos;

  public User() {}
}
