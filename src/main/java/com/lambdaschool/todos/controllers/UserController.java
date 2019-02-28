package com.lambdaschool.todos.controllers;

import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
  @Autowired
  UserRepository repository;

  @GetMapping("")
  public List<User> all() {
    return repository.findAll();
  }
}
