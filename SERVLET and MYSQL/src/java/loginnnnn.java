import java.sql.*;  
  
public class loginnnnn {  
public static boolean validate(String pass){  
boolean status=false;  
try
{  
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
PreparedStatement ps=con.prepareStatement("select * from student where Password=? ");  
 
ps.setString(1,pass);  
ResultSet rs=ps.executeQuery();  
status=rs.next();  
}
catch(Exception e){System.out.println(e);}  

return status; 
} 
 
}  