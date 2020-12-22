import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.Scanner;

public class dom
{
	public static void main(String[] args)
	{
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse("input.xml");
			Scanner s=new Scanner(System.in);
			System.out.println("\nEnter the roll no: ");
			String r=s.next();
			//System.out.println(doc.getDocumentElement().getNodeName());
			NodeList l=doc.getElementsByTagName("student");
			for(int i=0;i<l.getLength();i++)
			{
				Node n=l.item(i);
				if(n.getNodeType()==Node.ELEMENT_NODE)
				{
					Element elt=(Element)n;
					if(elt.getAttribute("rno").equals(r))
					{
						System.out.println("Roll no : " + elt.getAttribute("rno"));
						System.out.println("Name : " + elt.getElementsByTagName("name").item(0).getTextContent());
			       			System.out.println("Address : "+ elt.getElementsByTagName("address").item(0).getTextContent());
			        		System.out.println("Mobile : "+elt.getElementsByTagName("mob").item(0).getTextContent());
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}