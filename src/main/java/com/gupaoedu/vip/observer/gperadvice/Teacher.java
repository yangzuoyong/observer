package com.gupaoedu.vip.observer.gperadvice;

import com.google.common.eventbus.Subscribe;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {
    private String name;
    public Teacher(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer)o;
        Question question = (Question)arg;
        System.out.println("===============================");
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自“" + gper.getName() + "”的提问，希望您解答，问题内容如下：\n" +
                question.getContent() + "\n" +
                "提问者：" + question.getUserName());
    }
    @Subscribe
    public void subscribe(Question question) {
        System.out.println("==============================================================");
        System.out.println(name + "老师你好\n，" + "学员[ " + question.getUserName() +" ]提交了一个问题，问题内容是：" + question.getContent());
    }
}
