package com.huawei.test.test.design.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Listerer1 implements ApplicationListener<EventTest> {

    @Override
    public void onApplicationEvent(EventTest event) {
        System.out.println("Listerer1========"+event.getMessage());
    }
}
