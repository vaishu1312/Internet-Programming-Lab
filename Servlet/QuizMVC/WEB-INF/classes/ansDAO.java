package DAO;
import Bean.ansbean;
import java.sql.*;
import java.io.*;
import Bean.questionbean;
public class ansDAO
{
public int calcScore(ansbean b)
{
String db_url="jdbc:mysql://localhost:3306/exam";
String user="root";
String pass="vaishu";
int score=0;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection(db_url,user,pass);
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select ans from questions");
int i=0;
while(rs.next())
{
	if(b.getAns(i).equals(rs.getString(1))) {
		score += 20;
	} 
	i++;
}
return score;
}
catch(Exception e)
{
System.out.println("Exception"+e);
}
return score;
}
}
