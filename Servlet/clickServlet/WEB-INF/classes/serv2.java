import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class serv2 extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String str=req.getParameter("hit_cnt");
	int c=Integer.parseInt(str);
	c++;
	pw.println("Hit count: "+c);
	pw.println("<form action='hello3'>");
	pw.println("<input type='hidden' name='hit_cnt' value='"+c+"'>");
	pw.println("<input type='submit' value='click here'>");
	pw.println("</form>");
}
}
