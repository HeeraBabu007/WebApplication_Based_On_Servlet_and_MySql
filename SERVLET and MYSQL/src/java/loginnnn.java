import java.sql.*;  
  
public class loginnnn {  
public static boolean validate(int roll){  
boolean status=false;  
try
{  
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
PreparedStatement ps=con.prepareStatement("select * from rollnumber where Roll_no=? ");  
 
ps.setInt(1,roll);  
ResultSet rs=ps.executeQuery();  
status=rs.next();  
}
catch(Exception e){System.out.println(e);}  

return status; 
} 
 
}  