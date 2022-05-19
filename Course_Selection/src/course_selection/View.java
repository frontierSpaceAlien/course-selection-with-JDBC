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
import java.util.Observable;
import java.util.Observer;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Derek Lien
 */
class View extends JFrame implements Observer {

    private JPanel userPanel = new JPanel();
    private JPanel regPanel = new JPanel();
    private JPanel mainMenu = new JPanel();
    private JPanel addPanel = new JPanel();
    private JFrame addFrame = new JFrame();
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
    private JLabel sumEFTS = new JLabel("Total EFTS: ");
    private JLabel courses = new JLabel("Courses: ");
    private JTextField unInput = new JTextField(10);
    private JTextField nInput = new JTextField(10);
    private JTextField lInput = new JTextField(10);
    private JTextField eLog = new JTextField(100);
    private JTextField eInput = new JTextField(100);
    private JTextField phInput = new JTextField(10);
    private JTextField pwrInput = new JTextField(10);
    private JPasswordField pwInput = new JPasswordField(10);
    private JButton loginButton = new JButton("Log in");
    private JButton newUserButton = new JButton("Create New User");
    private JButton backButton = new JButton("Back");
    private JButton regButton = new JButton("Register");
    private JButton addButton = new JButton("Add");
    private JButton removeButton = new JButton("Remove");
    private JButton saveButton = new JButton("Save");
    private JButton backToLogin = new JButton("Back");
    private JButton exitApp = new JButton("Exit");
    private JButton addCourse = new JButton("Add Course");
    private JButton removeCourse = new JButton("Remove Course");
    private JButton cancelBtn = new JButton("Cancel");
    private JButton confirmBtn = new JButton("Confirm");
    private JDialog modal = new JDialog(addFrame, "Course Selection", true);
    private JComboBox courseList = new JComboBox();
    private JCheckBox sem1 = new JCheckBox("Semester 1");
    private JCheckBox sem2 = new JCheckBox("Semester 2");
    private JList courseAddList = new JList();
    private DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    private DefaultListModel<String> jListModel = new DefaultListModel<>();
    private ButtonGroup group = new ButtonGroup();
    private DefaultTableModel model = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JTable cTable = new JTable(model);
    private JScrollPane sp = new JScrollPane(cTable);
    private static final int MAXPAPERS = 4;

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

    public void studentMenu() {
        mainMenu.setLayout(null);
        this.setSize(480, 600);
        suName.setFont(new Font("Arial", Font.PLAIN, 14));
        sName.setFont(new Font("Arial", Font.PLAIN, 14));
        courses.setFont(new Font("Arial", Font.PLAIN, 14));
        sumEFTS.setFont(new Font("Arial", Font.PLAIN, 14));

        suName.setBounds(30, 20, 250, 100);
        sName.setBounds(30, 60, 250, 100);
        sumEFTS.setBounds(30, 100, 250, 100);
        courses.setBounds(30, 150, 250, 100);
        sp.setBounds(30, 220, 400, 200);
        addButton.setBounds(30, 430, 100, 25);
        removeButton.setBounds(140, 430, 100, 25);
        saveButton.setBounds(250, 430, 100, 25);
        backToLogin.setBounds(30, 510, 100, 25);
        exitApp.setBounds(330, 510, 100, 25);
        model.addColumn("Course Code");
        model.addColumn("Stream");
        cTable.getTableHeader().setReorderingAllowed(false);

        mainMenu.add(suName);
        mainMenu.add(sName);
        mainMenu.add(sumEFTS);
        mainMenu.add(courses);
        mainMenu.add(sp);
        mainMenu.add(addButton);
        mainMenu.add(removeButton);
        mainMenu.add(saveButton);
        mainMenu.add(backToLogin);
        mainMenu.add(exitApp);

        this.setLocationRelativeTo(null);
        this.getContentPane().removeAll();
        this.add(mainMenu);
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

    public void displayCourseSelect() {
        this.modal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.modal.setSize(750, 400);
        this.modal.setLocationRelativeTo(this);

        addPanel.setLayout(null);
        courseList.setBounds(50, 50, 400, 25);
        sem1.setBounds(500, 50, 100, 25);
        sem2.setBounds(600, 50, 100, 25);
        courseAddList.setBounds(50, 150, 630, 150);
        addCourse.setBounds(50, 100, 100, 25);
        removeCourse.setBounds(170, 100, 130, 25);
        cancelBtn.setBounds(50, 315, 100, 25);
        confirmBtn.setBounds(580, 315, 100, 25);
        addPanel.add(courseList);
        group.add(sem1);
        group.add(sem2);
        addPanel.add(sem1);
        addPanel.add(sem2);
        addPanel.add(courseAddList);
        addPanel.add(addCourse);
        addPanel.add(removeCourse);
        addPanel.add(cancelBtn);
        addPanel.add(confirmBtn);
        modal.add(addPanel);

        this.modal.setResizable(false);
        this.modal.setVisible(true);

    }

    public void addActionListener(ActionListener listener) {
        this.loginButton.addActionListener(listener);
        this.newUserButton.addActionListener(listener);
        this.backButton.addActionListener(listener);
        this.regButton.addActionListener(listener);
        this.addButton.addActionListener(listener);
        this.removeButton.addActionListener(listener);
        this.sem1.addActionListener(listener);
        this.sem2.addActionListener(listener);
        this.addCourse.addActionListener(listener);
        this.removeCourse.addActionListener(listener);
        this.cancelBtn.addActionListener(listener);
        this.confirmBtn.addActionListener(listener);
    }

    @Override
    public void update(Observable obs, Object obj) {
        Data data = (Data) obj;
        String courseString = "";
        String courseStream = "";
        String courseComboBoxString = "";
        String courseComboBoxStream = "";
        ArrayList<String> saveCourseCode = new ArrayList<String>();
        ArrayList<String> saveCourseStream = new ArrayList<String>();
        ArrayList<String> saveTableCourseCode = new ArrayList<String>();
        ArrayList<String> saveTableStreamCode = new ArrayList<String>();
        ArrayList<String> saveCourseList = new ArrayList<String>();
        ArrayList<String> saveStreamList = new ArrayList<String>();
        ArrayList saveTableValues = new ArrayList();

        if (data.registerFlag) {
            this.registerStart();
            data.registerFlag = false;
        } else if (data.addGUIFlag) {
            data.addGUIFlag = false;
            this.displayCourseSelect();
        } else if (data.removeFromTable) {
            data.removeFromTable = false;
            if (cTable.getSelectedRow() != -1) {
                model.removeRow(cTable.getSelectedRow());
            }
        } else if (data.cancelCourseMenu) {
            modal.setVisible(false);
            jListModel.clear();
            data.cancelCourseMenu = false;
        } else if (data.confirmCourse) {
            String upper = "17";
            String lower = "10";
            String upper2 = "54";
            String lower2 = "50";

            for (int i = 0; i < jListModel.size(); i++) {
                String[] split = jListModel.get(i).split("/");
                saveStreamList.add(split[1]);
                saveCourseList.add(split[0]);
            }

            for (int j = 0; j < cTable.getRowCount(); j++) {
                for (int f = 0; f < cTable.getColumnCount(); f++) {
                    saveTableValues.add(cTable.getValueAt(j, f));
                }
            }

            for (int e = 0; e < saveTableValues.size(); e++) {
                saveTableCourseCode.add(saveTableValues.get(e).toString());
                saveTableStreamCode.add(saveTableValues.get(++e).toString());
            }
            outerLoop:
            if (model.getRowCount() == MAXPAPERS) {
                JOptionPane.showMessageDialog(this.modal, "You have 4 papers added already!");
                data.confirmCourse = false;
            } else if (model.getRowCount() + jListModel.getSize() > MAXPAPERS) {
                JOptionPane.showMessageDialog(this.modal, "You cannot exceed 4 papers");
                data.confirmCourse = false;
            } else {

                for (String e : saveTableCourseCode) {
                    for (String f : saveCourseList) {
                        if (e.contains(f)) {
                            JOptionPane.showMessageDialog(this.modal, "You already have "+f+" added!");
                            data.confirmCourse = false;
                            break outerLoop;
                        }
                    }
                }

                for (String e : saveTableStreamCode) {
                    for (String f : saveStreamList) {
                        if (e.compareTo(lower) > 0 && e.compareTo(upper) < 0) {
                            if (f.compareTo(lower2) >= 0 && f.compareTo(upper2) < 0) {
                                JOptionPane.showMessageDialog(this.modal, "You cannot take this paper with semester 1 papers!");
                                data.confirmCourse = false;
                                break outerLoop;
                            }
                        } else if (e.compareTo(lower2) > 0 && e.compareTo(upper2) < 0) {
                            if (f.compareTo(lower) >= 0 && f.compareTo(upper) < 0) {
                                JOptionPane.showMessageDialog(this.modal, "You cannot take this paper with semester 2 papers!");
                                data.confirmCourse = false;
                                break outerLoop;
                            }
                        }
                    }
                }

                for (int i = 0; i < jListModel.size(); i++) {
                    String[] split = jListModel.get(i).split("/");
                    saveCourseStream.add(split[1]);
                    saveCourseCode.add(split[0]);
                    model.addRow(new Object[]{saveCourseCode.get(i), saveCourseStream.get(i)});
                }
                modal.setVisible(false);
                jListModel.clear();
                data.confirmCourse = false;
            }
        } else if (data.populateJListFlag) {

            if (jListModel.getSize() < MAXPAPERS) {
                courseString = String.valueOf(courseList.getSelectedItem());
                String[] splitCourseString = courseString.split("/");
                courseComboBoxString = splitCourseString[0];
                courseComboBoxStream = splitCourseString[1];
                String upper = "17";
                String lower = "10";
                String upper2 = "54";
                String lower2 = "50";

                for (int i = 0; i < jListModel.size(); i++) {
                    String[] split = jListModel.get(i).split("/");
                    courseStream = split[1];
                    saveCourseCode.add(split[0]);
                }

                if (jListModel.isEmpty()) {
                    jListModel.addElement(courseString);
                    courseAddList.setModel(jListModel);
                } else {
                    outerLoop:
                    if (courseStream.compareTo(lower) >= 0
                            && courseStream.compareTo(upper) <= 0
                            && courseComboBoxStream.compareTo(lower) >= 0
                            && courseComboBoxStream.compareTo(upper) <= 0) {
                        for (String e : saveCourseCode) {
                            if (e.contains(courseComboBoxString)) {
                                JOptionPane.showMessageDialog(this.modal, "You already have " + e + " added!");
                                break outerLoop;
                            }
                        }
                        jListModel.addElement(courseString);
                        courseAddList.setModel(jListModel);
                    } else if (courseStream.compareTo(lower2) >= 0
                            && courseStream.compareTo(upper2) <= 0
                            && courseComboBoxStream.compareTo(lower2) >= 0
                            && courseComboBoxStream.compareTo(upper2) <= 0) {
                        for (String e : saveCourseCode) {
                            if (e.contains(courseComboBoxString)) {
                                JOptionPane.showMessageDialog(this.modal, "You already have " + e + " added!");
                                break outerLoop;
                            }
                        }
                        jListModel.addElement(courseString);
                        courseAddList.setModel(jListModel);
                    } else {
                        JOptionPane.showMessageDialog(this.modal, "You cannot take semester 1 and semester 2 papers in the same semester!");
                    }

                }

            } else if (jListModel.getSize() >= MAXPAPERS) {
                JOptionPane.showMessageDialog(this.modal, "You cannot take more than 4 papers!");
            }

            data.populateJListFlag = false;

        } else if (data.removeJListFlag) {
            int index = courseAddList.getSelectedIndex();

            if (index != -1) {
                jListModel.remove(index);
            }

            data.removeJListFlag = false;
        } else if (data.populateCourseBoxFlag) {
            comboBoxModel.removeAllElements();
            for (int i = 0; i < data.course.size(); i++) {
                comboBoxModel.addElement(data.stream.get(i) + "/" + data.course.get(i));
            }
            courseList.setModel(comboBoxModel);

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
        } else if (data.passwordFlag && data.loginFlag) {
            suName.setText("Username: " + data.username);
            sName.setText("Name: " + data.name);
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

    public char[] getPwInput() {
        return this.pwInput.getPassword();
    }

    public String getPhInput() {
        return this.phInput.getText();
    }

    public String getEmail() {
        return this.eInput.getText();
    }

    public String getELog() {
        return this.eLog.getText();
    }

    public JCheckBox getSem1() {
        return sem1;
    }

    public JCheckBox getSem2() {
        return sem2;
    }

    public void setUnInput() {
        this.unInput.setText("");
    }

    public void setNInput() {
        this.nInput.setText("");
    }

    public void setLInput() {
        this.lInput.setText("");
    }

    public void setPwrInput() {
        this.pwrInput.setText("");
    }

    public void setPhInput() {
        this.phInput.setText("");
    }

    public void setEmail() {
        this.eInput.setText("");
    }

}
