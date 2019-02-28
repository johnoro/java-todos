package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.UserRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.StringUtils.capitalize;

@RestController
@ApiResponses(value = {
  @ApiResponse(code = 200, message = "successfully retrieve resource"),
  @ApiResponse(code = 401, message = "not authorized for this resource"),
  @ApiResponse(code = 403, message = "access to resource forbidden"),
  @ApiResponse(code = 404, message = "resource not found")
})
@RequestMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
  @Autowired
  UserRepository repository;

  @GetMapping("")
  public List<User> all() {
    return repository.findAll();
  }

  @GetMapping("id/{id}")
  public User oneById(@PathVariable int id) {
    return repository.findById(id);
  }

  @GetMapping("name/{name}")
  public User oneByName(@PathVariable String name) {
    return repository.findByName(
      capitalize(
        name.toLowerCase()
      )
    );
  }

  @PostMapping("")
  public User add(@RequestBody User user) {
    user.setName(
      capitalize(
        user.getName().toLowerCase()
      )
    );
    return repository.save(user);
  }

  @PutMapping("id/{id}")
  public User update(@RequestBody User user, @PathVariable int id) {
    User found = repository.findById(id);
    if (found != null) {
      user.setId(id);
      return repository.save(user);
    }
    return null;
  }

  @DeleteMapping("id/{id}")
  public User delete(@PathVariable int id) {
    User found = repository.findById(id);
    if (found != null) {
      repository.deleteById(id);
    }
    return found;
  }
}
