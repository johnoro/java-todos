package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.User;

public interface UserRepository extends BaseRepository<User> {
  User findById(int id);
  User findByName(String name);
}
