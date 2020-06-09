package com.huawei.test.test.design.proxy;

import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void test1(){
        System.out.println("ssssssssssss");
        Star star = (Star) (Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Star.class}, new StarProxy(new RealStar())));
//        Star star = (Star) (Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{Star.class}, new StarProxy()));

        String s = star.singSong("zhangsan");
        String s1 = star.writeSong("lisi");
    }
    @Test
    public void test2() throws IOException {
        Star star = new StarProxy().getInstance(new RealStar());
        byte[] s1 = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Star.class});
        FileOutputStream os = new FileOutputStream("e:/a.class");
        os.write(s1);
        os.close();
        String s = star.singSong("zhangsan");
    }

}
