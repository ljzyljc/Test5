package com.example.xmly.test5.rxjava;

public class Caller<T> {

    final  OnCall<T> onCall;

    public Caller(OnCall<T> onCall){
        this.onCall = onCall;
    }

    public static <T> Caller<T> create(OnCall<T> onCall){
        return new Caller<>(onCall);
    }


    public Calling call(Receiver<T> receiver){
        this.onCall.call(receiver);
        return receiver;
    }


    public interface OnCall<T> extends Action1<Receiver<T>>{

    }


}
