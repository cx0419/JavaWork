package com.cx.lunshuti.no2;

/**
 * @author 陈翔
 */
public class Room {
    public static void main(String[] args) {
        Thread reThread = new Thread(new ReceiveTask(8080));
        reThread.start();
        Thread SeThread = new Thread(new SendTask(8081));
        SeThread.start();

    }
}
