package controller;

import modal.Issuse;
import modal.Member;

import java.sql.*;
import java.util.ArrayList;

public class IssuseController {
    public static boolean issuseSet(Issuse issuse, String qty, String issuseId){
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                "root","1234");

        connection.setAutoCommit(false);

        PreparedStatement stm = connection.prepareStatement("insert into issuse values(?,?,?)");

        stm.setObject(1,issuse.getIssusId());
        stm.setObject(2,issuse.getIssusDate());
        stm.setObject(3,issuse.getMemberId());

        int TakeIt = stm.executeUpdate();

        if(TakeIt>0){
            PreparedStatement stm2 = connection.prepareStatement("update book set qty=? where bookId=?");

            stm2.setObject(1,Integer.parseInt(qty));
            stm2.setObject(2,issuseId);

            int itemUpdate = stm2.executeUpdate();

            if(itemUpdate>0){
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            }
            connection.rollback();
            connection.setAutoCommit(true);
        }
        connection.rollback();
        connection.setAutoCommit(true);
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }
        return false;
    }
    public static Issuse IssuseSearch(String iid) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement(" select * from issuse where iid = ? ");

            stm.setObject(1, iid);

            ResultSet result = stm.executeQuery();

            if (result.next()) {
                Issuse issuses = new Issuse();
                issuses.setIssusId(result.getString(1));
                issuses.setIssusDate(result.getString(2));
                issuses.setMemberId(result.getString(3));

                return issuses;
            }
            return null;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Issuse> loadAllIssuse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library",
                    "root", "1234");

            PreparedStatement stm = connection.prepareStatement("select * from issuse");

            ResultSet result = stm.executeQuery();

            ArrayList<Issuse> i1 = new ArrayList<>();

            while (result.next()) {
                Issuse issuse = new Issuse();

                issuse.setIssusId(result.getString(1));
                issuse.setIssusDate(result.getString(2));
                issuse.setMemberId(result.getString(3));

                i1.add(issuse);
            }
            return i1;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
