import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class displaycart extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String url="jdbc:mysql://localhost:3306/ip";
String user="root";
String pass="vaishu";
try
{
Connection con=DriverManager.getConnection(url,user,pass); 
Statement stmt;
String qt;
int i=1,j=0,qty,price=0;
double nprice=0,taxes;
pw.println("<b>ITEMS IN YOUR CART:</b>"); 
stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from products");  


Cookie ck;

pw.println("<table border=1 cellpadding=2 cellspacing=1>");
pw.println("<tr><th>Product ID</th><th>Item</th><th>Description</th><th>Price</th><th>Quantity</th></tr>");

while(rs.next())
{
  qt=req.getParameter(Integer.toString(i));
  qty=Integer.parseInt(qt);
  ck=new Cookie(Integer.toString(i),qt);
  res.addCookie(ck);
  j++;
  if(qty!=0)
   pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td><td>"+qt+"</td></tr>");
  price+=rs.getInt(4)*qty;
  i++;
}
pw.println("</table><br/><br/>");

pw.println("<form action=editcart>");
pw.println("<input type=submit value=EditCart>");
pw.println("</form><br/><br/>");



taxes=0.1*price;
nprice=price+taxes;
 

Cookie c1= new Cookie("Price",Integer.toString(price));
Cookie c2= new Cookie("Taxes",Double.toString(taxes));
Cookie c3= new Cookie("Totalprice",Double.toString(nprice)); 
res.addCookie(c1);
res.addCookie(c2);
res.addCookie(c3);



pw.println("<form action=displaybill>");
pw.println("<input type=submit value=viewbill>");
pw.println("</form>");

con.close();

}  
catch(Exception e)
{
 System.out.println(e);
}
}
}
