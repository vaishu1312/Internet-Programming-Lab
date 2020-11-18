import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import Bean.userBean;
import DAO.userDAO;


public class loginController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
	String u_str=request.getParameter("t1");
	String p_str=request.getParameter("t2");

//prepare the bean
	userBean usr = new userBean();
	usr.set_u(u_str);
	usr.set_p(p_str);

//call auth in userDAO

userDAO dao=new userDAO();
int i=dao.auth(usr);

if(i==1)
	request.getRequestDispatcher("success.jsp").forward(request,response);
else if(i==0)
	request.getRequestDispatcher("error.jsp").forward(request,response);
//out.println("i val: "+i);
}
}

