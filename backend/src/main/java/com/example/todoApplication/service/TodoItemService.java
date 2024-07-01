package com.example.todoApplication.service;

import com.example.todoApplication.model.TodoItem;
import com.example.todoApplication.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    private final TodoItemRepository todoItemRepository;

    @Autowired
    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getAllTodoItems() {
        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> getTodoItemById(Long id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem saveTodoItem(TodoItem todoItem) {
        // Set default values or apply business logic before saving
        todoItem.setCreatedAt(LocalDateTime.now());
        return todoItemRepository.save(todoItem);
    }

    public TodoItem updateTodoItem(Long id, TodoItem updatedTodoItem) {
        Optional<TodoItem> existingTodoItemOptional = todoItemRepository.findById(id);

        if (existingTodoItemOptional.isPresent()) {
            TodoItem existingTodoItem = existingTodoItemOptional.get();

            // Preserve createdAt from the existing item
            updatedTodoItem.setCreatedAt(existingTodoItem.getCreatedAt());
            updatedTodoItem.setId(id); // Ensure ID is set

            // Save the updated todo item
            return todoItemRepository.save(updatedTodoItem);
        }

        return null; // Handle not found case appropriately
    }

    public boolean deleteTodoItem(Long id) {
        if (todoItemRepository.existsById(id)) {
            todoItemRepository.deleteById(id);
            return true;
        }
        return false; // Handle not found case appropriately
    }

    // Other business logic methods as needed
}
