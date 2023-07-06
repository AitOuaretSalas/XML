/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajoutxml;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import org.w3c.dom.Text;
/**
 *
 * @author acer
 */
public class AjoutXML {

    
    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        
     File docXML = new File("src/ajoutxml/bibliotheque.xml");
           DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder DocBuilder = dbfactory.newDocumentBuilder();
           Document doc = DocBuilder.newDocument();
           
           
           Element racine = doc.createElement("bibliotheque");
           doc.appendChild(racine);
           
           
           Element livre = doc.createElement("livre");
           livre.setAttribute("langue", "fr");
           livre.setAttribute("type", "illustré");
           livre.setTextContent("hello world");
           racine.appendChild(livre);
           
           
           
           
           Element livre2 = doc.createElement("livre");
           
           Attr langue = doc.createAttribute("langue");
           langue.setNodeValue("en");
           
           Attr type = doc.createAttribute("type");
           type.setNodeValue("illustré");
           
           Text text = doc.createTextNode("bounjour le monde");
           
           livre2.setAttributeNode(type);
           livre2.setAttributeNode(langue);
           livre2.appendChild(text);
           racine.appendChild(livre2);
           
           
           TransformerFactory TF = TransformerFactory.newInstance();
           Transformer T = TF.newTransformer();
           DOMSource S = new DOMSource(doc);
           StreamResult R = new StreamResult(docXML);
           
           T.transform(S, R);
           
           
           
   
    }
    
  
    
}
