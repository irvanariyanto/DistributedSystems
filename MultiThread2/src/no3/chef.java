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
public class chef extends Thread{
    int selesai=0;
    int jumlahPesanan;
    Thread wait;

    public chef(int jumlahPesanan,Thread wai) {
        this.jumlahPesanan = jumlahPesanan;
        this.wait=wai;
    }
    
    @Override
    public void run() {
        try {
            for (int i = 1; i <= jumlahPesanan; i++) {
                System.out.println("pesanan ke "+i+" selesai");
            }
        } catch (Exception e) {
        }
        synchronized(wait){
            wait.notifyAll();
        }
    }
    
}
