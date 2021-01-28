
package hotel.managment.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
   
Conn()
{
  try {
	    Class.forName("com.mysql.jdbc.Driver");
	    c=DriverManager.getConnection("jdbc:mysql://127.0.0.1/hotel","root","");
	    s=c.createStatement();
           
	  
      }
  catch(ClassNotFoundException | SQLException e)
  {
	System.out.print(e); 
  }
}
}
