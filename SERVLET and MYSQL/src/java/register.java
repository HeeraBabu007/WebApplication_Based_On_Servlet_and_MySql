import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

public class register extends HttpServlet 
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                String a=request.getParameter("userfname");
                String b=request.getParameter("userlname");
                String c=request.getParameter("userdob");
                String d=request.getParameter("userid");
                String e=request.getParameter("usernumber");
                int f=Integer.parseInt(request.getParameter("userletter"));
                String g=request.getParameter("userpass");
                                
                try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
		
                PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
                
                //PreparedStatement ps2=con.prepareStatement("select count(*) from student");
                ps.setString(1, a);
                ps.setString(2, b);
                ps.setString(3, c);
                ps.setString(4, d);
                ps.setString(5, e);
                ps.setInt(6, f);
                ps.setString(7,g);
                int i=ps.executeUpdate();
                if(i>0)
                {
                out.println("<html>");
                out.println("<body>");
                out.println("<h1>Your information has been saved in our system</h1>");
                
                out.print("If you want to login please ");
                out.print("<a href='http://localhost:8080/studentlogin/login.html'>click here</a>");
                
                out.println("</html>");
                out.println("</body>");
                
                }
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from student");
                int count=0;
                while(rs.next())
                {
                       count++;
                }
                PreparedStatement pss=con.prepareStatement("insert into rollnumber values(?,?)");
                pss.setInt(1,count);
                pss.setString(2, a);
                pss.executeUpdate();
                
                }
                catch(ClassNotFoundException | SQLException j)
                {
                    System.out.print("Some error occured. Try registering again");
                }
    
}
}

   
    