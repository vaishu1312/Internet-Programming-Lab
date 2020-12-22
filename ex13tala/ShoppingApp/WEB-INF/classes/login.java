import javax.servlet.http.*; 
import javax.servlet.*; 
import java.io.*;
public class login extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
   res.setContentType("text/html"); 
   String str=req.getParameter("uname"); 
   String str1=req.getParameter("password"); 
   PrintWriter pw=res.getWriter();
   if( (str.equals("User1") && str1.equals("Praba")) || (str.equals("User2") && str1.equals("Sharan")) )
   {
     pw.println("<html>"); 
	 pw.println("<body>"); 
	 pw.println("<b>AUTHENTICATION SUCCESSFUL!!!!!!!</b><br/>");
	 pw.println("<p>Hello,"+str+"</p>");
	 pw.println("<form action=viewmenu>");
	 pw.println("<input type=submit value=ViewMenu>");
	 pw.println("</form>");
     pw.println("</html>"); 
	 pw.println("</body>");
    	 
   }
  else
  {
    req.getRequestDispatcher("error.html").forward(req,res);
  }
 }
}
