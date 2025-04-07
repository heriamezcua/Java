package _05_advanced._03_xml;

import java.io.FileOutputStream;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

public class _06_XMLCreation {

	public static void main(String[] args) {
		try {
			// Step 1: Create a DOM Document
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); // Enable namespace support
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			// Step 2: Create Root Element with Namespace
			String namespace = "http://www.w3.org/2000/svg";
			Element rootElement = doc.createElementNS(namespace, "svg");
			rootElement.setAttribute("width", "300");
			rootElement.setAttribute("height", "150");
			doc.appendChild(rootElement);

			// Step 3: Add a Child Element (Rectangle)
			Element rect = doc.createElementNS(namespace, "rect");
			rect.setAttribute("x", "231");
			rect.setAttribute("y", "61");
			rect.setAttribute("width", "9");
			rect.setAttribute("height", "12");
			rect.setAttribute("fill", "#6e4a13");
			rootElement.appendChild(rect);

			// Step 4: Write XML using Transformer (XSLT)
			writeXMLWithTransformer(doc, "output_transformer.xml");

			// Step 5: Write XML using LSSerializer
			writeXMLWithLSSerializer(doc, "output_lsserializer.xml");

			// Step 6: Write XML using StAX
			writeXMLWithStAX("output_stax.xml");

			System.out.println("XML files generated successfully!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes XML using Transformer API (XSLT)
	 */
	private static void writeXMLWithTransformer(Document doc, String filePath) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		// Enable pretty-printing
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");

		// Write to file
		StreamResult result = new StreamResult(new FileOutputStream(filePath));
		transformer.transform(new DOMSource(doc), result);
	}

	/**
	 * Writes XML using LSSerializer (DOM Level 3)
	 */
	private static void writeXMLWithLSSerializer(Document doc, String filePath) throws Exception {
		DOMImplementation impl = doc.getImplementation();
		DOMImplementationLS implLS = (DOMImplementationLS) impl.getFeature("LS", "3.0");

		LSSerializer serializer = implLS.createLSSerializer();
		serializer.getDomConfig().setParameter("format-pretty-print", true);

		String xmlString = serializer.writeToString(doc);

		// Write to file
		try (FileWriter writer = new FileWriter(filePath)) {
			writer.write(xmlString);
		}
	}

	/**
	 * Writes XML using StAX (Streaming API for XML)
	 */
	private static void writeXMLWithStAX(String filePath) throws Exception {
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(filePath), "UTF-8");

		writer.writeStartDocument();
		writer.writeStartElement("svg");

		writer.writeAttribute("xmlns", "http://www.w3.org/2000/svg");
		writer.writeAttribute("width", "300");
		writer.writeAttribute("height", "150");

		writer.writeStartElement("rect");
		writer.writeAttribute("x", "231");
		writer.writeAttribute("y", "61");
		writer.writeAttribute("width", "9");
		writer.writeAttribute("height", "12");
		writer.writeAttribute("fill", "#6e4a13");
		writer.writeEndElement(); // End <rect>

		writer.writeEndElement(); // End <svg>
		writer.writeEndDocument();

		writer.flush();
		writer.close();
	}
}
