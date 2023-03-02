package com.cx.lunshuti.no2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author 陈翔
 */
public class SendTask implements Runnable {
    private int sendPort;
    public SendTask(int sendPort) { this.sendPort = sendPort; }
    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            while (true) {
                String data = sc.nextLine();
                DatagramPacket dp = new DatagramPacket(data.getBytes(),0,data.length(), InetAddress.getLocalHost(),sendPort);
                ds.send(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}