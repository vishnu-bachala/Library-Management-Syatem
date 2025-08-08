### 📚 Library Management System (JDBC)

A **basic Library Management System** built in **Java** using **JDBC** for database connectivity.  
It allows users to perform CRUD (Create, Read, Update, Delete) operations on books stored in a MySQL database.

---

## ✨ Features
- ➕ **Add New Book** – Insert new book details into the database.
- 📋 **View All Books** – Retrieve and display all stored books.
- ✏ **Update Book Details** – Modify book title, author, or price.
- ❌ **Delete Book** – Remove a book from the library database.
- 🔍 **Search Book** – Find books by ID or title.

---

## 🛠️ Technologies Used
- **Java** – Core programming language.
- **JDBC (Java Database Connectivity)** – To connect and interact with the database.
- **MySQL** – Backend database to store book records.

---

## 📂 Project Structure

LibraryManagementSystem/
│── src/
│ ├── Book.java # Book entity class
│ ├── DBConnection.java # JDBC database connection utility
│ ├── LibraryDAO.java # Data Access Object with CRUD methods
│ ├── LibraryMain.java # Main menu-driven application
│── library.sql # SQL script to create and populate database
│── README.md # Project documentation



---

## ⚙️ Database Setup
1. **Create Database & Table**  
Run the following SQL script in MySQL:
```sql
CREATE DATABASE librarydb;

USE librarydb;

``
CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);
``
2. Insert sample data

`INSERT INTO books (title, author, price) VALUES
('Java Programming', 'John Doe', 499.99),
('Python Basics', 'Jane Smith', 299.50),
('Database Systems', 'Robert Brown', 599.00);
`

##  How to Run
Import the project into your IDE (Eclipse/IntelliJ/VS Code).

Update database credentials in DBConnection.java:

`private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
`

## 3.Compile and run:

javac src/*.java
java src/LibraryMain

## 4.Use the menu to add, view, update, delete books.

_====== Library Management System ======
1. Add Book
2. View All Books
3. Update Book
4. Delete Book
5. Search Book
6. Exit
Enter your choice:
_



 **📄 License**

This project is open-source and free to use under the MIT License.


```
If you want, I can also **add code snippets for `Book.java`, `DBConnection.java`, `LibraryDAO.java`, and `LibraryMain.java`** in the README so GitHub viewers can see them directly without opening files. That will make your repo more beginner-friendly.  

Do you want me to include that?
```

