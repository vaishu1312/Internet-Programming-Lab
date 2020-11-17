import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class serv2 extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
HttpSession s=req.getSession(false);
int a=(int)s.getAttribute("count");++a;
pw.println("Hit count:"+a);s.setAttribute("count",a);
pw.println("<a href='hello3'>go</a>");
}}
