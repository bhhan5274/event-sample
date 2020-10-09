package com.bhhan.eventsample.app;

import com.bhhan.eventsample.event.Events;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hbh5274@gmail.com on 2020-10-09
 * Github : http://github.com/bhhan5274
 */

@Slf4j
@Service
public class SampleService {
    @Transactional
    public void doSome(){
        log.info("raise event!!! > " + Thread.currentThread().getName());
        Events.raise(new SampleEvent());

        try {
            Thread.sleep(2000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000L);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
