import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class RemoveServlet extends HttpServlet

{
String c,s,name,regno;
int m1,m2,m3,m4,m5,m6,i,j;

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();

	try{
	Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "vaishu");

 
regno = req.getParameter("t8");
PreparedStatement ps1 = con.prepareStatement("DELETE FROM student WHERE reg_no=?;");
ps1.setString(1,regno);
i=ps1.executeUpdate();


PreparedStatement ps2 = con.prepareStatement("DELETE FROM marks WHERE reg_no=?;");
ps2.setString(1,regno);
j=ps2.executeUpdate();

if(j!=1) pw.println("Mark not deleted");
if(i==1 && j==1)
	pw.println("<p>Record deleted</p>");	
else
	pw.println("<p>Record not deleted</p>");

pw.println("<html>");
pw.println("<body>");

PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
ResultSet rs = ps.executeQuery();

pw.println("<h2>Student Details after deletion</h2><br>");
pw.println("<table border='5px' cellspacing='2px' cellpadding='1px'>");
pw.println("<tr><th>Roll No</th><th>Name</th></tr>");
while (rs.next())
{
 regno=rs.getString("reg_no");
 name=rs.getString("name");
 pw.println("<tr><td>"+regno+"</td><td>"+name+"</td></tr>");
}
pw.println("</table>");
pw.println("<br><br>");

PreparedStatement ps3 = con.prepareStatement("SELECT * FROM marks");
ResultSet rs1 = ps3.executeQuery();

pw.println("<h2>Marks Details after deletion</h2><br>");
pw.println("<table border='5px' cellspacing='2px' cellpadding='1px'>");
pw.println("<tr><th>Reg No</th><th>CS8601</th><th>CS8602</th><th>CS8603</th><th>CS8651</th><th>CS8691</th><th>CS8075</th></tr>");
while (rs1.next())
{
 regno=rs1.getString("reg_no");
m1=rs1.getInt(2);
m2=rs1.getInt(3);
m3=rs1.getInt(4);
m4=rs1.getInt(5);
m5=rs1.getInt(6);
m6=rs1.getInt(7);
pw.println("<tr><td>"+regno+"</td><td>"+m1+"</td><td>"+m2+"</td><td>"+m3+"</td><td>"+m4+"</td><td>"+m5+"</td><td>"+m6+"</td></tr>");
}
pw.println("</table>");
pw.println("<br><br>");

pw.println("</body>");
pw.println("</html>");

con.close();
}catch (Exception e)
{pw.println("Errorrrr!"+e.getMessage());}

}

}
