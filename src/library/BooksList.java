/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author Exodia
 */
public class BooksList implements  Serializable{
    
    private List<Book> konyvek; 
    
    public BooksList(){
        konyvek = new ArrayList<Book>();
    }
    public  Book keres(String ID){
        for(Book konyv : konyvek){
            if(konyv.getID().equals(ID))
                return konyv;
            
        }
        return null;
    }
    public void hozzaad(Book konyv){
        konyvek.add(konyv);
    }
    public Boolean torol(String ID){
        for(Book konyv : konyvek){
            if(konyv.getID().equals(ID))
                konyvek.remove(konyv);
            return true;
        }
        return false;
    }
    public Boolean modosit(String Id, Book konyv){
        for(Book konyvElem : konyvek){
            if(konyvElem.getID().equals(Id) ){
                konyvElem.setCim(konyv.getCim());
                konyvElem.setISBN(konyv.getISBN());
                konyvElem.setKiadasEve(konyv.getKiadasEve());
                konyvElem.setKiado(konyv.getKiado());
                konyv.setSzerzo(konyv.getSzerzo());
                return true;
            }

        }
        return false;
    }
    public void kiListaz(){
        for(Book konyv : konyvek)
            
        System.out.println(konyv.toString()+ " Kiado: " + konyv.getKiado());
    }
    public Boolean konyvListaMentese(){
        String filename = "konyvek.txt";
        //Konyv object = konyvek.get(0);
        
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(konyvek);
            
            out.close();
            file.close();
        //    return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    }
    public Boolean konyvListaBetoltes(){
        String filename = "konyvek.txt";
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream out2 = new ObjectInputStream(file);
            //ObjectOutputStream out = new ObjectOutputStream(file);
            List<Book> ujLista = new ArrayList<Book>();
            ujLista = (List<Book>) out2.readObject();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    } 
    public int getSize(){
        return konyvek.size();
    }
    public void konyvListaMentesXML(){
        try{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            //root elements
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("Books");
        doc.appendChild(rootElement);
        
        for(Book bk : konyvek){
            // Book element
       	    Element book = doc.createElement("Book");
            rootElement.appendChild(book);
            // shorten way
            book.setAttribute("id", bk.getID());
            
            Element cim = doc.createElement("Cim");
            cim.appendChild(doc.createTextNode(bk.getCim()));
           
           
            Element szerzo = doc.createElement("Szerzo");
            szerzo.appendChild(doc.createTextNode(bk.getSzerzo()));
            
            
            Element kiado = doc.createElement("Kiado");
            kiado.appendChild(doc.createTextNode(bk.getKiado()));
            
            
            Element kiadasEve = doc.createElement("KiadasEve");
            Integer i = new Integer(bk.getKiadasEve());
            kiadasEve.appendChild(doc.createTextNode(i.toString()));
            
            
            Element isbn = doc.createElement("ISBN");
            isbn.appendChild(doc.createTextNode(bk.getISBN()));
            
            
             book.appendChild(cim);
             book.appendChild(szerzo);
             book.appendChild(kiado);
             book.appendChild(kiadasEve);
             book.appendChild(isbn);
        }
        // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("books.xml"));
            
            transformer.transform(source, result);
 
            System.out.println("File saved!");
         
    }catch(Exception e){
        e.printStackTrace();
    }
        
    }
    
    public Boolean konyvListaBetoltesXML(){
        try{
             File fXmlFile = new File("books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

	
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Book");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Book id : " + eElement.getAttribute("id"));
                    System.out.println("Cime : " + eElement.getElementsByTagName("Cim").item(0).getTextContent());
                    System.out.println("Szerzo : " + eElement.getElementsByTagName("Szerzo").item(0).getTextContent());
                    System.out.println("Kiado: " + eElement.getElementsByTagName("Kiado").item(0).getTextContent());
                    System.out.println("KiadasEve : " + eElement.getElementsByTagName("KiadasEve").item(0).getTextContent());
                    System.out.println("ISBN : " + eElement.getElementsByTagName("ISBN").item(0).getTextContent());
                    return true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    
}
