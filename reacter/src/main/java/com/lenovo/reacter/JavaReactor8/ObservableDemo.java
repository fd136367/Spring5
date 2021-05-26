package com.lenovo.reacter.JavaReactor8;

import java.util.Observable;

public class ObservableDemo extends Observable {

    public static void main(String[] args) {
        ObservableDemo observable = new ObservableDemo();

        //添加观察者
        observable.addObserver((o, arg) -> {
            System.out.println("发生了变化");
        });

        observable.addObserver((o, arg) -> {
            System.out.println("手动被观察者通知，准备改变");
        });

        observable.setChanged();    //数据变化
        observable.notifyObservers();   //通知
    }
}
