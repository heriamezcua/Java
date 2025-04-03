package _05_advanced._03_xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class _04_Namespaces {

	public static void main(String[] args) {
		try {
			// Define an XML string with namespaces
			String xml = """
					    <configuration xmlns="http://www.horstmann.com/corejava"
					                   xmlns:si="http://www.bipm.fr/enus/3_SI/si.html">
					        <size value="210" si:unit="mm"/>
					    </configuration>
					""";

			// Convert string to InputStream
			InputStream inputStream = new ByteArrayInputStream(xml.getBytes());

			// Create a DocumentBuilderFactory and enable namespace awareness
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // Enables namespace processing

			// Create a DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(inputStream);

			// Get the root element
			Element root = document.getDocumentElement();

			// Print namespace information
			System.out.println("Root Element: " + root.getTagName());
			System.out.println("Namespace URI: " + root.getNamespaceURI());

			// Get the 'size' element
			NodeList sizeNodes = document.getElementsByTagNameNS("http://www.horstmann.com/corejava", "size");
			if (sizeNodes.getLength() > 0) {
				Element sizeElement = (Element) sizeNodes.item(0);
				System.out.println("Size Element: " + sizeElement.getTagName());
				System.out.println("Namespace URI: " + sizeElement.getNamespaceURI());

				// Get attributes
				System.out.println("Value Attribute: " + sizeElement.getAttribute("value"));
				System.out.println("Unit Attribute (Namespace URI: si): "
						+ sizeElement.getAttributeNS("http://www.bipm.fr/enus/3_SI/si.html", "unit"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
