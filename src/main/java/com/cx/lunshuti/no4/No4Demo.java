package com.cx.lunshuti.no4;

/**
 * 实现一个简单的银行存款程序，假设有两个储户都去银行往同一个账户存钱，一次存100，每人存3次，要求储户每存一次钱，账户余额增加100，请通过多线程的相关知识实现该功能，要求如下：
 * （1）正确定义银行类（Bank），该类中有账户余额属性和一个存款方法。（2分）
 * （2）正确定义储户类（Customer），并通过循环3次调用银行类中的存款方法。（4分）
 * （3）如何避免在存款过程中的多线程并发问题。（4分）
 * （4）定义测试类（Test），创建客户对象，并创建和开启两个线程执行存款操作。（5分）
 * @author 陈翔
 */
public class No4Demo {
    static class Customer extends Thread {
        private Bank bank;
        public Customer(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                bank.despite(100);
            }
        }
    }
    static class Bank {
        private Double balance;

        public Bank(Double balance) {
            this.balance = balance;
        }

        //在存钱的方法上添加synchronized关键字，使用同步方法来解决多线程并发问题
        public synchronized void despite(Integer money) {
            balance += money;
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额：" + balance);
        }
    }
    public static void main(String[] args) {
        Bank bank = new Bank(0.0);
        Customer customer1 = new Customer(bank);
        Customer customer2 = new Customer(bank);

        customer1.setName("客户1");
        customer2.setName("客户2");

        customer1.start();
        customer2.start();
    }
}
