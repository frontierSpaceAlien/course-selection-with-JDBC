/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Derek Lien
 */
public class Model extends Observable {

    public Data data;
    public Database db;
    public Student student;

    public Model() {
        this.db = new Database();
        this.data = new Data();
        this.student = new Student("", "", "");
        db.dbsetup();
    }

    public void registerStart() {
        this.data.registerFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void goBack() {
        this.data.backFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void regUser() {
        this.data.createUserFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void checkNewRegUser(String username, String fName, String lName,
            String password, String phNum, String email) {
        this.data = this.db.checkNewRegUser(username, fName, lName, password, phNum, email);

        if (data.createUserFlag) {
            this.db.saveUser(username, fName, lName, password, phNum, email);
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void checkLogin(String email, char[] password) {
        this.data = this.db.checkLoginUser(email, password);
        if (data.loginFlag || data.passwordFlag) {
            this.data = this.db.getStudentInfo(email);
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void addCourse() {
        this.data.addGUIFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void changeCourseBox(String semester) {
        this.data = this.db.getCourseInfoSem(semester);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void addCourseToList() {
        this.data.populateJListFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void removeCourseFromList() {
        this.data.removeJListFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void cancelCourseMenu() {
        this.data.cancelCourseMenu = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void confirmCourses() {
        this.data.confirmCourse = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void removeFromTable() {
        this.data.removeFromTable = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void saveToDatabase(String id, ArrayList<String> courseCode, ArrayList<Integer> streamCode) {
        this.data = this.db.saveToDatabase(id, courseCode, streamCode);
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void updateDatabase(String id, ArrayList<String> courseCode, ArrayList<Integer> streamCode) {
        this.data = this.db.updateSelection(id, courseCode, streamCode);
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void backToLogin(){
        this.data.backToLoginFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void exitApp(){
        this.data.exitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
}
