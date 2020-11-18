import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class select extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();

	Connection con;
     Statement stmt;
     ResultSet rs;

    String url="jdbc:mysql://localhost:3306/test1";
     String user="root";
     String pass="vaishu";

	 try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);    
            //System.out.println("Connected");      	    
     out.println("<html>");
        out.println("<body>");
	
	String sql;
	sql="select * from student1";

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	out.println("<pre>ID  NAME</pre>");
	while(rs.next())
	{
		out.println("<p>"+rs.getInt(1)+" "+rs.getString(2)+"</p>");
	}
	}catch(ClassNotFoundException ex){
                //System.out.println("sql error"+ex.getMessage());
            }
           catch(SQLException ex){
               // System.out.println("sql error"+ex.getMessage());
            }

      out.println("</body></html>");
      out.close(); 
   }
}
