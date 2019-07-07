package com.example.xmly.test5.rxjava;

import org.reactivestreams.Subscription;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RxJavaTest {

    public static void main(String[] args){
        System.out.println("-----------------jackie----------");
        test3();
    }

    public static void test4(){


    }


    public static void test3(){

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                System.out.println("-----------------jackie-----1-----");
                if (!e.isDisposed()){
                    System.out.println("subscribe:cureentThread"+Thread.currentThread().getName());
                    e.onNext("jackie");
                    e.onComplete();
                }

            }
        }).subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext:cureentThread"+Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }


    public static void test2(){

        Receiver<String> receiver = new Receiver<String>() {
            @Override
            public void onCompeted() {
                System.out.println("接收-----onCompleter");
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onReceiver(String s) {
                System.out.println("-----接收--------"+s);
            }
        };
        System.out.println(receiver.toString());

        Calling tCalling = Caller.create(new Caller.OnCall<String>() {
            @Override
            public void call(Receiver<String> stringReceiver) {
                if (!stringReceiver.isUnCalled()){
                    System.out.println("----------发送开始");
                    stringReceiver.onReceiver("test");
                    stringReceiver.onCompeted();
                    System.out.println("---------发送完毕"+stringReceiver.toString());
                }
            }
        }).call(receiver);


    }







    public void test1(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


}
