package com.example.xmly.test5.design.observer;

public interface Subject {

    void add(Observer observer);

    void remove(Observer observer);

    void notifyAllObserver();

    //自身的操作，比如执行更新，通知所有啊等等
    void operation();

}
