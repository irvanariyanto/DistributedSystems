/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no3;

/**
 *
 * @author BAY
 */
public class kitchen {
    public static void main(String[] args) {
        Thread w=new waiters();
        Thread c=new chef(10, w);
        
        c.start();
        w.start();
    }
}
