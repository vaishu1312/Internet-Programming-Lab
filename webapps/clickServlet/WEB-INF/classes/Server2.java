import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class Server2 extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String n=req.getParameter("uname");
	int c=Integer.parseInt(n)+1;
	String count=Integer.toString(c);
	pw.println("<p>Hit count:"+count+"</p>");

}
}
