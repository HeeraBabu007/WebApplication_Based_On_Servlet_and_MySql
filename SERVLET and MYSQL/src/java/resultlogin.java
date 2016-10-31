import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
  
public class resultlogin extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    
    int n = Integer.parseInt(request.getParameter("userroll"));     
    String p=request.getParameter("userpass");
    
    if((loginnnnn.validate(p)) && (loginnnn.validate(n))){  
        //out.print("your record is there in our system.");
         RequestDispatcher rd=request.getRequestDispatcher("/displayresult");  
         rd.forward(request,response);  
    }  
    else if(loginnnn.validate(n))
    {
          out.print("<html><body>");
          out.println("Sorry your are entering wrong password.");//  <a href='/login.html'>Try again</a>");
            RequestDispatcher rd1=request.getRequestDispatcher("/login.html");
            rd1.include(request,response);
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