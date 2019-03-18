package com.gupaoedu.vip.observer.events.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/***
 * 监听器就是观察者
 * @author : GP2713
 * @date : 2019/3/18
 */
public class EventLisenter {
    //JDK底层的Lisenter通常也是这样来设计的
    protected Map<String, Event> events = new HashMap<String, Event>();

    /**
     * 事件名称和一个目标对象来触发事件
     *
     * @param eventType :
     * @param target    :
     * @return : void
     * @author : GP12713
     * @date : 2019/3/18
     */
    public void addLisenter(String eventType, Object target) {
        try {
            this.addLisenter(
                    eventType,
                    target,
                    target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 注册事件
     * @author : GP12713
     * @date : 2019/3/18
     * @param eventType :
     * @param target :
     * @param method :
     * @return : void
     */
    private void addLisenter(String eventType, Object target, Method method) {
        events.put(eventType, new Event(target, method));
    }

    /***
     *事件名称触发
     * @author : GP12713
     * @date : 2019/3/18
     * @param trigger :
     * @return : void
     */
    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            return;
        }
        trigger(this.events.get(trigger).setTrigger(trigger));
    }

    /***
     * 触发，只要有动作就触发
     * @author : GP12713
     * @date : 2019/3/18
     * @param event :
     * @return : void
     */
    private void trigger(Event event) {
        event.setSource(this);
        event.setTime(System.currentTimeMillis());
        try {
            event.getCallback().invoke(event.getTarget(), event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 逻辑处理的私有方法，首字母大写
     * @author : GP12713
     * @date : 2019/3/18
     * @param str :
     * @return : java.lang.String
     */
    private String toUpperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
