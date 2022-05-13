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
import java.util.Arrays;
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
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(30), username VARCHAR(30), fname VARCHAR(50),"
                        + " lname VARCHAR(50), password VARCHAR(50), phone VARCHAR(50), email VARCHAR(100))");
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
            System.out.println("TABLE ERROR!");
        }
        return flag;
    }

    public void saveUser(String userName, String fName, String lName, String password,
            String phNum, String email) {
        Statement statement;
        Random generator = new Random();
        int id = generator.nextInt(500000);
        try {
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO Users "
                    + "VALUES ('" + id + "', '" + userName + "' , '" + fName + "', '" + lName
                    + "' , '" + password + "' , '" + phNum + "' , '" + email + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Data checkLoginUser(String email, char[] password) {
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT email, password FROM Users "
                    + "WHERE email = '" + email + "'");
            if (rs.next()) {
                String rsEmail = rs.getString("email");
                String rsPassword = rs.getString("password");
                String savePw = new String(password);
                if (email.compareTo(rsEmail) == 0) {
                    if (savePw.compareTo(rsPassword) == 0) {
                        data.loginFlag = true;
                        data.passwordFlag = true;
                    } else {
                        data.loginFlag = false;
                        data.passwordFlag = false;
                    }

                } else {
                    data.loginFlag = false;
                    data.passwordFlag = false;
                }
            } else {
                data.loginFlag = false;
                data.passwordFlag = false;
            }

        } catch (SQLException ex) {
            System.out.println("SQL check LOGIN ERROR!");
        }

        return data;
    }

    public Data checkNewRegUser(String userName, String fName, String lName, String password,
            String phNum, String email) {
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, email FROM Users "
                    + "WHERE email = '" + email + "'");
            if (rs.next()) {
                String rsEmail = rs.getString("email");
                if (email.compareTo(rsEmail) == 0) {
                    data.invalidFlag = false;
                } else {
                    data.createUserFlag = true;
                    data.invalidFlag = true;
                }
            } else {
                data.createUserFlag = true;
                data.invalidFlag = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }

    public Data getStudentInfo(String email) {
        String username = "";
        String name = "";
        Student student = new Student(username, name);
        Data data = new Data();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, fname||' '||lname AS name, email FROM Users "
                    + "WHERE email = '" + email + "'");
            if (rs.next()) {
                String rsEmail = rs.getString("email");
                if (email.compareTo(rsEmail) == 0) {
                    username = rs.getString("username");
                    name = rs.getString("name");
                    student.setUsername(username);
                    student.setName(name);
                    data.username = student.getUsername();
                    data.name = student.getName();
                    data.loginFlag = true;
                    data.passwordFlag = true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

        }

        return data;
    }
}
