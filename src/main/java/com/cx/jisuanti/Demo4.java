package com.cx.jisuanti;

interface Information<T> {
   public T getInfo();
}
class MyInfo<T> implements Information<T> {
   private T info;
   public MyInfo(T info) {
      this.info = info;
   }
   public void setInfo(T info) {
      this.info = info;
   }
   public T getInfo() {
      return info;
   }
}
public class Demo4 {
   public static void main(String args[]) {
      Information<String> info = new MyInfo<String>("55");
      System.out.print(info.getInfo());
      Information<Integer> aDate = null;
      aDate = new MyInfo<Integer>(99);
      System.out.print(aDate.getInfo());
   }
}