package _05_advanced._03_xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

public class _03_XPath {

	public static void main(String[] args) {
		try {
			// Load XML file
			File inputFile = new File("sample.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);
			doc.getDocumentElement().normalize();

			// Create an XPath object
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();

			// 1. Retrieve text content: Get database username
			String username = xPath.evaluate("/configuration/database/username", doc);
			System.out.println("Database Username: " + username);

			// 2. Retrieve a set of nodes: Get all <row> elements under <gridbag>
			NodeList rows = (NodeList) xPath.evaluate("/gridbag/row", doc, XPathConstants.NODESET);
			System.out.println("Number of <row> elements: " + rows.getLength());

			// 3. Retrieve a single node: Get the first <row>
			Node firstRow = (Node) xPath.evaluate("/gridbag/row[1]", doc, XPathConstants.NODE);
			if (firstRow != null) {
				System.out.println("First <row> found: " + firstRow.getNodeName());
			}

			// 4. Retrieve an attribute: Get the 'anchor' attribute of the first cell in the
			// first row
			String anchorValue = xPath.evaluate("/gridbag/row[1]/cell[1]/@anchor", doc);
			System.out.println("Anchor attribute of first cell: " + anchorValue);

			// 5. Retrieve all 'anchor' attributes within <cell> elements under <row>
			NodeList anchorNodes = (NodeList) xPath.evaluate("/gridbag/row/cell/@anchor", doc, XPathConstants.NODESET);
			System.out.println("Number of 'anchor' attributes: " + anchorNodes.getLength());

			// 6. Count elements: Get the number of <row> elements
			int rowCount = ((Number) xPath.evaluate("count(/gridbag/row)", doc, XPathConstants.NUMBER)).intValue();
			System.out.println("Total <row> elements: " + rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
