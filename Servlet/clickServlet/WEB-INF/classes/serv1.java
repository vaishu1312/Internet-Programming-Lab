import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class serv1 extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	int c=1;
	pw.println("<form action='hello2'>");
	pw.println("<input type='hidden' name='hit_cnt' value='"+c+"'>");
	pw.println("Hit count: "+c);
	pw.println("<input type='submit' value='click here'>");
	pw.println("</form>");
}

}
