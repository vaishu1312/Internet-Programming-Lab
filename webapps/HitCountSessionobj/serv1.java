import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class serv1 extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
int a=1;
HttpSession s=req.getSession(true);
s.setAttribute("count",a);
pw.println("hit count:"+a);
pw.println("<a href='hello2'>go</a>");
}}
