/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BAY
 */
public class waiters extends Thread{

    @Override
    public void run() {
        
        synchronized(this){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(waiters.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Pelayan mengantarkan pesanan");
        }
    }
    
}
