package com.cx.lunshuti.no2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 陈翔
 */
public class ReceiveTask implements Runnable {
    private int receivePort;
    public ReceiveTask(int receivePort) { this.receivePort = receivePort; }
    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(receivePort);
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            while (true) {
                ds.receive(dp);
                System.out.println(new String(buf));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}