package com.library.dao;

import com.library.db.DBConnection;
import com.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Add Book
    public boolean addBook(Book book) {
        String sql = "INSERT INTO books (id, title, author, price) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, book.getId());
            pst.setString(2, book.getTitle());
            pst.setString(3, book.getAuthor());
            pst.setDouble(4, book.getPrice());

            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // View All Books
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Search Book by ID
    public Book getBookById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete Book
    public boolean deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
