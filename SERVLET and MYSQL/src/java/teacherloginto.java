import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class teacherloginto extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("teachfname"); 
    //int p = Integer.parseInt(request.getParameter("userroll"));     
    
    String p=request.getParameter("teachpass");
    if(teachloginn.validate(n,p)){  
        out.print("your record is there in our system.");
         RequestDispatcher rd=request.getRequestDispatcher("/teachweb");  
        rd.forward(request,response);  
    }  
    else if(teacherloginnn.validate(n))
    {
        out.println("Sorry your are entering wrong password.");//<a href='/teacherlogin.html'>Try again</a>");
        RequestDispatcher rd1=request.getRequestDispatcher("/teacherlogin.html");
        rd1.include(request,response);
    }
    else{ 
        out.print("<html><body>");
        //out.print("<h3>You have to register first and then Sign in</h3>");
        out.print("</body></html>");
        //out.print("<a href='/teacherregister.html><h3>You have to register first and then Sign in</h3></a>");
        RequestDispatcher rd=request.getRequestDispatcher("/teacherregister.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  