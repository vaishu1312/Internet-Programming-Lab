import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class update extends HttpServlet {

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

    out.println("<html>");
      
      out.println("<body>");
	
	 try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);    
  	//out.println("<p>connected</p>"); 

	String sql;
	sql="select * from student1"; 

	stmt=con.createStatement();   	     

	rs=stmt.executeQuery(sql);
	out.println("<p>Before updation: </p>");
out.println("<pre>ID  NAME</pre>");
	while(rs.next())
	{
		out.println("<p>"+rs.getInt(1)+" "+rs.getString(2)+"</p>");
	}

	String str=request.getParameter("u_id");
	int id=Integer.parseInt(str);
	String name=request.getParameter("u_name");

out.println("<p>got: </p>"+name);	

	PreparedStatement pstmt= con.prepareStatement("update student1 set name=? where id=?");

	pstmt.setString(1,name);
	pstmt.setInt(2,id);
	int i=pstmt.executeUpdate();


	if(i==1)
		out.println("<p>Record updated</p>");	
	else
		out.println("<p>Record not updated</p>");	

	
	rs=stmt.executeQuery(sql);
	out.println("<p>After updation: </p>");
out.println("<pre>ID  NAME</pre>");
	while(rs.next())
	{
		out.println("<p>"+rs.getInt(1)+" "+rs.getString(2)+"</p>");
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
