/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasxml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
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
public class EscrituraXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Para crear un xml en java primero hay que crear un objeto Document, y una vez
        //hecho lo debemos transformar a XML
        File f = new File("C:\\Users\\amezc\\OneDrive\\Escritorio\\escritura.xml");
        try {
            //creo un nuevo objeto Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.newDocument();

            //creo el elemento raiz del xml
            Element raiz = documento.createElement("album");
//            //creo los atributos del raiz (si tuviera)
//            raiz.setAttribute("version", "1");
//            raiz.setAttribute("encoding", "UTF-8");
            //lo añado al documento
            documento.appendChild(raiz);

            Element canciones = documento.createElement("canciones");
            raiz.appendChild(canciones);

            //creo los elementos hijo del elemento canciones
            Element cancion = documento.createElement("cancion");

            //creo los elementos hijo del elemento cancion
            Element title = documento.createElement("titulo");
            title.appendChild(documento.createTextNode("Hotline Blind"));
            Element duration = documento.createElement("duration");
            duration.appendChild(documento.createTextNode("100"));

            //los añado al elemento cancion
            cancion.appendChild(title);
            cancion.appendChild(duration);

            //añado la cancion al track
            canciones.appendChild(cancion);

            //una vez creado el dom definitivo lo tranformo a xml y lo guardo en un fichero
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(documento);
            //establezco la extension xml
            if (!f.getName().endsWith(".xml")) {
                f = new File(f.getAbsolutePath() + ".xml");
            }
            //finalmente creo el archivo xspf
            StreamResult result = new StreamResult(f);
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(EscrituraXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
