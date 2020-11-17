import java.io.*;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.TwiMLException;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;

import java.util.Iterator;

@WebServlet("/receiveSms")
public class ReceiveSmsServlet extends HttpServlet {
String ACCOUNT_SID = "ACb5867ded67b44bce62c5fc6eec69ce72";
String AUTH_TOKEN = "078830f1d23cbbd14c813c20e29562c0";

String[] fields = {"name", "dob", "gender", "phno"};  
        String thirdField,prev_msg,next_msg = null;
        int i;
        String[] tokens;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {

 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        ResourceSet<com.twilio.rest.api.v2010.account.Message> messages = com.twilio.rest.api.v2010.account.Message.reader()
            .setFrom(new com.twilio.type.PhoneNumber("+12565008981"))
            .setTo(new com.twilio.type.PhoneNumber("+919962188067"))
            .limit(20)
            .read();

        Iterator<com.twilio.rest.api.v2010.account.Message> iterator = messages.iterator();
        prev_msg=iterator.next().getBody();
        System.out.println(prev_msg);

tokens = prev_msg.split(" ",0);
        if(tokens[0].equalsIgnoreCase("Please"))  //registration msg
        {
         thirdField=tokens[2];
         for (i=0;i<fields.length;i++) 
         {
            if(fields[i].equalsIgnoreCase(thirdField))
            {
                /*store recdmsg(current msg - obtained frm reques.getParameter("Body")) 
                in the db field matching with fields[i]  */
                if(i!=fields.length-1)    //if this not the last field
                {
                    next_msg="Please enter "+fields[i+1];
    
                }
                else if(i==fields.length-1)
                    next_msg="Thanks";



   // String fromNumber = request.getParameter("From");
    //String bodyOfMsg = request.getParameter("Body");
   // String message = String.format("Helloo, %s, you said %s", fromNumber, bodyOfMsg);

    Body body = new Body(next_msg);                    
    Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();
    MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();

    response.setContentType("application/xml");
    
    PrintWriter out = response.getWriter();
    try{
	out.print(twiml.toXml());
	}catch(TwiMLException ex){
	 
	}	
    out.close();
break;
            }
                
          } //end for         
          
        }
        else if(tokens[0].equalsIgnoreCase("UPD")){
            //update needs to be done
        }
       else if(tokens[0].equalsIgnoreCase("REG")){
            next_msg="Please enter name";
            Body body = new Body(next_msg);                    
                Message sms = new Message
                    .Builder()
                    .body(body)
                    .build();
                MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();
    
                try{ System.out.println(twiml.toXml());
                }catch(TwiMLException ex)
                {}
                
        }
  }
}