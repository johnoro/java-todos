package com.lambdaschool.todos.repositories;

import com.lambdaschool.todos.models.Todo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends BaseRepository<Todo> {
  Todo findById(int id);

  @Query(
    value = "SELECT t.*, u.username as username" +
      " FROM todos t" +
      " JOIN users u ON t.userid = u.userid",
    nativeQuery = true
  )
  List<Object> findAllWithNames();
}
