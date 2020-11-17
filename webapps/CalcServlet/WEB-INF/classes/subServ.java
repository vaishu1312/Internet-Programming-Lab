import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class subServ extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String num1=req.getParameter("a");
	String num2=req.getParameter("b");
	int a=Integer.parseInt(num1);
	int b=Integer.parseInt(num2);
	int diff=a-b;
	pw.println("<html><body>");
	pw.println("<p>Diff is:"+diff+"</p>");
	pw.println("</body></html>");
}

}
