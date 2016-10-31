import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class marksenter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
                response.setContentType("text/html");
		PrintWriter out = response.getWriter();
                String a=request.getParameter("roll");
                String b=request.getParameter("mark1");
                String c=request.getParameter("mark2");
                String d=request.getParameter("mark3");
                String e=request.getParameter("mark4");
                String f=request.getParameter("mark5");
                                
                try{
                    
                    Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
		PreparedStatement ps=con.prepareStatement("insert into marks values(?,?,?,?,?,?)");
                ps.setString(1, a);
                ps.setString(2, b);
                ps.setString(3, c);
                ps.setString(4, d);
                ps.setString(5, e);
                ps.setString(6, f);
         
                int i=ps.executeUpdate();
               
                if(i>0)
                {
                    out.println("<html>");
                out.println("<body>");
                out.println("<h1>marks has been entered successfully...</h1>");
                out.println("enter marks for another roll number");
                out.println("<a href='marksenter.html'>click here</a>");
                
                out.println("</html>");
                out.println("</body>");
                
                }
                }
                catch(ClassNotFoundException | SQLException j)
                {
                    System.out.print("Some error occured. Try again");
                }
    
}
}

   
    