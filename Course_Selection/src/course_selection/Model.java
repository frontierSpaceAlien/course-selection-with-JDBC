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
public class Model extends Observable{
    public Data data;
    public Database db = new Database();
    
    public Model(){
        db.dbsetup();
    }
    
    public void registerStart(){
        this.data.registerFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void goBack(){
        this.data.backFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void regUser(){
        this.data.createUserFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void checkNewRegUser(String email){
        this.db.checkNewRegUser(email);
        
        if (data.createUserFlag){
            this.db.saveUser(email, email, email, email, email, email);
        }
    }
    
}
