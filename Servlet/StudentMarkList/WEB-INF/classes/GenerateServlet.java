import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class GenerateServlet extends HttpServlet
{

int i=0;
int marks[];
String regno,c,s;
ResultSet rs1,rs2;
Connection con ;

public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "vaishu");

PreparedStatement ps1 = con.prepareStatement("SELECT * FROM student WHERE reg_no=?");
regno = req.getParameter("t1");
ps1.setString(1,regno);
rs1 = ps1.executeQuery();

pw.println("<html>");
pw.println("<body>");
pw.println("<h2>MarkList</h2><br>");

rs1.next();
pw.print("<h3>Roll number: "+rs1.getString(1)+"</h3>"+"  ");
pw.println("<h3>Name: "+rs1.getString(2)+"</h3><br><br>");

PreparedStatement ps2 = con.prepareStatement("SELECT * FROM marks WHERE reg_no=?");
ps2.setString(1,regno);
rs2 = ps2.executeQuery();
rs2.next();

marks = new int[6];

marks[0] = rs2.getInt(2);
marks[1] = rs2.getInt(3);
marks[2] = rs2.getInt(4);
marks[3] = rs2.getInt(5);
marks[4] = rs2.getInt(6);
marks[5] = rs2.getInt(7);

PreparedStatement ps3 = con.prepareStatement("SELECT * FROM mapping");
ResultSet rs3 = ps3.executeQuery();

pw.println("<table border='5px' cellspacing='2px' cellpadding='1px'>");
pw.println("<tr><th>Subject Code</th><th>Subject Name</th><th>Marks</th></tr>");

while (rs3.next())
{

//pw.println("marsddk"+marks[0]);

c=rs3.getString("code");
s=rs3.getString("sub");
pw.println("<tr><td>"+c+"</td><td>"+s+"</td><td>"+marks[i]+"</td></tr>");
i++;
}

pw.println("</table>");
pw.println("</body>");
pw.println("</html>");
con.close();
}
catch (Exception e) {pw.println("Erroreee!"+e);}

}

}
