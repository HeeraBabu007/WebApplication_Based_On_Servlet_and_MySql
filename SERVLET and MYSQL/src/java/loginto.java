import java.io.IOException;  
import java.io.PrintWriter;  
import static java.lang.Integer.parseInt;
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class loginto extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userfname"); 
    //int p = Integer.parseInt(request.getParameter("userroll"));     
    
    String p=request.getParameter("userpass");
    if(loginn.validate(n,p)){  
        out.print("your record is there in our system.");
        RequestDispatcher rdd=request.getRequestDispatcher("/web");  
        rdd.forward(request,response);  
         out.print("<a href='/web'>click here</a>");
    }  
    else if(loginnn.validate(n))
    {
          out.print("<html><body>");
          out.println("Sorry your are entering wrong password.");//  <a href='/login.html'>Try again</a>");
            RequestDispatcher rdd1=request.getRequestDispatcher("/login.html");
            rdd1.include(request,response);
    }
    else{ 
        out.print("<html><body>");
        //out.print("<h3>You have to register first and then Sign in</h3>");
        out.print("</body></html>");
        out.print("<a href='/index.html'><h3>You have to register first and then Sign in</h3></a>");
        //RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
        //rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  