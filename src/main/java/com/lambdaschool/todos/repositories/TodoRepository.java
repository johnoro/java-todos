package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.Todo;

public interface TodoRepository extends BaseRepository<Todo> {
  Todo findById(int id);
}
