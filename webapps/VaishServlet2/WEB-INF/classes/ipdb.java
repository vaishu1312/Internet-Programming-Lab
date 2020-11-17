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
     String pass="ssn";

    out.println("<html>");
      out.println("<head><title>Data, World</title></head>");
      out.println("<body>");
	out.println("<p>hellooo</p>");

	 try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);    
  	out.println("<p>connected</p>");   

	stmt=con.createStatement();   	    
 
	String sql1="update book set bid=1 where bname='abc'";
	stmt.executeUpdate(sql1);

	PreparedStatement pstmt= con.prepareStatement("insert into book values(?,?,?)");
	pstmt.setInt(1,15);
	pstmt.setString(2,"qrs");
	pstmt.setInt(3,100);	
	int i=pstmt.executeUpdate();
	if(i==1)
		out.println("<p>Record inserted</p>");	
	else
		out.println("<p>Record not inserted</p>");	

	String sql;
	sql="select * from book";
	

	rs=stmt.executeQuery(sql);
	while(rs.next())
	{
		out.println("<p>"+rs.getString(1)+" "+rs.getString(2)+"</p>");
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
