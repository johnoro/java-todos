package com.lambdaschool.todos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T> extends JpaRepository<T, Integer> {}
