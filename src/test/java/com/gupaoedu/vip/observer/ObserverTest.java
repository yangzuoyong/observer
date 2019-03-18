package com.gupaoedu.vip.observer;

import com.google.common.eventbus.EventBus;
import com.gupaoedu.vip.observer.events.mousevent.Mouse;
import com.gupaoedu.vip.observer.events.mousevent.MouseEventCallback;
import com.gupaoedu.vip.observer.events.mousevent.MouseEventType;
import com.gupaoedu.vip.observer.gperadvice.GPer;
import com.gupaoedu.vip.observer.gperadvice.Question;
import com.gupaoedu.vip.observer.gperadvice.Teacher;
import com.gupaoedu.vip.observer.guava.GuavaEvent;
import org.junit.Test;

public class ObserverTest {
    @Test
    public void mouseEventTest() {
        MouseEventCallback callback = new MouseEventCallback();
        Mouse mouse = new Mouse();
        //@谁？  @回调方法
        mouse.addLisenter(MouseEventType.ON_CLICK, callback);
        mouse.addLisenter(MouseEventType.ON_FOCUS, callback);
        mouse.addLisenter(MouseEventType.ON_BLUR, callback);
        mouse.addLisenter(MouseEventType.ON_DOUBLE_CLICK, callback);
        mouse.addLisenter(MouseEventType.ON_MOVE, callback);
        mouse.click();
        mouse.focus();
        mouse.blur();
        mouse.doubleClick();
        mouse.move();
    }

    @Test
    public void adviceTest() {
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");

        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者设计模式适用于哪些场景？");
        gper.addObserver(tom);
        gper.addObserver(mic);
        gper.publishQuestion(question);
    }

    @Test
    public void GuavaEventTest() {
        //消息总线
        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("Tom");

        //从Struts到SpringMVC的升级
        //因为Struts面向的类，而SpringMVC面向的是方法

        //前面两者面向的是类，Guava面向是方法

        //能够轻松落地观察模式的一种解决方案
        //MQ

        //作业
        Question question = new Question("GP12713","如何在项目中使用设计模式？");
        Teacher tom = new Teacher("tom");

        EventBus bus = new EventBus();
        bus.register(tom);
        bus.post(question);
    }
}
