package test;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dsrfsd;
//
//
//import java.sql.* ; 
//import java.util.*;
//
//
///**
// *
// * @author HP
// */
//public class Dsrfsd {
//
//    /**
//     * @param args the command line arguments
//     */
//    
//    public static void main(String[] args) throws SQLException {
//        // TODO code application logic here
//        
//  
//        String dbuRl= "jdbc:oracle:thin:@localhost:1521:XE" ; 
//        String username= "mohamed" ;
//        String password= "123" ;
//        
//        try {
//            java.sql.Connection connection =  DriverManager.getConnection(dbuRl , username , password);
//            System.out.println("connection to orcale server: ");
//            
//             Statement statement = connection.createStatement() ; 
//             
//             String room = "h5" ; 
//             String branch = "cairo" ; 
//             int pric = 100 ; 
//             String START_DATE = "23/30/2000 "  ;
//             int DAYS_OF_COURSE = 4;
//             String END_DATE = "27/30/2000 "  ; 
//             int CR_ID = 201970 ;
//             int id = 201970 ; 
//             
//             String name = "pl3" ;     
//             
//  // String query="UPDATE STUDENT set Name ='" +"ahmed mohamed"  + "' WHERE ID ='" + 201900400 + "'  ";
//           // String NewName = "ailmohamed"; 
//     String query ="Begin"
//                + "\n"
//                + "delete from INSTRUCTOR where id="
//                + 5555 + ";"
//                + "\n"
//                + "delete from users where password="
//                + 5555 + ";"
//                + "\n" + "End;";
//             statement.executeUpdate(query) ; 
//             
//
//             
//               
//           
//          
//            
//        }
//        catch(SQLException e){
//            
//            e.printStackTrace();
//        }
//        
//        
//       
//        
//    }
//    
//}
