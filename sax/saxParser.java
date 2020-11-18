import org.xml.sax.*;
import javax.xml.parsers.*;
import java.util.Scanner;
import org.xml.sax.helpers.DefaultHandler;

public class saxParser
{
	public static void main(String args[])
	{
		SAXParserFactory spf=SAXParserFactory.newInstance();
		try
		{
			SAXParser sp=spf.newSAXParser();
			Scanner s=new Scanner(System.in);
			System.out.println("\nEnter the roll no: ");
			String r=s.next();
			UserHandler handler = new UserHandler(r);
		        sp.parse("input.xml", handler);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}

class UserHandler extends DefaultHandler {

	boolean fname = false;
	boolean fadd = false;
	boolean fmob = false;
	String r = null;
	String rollno=null;

	public UserHandler(String r){
		this.r=r;
	}
	
	public void startElement(String uri, String localName,String qName, 
                Attributes att) throws SAXException {

		//System.out.println("Start Element :" + qName);

		if (qName.equals("student")) {
			rollno=att.getValue("rno");
		}

  		if(r.equals(rollno))
		{	

			if (qName.equals("name")) {
			fname = true;
			}

			if (qName.equals("address")) {
			fadd = true;
			}

			if (qName.equals("mob")) {
			fmob = true;
			}
		}	

	}

	public void endElement(String uri, String localName,
		String qName) throws SAXException {

		//System.out.println("End Element :" + qName);

	}

	public void characters(char ch[], int start, int length) throws SAXException {

		if (fname) {
			System.out.println("Name : " + new String(ch, start, length));
			fname = false;
		}

		if (fadd) {
			System.out.println("Address : " + new String(ch, start, length));
			fadd = false;
		}

		if (fmob) {
			System.out.println("Mobile: " + new String(ch, start, length));
			fmob = false;
		}

		
	}

     }