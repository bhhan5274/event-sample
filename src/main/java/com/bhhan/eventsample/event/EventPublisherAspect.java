package com.bhhan.eventsample.event;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by hbh5274@gmail.com on 2020-10-09
 * Github : http://github.com/bhhan5274
 */

@Slf4j
@Aspect
@Component
public class EventPublisherAspect implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;
    private ThreadLocal<Boolean> appliedLocal = new ThreadLocal<>();

    @Around("@annotation(org.springframework.transaction.annotation.Transactional)")
    public Object handleEvent(ProceedingJoinPoint joinPoint) throws Throwable {
        Boolean appliedValue = appliedLocal.get();
        boolean nested = false;

        if(appliedValue != null && appliedValue){
            nested = true;
        }else{
            appliedLocal.set(Boolean.TRUE);
        }

        if(!nested){
            Events.setPublisher(publisher);
        }

        try {
            return joinPoint.proceed();
        }finally {
            if(!nested){
                Events.reset();
                appliedLocal.remove();
            }
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
