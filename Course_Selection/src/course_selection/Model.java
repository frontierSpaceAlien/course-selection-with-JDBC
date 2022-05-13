/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

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
        this.student = new Student("","");
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

    public void checkNewRegUser(String username, String fName, String lName, String password,
            String phNum, String email) {
        this.data = this.db.checkNewRegUser(username, fName, lName, password, phNum, email);

        if (data.createUserFlag) {
            this.db.saveUser(username, fName, lName, password, phNum, email);
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void checkLogin(String email, char[] password){
        this.data = this.db.checkLoginUser(email, password);     
        this.data = this.db.getStudentInfo(email);
        this.setChanged();
        this.notifyObservers(this.data);
    }


}
