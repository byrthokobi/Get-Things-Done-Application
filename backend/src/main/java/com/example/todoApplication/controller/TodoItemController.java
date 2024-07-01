package com.example.todoApplication.controller;

import com.example.todoApplication.model.TodoItem;
import com.example.todoApplication.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo")
public class TodoItemController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public List<TodoItem> getAllTodoItems() {
        return todoItemService.getAllTodoItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable("id") Long id) {
        Optional<TodoItem> todoItem = todoItemService.getTodoItemById(id);
        return todoItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TodoItem> createTodoItem(@RequestBody TodoItem todoItem) {
        TodoItem createdTodoItem = todoItemService.saveTodoItem(todoItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable("id") Long id, @RequestBody TodoItem todoItem) {
        TodoItem updatedTodoItem = todoItemService.updateTodoItem(id, todoItem);
        return updatedTodoItem != null ?
                ResponseEntity.ok(updatedTodoItem) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable("id") Long id) {
        boolean deleted = todoItemService.deleteTodoItem(id);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    // Other endpoints and exception handling as needed
}

