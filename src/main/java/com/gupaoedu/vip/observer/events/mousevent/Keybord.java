package com.gupaoedu.vip.observer.events.mousevent;

import com.gupaoedu.vip.observer.events.core.EventLisenter;

public class Keybord extends EventLisenter {
    public void down(){
        System.out.println("调用按下方法");
        this.trigger(MouseEventType.ON_DOWN);
    }

    public void up(){
        System.out.println("调用弹起方法");
        this.trigger(MouseEventType.ON_UP);
    }
}
