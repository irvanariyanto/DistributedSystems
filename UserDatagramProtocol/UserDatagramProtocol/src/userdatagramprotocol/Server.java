/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userdatagramprotocol;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Enumeration;
import java.util.Vector;
//import static tugas3.Contoh3_5.BUFSIZE;
//import static tugas4.Client.SERVICE_PORT;
//import static tugas4.Contoh3_5.SERVICE_PORT;

/**
 *
 * @author BAY
 */
public class Server {

    public static final int SERVICE_PORT = 7;
    public static final int BUFSIZE = 4096;
    private DatagramSocket socket;

    public Server() {
        try {
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Server active on port " + socket.getLocalPort());
        } catch (Exception e) {
            System.err.println("Unable to bind port");
        }
    }

    public void serviceClients() throws IOException {
        Vector list;

        System.out.println("check data list");
        try {
            FileInputStream fin = new FileInputStream("list1.out");
            ObjectInputStream oin = new ObjectInputStream(fin);

            try {
                Object obj = oin.readObject();
                list = (Vector) obj;
            } catch (ClassCastException oce) {
                list = new Vector();
            } catch (ClassNotFoundException cnfe) {
                list = new Vector();
            }
            fin.close();
        } catch (FileNotFoundException fnfe) {
            list = new Vector();
        }

        byte[] buffer = new byte[BUFSIZE];
        for (;;) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);

                socket.receive(packet);
                System.out.println("Packet received from "
                        + packet.getAddress() + ":"
                        + packet.getPort() + " of length " + packet.getLength());

                ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(bin));
                String kata = "";
                for (;;) {
                    String line = reader2.readLine();
                    if (line == null) {
                        break;
                    } else {
                        kata = kata + line;
//                        System.out.println(kata);
                    }
                }

                if (kata.equals("2")) {
                    String pil = "";
                    String size = String.valueOf(list.size());
                    packet.setData(size.getBytes());
                    socket.send(packet);
                    DatagramPacket packet2 = new DatagramPacket(buffer, BUFSIZE);
                    socket.receive(packet2);

                    for (Enumeration enu = list.elements(); enu.hasMoreElements();) {

                        packet.setData(enu.nextElement().toString().getBytes());
                        socket.send(packet);
                    }

                } else if (kata.equals("3")) {
                    socket.send(packet);
                } else {
                    list.addElement(kata);
                    FileOutputStream fout = new FileOutputStream("list1.out");
                    ObjectOutputStream oout = new ObjectOutputStream(fout);
                    oout.writeObject(list);
                    System.out.println(list);

                    socket.send(packet);
                }
            } catch (Exception e) {
                System.err.println("Error " + e);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Server server = new Server();
        server.serviceClients();
    }
}
