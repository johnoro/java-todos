package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {
  @Autowired
  TodoRepository repository;

  @GetMapping("")
  public List<Todo> all() {
    return repository.findAll();
  }
}
