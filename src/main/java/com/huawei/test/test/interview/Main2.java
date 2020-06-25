package com.huawei.test.test.interview;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main2 {
    public static void main(String[] args) {
//        test2();
        test3();
    }
    public static void test1(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] s = str.split("\\s+");
        double num = 0;
        for (String s1:s){
            num += s1.length();
        }
        double v = Double.parseDouble(new DecimalFormat("#0.00").format(num / s.length));
        System.out.println(v);
        sc.close();
    }
    public static void test2(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = "";

        String[] s = str.split(",");
        String[] s1 = new String[s.length];
        int strlenmax = 0;
        String num = "";
        List listflag = new ArrayList();
        for (int i = 0; i < s.length; i++){
            String temp = s[i];
            String re = "";
            for(int j = temp.length()-1; j >= 0; j--){
                char c = temp.charAt(j);
                re += c;
            }
            if(temp.length() > strlenmax){
                strlenmax = temp.length();
            }
            s1[i] = re;
            listflag.add(i);
        }
        Boolean flag[] = new Boolean[s.length];
        for (int m = 0; m < strlenmax; m++){

            ArrayList<Score> list = new ArrayList<>();
            for (int n = 0; n < s.length; n++){
                if(!listflag.contains(n)){
                    continue;
                }else if(listflag.size() == 1){
                    result += s[n];
                    System.out.println(result);
                    return;
                }else if(listflag.size() == 0){
                    System.out.println(result);
                    return;
                }

                int c = Integer.parseInt(String.valueOf(s[n].charAt(m)));
                Score score = new Score(n, c);
                list.add(score);
            }
            list.sort(new Comparator<Score>() {
                @Override
                public int compare(Score score, Score t1) {
                    return -(score.value - t1.value);
                }
            });
            /*for (int i = 1; i < list.size()-1; i++) {//4589,101,41425,9999
                if(list.size() == 2 && list.get(i-1).value> list.get(i).value){
                    listflag.clear();
                    result += s[list.get(i-1).num];
                    result += s[list.get(i).num];
                    continue;
                }
                if(list.size() >= 3 && list.get(i-1).value> list.get(i).value && list.get(i).value > list.get(i+1).value && ){
                    listflag.remove(i);
                    result += s[list.get(i).num];
                }
            }*/
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < list.size()-1; i++){
                if(map.get(list.get(i).num) == null){
                    map.put(list.get(i).num,1);
                }else{
                    Integer va = map.get(list.get(i).num)+1;
                    map.put(list.get(i).num,va);
                }

            }
            for(Integer k :map.keySet()){
                if(map.get(k) == 1){
                    listflag.remove(k);
                    result += s[list.get(k).num];
                }
            }


        }
        System.out.println(result);
        sc.close();
    }
    public static void test3() {

        Main2 main=new Main2();
        Scanner cin=new Scanner(System.in);

        String arr[]=(cin.nextLine()).split(" ");
        System.out.println(main.MaxNum1(arr));

    }

    public long MaxNum(String[] str){// 014 45891 14259 999
        long ret=0;

        for (int j = 0; j < str.length; j++) {//
            for (int i = 0; i < str.length; i++) {
                if (this.biJiao(str[j], str[i])) {//str[j] > str[i]
                    String temp=str[j];
                    str[j]=str[i];
                    str[i]=temp;
                }
            }
        }
        String num="";
        for (int m = 0; m < str.length; m++) {
            num=num+str[m];
        }

        ret=Long.parseLong(num);


        return ret;
    }
    public long MaxNum1(String[] str){// 014 45891 14259 999
        long ret=0;

        for (int j = 0; j < str.length; j++) {//
            for (int i = j; i < str.length; i++) {
                if (!biJiao(str[j], str[i])) {//str[j] > str[i]
                    String temp=str[j];
                    str[j]=str[i];
                    str[i]=temp;
                }
            }
        }
        Arrays.stream(str).forEach(System.out::println);
        /*String num="";
        for (int m = 0; m < str.length; m++) {
            num=num+str[m];
        }

        ret=Long.parseLong(num);*/


        return 0;
    }

    public boolean biJiao(String str1,String str2){//str1>str2 从前到后单个字符对比，不一样就返回，>返回true,<返回false

        int length=str1.length()+str2.length();

        str1+=str2;
        str2+=str1;

        for (int i = 0; i < length; i++) {

            if (Integer.parseInt(str1.substring(i, i+1))>Integer.parseInt(str2.substring(i, i+1))) {
                return true;
            }
            if (Integer.parseInt(str1.substring(i, i+1))<Integer.parseInt(str2.substring(i, i+1))) {
                return false;
            }
        }

        return true;
    }

}
class Score{
    public Integer num;
    public Integer value;

    public Score(Integer num,Integer value) {
        this.num = num;
        this.value = value;
    }
}
