import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class DisplayServlet extends HttpServlet

{
String c,s,name,regno;
int s1,s2,s3,s4,s5,s6;
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();

	try{
	Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "vaishu");

pw.println("<html>");
pw.println("<body>");

PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
ResultSet rs = ps.executeQuery();

pw.println("<h2>Student Details</h2><br>");
pw.println("<table border='5px' cellspacing='2px' cellpadding='1px'>");
pw.println("<tr><th>Roll No</th><th>Name</th></tr>");
while (rs.next())
{
 regno=rs.getString("reg_no");
 name=rs.getString("name");
 pw.println("<tr><td>"+regno+"</td><td>"+name+"</td></tr>");
}
pw.println("</table>");
pw.println("<br>");

PreparedStatement ps3 = con.prepareStatement("SELECT * FROM marks");
ResultSet rs1 = ps3.executeQuery();

pw.println("<h2>Marks Details</h2><br>");
pw.println("<table border='5px' cellspacing='2px' cellpadding='1px'>");
pw.println("<tr><th>Reg No</th><th>CS8601</th><th>CS8602</th><th>CS8603</th><th>CS8651</th><th>CS8691</th><th>CS8075</th></tr>");
while (rs1.next())
{
 regno=rs1.getString("reg_no");
s1=rs1.getInt(2);
s2=rs1.getInt(3);
s3=rs1.getInt(4);
s4=rs1.getInt(5);
s5=rs1.getInt(6);
s6=rs1.getInt(7);
pw.println("<tr><td>"+regno+"</td><td>"+s1+"</td><td>"+s2+"</td><td>"+s3+"</td><td>"+s4+"</td><td>"+s5+"</td><td>"+s6+"</td></tr>");
}
pw.println("</table>");
pw.println("<br>");

PreparedStatement ps4 = con.prepareStatement("SELECT * FROM mapping");
ResultSet rs2 = ps4.executeQuery();

pw.println("<h2>Course Details</h2><br>");
pw.println("<table border='5px' cellspacing='2px' cellpadding='1px'>");
pw.println("<tr><th>Subject Code</th><th>Subject Name</th></tr>");
while (rs2.next())
{
c=rs2.getString("code");
s=rs2.getString("sub");
pw.println("<tr><td>"+c+"</td><td>"+s+"</td></tr>");
}
pw.println("</table>");


pw.println("</body>");
pw.println("</html>");
con.close();}
catch (Exception e)
{pw.println("Error!");}

}

}
