package project.com.huawei.test.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void  test(){
        redisTemplate.setEnableTransactionSupport(false);
        System.out.println("===========================================================");
//        redisTemplate.expire("kk1",2, TimeUnit.HOURS);
//        redisTemplate.opsForValue().set("kk1","vv1");

        System.out.println(redisTemplate.opsForValue().get("kk1"));
        System.out.println(redisTemplate.opsForHash().get("hash1","hk1"));


    }

}
