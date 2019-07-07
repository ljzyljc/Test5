package com.example.xmly.test5.design.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcrectSubject implements Subject {

    private List<Observer> list = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        for (Observer observer:list){
             observer.update();
        }
    }

    @Override
    public void operation() {
        System.out.println("通知所有的观察者");
        notifyAllObserver();
    }
}
