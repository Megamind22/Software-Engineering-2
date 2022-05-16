package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import test.Student;

public class studentGui extends JFrame implements ActionListener {
    
    private JLabel L_SGrade, L_SSurvay, L_SCourse,L_SInputCourse,L_SSurvayCourse,L_SOpinion;
    private JTextField t_SInputCourse,t_SSurvayCourse,t_SOpinion;
    private JTextArea txt_SShowCourses;
    private JButton b_SLogOut, b_SGrade, b_SSurvay, b_SCourses,b_SShowGrade,b_SGradeLogOut,b_SUpdate,b_SSLogOut,b_SShowLogOut;;
    private JFrame StudentFrame=new JFrame();
    private JFrame StuGradeFrame=new JFrame();
    private JFrame StuSurvayFrame=new JFrame();
    private JFrame StuCoursesFrame=new JFrame();
    private JFrame loginFrame=new JFrame();
    private Student student=new Student();
    
    
   public studentGui(JFrame log,Student student){
       this.student=student;
       loginFrame=log;
       //Show_grade_Student
       L_SGrade = new JLabel("See_Your_Grade");
       b_SGrade = new JButton();
       L_SInputCourse = new JLabel("Enter_Course_Id");
       t_SInputCourse = new JTextField();
       b_SShowGrade = new JButton("ShowGrade");
       b_SGradeLogOut = new JButton("back");
       //Survey
       L_SSurvay = new JLabel("Make_Survay_for_Course");
       b_SSurvay = new JButton();
       L_SSurvayCourse = new JLabel("Enter_Course_Name");
       L_SOpinion = new JLabel("Enter_Your_Opinion");
       t_SSurvayCourse = new JTextField();
       t_SOpinion = new JTextField();
       b_SUpdate = new JButton("Save");
       b_SSLogOut = new JButton("back");

       //show Course
       L_SCourse = new JLabel("See_All_Courses");
       b_SCourses = new JButton();
       txt_SShowCourses = new JTextArea();
       b_SShowLogOut = new JButton("back");
       //logout from Frame
       b_SLogOut = new JButton("LogOut");

   }
   
   
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==b_SLogOut){
             System.exit(0);
          }
        if(e.getSource()==b_SGrade){
            
                
              this.seeGradeFrame();
     
              }
 
       if(e.getSource()==b_SGradeLogOut){
                
               StuGradeFrame.dispose();
       }

      if(e.getSource()==b_SSLogOut){
                
              StuSurvayFrame.dispose();
       }
       if(e.getSource()==b_SShowLogOut){
                
               StuCoursesFrame.dispose();
       }
              
      if(e.getSource()==b_SShowGrade){
          
          String course =student.showGrade(t_SInputCourse.getText());
          if (course==null){course="Do U Attend Exam...!";}
              
         JOptionPane.showMessageDialog(null,course, "MESSAGE",JOptionPane.INFORMATION_MESSAGE );
         StuGradeFrame.setVisible(false);
             
              }

        if(e.getSource()==b_SSurvay){
            
              makeSurveyFrame();
        }
              

       if(e.getSource()==b_SUpdate){
          student.makeSurvey(t_SSurvayCourse.getText(), t_SOpinion.getText());
         JOptionPane.showMessageDialog(null,"Vaild Update", "MESSAGE",JOptionPane.INFORMATION_MESSAGE );
          StuSurvayFrame.dispose();
          }

       if(e.getSource()== b_SCourses){
           
                 
                seeAllCoursesFrame();
                txt_SShowCourses.setText(student.showAllCourses());
       }   
    
    }
    
    public  void showStudentFrame(){
    
        StudentFrame.setTitle("Student");
        StudentFrame.setSize(400, 400);
        StudentFrame.setLocation(600, 200);
        StudentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StudentFrame.setResizable(false);
        StudentFrame.setLayout(null);
        L_SGrade.setBounds(50, 10, 200, 100);
        b_SGrade.setBounds(250, 55, 15, 15);
        L_SSurvay.setBounds(50, 80, 200, 100);
        b_SSurvay.setBounds(250, 125, 15, 15);
        L_SCourse.setBounds(50, 150, 200, 100);
        b_SCourses.setBounds(250, 195, 15, 15);
        b_SLogOut.setBounds(120, 300, 160, 50);
        StudentFrame.add(L_SGrade);
        StudentFrame.add(b_SGrade);
        StudentFrame.add(L_SSurvay);
        StudentFrame.add(b_SSurvay);
        StudentFrame.add(L_SCourse);
        StudentFrame.add(b_SCourses);
        StudentFrame.add(b_SLogOut);
        loginFrame.setVisible(false);
        StudentFrame.setVisible(true);
        
        b_SLogOut.addActionListener(this);
        
        b_SGrade.addActionListener(this);
        b_SGradeLogOut.addActionListener(this);
        b_SShowGrade.addActionListener(this);
        b_SSurvay.addActionListener(this);
        b_SSLogOut.addActionListener(this);
        b_SUpdate.addActionListener(this);
        b_SCourses.addActionListener(this);
        b_SShowLogOut.addActionListener(this);


        
    }
    
    
    protected  void seeGradeFrame(){
        StuGradeFrame.setTitle("Grades_of_Student");
        StuGradeFrame.setSize(500, 300);
        StuGradeFrame.setLocation(600, 200);
        StuGradeFrame.setResizable(false);
        StuGradeFrame.setLayout(null);
        L_SInputCourse.setBounds(50, 80, 180, 30);
        t_SInputCourse.setBounds(250, 80, 200, 30);
        b_SShowGrade.setBounds(80, 200, 100, 30);
        b_SGradeLogOut.setBounds(300, 200, 100, 30);
        StuGradeFrame.add(L_SInputCourse);
        StuGradeFrame.add(t_SInputCourse);
        StuGradeFrame.add(b_SShowGrade);
        StuGradeFrame.add(b_SGradeLogOut);
        StuGradeFrame.setVisible(true);
    
    
    
    }
    
    protected  void makeSurveyFrame(){
              StuSurvayFrame.setTitle("Student_Survay");
              StuSurvayFrame.setSize(500, 300);
              StuSurvayFrame.setLocation(600, 200);
              StuSurvayFrame.setResizable(false);
              StuSurvayFrame.setLayout(null);
              L_SSurvayCourse.setBounds(50, 50, 180, 30);t_SSurvayCourse.setBounds(250, 50, 200, 30);
              L_SOpinion.setBounds(50, 110, 150, 30);t_SOpinion.setBounds(250, 110, 200, 30);
              b_SUpdate.setBounds(80, 200, 100, 30);b_SSLogOut.setBounds(300, 200, 100, 30);
              StuSurvayFrame.add(L_SSurvayCourse);StuSurvayFrame.add(t_SSurvayCourse);
              StuSurvayFrame.add(L_SOpinion);StuSurvayFrame.add(t_SOpinion);
              StuSurvayFrame.add(b_SUpdate);StuSurvayFrame.add(b_SSLogOut);
              StuSurvayFrame.setVisible(true);  
    }
    
    
    protected  void seeAllCoursesFrame(){
              txt_SShowCourses.setEditable(true);
              StuCoursesFrame.setLayout(new GridLayout(2,1));
              JPanel p=new JPanel();
              JPanel b=new JPanel();
              p.setLayout(new FlowLayout(FlowLayout.CENTER));
              b.setLayout(null);
              StuCoursesFrame.setTitle("Show_All_Courses");
              StuCoursesFrame.setSize(300, 200);
              StuCoursesFrame.setLocation(600, 200);
              StuCoursesFrame.setResizable(false);
              b_SShowLogOut.setBounds(115, 50, 70, 30);
              JScrollPane s=new JScrollPane( txt_SShowCourses,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              p.add(s);
              b.add(b_SShowLogOut);
              StuCoursesFrame.add(p);
              StuCoursesFrame.add(b);
              StuCoursesFrame.setVisible(true); 
    }
    
    
    protected static void updateStudentInfoFrame(){
    
    
    
    
    }

    
    
}
