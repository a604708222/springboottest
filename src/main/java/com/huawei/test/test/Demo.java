package com.huawei.test.test;



import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.NumberUtils;
import org.springframework.util.ObjectUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Demo {

    @Test
    public void test1() throws IOException {

        int a = -778554306;
        Integer.toHexString(a);
        System.out.println(Integer.toHexString(a));//d198343e
        int value = -778554306;

        List<Integer> list = Arrays.asList(-778554306, 1666961212, -778511352);
        byte[] byteArray = new byte[12];
        for (int i = 0; i < 3; i++) {
            byteArray[i * 4] = (byte) (list.get(i) & 0xFF);
            byteArray[i * 4 + 1] = (byte) (list.get(i) >> 8 & 0xFF);
            byteArray[i * 4 + 2] = (byte) (list.get(i) >> 16 & 0xFF);
            byteArray[i * 4 + 3] = (byte) (list.get(i) >> 24 & 0xFF);
        }
        OutputStream out = new FileOutputStream("e:/a.txt");
        out.write(byteArray);
        out.close();
    }

    @Test
    public void test2() {
        LocalDate now1 = LocalDate.now();
        LocalDateTime now2 = LocalDateTime.now();
        now2.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(321);

    }

    @Test
    public void test3() {
        Optional.of("aaa").map(t -> {
            return Objects.equals("aaa", t) ? t : 222;
        });
        Optional.of("aaa").map("aaa"::equals);

        System.out.println(321);

    }

    @Test
    public void test4() {
        String s = LocalDate.parse("2019-12-31", DateTimeFormatter.ISO_DATE).plusDays(1).format(DateTimeFormatter.ISO_DATE);
        LocalDateTime parse = LocalDateTime.parse("2019-12-31 12:12:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(123456);


    }

    @Test
    public void test5() {
        IntStream.rangeClosed(1, 5).forEach(System.out::print);
        System.out.println("");
        IntStream.range(1, 5).forEach(System.out::print);
//        Environment.Build
    }

    @Test
    public void test6() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", "123");
        System.out.println(map);

    }

    @Test
    public void test7() {
        Integer in = NumberUtils.convertNumberToTargetClass(123, Integer.class);
        System.out.println(in);

    }

    @Test
    public void test8() {
        Integer in = NumberUtils.parseNumber("12345", Integer.class);
        System.out.println(in);
        Assert.notNull(ObjectUtils.isEmpty("123"));
        StringUtils.isNotEmpty(null);

    }

    @Test
    public void test9() {
        StringBuilder aaa = new StringBuilder("aaa");
        System.out.println(aaa.hashCode());
        aaa.append("bbb");
        System.out.println(aaa.hashCode());
        Integer in[] = new Integer[4];
        System.arraycopy(new Integer[]{1, 2, 3, 4, 5}, 0, in, 0, 2);
        Arrays.stream(in).forEach(System.out::print);
    }

    @Test
    public void test10() {
        String a = "aa";
        System.out.println(a.hashCode());
        a += "jlk";
        System.out.println(a.hashCode());
    }

    @Test
    public void test11() {
        String a = "aa";
        String b = "aa";
        System.out.println(a == b);

    }
    @Test
    public void test12() {
        for (int i = 0; i < 3; i++){
            System.out.println("waiceng  i="+i);
            for (int j = 0; j < 3; i++){
                System.out.println("waiceng  j="+j);
                if(j == 0)break;
            }
        }
        System.out.println();
    }
    @Test
    public void test14() {
        Character a[] = {'a','火'};
        Character b = '艘';
    }
    @Test
    public void test15() throws ParseException {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println(timestamp);
        System.out.println("Date.toString====="+date.toString());
        System.out.println(Clock.systemDefaultZone());
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SS");
        date = simple.parse("2001-01-03 04:05:06_77");
        SimpleDateFormat simple1 = new SimpleDateFormat("HH:mm:ss_SS");
//        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_SS");
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2001-06-09");
        String format = simple1.format(date);
        String format1 = simple1.format(timestamp);
        LocalDateTime.now();
    }
}
