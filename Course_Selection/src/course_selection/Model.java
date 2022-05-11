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
    
    public Model(){
        System.out.println("Printing model constructor");
        this.data = new Data();
    }
    
    public void registerStart(){
        this.data.registerFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
}
