
package library.management.system;
import java.sql.*;
public class dbConnection {
    Connection connection;
    Statement statement;
     public dbConnection(){
      try{
       Class.forName("com.mysql.jdbc.Driver");
       connection=DriverManager.getConnection("jdbc:mysql:///library_management_system","root","");
       statement=connection.createStatement();
      }
      catch(Exception e){
        e.printStackTrace();
      }
    
    }
}
