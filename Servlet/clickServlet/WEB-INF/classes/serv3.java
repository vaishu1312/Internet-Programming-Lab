import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class serv3 extends HttpServlet

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
}
}
