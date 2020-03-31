/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Exodia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
       /*
        // TODO code application logic here
        String cim = "Mikszath Kalman";
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println((int)Math.random()*50 );
        Book konyv1 = new Book("Egri csillagok", "Gardonyi Geza", "Budapest-kiado", 1970, "123456", "1");
        Book konyv2 = new Book("Ember tragediaja", "Madach Imre", "kolozsvar", 2010, "321654", "2");
        
        BooksList konyvLista = new BooksList();
        konyvLista.hozzaad(konyv2);
        konyvLista.hozzaad(konyv1);
        konyvLista.kiListaz();
        System.out.println("\n\n");
        Book konyv3 = konyv2;
        konyv3.setKiado("Kolozsvar");
        konyvLista.modosit("2", konyv3);
        konyvLista.kiListaz();
        System.out.println("\n\n");
        konyvLista.torol(konyv3.getID());
        konyvLista.kiListaz();
        
        Book bk3 = new Book("KonyvCim", "KonyvSzerzo", "KonyvKiado", 2020, "3692581477", "3");
        konyvLista.hozzaad(bk3);
        
        
        //System.out.println(konyvLista.keres(konyv2.getID()));
        //konyvLista.konyvListaMentese();
        //System.out.println(konyvLista.userListBetoltese()) ;
        System.out.println(konyvLista.getSize());
        //konyvLista.konyvListaMentesXML();
        konyvLista.konyvListaBetoltesXML();
        
        User user1 = new User("Jozsef", new ContactAddress("1@email.com", "123456", "Maros utca 2"), "123456789");
        User user2 = new User("Anita", new ContactAddress("2@email.com", "987654", "Maros utca 4"),"231456789" );
        User user3 = user2;
        user3.setNev("Dani");
        
        UsersList felhasznaloLista = new UsersList();
        felhasznaloLista.hozzaad(user1);
        felhasznaloLista.hozzaad(user2);
        felhasznaloLista.kiListaz();
        System.out.println(felhasznaloLista.keres("123456789").toString());;
        felhasznaloLista.modosit(user3.getCNP(), user3);
        //System.out.println("List mentese:" + felhasznaloLista.userListMentese());
       // System.out.println("Lista betoltese:" + felhasznaloLista.userListBetoltese());
        
        System.out.println("SIZE:" + felhasznaloLista.getSize());
        //felhasznaloLista.userListMentesXML();
        felhasznaloLista.userListBetoltesXML();
     */
      List<Book> enlista = new ArrayList<Book>();
      BooksList b = new BooksList();
      enlista = b.konyvListaBetoltesTXT();
        System.out.println(enlista.toString());
     }
}
