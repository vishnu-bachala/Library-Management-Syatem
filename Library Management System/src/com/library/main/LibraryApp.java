package com.library.main;

import com.library.dao.BookDAO;
import com.library.model.Book;

import java.util.*;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n=== Library Management ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    Book book = new Book(id, title, author, price);
                    if (dao.addBook(book)) {
                        System.out.println("✅ Book added successfully!");
                    } else {
                        System.out.println("❌ Failed to add book.");
                    }
                    break;

                case 2:
                    List<Book> books = dao.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        books.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int searchId = sc.nextInt();
                    Book found = dao.getBookById(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    if (dao.deleteBook(deleteId)) {
                        System.out.println("✅ Book deleted.");
                    } else {
                        System.out.println("❌ Failed to delete.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
