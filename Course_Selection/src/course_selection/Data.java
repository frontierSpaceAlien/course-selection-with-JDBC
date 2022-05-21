/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

import java.util.ArrayList;

/**
 *
 * @author Derek Lien
 */
public class Data {
    boolean backFlag = false;
    boolean registerFlag = false;
    boolean loginFlag = false;
    boolean createUserFlag = false;
    boolean passwordFlag = false;
    boolean invalidFlag = true;
    boolean studentFlag = false;
    boolean addGUIFlag = false;
    boolean populateCourseBoxFlag = false;
    boolean populateJListFlag = false;
    boolean removeJListFlag = false;
    boolean cancelCourseMenu = false;
    boolean confirmCourse = false;
    boolean removeFromTable = false;
    boolean saveToDatabase = false;
    boolean checkForExist = false;
    boolean updateFlag = false;
    boolean backToLoginFlag = false;
    boolean exitFlag = false;
    boolean validateEmail = true;
    boolean validateUsername = false;
    boolean validateFname = false;
    boolean validateLname = false;
    boolean validatePassword = false;
    boolean checkIfAtLogin = false;
    ArrayList<String> course = new ArrayList<String>();
    ArrayList<String> stream = new ArrayList<String>();
    String username = "";
    String name = "";
    String id = "";
}
