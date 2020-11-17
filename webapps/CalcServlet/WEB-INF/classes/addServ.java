import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class addServ extends HttpServlet

{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();
	String num1=req.getParameter("x");
	String num2=req.getParameter("y");
	int x=Integer.parseInt(num1);
	int y=Integer.parseInt(num2);
	int sum=x+y;
	pw.println("<html><body>");
	pw.println("<p>Sum is:"+sum+"</p>");
	pw.println("</body></html>");
}

}
