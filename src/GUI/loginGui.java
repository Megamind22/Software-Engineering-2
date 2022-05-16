package GUI;


import test.Login;
import test.Student;
import test.Instructor;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class loginGui extends JFrame implements ActionListener{
    
     JLabel L_userName,L_pass;
     JTextField t_user;
    JPasswordField p_pass;
    JButton b_login;
    
    
    Login test_login=new Login();
    
     public loginGui(){
         
     L_userName=new JLabel("UserName");
     L_pass=new JLabel("Password");
     t_user=new JTextField();
     p_pass=new JPasswordField();
     b_login=new JButton("Login");   

     this.setTitle("LOGIN");
     this.setSize(400, 300);
     this.setLocation(600, 200);
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setResizable(false);
     this.setLayout(null);
     L_userName=new JLabel("UserName");
     L_pass=new JLabel("Password");
     t_user=new JTextField();
     p_pass=new JPasswordField();
     b_login=new JButton("Login");
     L_userName.setBounds(50, 20, 200, 100); t_user.setBounds(150, 55,150, 30);
     L_pass.setBounds(50, 90, 200, 100); p_pass.setBounds(150, 125,150, 30);
     b_login.setBounds(150,200,100,30);
     this.add(L_userName);this.add(t_user);
     this.add(L_pass);this.add(p_pass);this.add(b_login);
     
     this.setVisible(true);
    b_login.addActionListener(this);
     }
     
     public void actionPerformed(ActionEvent e) {
    
         if (e.getSource() == b_login) {
             
                String userName = t_user.getText();
                String password = p_pass.getText();
            if(test_login.testlogin(userName, Integer.parseInt(password)).equals("Error")){
      
                JOptionPane.showMessageDialog(null, "Invalid Login", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
         }else{
                if (test_login.testlogin(userName, Integer.parseInt(password)).equals("STD")){
                    Student student=new Student(userName,Integer.parseInt(password));
                    studentGui sg=new studentGui(this,student);
                     sg.showStudentFrame();
                }
                if (test_login.testlogin(userName, Integer.parseInt(password)).equals("TA")){
                    Instructor instructor=new Instructor(userName,Integer.parseInt(password));
                    instructorGui ig=new instructorGui(this,instructor);
                     ig.showInstructorFrame();
                } if (test_login.testlogin(userName, Integer.parseInt(password)).equals("admin")){
                    adminGui dg=new adminGui();
                     dg.showAdminFrame();
                }
            }
    }   


}
}

