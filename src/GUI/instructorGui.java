package GUI;

import java.awt.*;
import java.awt.event.*;
import test.Instructor;
import javax.swing.*;
public class instructorGui extends JFrame implements ActionListener {
    
    JLabel L_IAddGrade,L_IPublishGrade,L_ISTUName,L_ISTUID,L_ISTUGrade;
    JTextField t_ISTUName,t_ISTUID,t_ISTUGrade;
    JTextArea txt_IPublishGrade;
    JButton b_IAddGrade,b_IPublishGrade,b_ILogOut,b_IUpdate,b_IAddGLogOut,b_IPublishLogOut;
    
    
    JFrame INSAddGrade=new JFrame();
    JFrame INSPublishGrade=new JFrame();
    JFrame INSFrame=new JFrame();
    JFrame loginFrame=new JFrame();
    Instructor instructor=new Instructor();
    
    public instructorGui(JFrame log,Instructor in){
        
        instructor=in;
        //Instructor_add_grade
        loginFrame=log;
        L_IAddGrade = new JLabel("Add_Grade");
        b_IAddGrade = new JButton();
        L_ISTUName = new JLabel("Enter_Student_Name");
        L_ISTUID = new JLabel("Enter_Student_ID");
        L_ISTUGrade = new JLabel("Add_Grade");
        t_ISTUName = new JTextField();
        t_ISTUID = new JTextField();
        t_ISTUGrade = new JTextField();
        b_IUpdate = new JButton("Update");
        b_IAddGLogOut = new JButton("back");
    //Publish grade
        txt_IPublishGrade=new JTextArea();
        b_IPublishLogOut=new JButton("back");
        L_IPublishGrade = new JLabel("Publish_Grades");
        b_IPublishGrade = new JButton();
        b_ILogOut = new JButton("LogOut");
    
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b_ILogOut){
             System.exit(0);
          }
        
        if(e.getSource()==b_IAddGrade){
                
               AddGradeFrame();
              }

      if(e.getSource()==b_IUpdate){
          
         instructor.addGrade(Integer.parseInt(t_ISTUID.getText()),t_ISTUGrade.getText());
         JOptionPane.showMessageDialog(null,"Vaild Update", "MESSAGE",JOptionPane.INFORMATION_MESSAGE );
         INSAddGrade.dispose();
          }

      if(e.getSource()==b_IAddGLogOut){
                
               INSAddGrade.dispose();
     
              }
      if(e.getSource()== b_IPublishGrade){
                PublishGradesFrame(); 
                 txt_IPublishGrade.setText(instructor.puplishGrades());
       }

     if(e.getSource()==b_IPublishLogOut){
                
               INSPublishGrade.dispose();
     
              }
        
    }
   
    
    
    protected void showInstructorFrame(){
    
              INSFrame.setTitle("Instructor");
              INSFrame.setSize(400, 400);
              INSFrame.setLocation(600, 200);
              INSFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              INSFrame.setResizable(false);
              INSFrame.setLayout(null);
              L_IAddGrade.setBounds(50, 45, 200, 100); b_IAddGrade.setBounds(250, 85,15, 15);
              L_IPublishGrade.setBounds(50, 130, 200, 100); b_IPublishGrade.setBounds(250, 175,15, 15);
              b_ILogOut.setBounds(120, 300, 160, 50);
              INSFrame.add(L_IAddGrade);INSFrame.add(b_IAddGrade);INSFrame.add(L_IPublishGrade);
              INSFrame.add(b_IPublishGrade);
              INSFrame.add(b_ILogOut);    
              loginFrame.setVisible(false);
              INSFrame.setVisible(true);  
              b_ILogOut.addActionListener(this);
              b_IAddGrade.addActionListener(this);
              b_IUpdate.addActionListener(this);
              b_IAddGLogOut.addActionListener(this);
              b_IPublishGrade.addActionListener(this);
              b_IPublishLogOut.addActionListener(this);  
    }
    
    protected void AddGradeFrame(){
              INSAddGrade.setTitle("ADD_GRADE");
              INSAddGrade.setSize(500, 300);
              INSAddGrade.setLocation(600, 200);
              INSAddGrade.setResizable(false);
              INSAddGrade.setLayout(null);
              L_ISTUName.setBounds(50, 20, 180, 30);t_ISTUName.setBounds(250, 20, 200, 30);
              L_ISTUID.setBounds(50, 70, 150, 30);t_ISTUID.setBounds(250, 70, 200, 30);
              L_ISTUGrade.setBounds(50, 120, 150, 30);t_ISTUGrade.setBounds(250, 120, 200, 30);
              b_IUpdate.setBounds(80, 200, 100, 30);b_IAddGLogOut.setBounds(300, 200, 100, 30);
              INSAddGrade.add(L_ISTUName);INSAddGrade.add(t_ISTUName);
              INSAddGrade.add(L_ISTUID);INSAddGrade.add(t_ISTUID);
              INSAddGrade.add(L_ISTUGrade);INSAddGrade.add(t_ISTUGrade);
              INSAddGrade.add(b_IUpdate);INSAddGrade.add(b_IAddGLogOut);
              INSAddGrade.setVisible(true);
    }
    
    protected void PublishGradesFrame(){
             txt_IPublishGrade.setEditable(true);

              INSPublishGrade.setLayout(new GridLayout(2,1));
              JPanel p=new JPanel();
              JPanel b=new JPanel();
              p.setLayout(new FlowLayout(FlowLayout.CENTER));
              b.setLayout(null);
              INSPublishGrade.setTitle("Publish_Grades");
              INSPublishGrade.setSize(400, 600);
              INSPublishGrade.setLocation(600, 200);
              INSPublishGrade.setResizable(false);
              b_IPublishLogOut.setBounds(100, 200, 200, 40);
              JScrollPane s=new JScrollPane(txt_IPublishGrade,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              p.add(s);
              b.add(b_IPublishLogOut);
              INSPublishGrade.add(p);INSPublishGrade.add(b);
              this.setVisible(false);
              INSPublishGrade.setVisible(true);   
    } 
    
    
    
    
}

   
    


