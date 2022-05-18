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
import java.util.ArrayList;
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
            String[] tableName = {"Users", "Courses", "studentCourses", "Stream", "Semester"};

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE Users (userid VARCHAR(100) PRIMARY KEY NOT NULL, "
                        + "username VARCHAR(30), "
                        + "fname VARCHAR(50),"
                        + " lname VARCHAR(50), "
                        + "password VARCHAR(50), "
                        + "phone VARCHAR(50),"
                        + " email VARCHAR(100))");
                statement.executeUpdate("CREATE TABLE Courses (courseID VARCHAR(20) PRIMARY KEY NOT NULL, "
                        + "courseName VARCHAR(200))");
                statement.executeUpdate("CREATE TABLE studentCourses (userid VARCHAR(100) NOT NULL,"
                        + " courseID VARCHAR(20) NOT NULL,"
                        + "CONSTRAINT courseID_FK FOREIGN KEY (courseID) REFERENCES Courses (courseID),"
                        + "CONSTRAINT userID_FK FOREIGN KEY (userid) REFERENCES Users (userid),"
                        + " PRIMARY KEY (userid, courseID))");
                statement.executeUpdate("CREATE TABLE Stream (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1)"
                        + ", StreamNum INT NOT NULL,"
                        + " courseID VARCHAR(20) REFERENCES Courses (courseID), "
                        + "PRIMARY KEY (ID))");

                statement.executeUpdate("INSERT INTO Courses VALUES "
                        + "('COMP500','Programming Concepts and Techniques'),"
                        + "('COMP501','Computing Technology in Society'),"
                        + "('COMP503','Programming 2'),"
                        + "('COMP504','Networks and Internet'),"
                        + "('COMP507','IT Project Management'),"
                        + "('COMP508','Database System Design'),"
                        + "('COMP517','Data Analysis'),"
                        + "('DIGD507','Mahitahi | Collaborative Practices'),"
                        + "('INFS502','Digital Services in Information Technology'),"
                        + "('MATH503','Mathematics for Computing')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(11,'COMP500'),"
                        + "(12,'COMP500'),"
                        + "(14,'COMP500'),"
                        + "(15,'COMP500'),"
                        + "(17,'COMP500'),"
                        + "(50,'COMP500'),"
                        + "(51,'COMP500'),"
                        + "(52,'COMP500'),"
                        + "(53,'COMP500'),"
                        + "(54,'COMP500')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(10,'COMP501'),"
                        + "(12,'COMP501'),"
                        + "(13,'COMP501'),"
                        + "(14,'COMP501'),"
                        + "(16,'COMP501'),"
                        + "(50,'COMP501'),"
                        + "(51,'COMP501'),"
                        + "(52,'COMP501')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(10,'COMP503'),"
                        + "(11,'COMP503'),"
                        + "(12,'COMP503'),"
                        + "(50,'COMP503'),"
                        + "(51,'COMP503'),"
                        + "(52,'COMP503')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(50,'COMP504'),"
                        + "(51,'COMP504'),"
                        + "(52,'COMP504'),"
                        + "(53,'COMP504')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(10,'COMP507'),"
                        + "(11,'COMP507'),"
                        + "(12,'COMP507'),"
                        + "(13,'COMP507'),"
                        + "(14,'COMP507'),"
                        + "(50,'COMP507'),"
                        + "(51,'COMP507'),"
                        + "(52,'COMP507')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(10,'COMP508'),"
                        + "(11,'COMP508'),"
                        + "(12,'COMP508'),"
                        + "(50,'COMP508'),"
                        + "(51,'COMP508'),"
                        + "(52,'COMP508')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(50,'COMP517'),"
                        + "(51,'COMP517'),"
                        + "(52,'COMP517'),"
                        + "(53,'COMP517')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(11,'DIGD507'),"
                        + "(12,'DIGD507'),"
                        + "(14,'DIGD507'),"
                        + "(15,'DIGD507'),"
                        + "(50,'DIGD507'),"
                        + "(51,'DIGD507'),"
                        + "(52,'DIGD507'),"
                        + "(53,'DIGD507')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(50,'INFS502'),"
                        + "(51,'INFS502'),"
                        + "(52,'INFS502'),"
                        + "(53,'INFS502')");

                statement.executeUpdate("INSERT INTO Stream (StreamNum, CourseID) VALUES "
                        + "(11,'MATH503'),"
                        + "(12,'MATH503'),"
                        + "(14,'MATH503'),"
                        + "(15,'MATH503'),"
                        + "(17,'MATH503'),"
                        + "(50,'MATH503'),"
                        + "(51,'MATH503'),"
                        + "(52,'MATH503'),"
                        + "(53,'MATH503'),"
                        + "(54,'MATH503')");
            }

            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean checkTableExisting(String[] newTableName) {
        boolean flag = false;
        try {
            System.out.println("Checking for existing tables...");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);
            while (rsDBMeta.next()) {
                String TableName = rsDBMeta.getString("TABLE_NAME");
                for (int i = 0; i < newTableName.length; ++i) {
                    if (TableName.compareToIgnoreCase(newTableName[i]) == 0) {
                        System.out.println(TableName + " is there");
                        flag = true;
                    }
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

    public Data getCourseInfoSem(String semester) {
        Data data = new Data();

        try {
            if (semester.equals("Semester 1")) {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT s.STREAMNUM, c.COURSEID from stream s,  courses c "
                        + "WHERE s.COURSEID = c.COURSEID "
                        + "AND s.STREAMNUM >= 10 AND s.STREAMNUM <= 17");
                while (rs.next()) {
                    data.course.add(rs.getString(1));
                    data.stream.add(rs.getString(2));
                }
                data.populateCourseBoxFlag = true;

            } else if (semester.equals("Semester 2")) {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT s.STREAMNUM, c.COURSEID from stream s,  courses c "
                        + "WHERE s.COURSEID = c.COURSEID "
                        + "AND s.STREAMNUM >= 50 AND s.STREAMNUM <= 54");
                while (rs.next()) {
                    data.course.add(rs.getString(1));
                    data.stream.add(rs.getString(2));
                }
                data.populateCourseBoxFlag = true;

            }
            data.populateCourseBoxFlag = true;

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return data;
    }
}
