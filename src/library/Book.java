/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.Serializable;

/**
 *
 * @author Exodia
 */
public class Book implements Serializable{
    private String cim;
    private String szerzo;
    private String kiado;
    private int kiadasEve;
    private String ID;
    private String ISBN;



    public Book(){
        
    }
    
    public Book(String cim, String szerzo, String kiado, int kiadasEve, String ISBN, String ID){
        this.cim = cim;
        this.szerzo = szerzo;
        this.kiado = kiado;
        this.ISBN = ISBN;
        this.cim = cim;
        this.kiadasEve = kiadasEve;
        this.ID = ID;
    }
    public void setCim(String cim){
        this.cim = cim;
    }
    
    private String getUniqueID(){
        
        int szerzoRandom = (int) Math.random()* szerzo.length() + 1;
        //int cimRandom = (int) Math.random()*
        String id = new String();
        
        return id;
    }
    public void setSzerzo(String szerzo){
        this.szerzo = szerzo;
    }

    public void setKiado(String kiado) {
        this.kiado = kiado;
    }

    public void setKiadasEve(int kiadasEve) {
        this.kiadasEve = kiadasEve;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCim() {
        return cim;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getKiado() {
        return kiado;
    }

    public int getKiadasEve() {
        return kiadasEve;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getID() {
        return ID;
    }
    
    public String toString(){
        
        return "Szerzo: " + szerzo + " Cim: " + cim ;
    }
    
    
}
