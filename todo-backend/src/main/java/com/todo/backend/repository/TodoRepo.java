package com.todo.backend.repository;

import com.todo.backend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepo extends JpaRepository<Todo, Integer> {

    List<Todo> findByStatus(int status);

}
