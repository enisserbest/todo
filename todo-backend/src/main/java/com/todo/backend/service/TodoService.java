package com.todo.backend.service;

import com.todo.backend.model.Todo;
import com.todo.backend.repository.TodoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;

    public List<Todo> getAllTodos(int status) {
        log.debug("all todos retrieving started");
        List<Todo> todos = null;
        try {
            todos = todoRepo.findByStatus(status);
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            log.debug("getAllTodos result is {}", (todos != null ? todos.toString() : "null"));
        }
        return todos;
    }

    public Todo addTodo(Todo todoRequest) {
        log.debug("addTodo started");
        Todo todo = null;
        try {
            todo = todoRepo.save(todoRequest);
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            log.debug("addTodo result is {}", (todo != null ? todo.toString() : "null"));
        }
        return todo;
    }

    public void deleteTodo(int id) {
        log.debug("deleteTodo started");
        Todo todo = null;
        try {
            todo = todoRepo.getById(id);
            todo.setStatus(0);
            todoRepo.save(todo);
        } catch (Exception e) {
            log.warn(e.getMessage());
        } finally {
            log.debug("delete todo is", (todo.getStatus() == 0 ? "success" : "failed"));
        }
    }

    public Todo updateTodo(Todo todoRequest) {
        Todo todo = todoRepo.getById(todoRequest.getId());
        todo.setDescription(todoRequest.getDescription());
        return todoRepo.save(todo);
    }


}
