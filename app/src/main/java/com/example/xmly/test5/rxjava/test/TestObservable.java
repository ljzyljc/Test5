package com.example.xmly.test5.rxjava.test;


//import android.util.Log;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestObservable {
    private static final String TAG = "TestObservable";

    public static void main(String[] args){
         test1();
    }

    public static void test1(){
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("1");
                    e.onNext("2");
                    e.onNext("3");
                    Log.i(TAG, "subscribe: =======执行onComplete====");
//                    System.out.println("=========执行onComplete=============");
                    e.onComplete();
//                    System.out.println("=========执行onError======");
//                    Log.i(TAG, "subscribe: =======继续执行===========");
//                e.onNext("4");
//                e.onError(new Throwable("手动抛出异常"));
//                    Log.i(TAG, "subscribe: ========最后结束=====");
//                    System.out.println("=========执行结束======");
                }
            }
        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
//                System.out.println("==============开始订阅了======================");
                Log.i(TAG, "onSubscribe: =====开始采用subscribe连接");
            }

            @Override
            public void onNext(String s) {
//                System.out.println("=====onNext========"+s);
                Log.i(TAG, "onNext: ===="+s);
            }

            @Override
            public void onError(Throwable e) {
//                System.out.println("=====onError========"+e.getMessage());
                Log.i(TAG, "onError: ===="+e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete: ======结束了=====");
//                System.out.println("=====onComplete========");
            }
        });
    }

}
