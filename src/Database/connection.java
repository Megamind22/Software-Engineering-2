
package Database;

import java.sql.*;

public interface connection {
  
    public static final String URL ="jdbc:oracle:thin:@localhost:1521:XE"  ; 
    public static final String username = "mohamed" ; 
    public static final String password = "123" ; 
    
    public boolean testConnection() ;
    public void closeConnection() ; 
}
