// src/services/api.js
import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080/api', // Replace with your backend URL
  headers: {
    'Content-Type': 'application/json',
  },
});

export const getAllTodos = () => apiClient.get('/todo');
export const createTodo = (todoData) => apiClient.post('/todo', todoData);
export const updateTodo = (id, todoData) => apiClient.put(`/todo/${id}`, todoData);
export const deleteTodo = (id) => apiClient.delete(`/todo/${id}`);
