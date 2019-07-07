package com.example.xmly.test5.design.observer;

public class TestObserver {

    public static void main(String[] args){
        Observer observer1 = new Observer1();
        Observer observer2 = new Observer2();
        Subject subject = new ConcrectSubject();
        subject.add(observer1);
        subject.add(observer2);
        subject.operation();
    }
}
