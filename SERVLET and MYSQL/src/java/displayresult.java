import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class displayresult extends HttpServlet {  
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/swati","root","root");
    
        String g=request.getParameter("userroll");
        PreparedStatement ps2=con.prepareStatement("select name from rollnumber where Roll_no=?");
        ps2.setString(1,g);
        ResultSet r=ps2.executeQuery();
        while(r.next())
        {
            String x=r.getString("name");  
            out.println("<html><body>");
            out.println("<font size='5' color='blue'> WELCOME TO RESULT PORTAL "+x+" </font><br>");
        }
        
        
        PreparedStatement ps=con.prepareStatement("select sub1,sub2,sub3,sub4,sub5 from marks where Roll_no=?");
        ps.setString(1,g);
        
        ResultSet rs=ps.executeQuery();
        int per=0;
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        
        while(rs.next())
        {
           
            a=rs.getInt("sub1");
            b=rs.getInt("sub2");
            c=rs.getInt("sub3");
            d=rs.getInt("sub4");
            e=rs.getInt("sub5");

            out.println("<html>");
            out.println("<body>");
            out.println("<B><h3>Your result is :</h3><B> <br>");
            out.println("<table border='2'>");
            out.println("<tr><td><B>ENGLISH=</B>"+a+"</td></tr>");
            out.println("<tr><td><b>MATHEMATICS=</b>"+b+"</td></tr>");
            out.println("<tr><td><B>PHYSICS=</B>"+c+"</td></tr>");
            out.println("<tr><td><B>CHEMISTRY=</B>"+d+"</td></tr>");
            out.println("<tr><td><B>COMPUTER SCIENCE=</B>"+e+"</td></tr>");
            out.println("</table></body></html>");
            
        }
        
        per=(a+b+c+d+e)/5;
        if(per>0)
        {
        PreparedStatement pss=con.prepareStatement("insert into percentage values(?,?)");
            pss.setString(1,g);
            pss.setInt(2,per);
            pss.executeUpdate();
           
        PreparedStatement ps3=con.prepareStatement("select perc from percentage where rollno=?");
        ps3.setString(1,g);
        ResultSet r1=ps3.executeQuery();
        int perc;
        while(r1.next())
        {
            perc=r1.getInt("perc");
            out.println("<html><body>");
            out.println("your percentage is:" +perc);
            if(perc>50)
            {out.println("\nStaus:PASSED");}
            else{out.println("\nStatus: FAILED");}
            
            out.print("</body></html>");
        }
        }    
    }
    catch(Exception exc)
    {
        exc.printStackTrace();
    }  
  
}  
}