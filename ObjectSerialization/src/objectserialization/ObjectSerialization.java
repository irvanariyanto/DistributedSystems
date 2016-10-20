/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;



/**
 *
 * @author BAY
 */
public class ObjectSerialization implements Serializable{

    private String firstName;
    private String lastName;
    private int age;

    public ObjectSerialization(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public void printData(){
        System.out.println("Nama\t: "+firstName+" "+lastName);
        System.out.println("Usia\t: "+age);
    }
    
    public void saveObject(ObjectSerialization Obj){
        try {
            FileOutputStream fos=new FileOutputStream("data.ser");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(Obj);
            oos.flush();
        } catch (IOException e) {
            System.out.println("a problem accured during serialize.\n"+e.getMessage());
        }
    }
    
    public void readObject(ObjectSerialization Obj){
        try {
            FileInputStream fis=new FileInputStream("data.ser");
            ObjectInputStream ois=new ObjectInputStream(fis);
            Obj=(ObjectSerialization)ois.readObject();
            Obj.printData();
            fis.close();
        } catch (IOException |ClassNotFoundException ex) {
            System.out.println("a problem accured during serialize.\n"+ex.getMessage());
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        ObjectSerialization is=new ObjectSerialization("Dee", "aja", 22);
        is.saveObject(is);
        is.readObject(is);
    }
    
}
