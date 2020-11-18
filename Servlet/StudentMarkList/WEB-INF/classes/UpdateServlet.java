import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class UpdateServlet extends HttpServlet

{
String c,s,name,regno;
int s1,s2,s3,s4,s5,s6,i,j;

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();

	try{
	Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "vaishu");

String table_name = req.getParameter("tbl_name");
 
if (table_name.equals("student"))
{ 
regno = req.getParameter("t9");
name = req.getParameter("t10");

PreparedStatement ps1 = con.prepareStatement("UPDATE student SET name=? WHERE reg_no=?;");
ps1.setString(1,name);
ps1.setString(2,regno);
j=ps1.executeUpdate();
}

else if (table_name.equals("marks"))
{     
regno = req.getParameter("t9");
s1 = Integer.parseInt(req.getParameter("t11"));
s2 = Integer.parseInt(req.getParameter("t12"));
s3 = Integer.parseInt(req.getParameter("t13"));
s4 = Integer.parseInt(req.getParameter("t14"));
s5 = Integer.parseInt(req.getParameter("t15"));
s6 = Integer.parseInt(req.getParameter("t16"));

PreparedStatement ps2 = con.prepareStatement("UPDATE marks SET sub1=?,sub2=?,sub3=?,sub4=?,sub5=?,sub6=? WHERE reg_no=?;");

ps2.setInt(1,s1);
ps2.setInt(2,s2);
ps2.setInt(3,s3);
ps2.setInt(4,s4);
ps2.setInt(5,s5);
ps2.setInt(6,s6);
ps2.setString(7,regno);

j=ps2.executeUpdate();
}
if(j==1)
	pw.println("<p>Record updated</p>");	
else
	pw.println("<p>Record not updated</p>");	

pw.println("<html>");
pw.println("<body>");

if (table_name.equals("student"))
{ 
PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
ResultSet rs = ps.executeQuery();

pw.println("<h2>Student Details after updation</h2><br>");
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
}

else{
PreparedStatement ps3 = con.prepareStatement("SELECT * FROM marks");
ResultSet rs1 = ps3.executeQuery();

pw.println("<h2>Marks Details after updation</h2><br>");
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
pw.println("<br><br>");
}
pw.println("</body>");
pw.println("</html>");
con.close();}
catch (Exception e)
{pw.println("Error updating!"+e);}

}

}
