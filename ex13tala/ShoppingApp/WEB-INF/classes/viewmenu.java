import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class viewmenu extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String url="jdbc:mysql://localhost:3306/test";
String user="root";
String pass="";
try
{
Connection con=DriverManager.getConnection(url,user,pass); 
Statement stmt;
int i=1;
pw.println("<b>FOOD ITEMS:</b>"); 
stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from products");  
pw.println("<form method =get action=displaycart>");
pw.println("<table border=1 cellpadding=2 cellspacing=1>");
pw.println("<tr><th>Product ID</th><th>Item</th><th>Description</th><th>Price</th><th>Quantity</th></tr>");
while(rs.next())  
{  
   pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td>");
   String t=Integer.toString(i);
   pw.println("<td><input type=text value=0 name="+t+"></td></tr>");
   i++;
   
}
pw.println("</table><br/><br/>");

pw.println("<input type=submit value=ViewCart>");
pw.println("</form>");

con.close(); 
} 
catch(Exception e)
{
 System.out.println(e);
}
}
}
