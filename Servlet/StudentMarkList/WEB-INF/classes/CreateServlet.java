import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class CreateServlet extends HttpServlet

{
String regno,c,s,name;
int m1,m2,m3,m4,m5,m6,i,j;

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
	res.setContentType("text/html");
	PrintWriter pw=res.getWriter();

try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "vaishu");

String table_name = req.getParameter("table_name");
 
if (table_name.equals("student"))
{    
regno = req.getParameter("t2");
name = req.getParameter("t0");

PreparedStatement ps1 = con.prepareStatement("INSERT INTO student values(?,?);");
ps1.setString(1,regno);
ps1.setString(2,name);
j=ps1.executeUpdate();
}

else if (table_name.equals("marks"))
{     
regno = req.getParameter("t2");
m1 = Integer.parseInt(req.getParameter("t3"));
m2 = Integer.parseInt(req.getParameter("t4"));
m3 = Integer.parseInt(req.getParameter("t5"));
m4 = Integer.parseInt(req.getParameter("t6"));
m5 = Integer.parseInt(req.getParameter("t7"));
m6 = Integer.parseInt(req.getParameter("t8"));

PreparedStatement ps2 = con.prepareStatement("INSERT INTO marks values(?,?,?,?,?,?,?);");
ps2.setString(1,regno);
ps2.setInt(2,m1);
ps2.setInt(3,m2);
ps2.setInt(4,m3);
ps2.setInt(5,m4);
ps2.setInt(6,m5);
ps2.setInt(7,m6);
j=ps2.executeUpdate();
}

if(j==1)
	pw.println("<p>Record inserted</p>");	
else
	pw.println("<p>Record not inserted</p>");	

pw.println("<html>");
pw.println("<body>");

if (table_name.equals("student"))
{ 
PreparedStatement ps = con.prepareStatement("SELECT * FROM student");
ResultSet rs = ps.executeQuery();

pw.println("<h2>Student Details after insertion</h2><br>");
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

pw.println("<h2>Marks Details after insertion</h2><br>");
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
}
pw.println("</body>");
pw.println("</html>");
con.close();
}catch (Exception e)
{pw.println("Error!");}

}

}
