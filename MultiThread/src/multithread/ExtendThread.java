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
public class ExtendThread extends Thread{
    int number;
    public ExtendThread(int number) {
        this.number=number;
    }

    
    
    @Override
    public void run() {
        System.out.println("I'm thread number "+number);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(number+" is finished");
        }
        System.out.println(number+" is finished");
    }
    
    public static void main(String[] args) {
        System.out.println("Creating thread 1");
        Thread t1=new ExtendThread(1);
        
        System.out.println("Creating thread 2");
        Thread t2=new ExtendThread(2);
        
        t1.start();
        t2.start();
    }
}
