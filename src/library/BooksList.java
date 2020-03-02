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
        
}
