// src/components/TodoList.js

import React, { useState, useEffect } from 'react';
import { getAllTodos, createTodo, updateTodo, deleteTodo } from '../services/api';

const TodoList = () => {
  const [todos, setTodos] = useState([]);
  const [newTodo, setNewTodo] = useState('');
  const [editingTodo, setEditingTodo] = useState(null);
  const [updatedTodo, setUpdatedTodo] = useState('');

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    try {
      const response = await getAllTodos();
      setTodos(response.data);
    } catch (error) {
      console.error('Error fetching todos:', error);
    }
  };

  const handleCreateTodo = async () => {
    try {
      const response = await createTodo({
        title: newTodo,
        description: 'Default description',
        completed: false,
      });
      setTodos([...todos, response.data]);
      setNewTodo('');
    } catch (error) {
      console.error('Error creating todo:', error);
    }
  };

  const handleDeleteTodo = async (id) => {
    try {
      await deleteTodo(id);
      setTodos(todos.filter(todo => todo.id !== id));
    } catch (error) {
      console.error('Error deleting todo:', error);
    }
  };

  const handleUpdateTodo = async () => {
    try {
      const response = await updateTodo(editingTodo.id, {
        ...editingTodo,
        title: updatedTodo,
      });
      setTodos(todos.map(todo => (todo.id === editingTodo.id ? response.data : todo)));
      setEditingTodo(null);
      setUpdatedTodo('');
    } catch (error) {
      console.error('Error updating todo:', error);
    }
  };

  const startEditing = (todo) => {
    setEditingTodo(todo);
    setUpdatedTodo(todo.title);
  };

  return (
    <div className="max-w-xl mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">Todo List</h1>
      <div className="flex mb-4">
        <input
          type="text"
          value={newTodo}
          onChange={(e) => setNewTodo(e.target.value)}
          placeholder="Enter new todo..."
          className="flex-1 p-2 border border-gray-300 rounded"
        />
        <button onClick={handleCreateTodo} className="ml-2 p-2 bg-blue-500 text-white rounded">Add Todo</button>
      </div>

      <ul className="space-y-2">
        {todos.map(todo => (
          <li key={todo.id} className="p-4 border border-gray-300 rounded flex justify-between items-center">
            {editingTodo && editingTodo.id === todo.id ? (
              <div className="flex flex-1">
                <input
                  type="text"
                  value={updatedTodo}
                  onChange={(e) => setUpdatedTodo(e.target.value)}
                  className="flex-1 p-2 border border-gray-300 rounded"
                />
                <button onClick={handleUpdateTodo} className="ml-2 p-2 bg-green-500 text-white rounded">Save</button>
                <button onClick={() => setEditingTodo(null)} className="ml-2 p-2 bg-red-500 text-white rounded">Cancel</button>
              </div>
            ) : (
              <div className="flex flex-1 justify-between items-center">
                <p className="flex-1">{todo.title}</p>
                <button onClick={() => startEditing(todo)} className="ml-2 p-2 bg-yellow-500 text-white rounded">Update</button>
                <button onClick={() => handleDeleteTodo(todo.id)} className="ml-2 p-2 bg-red-500 text-white rounded">Delete</button>
              </div>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
