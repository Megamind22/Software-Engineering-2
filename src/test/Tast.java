
package test;

import Database.DatabaseConnection;
import java.util.*;
import GUI.*;
public class Tast {

  
    public static void main(String[] args)  {
          
        DatabaseConnection connect=new DatabaseConnection();
        Scanner read = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Enter Username :");
        System.out.print("Enter Password");
        loginGui login=new loginGui();
     
    } 
}
