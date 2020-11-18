import Bean.ansbean;
import DAO.ansDAO;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
public class anscontroller extends HttpServlet {
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
{
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
  ansbean abean=new ansbean();
  ansDAO dao=new ansDAO();
  int i;
  for(i=0; i<4; i++) {
  	String ch = req.getParameter(""+i);
  	String ans = (ch.equals("a")?"a":ch.equals("b")?"b":ch.equals("c")?"c":ch.equals("d")?"d":"e");
  	abean.setAns(i, ans);
  }
  int score = dao.calcScore(abean);
  HttpSession s=req.getSession(false);
  s.setAttribute("score",score);
  req.getRequestDispatcher("score.jsp").forward(req,res);
}
}

