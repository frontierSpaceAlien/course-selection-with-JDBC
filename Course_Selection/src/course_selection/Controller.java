/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
                this.model.checkEmailField(regEmail);
                this.model.checkUsernameField(username);
                this.model.checkFnameField(fname);
                this.model.checkLnameField(lname);
                this.model.checkPasswordField(regPw);
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
            case "Semester 1":
                this.model.changeCourseBox("Semester 1");
                break;
            case "Semester 2":
                this.model.changeCourseBox("Semester 2");
                break;
            case "Add Course":
                this.model.addCourseToList();
                break;
            case "Remove Course":
                this.model.removeCourseFromList();
                break;
            case "Cancel":
                this.model.cancelCourseMenu();
                break;
            case "Confirm":
                this.model.confirmCourses();
                break;
            case "Remove":
                this.model.removeFromTable();
                break;
            case "Save":
                ArrayList<String> saveTableCourseCode = new ArrayList<String>();
                ArrayList<Integer> saveTableStreamCode = new ArrayList<Integer>();
                ArrayList saveTableValues = new ArrayList();

                for (int j = 0; j < view.getcTable().getRowCount(); j++) {
                    for (int f = 0; f < view.getcTable().getColumnCount(); f++) {
                        saveTableValues.add(view.getcTable().getValueAt(j, f));
                    }
                }

                for (int f = 0; f < saveTableValues.size(); f++) {
                    saveTableCourseCode.add(saveTableValues.get(f).toString());
                    saveTableStreamCode.add(Integer.parseInt(saveTableValues.get(++f).toString()));
                }

                String[] split = this.view.getuID().getText().split(" ");
                String saveID = split[1];
                
                this.model.saveToDatabase(saveID, saveTableCourseCode, saveTableStreamCode);
                break;
            case "Back to login":
                this.model.backToLogin();
                break;
            case "Exit":
                this.model.exitApp();
                break;
            default:
                break;
        }

    }

}
