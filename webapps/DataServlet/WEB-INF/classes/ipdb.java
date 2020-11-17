import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ipdb extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {

      response.setContentType("text/html");

      PrintWriter out = response.getWriter();

	Connection con;
     Statement stmt;
     ResultSet rs;

    String url="jdbc:mysql://localhost:3306/library";
     String user="root";
     String pass="vaishu";

  out.println("<html>");
      out.println("<head><title>Data, World</title></head>");
      out.println("<body>");

	 try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);    
     
   
	String sql;
	sql="select * from book";

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql);
	while(rs.next())
	{
		out.println("<p>"+rs.getString(1)+"     "+rs.getInt(2)+"</p>");
	}
	}catch(ClassNotFoundException ex){
                out.println("<p>class error"+ex.getMessage()+"</p>");
            }
           catch(SQLException ex){
               out.println("<p>sql error"+ex.getMessage()+"</p>");
            }

      out.println("</body></html>");
      out.close();  
   }
}