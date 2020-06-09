package com.huawei.test.test.design.observer;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class EventTest extends ApplicationEvent {
    @Getter
    private String message;
    public EventTest(Object source,String message) {
        super(source);
        this.message = message;
    }
}
