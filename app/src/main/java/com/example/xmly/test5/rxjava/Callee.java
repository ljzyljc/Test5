package com.example.xmly.test5.rxjava;

public interface Callee<T> {

    void onCompeted();

    void onError(Throwable t);

    void onReceiver(T t);

}
