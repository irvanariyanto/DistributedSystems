/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

/**
 *
 * @author BAY
 */
public class RunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("I'm instance runnable class");
    }
    public static void main(String[] args) {
        System.out.println("Creating runnable object");
        
        Runnable run= new RunnableThread();
        
        System.out.println("creating first thred");
        Thread t1=new Thread(run);
        
        System.out.println("creating first thred");
        Thread t2=new Thread(run);
        
        System.out.println("run boot thread");
        t1.start();
        t2.start();
    }
}
