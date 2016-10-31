import java.sql.*;  
  
public class teacherloginnn {  
public static boolean validate(String name){  
boolean status=false;  
try
{  
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
PreparedStatement ps=con.prepareStatement("select * from teacher where Fname=?");  
 
ps.setString(1,name);  

ResultSet rs=ps.executeQuery();  
status=rs.next();  
}
catch(Exception e){System.out.println(e);}  

return status; 
} 
 
}  