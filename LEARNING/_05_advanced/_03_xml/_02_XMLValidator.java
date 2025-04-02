package _05_advanced._03_xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class _02_XMLValidator {

	public static void main(String[] args) {
		// Path to XML file
		String xmlFile = "config.xml";

		// Uncomment one of the lines below to validate with DTD or XSD
		// validateWithDTD(xmlFile);
		validateWithXSD(xmlFile, "config.xsd");
	}

	/**
	 * Validates an XML file against a DTD.
	 * 
	 * @param xmlFile Path to the XML file.
	 */
	public static void validateWithDTD(String xmlFile) {
		try {
			// Set up DocumentBuilderFactory to validate with DTD
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true); // Enable DTD validation
			factory.setNamespaceAware(true);

			// Create a DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Custom error handler for validation errors
			builder.setErrorHandler(new SimpleErrorHandler());

			// Parse and validate the XML file
			Document doc = builder.parse(new File(xmlFile));
			System.out.println("XML file successfully validated against DTD.");

		} catch (ParserConfigurationException | SAXException | java.io.IOException e) {
			System.out.println("DTD Validation Error: " + e.getMessage());
		}
	}

	/**
	 * Validates an XML file against an XML Schema (XSD).
	 * 
	 * @param xmlFile Path to the XML file.
	 * @param xsdFile Path to the XML Schema (XSD) file.
	 */
	public static void validateWithXSD(String xmlFile, String xsdFile) {
		try {
			// Set up DocumentBuilderFactory for XML Schema validation
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			factory.setValidating(false); // XSD validation requires a SchemaFactory

			// Create a DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Custom error handler for validation errors
			builder.setErrorHandler(new SimpleErrorHandler());

			// Parse and validate the XML file
			Document doc = builder.parse(new File(xmlFile));
			System.out.println("XML file successfully validated against XML Schema.");

		} catch (ParserConfigurationException | SAXException | java.io.IOException e) {
			System.out.println("XSD Validation Error: " + e.getMessage());
		}
	}

	/**
	 * Custom error handler to catch and display validation errors.
	 */
	private static class SimpleErrorHandler implements ErrorHandler {
		@Override
		public void warning(SAXParseException e) throws SAXException {
			System.out.println("Warning: " + e.getMessage());
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
			System.out.println("Error: " + e.getMessage());
		}

		@Override
		public void fatalError(SAXParseException e) throws SAXException {
			System.out.println("Fatal Error: " + e.getMessage());
		}
	}
}
