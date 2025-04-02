package _05_advanced._03_xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.SAXException;

public class _01_XMLParser {

	public static void main(String[] args) {
		try {
			// Step 1: Create a sample XML file
			String xmlFileName = "sample.xml";
			createSampleXML(xmlFileName);

			// Step 2: Create a DocumentBuilderFactory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Step 3: Parse the XML document
			Document document = builder.parse(new File(xmlFileName));

			// Step 4: Normalize the document (removes empty text nodes)
			document.getDocumentElement().normalize();

			// Step 5: Get the root element
			Element root = document.getDocumentElement();
			System.out.println("Root Element: " + root.getTagName());

			// Step 6: Process child nodes
			NodeList nodeList = root.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				// Ignore whitespace nodes
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("Element: " + element.getTagName());

					// Step 7: Retrieve attributes
					if (element.hasAttributes()) {
						NamedNodeMap attributes = element.getAttributes();
						for (int j = 0; j < attributes.getLength(); j++) {
							Node attribute = attributes.item(j);
							System.out.println(
									"  Attribute: " + attribute.getNodeName() + " = " + attribute.getNodeValue());
						}
					}

					// Step 8: Retrieve text content
					String textContent = element.getTextContent().trim();
					if (!textContent.isEmpty()) {
						System.out.println("  Text Content: " + textContent);
					}
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a sample XML file for testing if it doesn't exist.
	 */
	private static void createSampleXML(String fileName) throws IOException {
		File file = new File(fileName);
		if (!file.exists()) {
			String xmlContent = """
					<?xml version="1.0" encoding="UTF-8"?>
					<store>
					    <product id="101" category="electronics">
					        <name>Smartphone</name>
					        <price currency="USD">699.99</price>
					    </product>
					    <product id="102" category="appliances">
					        <name>Microwave</name>
					        <price currency="USD">89.99</price>
					    </product>
					</store>
					""";

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				writer.write(xmlContent);
			}
		}
	}
}
