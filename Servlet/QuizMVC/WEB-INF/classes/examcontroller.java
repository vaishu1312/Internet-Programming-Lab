import Bean.questionbean;
import DAO.questionDAO;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class examcontroller extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
  //questionbean qbean=new questionbean();
  questionDAO dao=new questionDAO();
  questionbean qbean=dao.calldao();
  HttpSession s=req.getSession(true);
  s.setAttribute("qbean",qbean);
  req.getRequestDispatcher("exam.jsp").forward(req,res);
  
}
}
