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
public class Counter {
    private int countValue;

    public Counter() {
        countValue=0;
    }
    
    public Counter(int start){
        countValue=start;
    }
    
    public synchronized void increaceCount(){
        int count = countValue;
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
        }
        count = count + 1;
        countValue = count;
        System.out.println(countValue);
    }
    
    public synchronized int getCount(){
        return countValue;
    }
}
