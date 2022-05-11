/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Derek Lien
 */
public class Database {

    Connection conn = null;
    String url = "jdbc:derby:CourseDB; create=true";

    String dbUserName = "pdc";
    String dbPassword = "pdc";

    public void dbsetup() {
        try {
            conn = DriverManager.getConnection(url, dbUserName, dbPassword);
            Statement statement = conn.createStatement();
            String tableName = "Users";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), username VARCHAR(12), fname VARCHAR(12),"
                        + " lname VARCHAR(12), password VARCHAR(12), phone VARCHAR(12), email VARCHAR(12))");
            }

            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {
            System.out.println("Checking for existing tables...");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String TableName = rsDBMeta.getString("TABLE_NAME");
                if (TableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(TableName + " is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
            System.out.println("WOW ERROR!");
        }
        return flag;
    }

    public void saveUser(String userName, String fName, String lName, String password,
            String email, String phNum) {
        Statement statement;
        Random generator = new Random();
        int id = generator.nextInt(500000);
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Users (USERID,USERNAME,FNAME,LNAME,PASSWORD,PHONE,EMAIL) VALUES"
                    + " (" + id + "," + userName + "," + fName + "," + lName
                    + "," + password + "," + email + "," + phNum + ")");
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    public Data checkLoginUser(String email) {
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, email FROM users"
                    + "WHERE email = " + email);
            if (rs.next()) {
                String rsEmail = rs.getString("email");
                if (email.compareTo(rsEmail) == 0) {
                    System.out.println("Logging in...");
                    data.loginFlag = true;
                } else {
                    data.loginFlag = false;
                }
            } else {
                System.out.println("No valid user");
                data.loginFlag = false;
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error!");
        }

        return data;
    }

    public Data checkNewRegUser(String email) {
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, email FROM users"
                    + "WHERE email = " + email);
            if (rs.next()) {
                String rsEmail = rs.getString("email");
                if (email.compareTo(rsEmail) == 0) {
                    System.out.println("User already exists!");
                    data.createUserFlag = false;
                } else {
                    data.createUserFlag = true;
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQL Error!");
        }

        return data;
    }
}
