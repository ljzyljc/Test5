package com.example.xmly.test5.rxjava;

public abstract class Receiver<T> implements Callee<T>,Calling{

    private volatile boolean unCalled;

    @Override
    public void unCall() {
        unCalled = true;
    }

    @Override
    public boolean isUnCalled() {
        return unCalled;
    }
}
