package com.cx.lunshuti.no2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 陈翔
 */
public class ReceiveTask implements Runnable {
    // 接收数据的端口号
    private int receivePort;

    public ReceiveTask(int receivePort) {
        this.receivePort = receivePort;
    }

    @Override
    public void run() {
        try {
            // 1.DatagramSocket对象
            DatagramSocket ds = new DatagramSocket(receivePort);
            // 2.创建DatagramPacket对象
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            // 3.接收数据
            while (true) {
                ds.receive(dp);
                // 4.显示接收到的数据
                String s = new String(buf);
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}