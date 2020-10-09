package com.bhhan.eventsample.event;

import org.springframework.context.ApplicationEventPublisher;

/**
 * Created by hbh5274@gmail.com on 2020-10-09
 * Github : http://github.com/bhhan5274
 */
public class Events {
    private static ThreadLocal<ApplicationEventPublisher> publisherLocal = new ThreadLocal<>();

    public static void raise(DomainEvent event){
        if(event == null){
            return;
        }

        if(publisherLocal.get() != null){
            publisherLocal.get().publishEvent(event);
        }
    }

    public static void setPublisher(ApplicationEventPublisher publisher){
        publisherLocal.set(publisher);
    }

    public static void reset(){
        publisherLocal.remove();
    }
}
