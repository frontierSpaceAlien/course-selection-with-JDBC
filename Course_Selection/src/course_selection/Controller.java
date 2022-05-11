/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Derek Lien
 */
class Controller implements ActionListener {

    Model model;
    View view;

    Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command){
            case "Register":
                this.model.registerStart();
                break;
            default:
                break;
        }
    }
}
