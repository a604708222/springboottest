package project.com.huawei.test.test;



import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Demo {

    @Test
    public void test1() throws IOException {

        int a = -778554306;
        Integer.toHexString(a);
        System.out.println(Integer.toHexString(a));//d198343e
        int value = -778554306;

        List<Integer> list = Arrays.asList(-778554306, 1666961212, -778511352);
        byte[] byteArray = new byte[12];
        for (int i = 0; i < 3; i++){
            byteArray[i*4] = (byte) (list.get(i) & 0xFF);
            byteArray[i*4+1] = (byte) (list.get(i) >> 8  & 0xFF);
            byteArray[i*4+2] = (byte) (list.get(i) >> 16 & 0xFF);
            byteArray[i*4+3] = (byte) (list.get(i) >> 24 & 0xFF);
        }
        OutputStream out = new FileOutputStream("e:/a.txt");
        out.write(byteArray);
        out.close();
    }

    @Test
    public void test2(){
        LocalDate now1 = LocalDate.now();
        LocalDateTime now2 = LocalDateTime.now();
        now2.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(321);

    }
    @Test
    public void test3(){
        Optional.of("aaa").map(t -> {
            return Objects.equals("aaa",t)?t:222;
        });
        Optional.of("aaa").map("aaa"::equals);

        System.out.println(321);

    }
    @Test
    public void test4(){
        String s = LocalDate.parse("2019-12-31", DateTimeFormatter.ISO_DATE).plusDays(1).format(DateTimeFormatter.ISO_DATE);



    }

}
