/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasxml;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
public class Otra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document documento = db.parse("C:\\Users\\amezc\\OneDrive\\Escritorio\\xspf.xml");

            NodeList listaNodos = documento.getElementsByTagName("track");

            for (int i = 0; i < 1; i++) {
                Element track = (Element) listaNodos.item(i);

                String titulo = track.getElementsByTagName("title").item(i).getTextContent();
                String location = track.getElementsByTagName("location").item(i).getTextContent();
                String duracion = track.getElementsByTagName("duration").item(i).getTextContent();

            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Otra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
