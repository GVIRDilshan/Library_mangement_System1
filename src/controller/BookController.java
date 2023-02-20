package controller;

import modal.Book;
import modal.Member;

import java.sql.*;
import java.util.ArrayList;

public class BookController {

    public static boolean AddBook(Book book) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("insert into  book values(?,?,?,?)");
            stm.setObject(1, book.getId());
            stm.setObject(2, book.getName());
            stm.setObject(3, book.getAuthor());
            stm.setObject(4, book.getQty());

            int result = stm.executeUpdate();

            if (result > 0) {
                return true;
            } else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static Book bookSearch(String id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from book where bookID=?");

            stm.setObject(1, id);

            ResultSet result = stm.executeQuery();

            if (result.next()) {
                Book book = new Book();
                book.setId(result.getString(1));
                book.setName(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setQty(Integer.parseInt(result.getString(4)));
                return book;
            }
            return null;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean BookDelete(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("delete from book where bookID =?");

            stm.setObject(1, id);

            int result = stm.executeUpdate();

            if (result > 0) {
                return true;
            } else {
                return false;
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean BookUpdate(Book b1) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("update book set name=?, author=?, price=? where  bookId=?");

            stm.setObject(1, b1.getName());
            stm.setObject(2, b1.getAuthor());
            stm.setObject(3, b1.getQty());
            stm.setObject(4, b1.getId());

            int result = stm.executeUpdate();

            if (result == 1) {
                return true;
            }else{
                return false;
            }
        } catch (
                ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Book> loadAllMember() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from book");

            ResultSet result = stm.executeQuery();

            ArrayList<Book> books = new ArrayList<>();

            while (result.next()) {
                Book book = new Book();

                book.setId(result.getString(1));
                book.setName(result.getString(2));
                book.setAuthor(result.getString(3));
                book.setQty(Integer.parseInt(result.getString(4)));

                books.add(book);
            }
            return books;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<String> loadAllBookIds() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select bookId from book");

            ResultSet result = stm.executeQuery();

            ArrayList<String> BookIds = new ArrayList<>();

            while (result.next()) {
                BookIds.add(result.getString(1));
            }
            return BookIds;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}


