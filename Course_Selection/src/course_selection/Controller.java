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
        switch (command) {
            case "Create New User":
                this.view.setUnInput();
                this.view.setNInput();
                this.view.setLInput();
                this.view.setPwrInput();
                this.view.setPhInput();
                this.view.setEmail();
                this.model.registerStart();
                break;
            case "Back":
                this.model.goBack();
                break;
            case "Register":
                String username = this.view.getUnInput();
                String fname = this.view.getNInput();
                String lname = this.view.getLInput();
                String regPw = this.view.getPwrInput();
                String phone = this.view.getPhInput();
                String regEmail = this.view.getEmail();
                this.model.checkNewRegUser(username, fname, lname, regPw, phone, regEmail);
                break;
            case "Log in":
                String email = this.view.getELog();
                char[] pw = this.view.getPwInput();
                this.model.checkLogin(email, pw);
                break;
            case "Add":
                this.model.addCourse();
                break;
            case "1":
                break;
            case "2":
                break;
            default:
                break;
        }
        
        
    }
    
}
