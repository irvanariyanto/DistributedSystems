/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipscanner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 *
 * @author Bay
 */
public class IpScanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        // TODO code application logic here
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        ipAddress = ipAddress.substring(0, ipAddress.lastIndexOf('.')) + ".";
        for (int i = 0; i < 256; i++) {
            String otherAddress = ipAddress + String.valueOf(i);
            try {
                if (InetAddress.getByName(otherAddress.toString()).isReachable(100)) {
                    System.out.println(otherAddress + " is reachable");
                } else {
                    System.out.println(otherAddress + " is not reachable");
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
