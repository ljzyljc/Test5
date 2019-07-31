package com.example.xmly.test5.thread;

public class TestThread {

    private static int count;
    public static void main(String[] args){

//        TestThread testThread = new TestThread();
//        testThread.testDeadRecycle();
        testDeadRecycle();

    }

    private static void testDeadRecycle(){
        Thread currentThread = Thread.currentThread();
        while (true){
            if (currentThread.isInterrupted()){
                break;
            }
            count++;

            try {
                if (count == 20){
                    System.out.println("=======中段线程====");
                    interrupt();
                }
                System.out.println("==============执行Thread.sleep(100)========");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("====="+e.getMessage());
                //Thread.currentThread().interrupt();   //TODO：添加这个代码程序才会真正停止
                e.printStackTrace();
            }

        }
    }

    public static void interrupt(){
        Thread.currentThread().interrupt();
    }

}
