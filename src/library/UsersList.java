/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

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

/**
 *
 * @author Exodia
 */
public class UsersList implements  Serializable{
    private List<User> userList;
    
    public UsersList(){
        userList = new ArrayList<User>();
    }
    
     public User keres(String ID){
         
             for(User user : userList){
            if(user.getCNP().equals(ID))
                return user;
            
        }
        return null;
    }
     public void hozzaad(User user){
        userList.add(user);
    }
     public Boolean torol(String ID){
        for(User user : userList){
            if(user.getCNP().equals(ID))
                userList.remove(user);
            return true;
        }
        return false;
    }
     public Boolean modosit(String CNP, User user){
         for(User u: userList){
             if(u.getCNP().equals(CNP) ){
                 u.setNev(user.getNev());
                 u.setElerhetoseg(user.getElerhetoseg());
                 return true;
             }
         }
         return false;
     }
     public void kiListaz(){
        for(User user : userList)
            
        System.out.println(user.toString());
     }
     public Boolean userListMentese(){
        String filename = "users.txt";
        //Konyv object = konyvek.get(0);
        
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(userList);
            
            out.close();
            file.close();
        //    return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    }
    public Boolean userListBetoltese(){
        String filename = "users.txt";
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream out2 = new ObjectInputStream(file);
            //ObjectOutputStream out = new ObjectOutputStream(file);
            List<User> ujLista = new ArrayList<User>();
            ujLista = (List<User>) out2.readObject();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            
        }
        return false;
    } 
    public int getSize(){
        return userList.size();
    }
    
   
    public void userListMentesXML(){
        try{
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            
            //root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Users");
            doc.appendChild(rootElement);
            
            for(User u : userList){
                // User elements
                Element user = doc.createElement("User");
                rootElement.appendChild(user);
                // set attribute to user element
                // shorten way
                user.setAttribute("id", u.getCNP());
                //name field
                // name element
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(u.getNev()));
                user.appendChild(name);
                //contatAddress
                // contactAddress elements
                    Element contactAddress = doc.createElement("ContactAddress");

                    Element telSzam = doc.createElement("telSzam");
                    telSzam.appendChild(doc.createTextNode(u.getElerhetoseg().getTelSzam()));

                    Element utcaNev = doc.createElement("UtcaNev");
                    utcaNev.appendChild(doc.createTextNode(u.getElerhetoseg().getUtcaNev()));

                    Element hazSzam = doc.createElement("Hazszam");
                    Integer i = new Integer(u.getElerhetoseg().getHazSzam());
                    hazSzam.appendChild(doc.createTextNode( i.toString() ));

                    Element email = doc.createElement("Email");
                    email.appendChild(doc.createTextNode(u.getElerhetoseg().getEmail()));

                    contactAddress.appendChild(telSzam);
                    contactAddress.appendChild(utcaNev);
                    contactAddress.appendChild(hazSzam);
                    contactAddress.appendChild(email);
                //contactAddress.appendChild(doc.createTextNode("addr1"));
                user.appendChild(contactAddress);

            }
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("users2.xml"));
            
            transformer.transform(source, result);
 
            System.out.println("File saved!");
            //return true;
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
}
