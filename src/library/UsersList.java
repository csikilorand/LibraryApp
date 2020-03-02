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
    
}
