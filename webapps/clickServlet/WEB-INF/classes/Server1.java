import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class Server1 extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	pw.println("<form action=\"welcome2\">");
	String count="1";
	pw.println("<p>Hit count:"+count+"</p>");
	pw.println("<input type=\"hidden\" name=\"uname\" value=\"1\">");
	pw.println("<input type=\"submit\" value=\"click\">");


}

}
