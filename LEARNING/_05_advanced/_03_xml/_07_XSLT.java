package _05_advanced._03_xml;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class _07_XSLT {

	public static void main(String[] args) {
		try {
			// Define the XML source file
			File xmlFile = new File("data.xml");

			// Define the XSLT stylesheet file
			File xsltFile = new File("style.xsl");

			// Define the output file (HTML result)
			File outputFile = new File("output.html");

			// Create a TransformerFactory instance
			TransformerFactory factory = TransformerFactory.newInstance();

			// Create a Transformer with the given XSLT file
			Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

			// Perform the transformation from XML to HTML
			transformer.transform(new StreamSource(xmlFile), new StreamResult(outputFile));

			System.out.println("Transformation completed. Output saved to output.html");

		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
