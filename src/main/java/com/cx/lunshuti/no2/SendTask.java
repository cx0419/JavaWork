package com.cx.lunshuti.no2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author 陈翔
 */
public class SendTask implements Runnable {
    // 发数据的端口号
    private int sendPort;

    //构造方法
    public SendTask(int sendPort) {
        this.sendPort = sendPort;
    }

    @Override
    public void run() {
        try {
            // 1. 创建DatagramSocket对象
            DatagramSocket ds = new DatagramSocket();
            // 2.输入要发送的数据
            Scanner sc = new Scanner(System.in);
            while (true) {
                // 获取键盘输入的数据
                String data = sc.nextLine();
                // 3.封装数据到 DatagramPacket对象中
                DatagramPacket dp = new DatagramPacket(data.getBytes(),0,data.length(), InetAddress.getLocalHost(),sendPort);
                // 4.发送数据
                ds.send(dp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}