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
public class CountingThread implements Runnable{
    Counter myCounter;
    int countAmount;

    public CountingThread(Counter myCounter, int countAmount) {
        this.myCounter = myCounter;
        this.countAmount = countAmount;
    }

    @Override
    public void run() {
        for (int i = 1; i <= countAmount; i++) {
            myCounter.increaceCount();
//            System.out.println(""+myCounter.getCount());
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Counter c=new Counter();
        
        Runnable run=new CountingThread(c, 10);
        System.out.println("Starting counting threads");
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        
        t1.start();t2.start();t3.start();
        t1.join();t2.join();t3.join();
        System.out.println("Counter value is "+c.getCount());
    }
}
