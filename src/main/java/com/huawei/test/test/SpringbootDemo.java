package com.huawei.test.test;


import com.huawei.test.Controller.BookController;
import com.huawei.test.entity.Book;
import com.huawei.test.test.design.observer.EventTest;
import com.huawei.test.test.design.observer.Publisher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo {

    @Autowired
    private Publisher publisher;
    @Autowired
    private BookController bookController;


    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void  test(){
        redisTemplate.setEnableTransactionSupport(false);
        System.out.println("===========================================================");
//        redisTemplate.expire("kk1",2, TimeUnit.HOURS);
//        redisTemplate.opsForValue().set("kk1","vv1");

        System.out.println(redisTemplate.opsForValue().get("kk1"));
        System.out.println(redisTemplate.opsForHash().get("hash1","hk1"));


    }
    @Test
    public void  test1(){
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_book");
//        System.out.println(maps);
        List<Book> list = jdbcTemplate.query("select * from t_book", new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Book().setAuthor(rs.getString("author"))
                        .setId(rs.getInt("id")).setName(rs.getString("name"));
            }
        });
//        jdbcTemplate.queryF
        list.forEach(System.out::println);

    }
    @Test
    public void  test2(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_book");
        System.out.println(maps);

    }
    @Test
    public void  test3(){
//        List<String> book = jdbcTemplate.queryForList("select author from t_book", String.class);
        List<Book> book = jdbcTemplate.queryForList("select author from t_book", Book.class);
        System.out.println(book);

    }

    /**
     * 测试springboot监听器
     */
    @Test
    public void  test4(){
        publisher.publish("消息来了----=============");

    }
    @Test
    public void  test5(){
        bookController.list();

    }




}
