/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasxml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author amezc
 */
public class LecturaXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //CARGAR UN DOCUMENTO
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document documento = db.parse("C:\\Users\\amezc\\OneDrive\\Escritorio\\prueba.xml");
            
            File f = new File("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\pruebaXML.xml");
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StreamResult result = new StreamResult(f);
            DOMSource source = new DOMSource(documento);

            transformer.transform(source, result);

            NodeList listaNodos = documento.getElementsByTagName("company");
            Element juego;

            if (listaNodos.getLength() == 1) {
                juego = (Element) listaNodos.item(0);
            }
            
            
            for (int i = 0; i < listaNodos.getLength(); i++) {
                Node nodo = listaNodos.item(i);
                switch (nodo.getNodeType()) {
                    case Node.ELEMENT_NODE -> {
                        Element elemento = (Element) nodo;
                        System.out.println("Etiqueta: " + elemento.getTagName() + ", contenido: " + elemento.getTextContent());
                    }
                    case Node.TEXT_NODE -> {
                        Text texto = (Text) nodo;
                        System.out.println("Texto:" + texto.getWholeText());
                    }
                }
            }

            Element direccionTag = documento.createElement("DIRECCION_ENTREGADA");
            Text direccionTxt = documento.createTextNode("C/Perdida S/N");
            direccionTag.appendChild(direccionTxt);
            documento.getDocumentElement().appendChild(direccionTag);

        } catch (ParserConfigurationException | SAXException | IOException | TransformerConfigurationException ex) {
            Logger.getLogger(LecturaXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(LecturaXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

//System.out.println(Files.readString(fileDatos.toPath()));