package com.cx.lunshuti.no8;

class MyRunnable implements Runnable {
    //票总数
    int num_Ticket = 100;

    @Override
    public synchronized void run() {
        while (true) {
            if (num_Ticket > 0) {
                try {
                    //每卖出一张票，线程休眠10ms。
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "= " + num_Ticket--);
            }
            //循环出口，当没有余票时，停止。
            if (num_Ticket <= 0) {
                break;
            }
        }
    }
}