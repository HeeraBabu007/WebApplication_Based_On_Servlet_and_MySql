import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class teachweb extends HttpServlet {  
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
    
        String a=request.getParameter("teachfname");
        PreparedStatement ps=con.prepareStatement("select * from teacher where Fname=?");
        ps.setString(1,a);
        
        ResultSet rs=ps.executeQuery();
        
        while(rs.next())
        {
            String b=rs.getString("Lname");
            String c=rs.getString("DOB");
            String d=rs.getString("Email_id");
            String e=rs.getString("Phone_no");
            int f=rs.getInt("letter_no");
            
            out.println("<html>");
            out.println("<body>");
            out.println("<font size='5' color='blue'> Welcome to Teacher's portal "+a+" "+b+"</font><br>");
            out.println("<B><h3>Your information in our database is as follows:</h3><B> <br>");
            out.println("<table border='2'>");
            out.println("<tr><td><B>DOB=</B>"+c+"</td></tr>");
            out.println("<tr><td><b>Email id=</b>"+d+"</td></tr>");
            out.println("<tr><td><B>Phone number=</B>"+e+"</td></tr>");
            out.println("<tr><td><B>Admission letter number=</B>"+f+"</td></tr>");
            out.println("</table></body></html>");
            out.println("<a href='marksenter.html'>click here to enter marks</a>");
        }
    }
    catch(Exception exc)
    {
        exc.printStackTrace();
    }  
  
}  
}