# Todo List Application

This is a full-stack Todo List application developed using React for the front end and Spring Boot for the back end.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Project Structure](#project-structure)
- [API Endpoints](#api-endpoints)
- [Contributing](#contributing)
- [Contact](#contact)

## Introduction

The Todo List application allows users to manage their tasks efficiently. Users can create, update, delete, and categorize tasks. Additional features include authentication, drag and drop functionality, due dates, and dark mode.

## Features

- Create, Read, Update, and Delete (CRUD) tasks
- Categorize tasks
- Set due dates for tasks
- Drag and drop functionality
- Dark mode for better user experience
- User authentication

## Technologies Used

- **Frontend:** React, Tailwind CSS
- **Backend:** Spring Boot, Spring JPA, H2 Database
- **Tools:** Git, VSCode, Intellij, Postman

## Getting Started

### Prerequisites

- Node.js and npm (for the frontend)
- Java 21 (for the backend)
- H2 Database (for the in-memory database)

### Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/yourusername/Get-Things-Done-Application.git
   cd Get-Things-Done-Application

2. **Install frontend dependencies:**

cd frontend
npm install

3. **Setup backend:**

    Navigate to the backend directory:
    cd ../backend

Update application.properties with your H2 database credentials

4. **Build and run the backend:**

mvn clean install
mvn spring-boot:run

Run the frontend:


    cd ../frontend
    npm start

**Running the Application**

    Backend: Runs on http://localhost:8080
    Frontend: Runs on http://localhost:3000

**##Project Structure**

todo-list-app/
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/todoApplication/
│   │       └── resources/
│   └── pom.xml
├── frontend/
│   ├── public/
│   ├── src/
│   └── package.json
└── README.md

**##API Endpoints##**

Task Endpoints

    GET /api/todo - Get all tasks
    GET /api/todo/{id} - Get task by ID
    POST /api/todo - Create a new task
    PUT /api/todo/{id} - Update a task
    DELETE /api/todo/{id} - Delete a task**

**##Contributing##**

Contributions are welcome! Please fork this repository and create a pull request with your changes. Ensure your code follows the project's coding standards and includes appropriate tests.

**Contact**

    Email: kadirswachchho@gmail.com
    LinkedIn: https://www.linkedin.com/in/h-m-sazzad-quadir-5a7a701b0/
    GitHub: github.com/byrthokobi
