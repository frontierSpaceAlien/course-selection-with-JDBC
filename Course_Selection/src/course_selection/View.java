/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Derek Lien
 */
class View extends JFrame implements Observer {

    private JPanel userPanel = new JPanel();
    private JPanel regPanel = new JPanel();
    private JPanel studentPanel = new JPanel();
    private JLabel uRegName = new JLabel("Username: ");
    private JLabel fName = new JLabel("First Name: ");
    private JLabel lName = new JLabel("Last Name: ");
    private JLabel email = new JLabel("Email: ");
    private JLabel eLogLabel = new JLabel("Email: ");
    private JLabel phNum = new JLabel("Phone Number: ");
    private JLabel pw = new JLabel("Password: ");
    private JLabel pwrLabel = new JLabel("Password: ");
    private JLabel eRegMsg = new JLabel("User already exists!");
    private JLabel logMessage = new JLabel("Course Selection");
    private JLabel regMessage = new JLabel("Register");
    private JLabel logError = new JLabel("Invalid Login");
    private JLabel suName = new JLabel();
    private JLabel sName = new JLabel();
    private JLabel sumEFTS = new JLabel();
    private JLabel courses = new JLabel("Courses: ");
    private JTextField unInput = new JTextField(10);
    private JTextField nInput = new JTextField(10);
    private JTextField lInput = new JTextField(10);
    private JTextField eLog = new JTextField(100);
    private JTextField eInput = new JTextField(100);
    private JTextField phInput = new JTextField(10);
    private JTextField pwrInput = new JTextField(10);
    private JTextField uInput = new JTextField(10);
    private JPasswordField pwInput = new JPasswordField(10);
    private JButton loginButton = new JButton("Log in");
    private JButton newUserButton = new JButton("Create New User");
    private JButton backButton = new JButton("Back");
    private JButton regButton = new JButton("Register");

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        this.setLocationRelativeTo(null);

        userPanel.setLayout(null);

        logMessage.setBounds(10, 10, 250, 25);
        logMessage.setFont(new Font("Grandview", Font.BOLD, 24));
        eLogLabel.setBounds(10, 40, 80, 25);
        eLog.setBounds(100, 40, 165, 25);
        pw.setBounds(10, 70, 80, 25);
        pwInput.setBounds(100, 70, 165, 25);
        loginButton.setBounds(10, 100, 80, 25);
        newUserButton.setBounds(100, 100, 150, 25);

        userPanel.add(logMessage);
        userPanel.add(eLogLabel);
        userPanel.add(eLog);
        userPanel.add(pw);
        userPanel.add(pwInput);
        userPanel.add(loginButton);
        userPanel.add(newUserButton);

        this.add(userPanel);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Course Selection");
    }

    public void back() {
        this.setSize(350, 200);
        this.getContentPane().removeAll();
        this.setLocationRelativeTo(null);
        this.add(userPanel);
        this.revalidate();
        this.repaint();
    }

    public void registerStart() {
        regPanel.setLayout(null);
        this.setSize(800, 600);

        regMessage.setBounds(300, 20, 250, 100);
        regMessage.setFont(new Font("Grandview", Font.BOLD, 48));
        regPanel.add(regMessage);

        uRegName.setBounds(250, 120, 100, 25);
        unInput.setBounds(250, 150, 300, 25);
        regPanel.add(uRegName);
        regPanel.add(unInput);

        fName.setBounds(250, 180, 100, 25);
        nInput.setBounds(250, 210, 300, 25);
        regPanel.add(fName);
        regPanel.add(nInput);

        lName.setBounds(250, 240, 100, 25);
        lInput.setBounds(250, 270, 300, 25);
        regPanel.add(lName);
        regPanel.add(lInput);

        pwrLabel.setBounds(250, 300, 100, 25);
        pwrInput.setBounds(250, 330, 300, 25);
        regPanel.add(pwrLabel);
        regPanel.add(pwrInput);

        phNum.setBounds(250, 360, 100, 25);
        phInput.setBounds(250, 390, 300, 25);
        regPanel.add(phNum);
        regPanel.add(phInput);

        email.setBounds(250, 420, 100, 25);
        eInput.setBounds(250, 450, 300, 25);
        regPanel.add(email);
        regPanel.add(eInput);

        backButton.setBounds(250, 500, 100, 25);
        regPanel.add(backButton);

        regButton.setBounds(450, 500, 100, 25);
        regPanel.add(regButton);

        this.setLocationRelativeTo(null);
        this.getContentPane().removeAll();
        this.add(regPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void studentMenu(){
        studentPanel.setLayout(null);
        this.setSize(800, 600);
        
        suName.setBounds(50, 100, 250, 100);
        sName.setBounds(50, 100, 100, 25);
        studentPanel.add(suName);
        studentPanel.add(sName);
        
        
        this.setLocationRelativeTo(null);
        this.getContentPane().removeAll();
        this.add(studentPanel);
        this.revalidate();
        this.repaint();
    }

    public void displayErrorReg() {
        eRegMsg.setBounds(350, 530, 100, 25);
        eRegMsg.setForeground(Color.red);
        regPanel.add(eRegMsg);

        this.getContentPane().removeAll();
        this.add(regPanel);
        this.revalidate();
        this.repaint();
    }

    public void displayLogError() {
        logError.setBounds(10, 130, 250, 25);
        logError.setForeground(Color.red);
        userPanel.add(logError);
        
        this.getContentPane().removeAll();
        this.add(userPanel);
        this.revalidate();
        this.repaint();
    }

    public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.newUserButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
        this.regButton.addActionListener(listener);
    }

    public void update(Observable obs, Object obj) {
        Data data = (Data) obj;
        
        if (data.registerFlag) {
            this.registerStart();
            data.registerFlag = false;
        } else if (data.backFlag) {
            this.back();
            data.backFlag = false;
        } else if (data.createUserFlag) {
            JOptionPane.showMessageDialog(this, "Register Successful");
            this.back();
            data.createUserFlag = false;
        } else if (!data.invalidFlag) {
            this.displayErrorReg();
        } else if (!data.passwordFlag || !data.loginFlag) {
            this.displayLogError();
        } else if(data.passwordFlag || data.loginFlag){
            suName.setText("Username: "+data.username);
            sName.setText("Name: "+data.name);
            this.studentMenu();
        }
    }

    public String getUnInput() {
        return this.unInput.getText();
    }

    public String getNInput() {
        return this.nInput.getText();
    }

    public String getLInput() {
        return this.lInput.getText();
    }

    public String getPwrInput() {
        return this.pwrInput.getText();
    }
    
    public char[] getPwInput(){
        return this.pwInput.getPassword();
    }

    public String getPhInput() {
        return this.phInput.getText();
    }

    public String getEmail() {
        return this.eInput.getText();
    }
    
    public String getELog(){
        return this.eLog.getText();
    }
    
    public void setUnInput(){
        this.unInput.setText("");
    }
    
    public void setNInput(){
        this.nInput.setText("");
    }
    
    public void setLInput(){
        this.lInput.setText("");
    }
    
    public void setPwrInput(){
        this.pwrInput.setText("");
    } 
    
    public void setPhInput(){
        this.phInput.setText("");
    }
    
    public void setEmail(){
        this.eInput.setText("");
    }
    

}
