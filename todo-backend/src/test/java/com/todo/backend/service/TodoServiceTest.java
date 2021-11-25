package com.todo.backend.service;

import com.todo.backend.model.Todo;
import com.todo.backend.repository.TodoRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepo todoRepo;

    private static final int VALID_STATUS = 1;
    private static final int INVALID_STATUS = 0;

    @Before()
    public void setMocks() {
        Mockito.when(todoRepo.findByStatus(Mockito.anyInt())).thenReturn(mockTodoRepoFindByStatus());
        Mockito.when(todoRepo.getById(Mockito.anyInt())).thenReturn(mockDeleteTodo());
    }

    @Test
    public void getAllTodosTest() {
        List<Todo> todos = todoService.getAllTodos(VALID_STATUS);
        Assertions.assertFalse(todos.isEmpty());
        Assertions.assertNotNull(todos.get(0).getDescription());
        Assertions.assertEquals(VALID_STATUS, todos.get(0).getStatus());
    }

    @Test
    public void deleteTodoTest() {
        Todo todo = new Todo();
        TodoService todoService = Mockito.mock(TodoService.class);
        doNothing().when(todoService).deleteTodo(Mockito.anyInt());
        Assertions.assertEquals(INVALID_STATUS, todo.getStatus());
    }

    private static Todo mockDeleteTodo() {
        Todo todo = new Todo();
        todo.setStatus(0);
        return todo;
    }

    private static List<Todo> mockTodoRepoFindByStatus() {
        List<Todo> todos = new ArrayList<>();
        Todo todo = new Todo();
        todo.setId(1);
        todo.setDescription("Studying Finals");
        todo.setStatus(1);
        todos.add(todo);
        return todos;
    }
}
