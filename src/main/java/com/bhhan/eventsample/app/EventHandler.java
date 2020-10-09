package com.bhhan.eventsample.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * Created by hbh5274@gmail.com on 2020-10-09
 * Github : http://github.com/bhhan5274
 */

@Slf4j
@Component
public class EventHandler {
    @Async
    @TransactionalEventListener
    public void handle(SampleEvent event){
        log.info("handle event!!! > " + Thread.currentThread().getName());
    }
}
