package com.huawei.test.test.design.proxy;

public class RealStar implements Star {
    @Override
    public String singSong(String name) {
        System.out.println("RealStar====singSong");
        return name;
    }

    @Override
    public String writeSong(String name) {
        System.out.println("RealStar====writeSong");
        return name;
    }
}
