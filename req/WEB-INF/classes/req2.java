import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
public class req2 extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
    String n=request.getParameter("userName");  
    out.print("Welcome "+n);  
    }  }  

