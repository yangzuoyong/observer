package com.gupaoedu.vip.observer.gperadvice;

import java.util.Observable;

/**
 *JDK提供的一种观察者的实现方式，被观察者
 * @author : yangzuoyong
 * @date : 2019/3/19
 */
public class GPer extends Observable {
    private String name = "GPer生态圈";
    private static GPer gper = null;
    private GPer(){}
    public static GPer getInstance(){
        return null==gper? new GPer():gper;
    }
    public String getName(){
        return name;
    }
    public void publishQuestion(Question question){
        System.out.println(String.format("%s在%s上提交了一个问题。",question.getUserName(),this.name));
        setChanged();
        notifyObservers(question);
    }
}
