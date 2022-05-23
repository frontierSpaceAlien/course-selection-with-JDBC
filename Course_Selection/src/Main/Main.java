/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import MVC.Model;
import MVC.View;
import MVC.Controller;
import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author Derek Lien
 */
public class Main {

    public static void main(String[] args) {

        try {
            FlatLightLaf.setup();
        } catch (Exception ignored) {
        }

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view); 
    }
}
