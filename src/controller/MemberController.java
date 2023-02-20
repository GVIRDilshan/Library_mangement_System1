package controller;

import modal.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;

public class MemberController {


    public static boolean memberAddFrom(Member member) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("insert into member values(?,?,?,?,?,?)");

            stm.setObject(1, member.getId());
            stm.setObject(2, member.getName());
            stm.setObject(3, member.getAddress());
            stm.setObject(4, member.getContact());
            stm.setObject(5, member.getAge());
            stm.setObject(6,member.getEmail());

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

    public static Member searchFrom(String id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from member where memberId=?");

            stm.setObject(1, id);

            ResultSet result = stm.executeQuery();

            if (result.next()) {
                Member member = new Member();
                member.setId(result.getString(1));
                member.setName(result.getString(2));
                member.setAddress(result.getString(3));
                member.setContact(result.getString(4));
                member.setAge(Integer.parseInt(result.getString(5)));
                member.setEmail(result.getString(6));
                return member;
            }
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteFrom(String id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("delete from member where memberId =?");

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

    public static Boolean updateMember(Member member) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("update member set name=?,address=?,contact=?,age=?,email=? where memberId=?");

            stm.setObject(1, member.getName());
            stm.setObject(2, member.getAddress());
            stm.setObject(3, member.getContact());
            stm.setObject(4, member.getAge());
            stm.setObject(5,member.getEmail());
            stm.setObject(6, member.getId());

            int result = stm.executeUpdate();

            if (result == 1) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static ArrayList<Member> loadAllMember() {
        try {
            //java app + mysql connect karana connector load
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create a connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from member");

            ResultSet result = stm.executeQuery();

            ArrayList<Member> members = new ArrayList<>();

            while (result.next()) {
                Member member = new Member();

                member.setId(result.getString(1));
                member.setName(result.getString(2));
                member.setAddress(result.getString(3));
                member.setContact(result.getString(4));
                member.setAge(Integer.parseInt(result.getString(5)));
                member.setEmail(result.getString(6));

                members.add(member);
            }

            return members;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<String> loadAllMemberIds() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select memberId from member");

            ResultSet result = stm.executeQuery();

            ArrayList<String> membersIds = new ArrayList<>();

            while (result.next()) {
               membersIds.add(result.getString(1));
            }
            return membersIds;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<String> loadAllMemberEmails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select email from member");

            ResultSet result = stm.executeQuery();

            ArrayList<String> Emails = new ArrayList<>();

            while (result.next()) {
                Emails.add(result.getString(1));
            }
            return Emails;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
