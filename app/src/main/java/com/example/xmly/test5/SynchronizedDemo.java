package com.example.xmly.test5;

public class SynchronizedDemo {
    private int name = 0;
    public Object object = new Object();
    public void method(){
        synchronized (SynchronizedDemo.class){
            System.out.print("jackie");
        }
    }

}
