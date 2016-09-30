/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Bay
 */
public class DataStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        InputStream fileInput = new FileInputStream("D:/From.txt");
        String destination="D:/To.txt";
        OutputStream output=new FileOutputStream(destination);
        String text="";
        int data = fileInput.read();
        while (data != -1) {
            output.write(data);
            data=fileInput.read();
        }
    }

}
