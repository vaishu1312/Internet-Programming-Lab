/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo1;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Iterator;
import org.joda.time.DateTime;

/**
 *
 * @author vaish
 */
public class Demo1 {

      // Find your Account Sid and Token at twilio.com/console
    // DANGER! This is insecure. See http://twil.io/secure
    public static final String ACCOUNT_SID = "ACb5867ded67b44bce62c5fc6eec69ce72";
    public static final String AUTH_TOKEN = "078830f1d23cbbd14c813c20e29562c0";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        ResourceSet<Message> messages = Message.reader()
            .setFrom(new com.twilio.type.PhoneNumber("+12565008981"))
            .setTo(new com.twilio.type.PhoneNumber("+919962188067"))
            .limit(20)
            .read();

        Iterator<Message> iterator = messages.iterator();
        System.out.println(iterator.next().getBody());
        
        
    }
}

