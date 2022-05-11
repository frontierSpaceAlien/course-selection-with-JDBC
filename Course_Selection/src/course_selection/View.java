/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course_selection;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private JLabel uRegName = new JLabel("Username: ");
    private JLabel fName = new JLabel("First Name: ");
    private JLabel lName = new JLabel("Last Name: ");
    private JLabel email = new JLabel("Email: ");
    private JLabel phNum = new JLabel("Phone Number: ");
    private JLabel regPw = new JLabel("Password: ");
    private JLabel uName = new JLabel("Username: ");
    private JLabel pw = new JLabel("Password: ");
    private JLabel logMessage = new JLabel("Welcome to the Course Selection Program!");
    private JLabel regMessage = new JLabel("Register");
    private JTextField unInput = new JTextField(10);
    private JTextField nInput = new JTextField(10);
    private JTextField lInput = new JTextField(10);
    private JTextField eInput = new JTextField(10);
    private JTextField phInput = new JTextField(10);
    private JTextField pwrInput = new JTextField(10);
    private JTextField uInput = new JTextField(10);
    private JPasswordField pwInput = new JPasswordField(10);
    private JButton loginButton = new JButton("Log in");
    private JButton regButton = new JButton("Register");
    private boolean started = false;
    
    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(330, 180);
        this.setLocationRelativeTo(null);
        
        userPanel.setLayout(null);
        
        logMessage.setBounds(10, 10, 250, 25);
        logMessage.setFont(new Font("Grandview", Font.BOLD, 24));
        uName.setBounds(10, 40, 80, 25);
        uInput.setBounds(100, 40, 165, 25);
        pw.setBounds(10, 70, 80, 25);
        pwInput.setBounds(100, 70, 165, 25);
        loginButton.setBounds(10, 100, 80, 25);
        regButton.setBounds(100, 100, 100, 25);
        
        userPanel.add(logMessage);
        userPanel.add(uName);
        userPanel.add(uInput);
        userPanel.add(pw);
        userPanel.add(pwInput);
        userPanel.add(loginButton);
        userPanel.add(regButton);
        
        this.add(userPanel);
        this.setVisible(true);
        this.setResizable(false);
    }
    
    public void registerStart() {
        regPanel.setLayout(null);
        this.setSize(800, 600);
        
        uRegName.setBounds(250, 60, 80, 25);
        unInput.setBounds(100, 60, 100, 25);
        fName.setBounds(10, 90, 100, 25);
        nInput.setBounds(100, 90, 100, 25);
        lName.setBounds(10, 120, 100, 25);
        lInput.setBounds(100, 120, 100, 25);
        regMessage.setBounds(350, 7, 250, 30);
        regMessage.setFont(new Font("Grandview", Font.BOLD, 24));
        email.setBounds(10, 150, 100, 25);
        eInput.setBounds(100, 150, 100, 25);
        phNum.setBounds(10, 180, 100, 25);
        phInput.setBounds(100, 180, 100, 25);
        
        regPanel.add(regMessage);
        regPanel.add(uRegName);
        regPanel.add(unInput);
        regPanel.add(fName);
        regPanel.add(nInput);
        regPanel.add(lName);
        regPanel.add(lInput);
        regPanel.add(email);
        regPanel.add(eInput);
        regPanel.add(phNum);
        regPanel.add(phInput);
        regPanel.add(regPw);
        regPanel.add(pwrInput);
        this.getContentPane().removeAll();
        this.add(regPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.regButton.addActionListener(listener);
    }
    
    public void update(Observable obs, Object obj) {
        Data data = (Data) obj;
        if (data.registerFlag) {
            this.registerStart();
        }
    }
}
