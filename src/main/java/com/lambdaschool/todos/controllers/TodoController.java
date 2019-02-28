package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("id/{id}")
  public Todo oneById(@PathVariable int id) {
    return repository.findById(id);
  }

  @GetMapping("users")
  public List<Object> todosWithUsername() {
    return repository.findAllWithNames();
  }

  @PostMapping("")
  public Todo add(@RequestBody Todo todo) {
    return repository.save(todo);
  }

  @PutMapping("id/{id}")
  public Todo update(@RequestBody Todo todo, @PathVariable int id) {
    Todo found = repository.findById(id);
    if (found != null) {
      todo.setId(id);
      return repository.save(todo);
    }
    return null;
  }

  @DeleteMapping("id/{id}")
  public Todo delete(@PathVariable int id) {
    Todo found = repository.findById(id);
    if (found != null) {
      repository.deleteById(id);
    }
    return found;
  }
}
