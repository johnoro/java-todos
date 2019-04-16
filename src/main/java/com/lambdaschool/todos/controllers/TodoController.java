package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.Todo;
import com.lambdaschool.todos.repositories.TodoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//* 200 - successfully retrieve list
//  * 401 - not authorized for this resource
//  * 403 - access to resource forbidden
//  * 404 - resource not found

@RestController
@ApiResponses(value = {
  @ApiResponse(code = 200, message = "successfully retrieve resource"),
  @ApiResponse(code = 401, message = "not authorized for this resource"),
  @ApiResponse(code = 403, message = "access to resource forbidden"),
  @ApiResponse(code = 404, message = "resource not found")
})
@RequestMapping(path = "todos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {
  @Autowired
  TodoRepository repository;

  @ApiOperation(value = "Lists all todos", response = List.class)
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Good list"),
    @ApiResponse(code = 401, message = "Bad user"),
    @ApiResponse(code = 403, message = "Forbidden"),
    @ApiResponse(code = 404, message = "Bad list")
  })
  @GetMapping("")
  public List<Todo> all() {
    return repository.findAll();
  }

  @GetMapping("id/{id}")
  public Todo oneById(@PathVariable int id) {
    return repository.findById(id);
  }

  @ApiOperation(
    value = "Lists all todos with their respective usernames",
    response = Todo.class
  )
  @GetMapping("users")
  public List<Object> todosWithUsername() {
    return repository.findAllWithNames();
  }

  @PostMapping("")
  public Todo add(@RequestBody Todo todo) {
    return repository.save(todo);
  }

  @ApiOperation(value = "Updates a todo", response = Todo.class)
  @PutMapping("id/{id}")
  public Todo update(@RequestBody Todo todo, @PathVariable int id) {
    Todo found = repository.findById(id);
    if (found != null) {
      todo.setId(id);
      return repository.save(todo);
    }
    return null;
  }

  @ApiOperation(value = "Deletes a todo", response = Todo.class)
  @DeleteMapping("id/{id}")
  public Todo delete(@PathVariable int id) {
    Todo found = repository.findById(id);
    if (found != null) {
      repository.deleteById(id);
    }
    return found;
  }
}
