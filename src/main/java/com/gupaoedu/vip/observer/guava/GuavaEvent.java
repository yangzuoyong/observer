package com.gupaoedu.vip.observer.guava;

import com.google.common.eventbus.Subscribe;
import com.gupaoedu.vip.observer.gperadvice.GPer;
import com.gupaoedu.vip.observer.gperadvice.Question;

import java.util.Observable;

public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        System.out.println("执行subscribe方法，传入的参数是：" + str);
    }
}
