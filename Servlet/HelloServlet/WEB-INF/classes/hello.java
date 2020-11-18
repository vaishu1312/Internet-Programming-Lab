import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class hello extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
 

      out.println("<html>");
      out.println("<head><title>Hello World</title></head>");
      out.println("<body>");
      out.println("<h1>Welcome</h1>");  
      out.println("</body></html>");
      out.close();  
   }
}