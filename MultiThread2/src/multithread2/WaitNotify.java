/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread2;

/**
 *
 * @author BAY
 */
public class WaitNotify extends Thread{

    public static void main(String[] args) throws InterruptedException {
        Thread notificationThread=new WaitNotify();
        notificationThread.start();
        
        synchronized(notificationThread){
            notificationThread.wait();
        }
        System.out.println("This wait is over");
    }
    @Override
    public void run() {
        System.out.println("hit enter to stop waiting thread");
        try {
            System.in.read();
        } catch (Exception e) {
        }
        synchronized (this){
            this.notifyAll();
        }
    }
    
}
