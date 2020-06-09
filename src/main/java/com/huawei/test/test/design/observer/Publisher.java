package com.huawei.test.test.design.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    @Autowired
    private ApplicationContext applicationContext;

    public void  publish(String message){
        applicationContext.publishEvent(new EventTest(this,message));

    }

}
