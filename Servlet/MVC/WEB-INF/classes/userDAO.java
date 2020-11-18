package DAO;

import Bean.userBean;
import java.sql.*;

public class userDAO{

Connection con;
Statement stmt;
ResultSet rs;
String sql;
int flag=0;

	public int auth(userBean l)
	{	 
	String usr=l.get_u();
	String pwd=l.get_p();

	final String DB_URL ="jdbc:mysql://localhost/test1";
	final String USER = "root";
	final String PASS ="vaishu";

	 try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection(DB_URL,USER,PASS);        
   
			  sql="select * from users";
				stmt=con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					if(usr.equals(rs.getString(1)) && pwd.equals(rs.getString(2)) )
						flag=1; //return 1;
				}
   }catch(ClassNotFoundException ex){ }
               // out.println("<p>class error"+ex.getMessage()+"</p>");
            
   catch(SQLException ex){ }
              // out.println("<p>sql error"+ex.getMessage()+"</p>");
   return flag;     
  }
}
