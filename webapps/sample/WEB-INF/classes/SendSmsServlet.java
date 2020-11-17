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

@WebServlet("/sendSms")
public class SendSmsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {

    String fromNumber = request.getParameter("From");
    String bodyOfMsg = request.getParameter("Body");
    String message = String.format("Hello, %s, you said %s", fromNumber, bodyOfMsg);

    Body body = new Body(message);                    
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
  }
}

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

// [START gae_flex_twilio_send_sms]
@SuppressWarnings("serial")
@WebServlet(name = "sendsms", value = "/sms/send")
public class SendSmsServlet extends HttpServlet {

  @Override
  public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException,
      ServletException {
    final String twilioAccountSid = System.getenv("TWILIO_ACCOUNT_SID");
    final String twilioAuthToken = System.getenv("TWILIO_AUTH_TOKEN");
    final String twilioNumber = System.getenv("TWILIO_NUMBER");
    final String toNumber = (String) req.getParameter("to");
    if (toNumber == null) {
      resp.getWriter()
          .print("Please provide the number to message in the \"to\" query string parameter.");
      return;
    }
    TwilioRestClient client = new TwilioRestClient(twilioAccountSid, twilioAuthToken);
    Account account = client.getAccount();
    MessageFactory messageFactory = account.getMessageFactory();
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("To", toNumber));
    params.add(new BasicNameValuePair("From", twilioNumber));
    params.add(new BasicNameValuePair("Body", "Hello from Twilio!"));
    try {
      Message sms = messageFactory.create(params);
      resp.getWriter().print(sms.getBody());
    } catch (TwilioRestException e) {
      throw new ServletException("Twilio error", e);
    }
  }
}