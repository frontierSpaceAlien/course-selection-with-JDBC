/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;

/**
 *
 * @author Derek Lien
 */
public class Data {
    public boolean backFlag = false;
    public boolean registerFlag = false;
    public boolean loginFlag = false;
    public boolean createUserFlag = false;
    public boolean passwordFlag = false;
    public boolean invalidFlag = true;
    public boolean studentFlag = false;
    public boolean addGUIFlag = false;
    public boolean populateCourseBoxFlag = false;
    public boolean populateJListFlag = false;
    public boolean removeJListFlag = false;
    public boolean cancelCourseMenu = false;
    public boolean confirmCourse = false;
    public boolean removeFromTable = false;
    public boolean saveToDatabase = false;
    public boolean checkForExist = false;
    public boolean updateFlag = false;
    public boolean backToLoginFlag = false;
    public boolean exitFlag = false;
    public boolean validateEmail = true;
    public boolean validateUsername = false;
    public boolean validateFname = false;
    public boolean validateLname = false;
    public boolean validatePassword = false;
    public boolean checkIfAtLogin = false;
    public ArrayList<String> course = new ArrayList<String>();
    public ArrayList<String> stream = new ArrayList<String>();
    public String username = "";
    public String name = "";
    public String id = "";
}
