package com.huawei.test.test.design.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarProxy implements InvocationHandler {

    private Star star;

    public StarProxy(Star star) {
        this.star = star;
    }
    public StarProxy() {}
    public Star getInstance(Star star){
        this.star = star;
        Class<?> starClass = star.getClass();
        System.out.println(starClass.getInterfaces());
        return (Star) Proxy.newProxyInstance(starClass.getClassLoader(),starClass.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //invoke为方法的返回值
        Object invoke = method.invoke(star, objects);
        return "123456"+invoke;
    }
}
