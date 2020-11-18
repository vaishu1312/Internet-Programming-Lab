import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class serv1 extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
int a;
HttpSession s=req.getSession(true);
if(s.isNew())
{
	a=1;
	s.setAttribute("count",a);
}	
else
{
	a=(int)s.getAttribute("count");
	a++;
	s.setAttribute("count",a);
}
pw.println("Hit count:"+a);
pw.println("<br>");
pw.println("<a href='hello2'>GO</a>");
}}
