# 📘 E-Learning Platform

A full-stack E-Learning Platform built using **Spring Boot (Java)** for the backend and **React.js** for the frontend. The platform allows **Students**, **Teachers**, and the **COE (Controller of Examinations)** to manage course registrations, submissions, grading, and certificate approvals through a secure, role-based system.

---

## 🚀 Features

### 👨‍🎓 Student
- Register and log in
- Enroll in courses
- Submit assignments
- View grades and course materials

### 👩‍🏫 Teacher
- Create and manage courses
- Upload materials and assignments
- Grade student submissions

### 🧑‍💼 COE (Controller of Examinations)
- Monitor platform activity
- Approve final grades
- Issue completion certificates

---

## 🏗️ Architecture

- **Backend**: Spring Boot (Java), REST APIs, MySQL Database
- **Frontend**: React.js with modular components
- **Pattern**: Model-View-Controller (MVC)

---

## 🧠 Design Patterns & Principles

### Design Patterns:
- **MVC** – Clean separation between model, view, and controller layers
- **Factory Pattern** – Used via Spring Boot’s bean configuration
- **Strategy Pattern** – Role-based service delegation
- **Dependency Injection (DI)** – Loose coupling via `@Autowired`

### Design Principles:
- **Single Responsibility Principle**
- **Open/Closed Principle**
- **Interface Segregation Principle**
- **Dependency Inversion Principle**

---

## 🗂️ Project Structure

e-learning-platform/ ├── e-learning-frontend/ # React.js frontend 
                     └── e-learning-platform/ # Spring Boot backend 
                     ├── src/ 
                     │ 
                     └── main/java/com/... # Java source files 
                     ├── pom.xml 
                     └── application.properties


---

## ⚙️ Tech Stack

- **Java 17**
- **Spring Boot 3.2.5**
- **MySQL**
- **React.js**
- **Maven**

---

## 🔧 Getting Started

### Backend (Spring Boot)
```bash
cd e-learning-platform
./mvnw spring-boot:run

### Frontend (React.js)
```bash
cd e-learning-frontend
npm install
npm start
