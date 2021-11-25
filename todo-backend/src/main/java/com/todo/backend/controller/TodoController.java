package com.todo.backend.controller;

import com.todo.backend.model.Todo;
import com.todo.backend.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8000"})
@Slf4j
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping("/getTodos")
    @GetMapping
    public ResponseEntity getTodos() {
        return ResponseEntity.ok(todoService.getAllTodos(1));
    }

    @RequestMapping("/addTodo")
    @PostMapping
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.addTodo(todo));
    }

    @RequestMapping("/deleteTodo")
    @PostMapping
    public void deleteTodo(@RequestBody Todo todo) {
        todoService.deleteTodo(todo.getId());
    }

    @RequestMapping("/updateTodo")
    @PostMapping
    public ResponseEntity updateTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.updateTodo(todo));
    }

}
