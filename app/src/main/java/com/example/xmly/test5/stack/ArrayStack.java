package com.example.xmly.test5.stack;

public class ArrayStack {

    private String[] items;
    private int count; //栈中元素个数
    private int n;  //栈的大小

    public ArrayStack(int n){
        items = new String[n];
        this.n = n;
        this.count = 0;
    }

    public String pop(){
        if (n == 0){
            return "";
        }
        String ss = items[count-1];
        count--;
        return ss;
    }

    public boolean push(String s){
        if (n == count){
            return false;
        }
        items[count] = s;
        ++count;
        return true;
    }



}
