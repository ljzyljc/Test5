package com.example.xmly.test5.queue;

public class CircleQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircleQueue(int capaticy) {
        items = new String[capaticy];
        n = capaticy;
    }


    public boolean enqueue(String item) {
        //队满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }


}
