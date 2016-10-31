

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

public class teacher extends HttpServlet 
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                String a=request.getParameter("teachfname");
                String b=request.getParameter("teachlname");
                String c=request.getParameter("teachdob");
                String d=request.getParameter("teachid");
                String e=request.getParameter("teachnumber");
                int f=Integer.parseInt(request.getParameter("teachletter"));
                String g=request.getParameter("teachpass");
                                
                try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
		PreparedStatement ps=con.prepareStatement("insert into teacher values(?,?,?,?,?,?,?)");
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
                out.println("<h1>Congrats! Your information has been saved in our system</h1>");
                out.print("If you want to login please ");
                out.print("<a href='/teacherlogin.html'>click here</a>");
                
                out.println("</html>");
                out.println("</body>");
                
                }
                }
                catch(ClassNotFoundException | SQLException j)
                {
                    System.out.print("Some error occured. Try registering again");
                }
    
}
}

   
    