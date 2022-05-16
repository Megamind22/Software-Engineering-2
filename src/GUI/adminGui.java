package GUI;

import test.CoursesModule;
import test.Admin;
import test.Student;
import test.CourseComponent;
import test.Instructor;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import Database.*;
import javax.swing.*;


public class adminGui extends JFrame implements ActionListener {
    
    private JLabel L_ASTUName, L_ASTUID, L_ASTUCourse, L_AINSName, L_AINSID, L_AINSCourse, L_ASTUDLName,
            L_ASTUDLID, L_AINSDLName, L_AINSDLID, L_AUSTUPID, L_AUSTUNID, L_AUINSPID, L_AUINSNID, L_ACrsName, L_ACrsID, L_ACrsRoom, L_ACrsBranch, L_ACrsPrice, L_ACrsSTDate, L_ACrsEndDate, L_ACrsDays, L_ADLCrsID, L_ACrsUID, L_AUPRoom, L_AUPBranch, L_AUPPrice, L_AUPCrsDays,
            L_AUPSTDate, L_AUPEndDate;

    private JTextField t_ASTUName, t_ASTUID, t_ASTUCourse, t_AINSName, t_AINSID, t_AINSCourse,
            t_ASTUDLName, t_ASTUDLID, t_AINSDLName, t_AINSDLID, t_AUSTUPID, t_AUSTUNID, t_AUINSPID, t_AUINSNID, t_ACrsName, t_ACrsID, t_ACrsRoom, t_ACrsBranch, t_ACrsPrice, t_ACrsSTDate,
            t_ACrsEndDate, t_ACrsDays, t_ADLCrsID, t_ACrsUID, t_AUPRoom, t_AUPBranch, t_AUPPrice, t_AUPCrsDays,
            t_AUPSTDate, t_AUPEndDate;

    private JTextArea txt_AStartCourse, txt_AEndCourse, txt_ASHDS, txt_ASHSTU, txt_ASHINS;

    private JButton  b_AAddSTU, b_AAddINS, b_ADeleteSTU, b_ADeleteINS, b_AUpdateSTU, b_AUpdateINS,
            b_AStartCourse, b_AEndCourse, b_AAddCourse, b_ARemoveCourse, b_AUpdateCourse,
            b_AShowStudents, b_AShowInstructors, b_ALogOut, b_AAddSTULogOut, b_AUAddSTU, b_AAddINSLogOut, b_AUAddINS,
            b_ADLSTULogOut, b_AUDLSTU, b_ADLINSLogOut, b_AUDLINS, b_AUSTULogOut,
            b_AUSTUU, b_AUINSLogOut, b_AUINSU, b_ASTCrsLogOut, b_AEndCrsLogOut, b_AUAddCrs, b_AAddCrsLogOut,
            b_AUDLCrs, b_ADLCrsLogOut,
            b_ASelUpdate, b_AULogOut, b_AUPRoom, b_AUPBranch, b_AUPPrice,
            b_AUPCrsDays, b_AUPSTDate,
            b_AUPEndDate, b_AUPShowCourse, b_AUPLogOut, b_AURoomU, b_AUBranchU,
            b_AUPriceU, b_AUCrsDaysU, b_AUEndU, b_AUSTU,
            b_AURoomLogOut, b_AUBranchLogOut, b_AUPriceLogOut, b_AUCrsDaysLogOut,
            b_AUEndLogOut, b_AUSTLogOut,
            b_ASHDSLogOut, b_ASHSTULogOut, b_ASHINSLogOut;

    private Admin adminSystem = new Admin();
    private CoursesModule coursemodule=new CoursesModule();
    CourseSQl CourseUpdate=new CourseSQl();
    JFrame AdmFrame = new JFrame();
    JFrame AddSTU = new JFrame();
    JFrame AddINS = new JFrame();
    JFrame DeleteSTU = new JFrame();
    JFrame DeleteINS = new JFrame();
    JFrame UpdateSTU = new JFrame();
    JFrame UpdateINS = new JFrame();
    JFrame StartCrs = new JFrame();
    JFrame EndCrs = new JFrame();
    JFrame AddCrs = new JFrame();
    JFrame UpdateCrs = new JFrame();
    JFrame SelUpdateCrs = new JFrame();
    JFrame UpdateRoom = new JFrame();
    JFrame UpdateBranch = new JFrame();
    JFrame UpdatePrice = new JFrame();
    JFrame UpdateCrsDays = new JFrame();
    JFrame UpdateSTDate = new JFrame();
    JFrame UpdateEndDate = new JFrame();
    JFrame ShowCourse = new JFrame();
    JFrame DeleteCrs = new JFrame();
    JFrame ShowAllSTU = new JFrame();
    JFrame ShowAllINS = new JFrame();

    
    
    public adminGui(){
        
     b_AAddSTU=new JButton("ADD_STUDENT");
      L_ASTUName=new JLabel("Enter_Student_Name");
     L_ASTUID=new JLabel("Enter_Student_ID");
     L_ASTUCourse=new JLabel("Enter_CoursesID_In_Space");
     t_ASTUName=new JTextField();
     t_ASTUID=new JTextField();
     t_ASTUCourse=new JTextField();
     b_AUAddSTU=new JButton("Update");
     b_AAddSTULogOut=new JButton("back");
     
     
     b_AAddINS=new JButton("ADD_INSTRUCTOR");
     L_AINSName=new JLabel("Enter_Instructor_Name");
     L_AINSID=new JLabel("Enter_Instructor_ID");
     L_AINSCourse=new JLabel("Enter_Course_ID");
     t_AINSName=new JTextField();
     t_AINSID=new JTextField();
     t_AINSCourse=new JTextField();
     b_AUAddINS=new JButton("Update");
     b_AAddINSLogOut=new JButton("back");
     
     
     b_ADeleteSTU=new JButton("DELETE_STUDENT");
     L_ASTUDLName=new JLabel("Enter_Student_Name");
     L_ASTUDLID=new JLabel("Enter_Student_ID");
     t_ASTUDLName=new JTextField();
     t_ASTUDLID=new JTextField();
     b_AUDLSTU=new JButton("Update");
     b_ADLSTULogOut=new JButton("back");

     
     b_ADeleteINS=new JButton("DELETE_INSTRUCTOR");
     L_AINSDLName=new JLabel("Enter_Instructor_Name");
     L_AINSDLID=new JLabel("Enter_Instructor_ID");
     t_AINSDLName=new JTextField();
     t_AINSDLID=new JTextField();
     b_AUDLINS=new JButton("Update");
     b_ADLINSLogOut=new JButton("back");
     
     
     b_AUpdateSTU=new JButton("UPDATE_STUDENT");
     L_AUSTUPID=new JLabel("Enter_Student_ID");
     L_AUSTUNID=new JLabel("Enter_Student_Name");
     t_AUSTUPID=new JTextField();
     t_AUSTUNID=new JTextField();
     b_AUSTUU=new JButton("Update");
     b_AUSTULogOut=new JButton("back");
     
     
     b_AUpdateINS=new JButton("UPDATE_INSTRUCTOR");
      L_AUINSPID=new JLabel("Enter_Instructor_ID");
     L_AUINSNID=new JLabel("Enter_Instructor_Name");
     t_AUINSPID=new JTextField();
     t_AUINSNID=new JTextField();
     b_AUINSU=new JButton("Update");
     b_AUINSLogOut=new JButton("back");
     
     
     b_AStartCourse=new JButton("START_COURSE");
     txt_AStartCourse=new JTextArea();
     b_ASTCrsLogOut=new JButton("back"); 
     
     
     b_AEndCourse=new JButton("END_COURSE");
     txt_AEndCourse=new JTextArea();
     b_AEndCrsLogOut=new JButton("back");
     
     
     b_AAddCourse=new JButton("ADD_COURSE");
     L_ACrsName=new JLabel("Enter_Course_Name");
      L_ACrsID=new JLabel("Enter_Course_ID");
      L_ACrsRoom=new JLabel("Enter_Course_Room");
      L_ACrsBranch=new JLabel("Enter_Course_Branch");
      L_ACrsPrice=new JLabel("Enter_Course_Price");
      L_ACrsSTDate=new JLabel("Enter_Start_Date");
      L_ACrsEndDate=new JLabel("Enter_End_Date");
      L_ACrsDays=new JLabel("Enter_Course_Days");
      t_ACrsName=new JTextField();
      t_ACrsID=new JTextField();
      t_ACrsRoom=new JTextField();
      t_ACrsBranch=new JTextField();
      t_ACrsPrice=new JTextField();
      t_ACrsSTDate=new JTextField();
      t_ACrsEndDate=new JTextField();
      t_ACrsDays=new JTextField();
      b_AUAddCrs=new JButton("Update");
      b_AAddCrsLogOut=new JButton("back");
     
     b_ARemoveCourse=new JButton("DELETE_COURSE");
     L_ADLCrsID=new JLabel("Enter_Course_ID");
      t_ADLCrsID=new JTextField();
      b_AUDLCrs=new JButton("Update");
      b_ADLCrsLogOut=new JButton("back");
      
      //Update_Course
      b_AUpdateCourse=new JButton("UPDATE_COURSE");
      L_ACrsUID=new JLabel("Enter_Course_ID");
      L_AUPRoom=new JLabel("Enter New Room");
      L_AUPBranch=new JLabel("Enter New Branch ");
      L_AUPPrice=new JLabel("Enter New Price");
      L_AUPCrsDays=new JLabel("Enter_New_Number_Days");
      L_AUPSTDate=new JLabel("Enter New StartDate");
      L_AUPEndDate=new JLabel("Enter New EndDate");
      t_ACrsUID=new JTextField();
      t_AUPRoom=new JTextField();
      t_AUPBranch=new JTextField();
      t_AUPPrice=new JTextField();
      t_AUPCrsDays=new JTextField();
      t_AUPSTDate=new JTextField();
      t_AUPEndDate=new JTextField();
      b_ASelUpdate=new JButton("Selection_Updateٍ");
      b_AULogOut=new JButton("Back");
      b_AUPRoom=new JButton("Update_Room");
      b_AUPBranch=new JButton("Update_Branch");
      b_AUPPrice=new JButton("Update_Price");
      b_AUPCrsDays=new JButton("Update_N_Of_Days");
      b_AUPSTDate=new JButton("Update_StartDate");
      b_AUPEndDate=new JButton("Update_EndDate");
      b_AUPShowCourse=new JButton("Show_Course_Details");
      b_AUPLogOut=new JButton("Back");
      b_AURoomU=new JButton("Update");
      b_AUBranchU=new JButton("Update");
      b_AUPriceU=new JButton("Update");
      b_AUCrsDaysU=new JButton("Update");
      b_AUSTU=new JButton("Update");
      b_AUEndU=new JButton("Update");
      b_AURoomLogOut=new JButton("Back");
      b_AUPriceLogOut=new JButton("Back");
      b_AUBranchLogOut=new JButton("Back");
      b_AUCrsDaysLogOut=new JButton("Back");
      b_AUEndLogOut=new JButton("Back");
      b_AUSTLogOut=new JButton("Back");
      b_ASHDSLogOut=new JButton("Back");
      txt_ASHDS=new JTextArea();
      
     
     b_AShowStudents=new JButton("SHOW_ALL_Students");
      txt_ASHSTU=new JTextArea();
      b_ASHSTULogOut=new JButton("Back");

     b_AShowInstructors=new JButton("SHOW_ALL_INSTRUCTORS");
     txt_ASHINS=new JTextArea();
      b_ASHINSLogOut=new JButton("Back");
      
     b_ALogOut=new JButton("LOG OUT");

        
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b_ALogOut) {
            System.exit(0);
        }
        if (e.getSource() == b_AAddSTU) {

            AddStudentFrame();
        }

        if (e.getSource() == b_AAddSTULogOut) {

            AddSTU.dispose();
        }

        if (e.getSource() == b_AUAddSTU) {
            
            Student newStudent=new Student(t_ASTUName.getText(),Integer.parseInt(t_ASTUID.getText()));
            adminSystem.addStudentWithInitialCourses(newStudent, t_ASTUCourse.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            AddSTU.dispose();

        }

        if (e.getSource() == b_AAddINS) {

            AddInstructorFrame();
        }

        if (e.getSource() == b_AAddINSLogOut) {

            AddINS.dispose();
        }

        if (e.getSource() == b_AUAddINS) {
            Instructor newInstructor=new Instructor(t_AINSName.getText(),Integer.parseInt(t_AINSID.getText()));
            adminSystem.addInstructorWithInitialCourse(newInstructor, t_AINSCourse.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            AddINS.dispose();

        }

        if (e.getSource() == b_ADeleteSTU) {

            DeleteStudentFrame();
        }

        if (e.getSource() == b_ADLSTULogOut) {

            DeleteSTU.dispose();
        }

        if (e.getSource() == b_AUDLSTU) {
            
            adminSystem.deleteStudent(Integer.parseInt(t_ASTUDLID.getText()));
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            DeleteSTU.dispose();

        }

        if (e.getSource() == b_ADeleteINS) {

            DeleteInstructorFrame();
        }

        if (e.getSource() == b_ADLINSLogOut) {

            DeleteINS.dispose();
        }

        if (e.getSource() == b_AUDLINS) {
            adminSystem.deleteInstructort(Integer.parseInt(t_AINSDLID.getText()));
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            DeleteINS.dispose();

        }

        if (e.getSource() == b_AUpdateSTU) {

            UpdateStudentFrame();
        }

        if (e.getSource() == b_AUSTULogOut) {

            UpdateSTU.dispose();
        }

        if (e.getSource() == b_AUSTUU) {
            AdminSQl.updateStudent(t_AUSTUPID.getText(),t_AUSTUNID.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdateSTU.dispose();

        }

        if (e.getSource() == b_AUpdateINS) {

            UpdateInstructorFrame();
        }

        if (e.getSource() == b_AUINSLogOut) {

            UpdateINS.dispose();
        }

        if (e.getSource() == b_AUINSU) {
            AdminSQl.updateInstructor(t_AUINSPID.getText(),t_AUINSNID.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdateINS.dispose();

        }

        if (e.getSource() == b_AStartCourse) {
            StartCourseFrame();
            
            try {
                txt_AStartCourse.setText(coursemodule.ShowNearestStartCourseDetails());
            } catch (ParseException ex) {
                System.out.println(ex);
            }

        }

        if (e.getSource() == b_ASTCrsLogOut) {

            StartCrs.dispose();

        }

        if (e.getSource() == b_AEndCourse) {

            EndCourseFrame();

            try {
                txt_AEndCourse.setText(coursemodule.ShowNearestEndCoursDetails());
            } catch (ParseException ex) {
                System.out.println(ex);
            }

        }

        if (e.getSource() == b_AEndCrsLogOut) {

            EndCrs.dispose();

        }

        if (e.getSource() == b_AAddCourse) {
            AddCourseFrame();
        }

        if (e.getSource() == b_AAddCrsLogOut) {
            AddCrs.dispose();
        }

        if (e.getSource() == b_AUAddCrs) {
            System.out.println(Integer.parseInt(t_ACrsID.getText()));
            CourseComponent c=new CourseComponent(t_ACrsName.getText(),Integer.parseInt(t_ACrsID.getText()),t_ACrsRoom.getText(),t_ACrsBranch.getText(),t_ACrsPrice.getText(),t_ACrsSTDate.getText(),t_ACrsDays.getText(),t_ACrsEndDate.getText());    

              coursemodule.addCourse(c);
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            AddCrs.dispose();

        }

        if (e.getSource() == b_ARemoveCourse) {
            
            DeleteCourseFrame();
        }

        if (e.getSource() == b_ADLCrsLogOut) {
            DeleteCrs.dispose();
        }

        if (e.getSource() == b_AUDLCrs) {
                  
            coursemodule.deleteCourse(t_ADLCrsID.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            DeleteCrs.dispose();

        }

        if (e.getSource() == b_AUpdateCourse) {
            UpdateCourseFrame();
        }

        if (e.getSource() == b_AULogOut) {
            UpdateCrs.dispose();
        }

        if (e.getSource() == b_ASelUpdate) {
            
            
            SelectionUpdateCourseFrame();
        }

        if (e.getSource() == b_AUPLogOut) {
            SelUpdateCrs.dispose();
        }

        if (e.getSource() == b_AUPRoom) {
            CourseRoomFrame();
        }

        if (e.getSource() == b_AURoomU) {
            UpdateCourseSQL.UpdateRoom(t_ACrsUID.getText(),t_AUPRoom.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdateRoom.dispose();
        }

        if (e.getSource() == b_AURoomLogOut) {
            UpdateRoom.dispose();
        }

        if (e.getSource() == b_AUPBranch) {
            CourseBranchFrame();
        }

        if (e.getSource() == b_AUBranchU) {
           UpdateCourseSQL.Updatebranch(t_ACrsUID.getText(),t_AUPBranch.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdateBranch.dispose();
        }

        if (e.getSource() == b_AUBranchLogOut) {
            UpdateBranch.dispose();
        }

        if (e.getSource() == b_AUPPrice) {
            CoursePriceFrame();
        }

        if (e.getSource() == b_AUPriceU) {
             UpdateCourseSQL.UpdateCoursePrice(t_ACrsUID.getText(),t_AUPPrice.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdatePrice.dispose();
        }

        if (e.getSource() == b_AUPriceLogOut) {
            UpdatePrice.dispose();
        }

        if (e.getSource() == b_AUPCrsDays) {
            NumberOfCourseDaysFrame();
        }

        if (e.getSource() == b_AUCrsDaysU) {
             UpdateCourseSQL.UpdateDaysOfCourse(t_ACrsUID.getText(),t_AUPCrsDays.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdateCrsDays.dispose();
        }

        if (e.getSource() == b_AUCrsDaysLogOut) {
            UpdateCrsDays.dispose();
        }

        if (e.getSource() == b_AUPSTDate) {
            CourseStartDataFrame();
        }

        if (e.getSource() == b_AUSTU) {
             UpdateCourseSQL.UpdateStartDate(t_ACrsUID.getText(),t_AUPSTDate.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdateSTDate.dispose();
        }

        if (e.getSource() == b_AUSTLogOut) {
            UpdateSTDate.dispose();
        }

        if (e.getSource() == b_AUPEndDate) {
            CourseEndDataFrame();
        }

        if (e.getSource() == b_AUEndU) {
            UpdateCourseSQL.UpdateEndDate(t_ACrsUID.getText(),t_AUPEndDate.getText());
            JOptionPane.showMessageDialog(null, "Vaild Update", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            UpdateEndDate.dispose();
        }

        if (e.getSource() == b_AUEndLogOut) {
            UpdateEndDate.dispose();
        }
        
        if(e.getSource()==b_AUPShowCourse){        
        
                ShowCourseDetailsFrame();
                
                 txt_ASHDS.setText("txt");
    
     }

        if (e.getSource() == b_ASHDSLogOut) {
            ShowCourse.dispose();
        }

        if (e.getSource() == b_AShowStudents) {

            ShowAllStudentsFrame();
            
            txt_ASHSTU.setText(adminSystem.shwoAllStudent());

        }

        if (e.getSource() == b_ASHSTULogOut) {
            ShowAllSTU.dispose();
        }

        if (e.getSource() == b_AShowInstructors) {
            
            ShowAllInstructorsFrame();

            txt_ASHINS.setText(adminSystem.shwoAllInstractor());

        }

        if (e.getSource() == b_ASHINSLogOut) {
            ShowAllINS.dispose();
        }

        
        
    }
    
    
    
    protected void showAdminFrame(){
            System.out.println(this);
              AdmFrame.setTitle("Admin");
              AdmFrame.setSize(500, 400);
              AdmFrame.setLocation(550, 100);
              AdmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              AdmFrame.setResizable(false);
              AdmFrame.setLayout(new GridLayout(7,2,10,10));
              b_ALogOut.setForeground(Color.red);
              AdmFrame.add(b_AAddSTU); AdmFrame.add(b_AAddINS); AdmFrame.add(b_ADeleteSTU);
              AdmFrame.add(b_ADeleteINS); AdmFrame.add(b_AUpdateSTU); AdmFrame.add(b_AUpdateINS);
              AdmFrame.add(b_AStartCourse); AdmFrame.add(b_AEndCourse); AdmFrame.add(b_AAddCourse);
              AdmFrame.add(b_ARemoveCourse); AdmFrame.add(b_AUpdateCourse); AdmFrame.add(b_AShowStudents);
              AdmFrame.add(b_AShowInstructors); AdmFrame.add(b_ALogOut);
              AdmFrame.setVisible(true);
             // this.setVisible(false);
              b_ALogOut.addActionListener(this);
              b_AAddSTU.addActionListener(this);
              
              b_AUAddSTU.addActionListener(this);
              b_AAddSTULogOut.addActionListener(this);
              b_AAddINS.addActionListener(this);
              b_AUAddINS.addActionListener(this);
              b_AAddINSLogOut.addActionListener(this);
              b_ADeleteSTU.addActionListener(this);
              b_AUDLSTU.addActionListener(this);
              b_ADLSTULogOut.addActionListener(this);
              b_ADeleteINS.addActionListener(this);
              b_AUDLINS.addActionListener(this);
              b_ADLINSLogOut.addActionListener(this);
              b_AUpdateSTU.addActionListener(this);
              b_AUSTUU.addActionListener(this);
              b_AUSTULogOut.addActionListener(this);
              b_AUpdateINS.addActionListener(this);
              b_AUINSU.addActionListener(this);
              b_AUINSLogOut.addActionListener(this);
              b_AStartCourse.addActionListener(this);
              b_ASTCrsLogOut.addActionListener(this);
              b_AEndCourse.addActionListener(this);
              b_AEndCrsLogOut.addActionListener(this);
              b_AAddCourse.addActionListener(this);
              b_AUAddCrs.addActionListener(this);
              b_AAddCrsLogOut.addActionListener(this);
              b_ARemoveCourse.addActionListener(this);
              b_AUDLCrs.addActionListener(this);
              b_ADLCrsLogOut.addActionListener(this);
              b_AUpdateCourse.addActionListener(this);
              b_AULogOut.addActionListener(this);
              b_AShowStudents.addActionListener(this);
              b_ASHSTULogOut.addActionListener(this);
              b_AShowInstructors.addActionListener(this);
              b_ASHINSLogOut.addActionListener(this);
    }
    
    public void AddStudentFrame(){
              AddSTU.setTitle("ADD_STUDENT");
              AddSTU.setSize(500, 300);
              AddSTU.setLocation(600, 200);
              AddSTU.setResizable(false);
              AddSTU.setLayout(null);
              L_ASTUName.setBounds(50, 20, 180, 30);t_ASTUName.setBounds(250, 20, 200, 30);
              L_ASTUID.setBounds(50, 70, 150, 30);t_ASTUID.setBounds(250, 70, 200, 30);
              L_ASTUCourse.setBounds(50, 110, 160, 50);t_ASTUCourse.setBounds(250, 120, 200, 30);
              b_AUAddSTU.setBounds(80, 200, 100, 30); b_AAddSTULogOut.setBounds(300, 200, 100, 30);
              AddSTU.add(L_ASTUName);AddSTU.add(t_ASTUName);AddSTU.add(L_ASTUID);AddSTU.add(t_ASTUID);
              AddSTU.add(L_ASTUCourse);AddSTU.add(t_ASTUCourse);
              AddSTU.add( b_AAddSTULogOut);AddSTU.add( b_AUAddSTU);
              AddSTU.setVisible(true);
    }
    public void AddInstructorFrame(){
              AddINS.setTitle("ADD_INSTRUCTOR");
              AddINS.setSize(500, 300);
              AddINS.setLocation(600, 200);
              AddINS.setResizable(false);
              AddINS.setLayout(null);
              L_AINSName.setBounds(50, 20, 180, 30);t_AINSName.setBounds(250, 20, 200, 30);
              L_AINSID.setBounds(50, 70, 150, 30);t_AINSID.setBounds(250, 70, 200, 30);
              L_AINSCourse.setBounds(50, 120, 150, 30);t_AINSCourse.setBounds(250, 120, 200, 30);
              b_AUAddINS.setBounds(80, 200, 100, 30); b_AAddINSLogOut.setBounds(300, 200, 100, 30);
              AddINS.add(L_AINSName); AddINS.add(t_AINSName); AddINS.add(L_AINSID); AddINS.add(t_AINSID);
              AddINS.add(L_AINSCourse); AddINS.add(t_AINSCourse);
              AddINS.add( b_AAddINSLogOut); AddINS.add( b_AUAddINS);
              AddINS.setVisible(true);
    }

   public void DeleteStudentFrame(){
              DeleteSTU.setTitle("Delete_STUDENT");
              DeleteSTU.setSize(500, 300);
              DeleteSTU.setLocation(600, 200);
              DeleteSTU.setResizable(false);
              DeleteSTU.setLayout(null);
              L_ASTUDLName.setBounds(50, 50, 180, 30);t_ASTUDLName.setBounds(250, 50, 200, 30);
              L_ASTUDLID.setBounds(50, 120, 150, 30);t_ASTUDLID.setBounds(250, 120, 200, 30);
              b_AUDLSTU.setBounds(80, 200, 100, 30); b_ADLSTULogOut.setBounds(300, 200, 100, 30);
              DeleteSTU.add(L_ASTUDLName);DeleteSTU.add(t_ASTUDLName);
              DeleteSTU.add(L_ASTUDLID);DeleteSTU.add(t_ASTUDLID);
              DeleteSTU.add( b_ADLSTULogOut);DeleteSTU.add( b_AUDLSTU);
              DeleteSTU.setVisible(true);
    }

   public void DeleteInstructorFrame(){
              DeleteINS.setTitle("Delete_INSTRUCTOR");
              DeleteINS.setSize(500, 300);
              DeleteINS.setLocation(600, 200);
              DeleteINS.setResizable(false);
              DeleteINS.setLayout(null);
              L_AINSDLName.setBounds(50, 50, 180, 30);t_AINSDLName.setBounds(250, 50, 200, 30);
              L_AINSDLID.setBounds(50, 120, 150, 30);t_AINSDLID.setBounds(250, 120, 200, 30);
              b_AUDLINS.setBounds(80, 200, 100, 30); b_ADLINSLogOut.setBounds(300, 200, 100, 30);
              DeleteINS.add(L_AINSDLName);DeleteINS.add(t_AINSDLName);
              DeleteINS.add(L_AINSDLID);DeleteINS.add(t_AINSDLID);
              DeleteINS.add( b_ADLINSLogOut);DeleteINS.add( b_AUDLINS);
              DeleteINS.setVisible(true);
    }

   public void UpdateStudentFrame(){
              UpdateSTU.setTitle("Update_Student");
              UpdateSTU.setSize(500, 300);
              UpdateSTU.setLocation(600, 200);
              UpdateSTU.setResizable(false);
              UpdateSTU.setLayout(null);
              L_AUSTUPID.setBounds(50, 50, 180, 30);t_AUSTUPID.setBounds(250, 50, 200, 30);
              L_AUSTUNID.setBounds(50, 120, 150, 30);t_AUSTUNID.setBounds(250, 120, 200, 30);
              b_AUSTUU.setBounds(80, 200, 100, 30); b_AUSTULogOut.setBounds(300, 200, 100, 30);
              UpdateSTU.add(L_AUSTUPID);UpdateSTU.add(t_AUSTUPID);
              UpdateSTU.add( L_AUSTUNID);UpdateSTU.add(t_AUSTUNID);
              UpdateSTU.add(b_AUSTUU);UpdateSTU.add(b_AUSTULogOut);
              UpdateSTU.setVisible(true);
    }

   public void UpdateInstructorFrame(){
              UpdateINS.setTitle("Update_Instructor");
              UpdateINS.setSize(500, 300);
              UpdateINS.setLocation(600, 200);
              UpdateINS.setResizable(false);
              UpdateINS.setLayout(null);
              L_AUINSPID.setBounds(50, 50, 180, 30);t_AUINSPID.setBounds(250, 50, 200, 30);
              L_AUINSNID.setBounds(50, 120, 150, 30);t_AUINSNID.setBounds(250, 120, 200, 30);
              b_AUINSU.setBounds(80, 200, 100, 30); b_AUINSLogOut.setBounds(300, 200, 100, 30);
              UpdateINS.add(L_AUINSPID);UpdateINS.add(t_AUINSPID);
              UpdateINS.add( L_AUINSNID);UpdateINS.add(t_AUINSNID);
              UpdateINS.add(b_AUINSU);UpdateINS.add(b_AUINSLogOut);
              UpdateINS.setVisible(true);
    }

       public void StartCourseFrame(){
              txt_AStartCourse.setEditable(true);
              StartCrs.setLayout(new GridLayout(2,1));
              JPanel p=new JPanel();
              JPanel b=new JPanel();
              p.setLayout(new FlowLayout(FlowLayout.CENTER));
              b.setLayout(null);
              StartCrs.setTitle("START_COURSE");
              StartCrs.setSize(500, 200);
              StartCrs.setLocation(600, 200);
              StartCrs.setResizable(false);
              b_ASTCrsLogOut.setBounds(165, 50, 110, 30);
              JScrollPane s=new JScrollPane(txt_AStartCourse,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              p.add(s);
              b.add(b_ASTCrsLogOut);
              StartCrs.add(p);StartCrs.add(b);
              this.setVisible(false);
              StartCrs.setVisible(true);   
    } 

   public void EndCourseFrame(){
              txt_AEndCourse.setEditable(true);
              EndCrs.setLayout(new GridLayout(2,1));
              JPanel p=new JPanel();
              JPanel b=new JPanel();
              p.setLayout(new FlowLayout(FlowLayout.CENTER));
              b.setLayout(null);
              EndCrs.setTitle("END_COURSE");
              EndCrs.setSize(500, 200);
              EndCrs.setLocation(600, 200);
              EndCrs.setResizable(false);
              b_AEndCrsLogOut.setBounds(165, 50, 110, 30);
              JScrollPane s=new JScrollPane(txt_AEndCourse,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              p.add(s);
              b.add(b_AEndCrsLogOut);
              EndCrs.add(p);EndCrs.add(b);
              this.setVisible(false);
              EndCrs.setVisible(true);   
    } 

   public void AddCourseFrame(){
              AddCrs.setTitle("ADD_COURSE");
              AddCrs.setSize(800, 500);
              AddCrs.setLocation(600, 200);
              AddCrs.setResizable(false);
              AddCrs.setLayout(null);
              L_ACrsName.setBounds(50, 40, 150, 30);t_ACrsName.setBounds(200, 40, 150, 30);
              L_ACrsID.setBounds(400, 40, 150, 30);t_ACrsID.setBounds(550, 40, 150, 30);
              L_ACrsRoom.setBounds(50, 120, 150, 30);t_ACrsRoom.setBounds(200, 120, 150, 30);
              L_ACrsBranch.setBounds(400, 120, 150, 30);t_ACrsBranch.setBounds(550, 120, 150, 30);
              L_ACrsPrice.setBounds(50, 200, 150, 30);t_ACrsPrice.setBounds(200, 200, 150, 30);
              L_ACrsDays.setBounds(400, 200, 150, 30);t_ACrsDays.setBounds(550, 200, 150, 30);
              L_ACrsSTDate.setBounds(50, 280, 150, 30);t_ACrsSTDate.setBounds(200, 280, 150, 30);
              L_ACrsEndDate.setBounds(400, 280, 150, 30);t_ACrsEndDate.setBounds(550, 280, 150, 30);
              b_AUAddCrs.setBounds(150, 370, 200, 50); b_AAddCrsLogOut.setBounds(450, 370, 200, 50);
              AddCrs.add(L_ACrsName);AddCrs.add(t_ACrsName);AddCrs.add(L_ACrsID);AddCrs.add(t_ACrsID);
              AddCrs.add(L_ACrsRoom);AddCrs.add(t_ACrsRoom);AddCrs.add(L_ACrsBranch);AddCrs.add(t_ACrsBranch);
              AddCrs.add(L_ACrsPrice);AddCrs.add(t_ACrsPrice);AddCrs.add(L_ACrsDays);AddCrs.add(t_ACrsDays);
              AddCrs.add(L_ACrsSTDate);AddCrs.add(t_ACrsSTDate);AddCrs.add(L_ACrsEndDate);AddCrs.add(t_ACrsEndDate);
              AddCrs.add( b_AAddCrsLogOut);AddCrs.add( b_AUAddCrs);
              AddCrs.setVisible(true);
    }

    
   public void DeleteCourseFrame(){
              DeleteCrs.setTitle("DELETE_COURSE");
              DeleteCrs.setSize(300, 200);
              DeleteCrs.setLocation(600, 200);
              DeleteCrs.setResizable(false);
              DeleteCrs.setLayout(null);
              L_ADLCrsID.setBounds(30, 50, 130, 30);t_ADLCrsID.setBounds(170, 50, 100, 30);
              b_AUDLCrs.setBounds(30, 115, 100, 30); b_ADLCrsLogOut.setBounds(150, 115, 100, 30);
              DeleteCrs.add( L_ADLCrsID);DeleteCrs.add(t_ADLCrsID);
              DeleteCrs.add( b_AUDLCrs);DeleteCrs.add( b_ADLCrsLogOut);
              DeleteCrs.setVisible(true);
    }

   public void UpdateCourseFrame(){
              UpdateCrs.setTitle("UPDATE_COURSE");
              UpdateCrs.setSize(400, 200);
              UpdateCrs.setLocation(600, 200);
              UpdateCrs.setResizable(false);
              UpdateCrs.setLayout(null);
              L_ACrsUID.setBounds(30, 50, 130, 30);t_ACrsUID.setBounds(170, 50, 200, 30);
              b_ASelUpdate.setBounds(30, 115, 150, 30); b_AULogOut.setBounds(240, 115, 100, 30);
              UpdateCrs.add( L_ACrsUID);UpdateCrs.add(t_ACrsUID);
              UpdateCrs.add( b_ASelUpdate);UpdateCrs.add( b_AULogOut);
              UpdateCrs.setVisible(true);
              b_AUPLogOut.addActionListener(this);
              b_ASelUpdate.addActionListener(this);
             
    }

   public void SelectionUpdateCourseFrame(){
              SelUpdateCrs.setTitle("Selection_Update_COURSE");
              SelUpdateCrs.setSize(500, 400);
              SelUpdateCrs.setLocation(600, 200);
              SelUpdateCrs.setResizable(false);
              SelUpdateCrs.setLayout(new GridLayout(4,2,10,10));
              SelUpdateCrs.add(b_AUPRoom);SelUpdateCrs.add(b_AUPBranch);SelUpdateCrs.add(b_AUPPrice);
              SelUpdateCrs.add(b_AUPCrsDays);SelUpdateCrs.add(b_AUPSTDate);SelUpdateCrs.add(b_AUPEndDate);
              SelUpdateCrs.add(b_AUPShowCourse);SelUpdateCrs.add(b_AUPLogOut);
              SelUpdateCrs.setVisible(true);
              UpdateCrs.setVisible(false);
              b_AUPRoom.addActionListener(this);
              b_AURoomLogOut.addActionListener(this);
              b_AURoomU.addActionListener(this);
              b_AUPBranch.addActionListener(this);
              b_AUBranchLogOut.addActionListener(this);
              b_AUBranchU.addActionListener(this);
              b_AUPPrice.addActionListener(this);
              b_AUPriceLogOut.addActionListener(this);
              b_AUPriceU.addActionListener(this);
              b_AUPCrsDays.addActionListener(this);
              b_AUCrsDaysLogOut.addActionListener(this);
              b_AUCrsDaysU.addActionListener(this);
              b_AUPSTDate.addActionListener(this);
              b_AUSTLogOut.addActionListener(this);
              b_AUSTU.addActionListener(this);
              b_AUPEndDate.addActionListener(this);
              b_AUEndLogOut.addActionListener(this);
              b_AUEndU.addActionListener(this);
              b_AUPShowCourse.addActionListener(this);
              b_ASHDSLogOut.addActionListener(this);
    }

   public void CourseRoomFrame(){
              UpdateRoom.setTitle("UPDATE_COURSE-ROOM");
              UpdateRoom.setSize(400, 200);
              UpdateRoom.setLocation(600, 200);
              UpdateRoom.setResizable(false);
              UpdateRoom.setLayout(null);
              L_AUPRoom.setBounds(40, 50, 180, 30);t_AUPRoom.setBounds(220, 50, 130, 30);
              b_AURoomU.setBounds(50, 115, 100, 30); b_AURoomLogOut.setBounds(240, 115, 100, 30);
              UpdateRoom.add( L_AUPRoom);UpdateRoom.add(t_AUPRoom);
              UpdateRoom.add( b_AURoomU);UpdateRoom.add( b_AURoomLogOut);
              UpdateRoom.setVisible(true);
    }

   public void CourseBranchFrame(){
              UpdateBranch.setTitle("UPDATE_COURSE-BRANCH");
              UpdateBranch.setSize(400, 200);
              UpdateBranch.setLocation(600, 200);
              UpdateBranch.setResizable(false);
              UpdateBranch.setLayout(null);
              L_AUPBranch.setBounds(40, 50, 180, 30);t_AUPBranch.setBounds(220, 50, 130, 30);
              b_AUBranchU.setBounds(50, 115, 100, 30); b_AUBranchLogOut.setBounds(240, 115, 100, 30);
              UpdateBranch.add( L_AUPBranch);UpdateBranch.add(t_AUPBranch);
              UpdateBranch.add( b_AUBranchU);UpdateBranch.add( b_AUBranchLogOut);
              UpdateBranch.setVisible(true);
    }

   public void CoursePriceFrame(){
              UpdatePrice.setTitle("UPDATE_COURSE-PRICE");
              UpdatePrice.setSize(400, 200);
              UpdatePrice.setLocation(600, 200);
              UpdatePrice.setResizable(false);
              UpdatePrice.setLayout(null);
              L_AUPPrice.setBounds(40, 50, 180, 30);t_AUPPrice.setBounds(220, 50, 130, 30);
              b_AUPriceU.setBounds(50, 115, 100, 30); b_AUPriceLogOut.setBounds(240, 115, 100, 30);
              UpdatePrice.add( L_AUPPrice);UpdatePrice.add(t_AUPPrice);
              UpdatePrice.add( b_AUPriceU);UpdatePrice.add( b_AUPriceLogOut);
              UpdatePrice.setVisible(true);
    }

   public void NumberOfCourseDaysFrame(){
              UpdateCrsDays.setTitle("UPDATE_Number_Of_COURSE-Days");
              UpdateCrsDays.setSize(400, 200);
              UpdateCrsDays.setLocation(600, 200);
              UpdateCrsDays.setResizable(false);
              UpdateCrsDays.setLayout(null);
              L_AUPCrsDays.setBounds(40, 50, 180, 30);t_AUPCrsDays.setBounds(220, 50, 130, 30);
              b_AUCrsDaysU.setBounds(50, 115, 100, 30); b_AUCrsDaysLogOut.setBounds(240, 115, 100, 30);
              UpdateCrsDays.add(L_AUPCrsDays);UpdateCrsDays.add(t_AUPCrsDays);
              UpdateCrsDays.add( b_AUCrsDaysU);UpdateCrsDays.add( b_AUCrsDaysLogOut);
              UpdateCrsDays.setVisible(true);
    }

   public void CourseStartDataFrame(){
              UpdateSTDate.setTitle("UPDATE_Course_StartData");
              UpdateSTDate.setSize(400, 200);
              UpdateSTDate.setLocation(600, 200);
              UpdateSTDate.setResizable(false);
              UpdateSTDate.setLayout(null);
              L_AUPSTDate.setBounds(40, 50, 180, 30);t_AUPSTDate.setBounds(220, 50, 130, 30);
              b_AUSTU.setBounds(50, 115, 100, 30); b_AUSTLogOut.setBounds(240, 115, 100, 30);
              UpdateSTDate.add( L_AUPSTDate);UpdateSTDate.add(t_AUPSTDate);
              UpdateSTDate.add( b_AUSTU);UpdateSTDate.add( b_AUSTLogOut);
              UpdateSTDate.setVisible(true);
    }

   public void CourseEndDataFrame(){
              UpdateEndDate.setTitle("UPDATE_Course_StartData");
              UpdateEndDate.setSize(400, 200);
              UpdateEndDate.setLocation(600, 200);
              UpdateEndDate.setResizable(false);
              UpdateEndDate.setLayout(null);
              L_AUPEndDate.setBounds(40, 50, 180, 30);t_AUPEndDate.setBounds(220, 50, 130, 30);
              b_AUEndU.setBounds(50, 115, 100, 30); b_AUEndLogOut.setBounds(240, 115, 100, 30);
              UpdateEndDate.add( L_AUPEndDate);UpdateEndDate.add(t_AUPEndDate);
              UpdateEndDate.add( b_AUEndU);UpdateEndDate.add(b_AUEndLogOut);
              UpdateEndDate.setVisible(true);
    }

   public void ShowCourseDetailsFrame(){
              ShowCourse.setTitle("Show_Course_Details");
              txt_ASHDS.setEditable(true);
              ShowCourse.setLayout(new GridLayout(2,1));
              JPanel p=new JPanel();
              JPanel b=new JPanel();
              p.setLayout(new FlowLayout(FlowLayout.CENTER));
              b.setLayout(null);
              ShowCourse.setSize(400, 600);
              ShowCourse.setLocation(600, 200);
              ShowCourse.setResizable(false);
              b_ASHDSLogOut.setBounds(100, 200, 200, 40);
              JScrollPane s=new JScrollPane(txt_ASHDS,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              p.add(s);
              b.add( b_ASHDSLogOut);
               ShowCourse.add(p); ShowCourse.add(b);
               ShowCourse.setVisible(true);
    }

   public void ShowAllStudentsFrame(){
              ShowAllSTU.setTitle("Show_All_Student");
              txt_ASHSTU.setEditable(true);
              ShowAllSTU.setLayout(new GridLayout(2,1));
              JPanel p=new JPanel();
              JPanel b=new JPanel();
              p.setLayout(new FlowLayout(FlowLayout.CENTER));
              b.setLayout(null);
              ShowAllSTU.setSize(400, 600);
              ShowAllSTU.setLocation(600, 200);
              ShowAllSTU.setResizable(false);
              b_ASHSTULogOut.setBounds(100, 200, 200, 40);
              JScrollPane s=new JScrollPane(txt_ASHSTU,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              p.add(s);
              b.add( b_ASHSTULogOut);
               ShowAllSTU.add(p); ShowAllSTU.add(b);
              ShowAllSTU.setVisible(true);
    }

   public void ShowAllInstructorsFrame(){
              ShowAllINS.setTitle("Show_All_Instructor");
              txt_ASHINS.setEditable(true);
              ShowAllINS.setLayout(new GridLayout(2,1));
              JPanel p=new JPanel();
              JPanel b=new JPanel();
              p.setLayout(new FlowLayout(FlowLayout.CENTER));
              b.setLayout(null);
              ShowAllINS.setSize(400, 600);
              ShowAllINS.setLocation(600, 200);
              ShowAllINS.setResizable(false);
              b_ASHINSLogOut.setBounds(100, 200, 200, 40);
              JScrollPane s=new JScrollPane(txt_ASHINS,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
              p.add(s);
              b.add( b_ASHINSLogOut);
               ShowAllINS.add(p); ShowAllINS.add(b);
              ShowAllINS.setVisible(true);
    }

    
}
