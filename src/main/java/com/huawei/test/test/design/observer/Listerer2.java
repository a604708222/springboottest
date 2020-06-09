package com.huawei.test.test.design.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class Listerer2 implements ApplicationListener<EventTest> {
    @Override
    public void onApplicationEvent(EventTest event) {
        System.out.println("Listerer2========"+event.getMessage());
    }
}
