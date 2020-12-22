import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class displaybill extends HttpServlet {
 
   public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
     Cookie cookie = null;
      Cookie[] cookies = null;

      cookies = req.getCookies();

      PrintWriter pw=res.getWriter(); 
     pw.println("<b>TOTAL AMOUNT TO BE PAID:</b>");	  
     pw.println("<br/><br/>");
     for (int i = 0; i < cookies.length; i++) {
            cookie = cookies[i];
            if(cookie.getName().equals("Price"))
            {    pw.println("<b>Price:</b>" + cookie.getValue( ));
			    pw.println("<br/><br/>");}
			else if(cookie.getName().equals("Taxes"))
            {    pw.println("<b>Taxes:</b>" + cookie.getValue( ));
			     pw.println("<br/><br/>");}
			else if(cookie.getName().equals("Totalprice"))
            {    pw.println("<b>Total Price:</b>" + cookie.getValue( ));
	             pw.println("<br/><br/>");}
			   
        
     
   }
   pw.println("<br/><br/>");
   pw.println("<b>THANK YOU FOR SHOPPING!!!!!</b>");	
}
}
