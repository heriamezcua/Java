package _05_advanced._03_xml;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.stream.*;
import java.io.*;

public class _05_StreamingParsers {

	public static void main(String[] args) throws Exception {
		// Sample XML content for testing
		String xmlContent = """
				    <root>
				        <a href='https://example.com'>Example</a>
				        <a href='https://test.com'>Test</a>
				    </root>
				""";

		// Convert string to InputStream for parsing
		InputStream xmlStream = new ByteArrayInputStream(xmlContent.getBytes());

		// Test SAX Parser
		System.out.println("SAX Parser Output:");
		parseWithSAX(xmlStream);

		// Reset InputStream for the next parser
		xmlStream = new ByteArrayInputStream(xmlContent.getBytes());

		// Test StAX Parser
		System.out.println("\nStAX Parser Output:");
		parseWithStAX(xmlStream);
	}

	public static void parseWithSAX(InputStream xmlStream) throws Exception {
		// Create SAX Parser Factory and configure it
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true); // Enable namespace awareness
		factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

		// Create SAX Parser
		SAXParser saxParser = factory.newSAXParser();

		// Define a SAX Handler
		DefaultHandler handler = new DefaultHandler() {
			@Override
			public void startElement(String uri, String localName, String qName, Attributes attributes) {
				// Check if the tag is 'a' and extract 'href' attribute
				if (qName.equalsIgnoreCase("a")) {
					String href = attributes.getValue("href");
					if (href != null) {
						System.out.println(href);
					}
				}
			}
		};

		// Parse the XML
		saxParser.parse(xmlStream, handler);
	}

	public static void parseWithStAX(InputStream xmlStream) throws Exception {
		// Create StAX Parser Factory
		XMLInputFactory factory = XMLInputFactory.newInstance();
		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);

		// Create XMLStreamReader
		XMLStreamReader parser = factory.createXMLStreamReader(xmlStream);

		// Iterate through XML events
		while (parser.hasNext()) {
			int event = parser.next();

			if (event == XMLStreamConstants.START_ELEMENT) {
				// Check if the element is 'a' and extract 'href' attribute
				if (parser.getLocalName().equals("a")) {
					String href = parser.getAttributeValue(null, "href");
					if (href != null) {
						System.out.println(href);
					}
				}
			}
		}
		parser.close();
	}
}
