package com.huawei.test.test.interview;



import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.Assert;
import org.springframework.util.NumberUtils;
import org.springframework.util.ObjectUtils;

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

public class Main {

    static String[] oper = {"-", "*", "/", "+"};

    public static void main(String[] args) throws IOException {
//        int i = test1();
//        System.out.println(i);
        //System.out.println(commonMultiple());
//        System.out.println(commonDivisor(4, 8));
//        System.out.println(getCubeRoot());
        test105();
    }

//    public static void test50(){}

    /**
     *
     */
    public static void test0(){

    }
    /**
     *计算字符串最后一个单词的长度，单词以空格隔开。
     * 输入描述:
     * 一行字符串，非空，长度小于5000。
     *
     * 输出描述:
     * 整数N，最后一个单词的长度。
     *
     * 示例1
     * 输入
     * 复制
     * hello world
     * 输出
     * 复制
     * 5
     */
    public static void test107(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] s = str.split("\\s+");
        if(s.length==0){
            System.out.println(0);
        }else{
            System.out.println(s[s.length-1].length());
        }
    }

    /**
     *写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
     *
     * 输入描述:
     * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
     *
     * 输出描述:
     * 输出输入字符串中含有该字符的个数。
     *
     * 示例1
     * 输入
     * 复制
     * ABCDEF
     * A
     * 输出
     * 复制
     * 1
     */
    public static void test106(){
        Scanner scanner = new Scanner(System.in);
        String st = scanner.nextLine();
        String ch = scanner.nextLine();
        char c = ch.toCharArray()[0];
        int n = getNumFromString(st,c);
        System.out.println(n);
    }

    public static int getNumFromString(String string,char ch){
        int n = 0;
        //将字符串统一转成小写（大写也可）
        String St = string.toLowerCase();
        String st = String.valueOf(ch).toLowerCase();
        //获取一个正则表达式适配器
        Pattern p = Pattern.compile(st);//编译一个正则表达式
        Matcher m = p.matcher(St);//正则表达式适配器
        //查找
        while(m.find()){
            n++;
        }
        return n;

    }


    /**
     *明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。
     * Input Param
     * n               输入随机数的个数
     * inputArray      n个随机整数组成的数组
     * Return Value
     * OutputArray    输出处理后的随机整数
     * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
     * 样例输入解释：
     * 样例有两组测试
     * 第一组是3个数字，分别是：2，2，1。
     * 第二组是11个数字，分别是：10，20，40，32，67，40，20，89，300，400，15。
     * 输入描述:
     * 输入多行，先输入随机整数的个数，再输入相应个数的整数
     * 输出描述:
     * 返回多行，处理后的结果
     * 示例1
     * 输入
     * 复制
     * 3
     * 2
     * 2
     * 1
     * 11
     * 10
     * 20
     * 40
     * 32
     * 67
     * 40
     * 20
     * 89
     * 300
     * 400
     * 15
     * 输出
     * 复制
     * 1
     * 2
     * 10
     * 15
     * 20
     * 32
     * 40
     * 67
     * 89
     * 300
     * 400
     */
    public static void test105(){
        Scanner in = new Scanner(System.in);
        int[] num = new int[1000];
        while(in.hasNext()){
            int len = in.nextInt();
            for(int j = 0;j < 1000;j++)//初始化数组，为了应对你要在此输入新的数据时长度不一致
                num[j] = 0;
            for(int h = 0;h < len;h++){
                int tar = in.nextInt();
                num[tar] = tar;       //输入的数据对应了相应的下标，就等于排序好了
            }
            for(int k = 0;k < 1000;k++){
                if(num[k] == 0){   //有空格的时候不需要干啥
                    //这里需要括号，为了表明你啥也不干
                }
                else
                    System.out.println(num[k]);
            }
        }
        in.close();
    }

    /**
     *连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 输入描述:
     * 连续输入字符串(输入2次,每个字符串长度小于100)
     *
     * 输出描述:
     * 输出到长度为8的新字符串数组
     *
     * 示例1
     * 输入
     * 复制
     * abc
     * 123456789
     * 输出
     * 复制
     * abc00000
     * 12345678
     * 90000000
     */
    public static void test104(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            if (s.length()%8 != 0){
                s = s +"00000000";
            }
            while(s.length() >=8){
                System.out.println(s.substring(0,8));
                s = s.substring(8);
            }
        }
    }

    /**
     *写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
     *
     * 输入描述:
     * 输入一个十六进制的数值字符串。
     *
     * 输出描述:
     * 输出该数值的十进制字符串。
     *
     * 示例1
     * 输入
     * 复制
     * 0xA
     * 输出
     * 复制
     * 10
     */
    public static void test103(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str = in.nextLine();
            int result = change(str);
            System.out.println(result);
        }
    }
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    private static final String E = "E";
    private static final String F = "F";

    public static int change(String str) {
        int[] data = new int[str.length()-2];//题目要求输入格式为：0xA，所以要剔除"0x"所占用的空间。以下类似
        int result = 0;
        for(int i=0; i<str.length()-2; i++) {
            String sub = str.substring(i+2, i+3);//不管"0x"两个字符，直接截取"A"。
            switch(sub) {
                case A:
                    data[i] = 10;
                    break;
                case B:
                    data[i] = 11;
                    break;
                case C:
                    data[i] = 12;
                    break;
                case D:
                    data[i] = 13;
                    break;
                case E:
                    data[i] = 14;
                    break;
                case F:
                    data[i] = 15;
                    break;
                default:
                    data[i] = Integer.parseInt(sub);
                    //	data[i] = (sub.charAt(0)-'0');//将sub对应的单个字符强转为整型
            }
            result += data[i]*Math.pow(16,str.length()-2-i-1);
        }
        return result;
    }

    /**
     *功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
     * 最后一个数后面也要有空格
     * 输入描述:
     * 输入一个long型整数
     * 输出描述:
     * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
     * 示例1
     * 输入
     * 复制
     * 180
     * 输出
     * 复制
     * 2 2 3 3 5
     */
    public static void test102(){
        Scanner scanner = new Scanner (System.in);

        long input = scanner.nextLong();

        String resu = calculate(input);

        System.out.println(resu);
    }
    // 封装的计算所有质因子的方法
    public static String calculate(Long input){
        String result="";
        int i;
        for(i=2;i<Math.ceil(Math.sqrt(input));i++){
            Long x = input % i;
            if(x==0){
                break;
            }
        }
        if(i==Math.ceil(Math.sqrt(input))){
            if(i==2){
                result+="2 2 ";
            }else{
                result+=input+" ";
            }
            return result;
        }else{
            result+=i+" ";
            input=input / i;
            // 这里比较费时间，用了递归，最终将所有质因子一起返回
            return i+" "+calculate(input);
        }
    }

    /**
     *写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
     * 输入描述:
     * 输入一个正浮点数值
     * 输出描述:
     * 输出该数值的近似整数值
     * 示例1
     * 输入
     * 复制
     * 5.5
     * 输出
     * 复制
     * 6
     */
    public static void test101(){
        Scanner in = new Scanner(System.in);
        float num = in.nextFloat();
        INT(num);
    }
    public static void INT(float num){
        if(num>0) {
            float tempNum = num - (int)num;
            if(tempNum>=0.5){
                System.out.println((int)num+1);
            }else{
                System.out.println((int)num);
            }
        }
    }

    /**
     *数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
     * 输入描述:
     * 先输入键值对的个数
     * 然后输入成对的index和value值，以空格隔开
     * 输出描述:
     * 输出合并后的键值对（多行）
     * 示例1
     * 输入
     * 复制
     * 4
     * 0 1
     * 0 2
     * 1 2
     * 3 4
     * 输出
     * 复制
     * 0 3
     * 1 2
     * 3 4
     */
    public static void test100(){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {//注意while处理多个case
            String strNum = in.nextLine();
            int count = Integer.parseInt(strNum);
            int[] k = new int[count];
            int[] v = new int[count];

            for (int i = 0; i < count; i++) {
                String[] value = in.nextLine().split(" ");
                //System.out.println(JSON.toJSONString(value));
                k[i] = Integer.parseInt(value[0]);
                v[i] = Integer.parseInt(value[1]);
            }

            Set<Integer> set = new HashSet<>();//相同的索引值只统计一次
            Map<Integer, Integer> contents = new HashMap<>();//便于排序后输出
            List<Integer> key = new ArrayList<>();
            //List<Integer> val = new ArrayList<>();

            //Map<Integer,Integer> map00 = new TreeMap<>();

            for (int i = 0; i < count; i++) {
                if (set.add(k[i])) {
                    int tmpVal = v[i];
                    for (int j = 0; j < count; j++) {
                        if ((i != j) && (k[i] == k[j])) {
                            tmpVal += v[j];

                        }
                    }
                    key.add(k[i]);
                    //val.add(tmpVal);
                    contents.put(k[i], tmpVal);
                    //map00.put(k[i],tmpVal);
                    //System.out.println(k[i] + "  " + tmpVal);
                }
            }
            //或者使用有序的TreeMap
            //System.out.println(JSON.toJSONString(map00));
            //排序
            key.sort(Integer::compareTo);
            //key.forEach(System.out::print);
            for (int i = 0; i < key.size(); i++) {
                int index = key.get(i);
                System.out.println(index + " " + contents.get(index));
            }
        }
    }

    /**
     *输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 输入描述:
     * 输入一个int型整数
     * 输出描述:
     * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
     * 示例1
     * 输入
     * 复制
     * 9876673
     * 输出
     * 复制
     * 37689
     */
    public static void test99(){
        Scanner sc = new Scanner(System.in);
        int input=sc.nextInt();
        List<Integer> list= new ArrayList<Integer>();
        while(input>0){
            if(list.indexOf(input%10)<0){//如果余数存在，则不存入

                list.add(input%10);
            }
            input=(input-input%10)/10;
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i));
        }
        sc.close();
    }

    /**
     *编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。注意是不同的字符
     * 输入描述:
     * 输入N个字符，字符在ACSII码范围内。
     * 输出描述:
     * 输出范围在(0~127)字符的个数。
     * 示例1
     * 输入
     * 复制
     * abc
     * 输出
     * 复制
     * 3
     */
    public static void test98(){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            int len=getLen(s);
            System.out.println(len);
        }
    }

    public static int  getLen(String s) {
        int[] arr=new int[128];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)]=1;
        }
        int len=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1){
                len++;
            }
        }
        return len;
    }

    /**
     *描述：
     *
     * 输入一个整数，将这个整数以字符串的形式逆序输出
     *
     * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
     *
     *
     * 输入描述:
     * 输入一个int整数
     *
     * 输出描述:
     * 将这个整数以字符串的形式逆序输出
     *
     * 示例1
     * 输入
     * 复制
     * 1516000
     * 输出
     * 复制
     * 0006151
     */
    public static void test97(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        toOut(num);
    }
    public static void toOut(int num){
        List<Integer> intNum = new ArrayList<>();
        while(num>0){
            intNum.add((num%10));
            num /= 10;
        }
        for(int data:intNum){
            System.out.print(data);
        }
    }

    /**
     *写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
     *
     * 输入描述:
     * 输入N个字符
     *
     * 输出描述:
     * 输出该字符串反转后的字符串
     *
     * 示例1
     * 输入
     * 复制
     * abcd
     * 输出
     * 复制
     * dcba
     */
    public static void test96(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            byte[] b = s.getBytes();
            for (int i = b.length-1; i >= 0; i--) {
                System.out.print((char)b[i]);
            }
        }
    }

    /**
     *将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     * 接口说明
     *  * 反转句子
     *  * @param sentence 原句子
     *  * @return 反转后的句子
    public String reverse(String sentence);
             *输入描述:
            *将一个英文语句以单词为单位逆序排放。
            *输出描述:
            *得到逆序的句子
             *示例1
     *输入
     *复制
    I am
    a boy
     *输出
     *复制
    boy a
    am I
     */
    public static void test95(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] r=new String[str.length()];
        r= str.split(" ");
        for (int i =r.length-1; i>=0; i--) {
            System.out.print(r[i]+" ");
        }
    }

    /**
     *给定n个字符串，请对n个字符串按照字典序排列。
     * 输入描述:
     * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
     * 输出描述:
     * 数据输出n行，输出结果为按照字典序排列的字符串。
     * 示例1
     * 输入
     * 复制
     * 9
     * cap
     * to
     * cat
     * card
     * two
     * too
     * up
     * boat
     * boot
     * 输出
     * 复制
     * boat
     * boot
     * cap
     * card
     * cat
     * to
     * too
     * two
     * up
     */
    public static void test94(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long n = sc.nextInt();//其实这里也可以直接用数组，然后用Arrays.sort()
            List<String> list = new ArrayList<String>();for(int i=0;i<n;i++){
                //这里之前用的nextLine()就不行，提示错误，看了讨论说是因为前面的nextInt没有读第一行的换行符
                String b = sc.next();
                list.add(b);
            }
            Collections.sort(list);

            for(String st:list){
                System.out.println(st);
            }
        }
    }

    /**
     *输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
     *
     * 输入描述:
     *  输入一个整数（int类型）
     *
     * 输出描述:
     *  这个数转换成2进制后，输出1的个数
     *
     * 示例1
     * 输入
     * 复制
     * 5
     * 输出
     * 复制
     * 2
     */
    public static void test93(){
        Scanner scanner =  new Scanner(System.in);

        int input = scanner.nextInt();

        // 手写的十进制转二进制
        // ArrayList<Integer> ints = new ArrayList<Integer>();

        // while(input != 0){
        //     // int shang = input / 2;
        //     ints.add(input % 2);
        //     input /= 2;
        // }

        String str = Integer.toBinaryString(input);

        char [] ints =str.toCharArray();

        int count=0;
        for(int i=0;i<ints.length;i++){
            if(ints[i]=='1'){
                count++;
            }
        }

        System.out.println(count);
    }
    /**
     *王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
     * 主件	附件
     * 电脑	打印机，扫描仪
     * 书柜	图书
     * 书桌	台灯，文具
     * 工作椅	无
     * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
     * 王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。
     * 他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
     *     设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
     * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
     *     请你帮助王强设计一个满足要求的购物单。
     * 输入描述:
     * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
     * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
     * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
     * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，
     * 表示该物品为附件， q 是所属主件的编号）
     * 输出描述:
     *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
     * 示例1
     * 输入
     * 复制
     * 1000 5
     * 800 2 0
     * 400 5 1
     * 300 5 1
     * 400 3 0
     * 500 2 0
     * 输出
     * 复制
     * 2200
     */
    public static void test92(){
        Scanner sc=new Scanner(System.in);
        String[] str1=sc.nextLine().split(" ");
        int m=Integer.valueOf(str1[0])/10;//总钱数
        int c=Integer.valueOf(str1[1]);//希望购买的数量
        Good[][] goods=new Good[c+1][3];
        for(int i=1;i<=c;i++){
            String[] str2=sc.nextLine().split(" ");
            int v=Integer.valueOf(str2[0])/10;//节省空间
            int p=Integer.valueOf(str2[1]);
            int q=Integer.valueOf(str2[2]);
            Good good=new Good(v,v*p,q);
            if(good.q==0){//根据是否为主件属性对物品分组
                goods[i][0]=good;
            }else{
                if(goods[q][1]==null){
                    goods[q][1]=good;
                }else{
                    goods[q][2]=good;
                }
            }
        }

        //开始动态规划
        int[][] dp=new int[c+1][m+1];
        for(int i=1;i<=c;i++){//dp表的第i行，表示只添加第i件商品时
            for(int j=1;j<=m;j++){//dp表的列，表示钱数从1增长到最大m，判断每次增长后能否买到商品
                if(goods[i][0]==null){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                int t1=0;
                int t2=0;
                int t3=0;
                int t4=0;
                //只添加主件
                if(j>=goods[i][0].value){
                    t1=dp[i-1][j-goods[i][0].value]+goods[i][0].weight;
                }
                //添加主件和附件1
                if(goods[i][1]!=null && j>=(goods[i][0].value+goods[i][1].value)){
                    t2=dp[i-1][j-goods[i][0].value-goods[i][1].value]+goods[i][0].weight+goods[i][1].weight;
                }
                if(goods[i][2]!=null){
                    //添加主件和附件2
                    if(j>=(goods[i][0].value+goods[i][2].value)){
                        t3=dp[i-1][j-goods[i][0].value-goods[i][2].value]+goods[i][0].weight+goods[i][2].weight;
                    }
                    //添加主件和附件1、2
                    if(j>=(goods[i][0].value+goods[i][1].value+goods[i][2].value)){
                        t4=dp[i-1][j-goods[i][0].value-goods[i][1].value-goods[i][2].value]+goods[i][0].weight+goods[i][1].weight+goods[i][2].weight;
                    }
                }
                //选择上述可能中最大的结果，更新dp
                dp[i][j]=Math.max(Math.max(Math.max(Math.max(t1,t2),t3),t4),dp[i-1][j]);
            }
        }

        System.out.println(dp[c][m]*10);//最终结果
    }

    /**
     *开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，
     * 并将最终输入结果输出到输出文件里面。
     * 输入：
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     * 坐标之间以;分隔。
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     * 下面是一个简单的例子 如：
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 处理过程：
     * 起点（0,0）
     * +   A10   =  （-10,0）
     * +   S20   =  (-10,-20)
     * +   W10  =  (-10,-10)
     * +   D30  =  (20,-10)
     * +   x    =  无效
     * +   A1A   =  无效
     * +   B10A11   =  无效
     * +  一个空 不影响
     * +   A10  =  (10,-10)
     * 结果 （10， -10）
     * 注意请处理多组输入输出
     * 输入描述:
     *
     * 输出描述:
     * 最终坐标，以,分隔
     * 示例1
     * 输入
     * 复制
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     * 输出
     * 复制
     * 10,-10
     */
    public static void test91(){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String[] strx=str.split(";");

            Point start=new Point();//新建一个坐标点（0,0）

            for(int i=0;i<strx.length;i++){
                if(strx[i].length()<=3&&strx[i].length()>1){
                    if (strx[i].charAt(0) == 'A'
                            || strx[i].charAt(0) == 'W'
                            || strx[i].charAt(0) == 'S'
                            || strx[i].charAt(0) == 'D') {

                        String num=strx[i].substring(1);
                        int len=num.length();
                        if(len-num.replaceAll("[^0-9]","").length()==0){
                            start=Direction(strx[i],start);
                        }
                    }
                }
            }

            System.out.println(start.x+","+start.y);
        }
    }
    public static Point Direction(String str,Point start){
        if(str.charAt(0)=='A'){
            start.x=start.x-Integer.parseInt(str.substring(1));
        }
        if(str.charAt(0)=='W'){
            start.y=start.y+Integer.parseInt(str.substring(1));
        }
        if(str.charAt(0)=='S'){
            start.y=start.y-Integer.parseInt(str.substring(1));
        }
        if(str.charAt(0)=='D'){
            start.x=start.x+Integer.parseInt(str.substring(1));
        }
        return start;
    }

    /**
     *请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
     * 所有的IP地址划分为 A,B,C,D,E五类
     * A类地址1.0.0.0~126.255.255.255;
     * B类地址128.0.0.0~191.255.255.255;
     * C类地址192.0.0.0~223.255.255.255;
     * D类地址224.0.0.0~239.255.255.255；
     * E类地址240.0.0.0~255.255.255.255
     * 私网IP范围是：
     * 10.0.0.0～10.255.255.255
     * 172.16.0.0～172.31.255.255
     * 192.168.0.0～192.168.255.255
     * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
     * 注意二进制下全是1或者全是0均为非法
     * 注意：
     * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
     * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
     * 输入描述:
     * 多行字符串。每行一个IP地址和掩码，用~隔开。
     * 输出描述:
     * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
     * 示例1
     * 输入
     * 复制
     * 10.70.44.68~255.254.255.0
     * 1.0.0.1~255.0.0.0
     * 192.168.0.2~255.255.255.0
     * 19..0.~255.255.255.0
     * 输出
     * 复制
     * 1 0 1 0 0 2 1
     */
    public static void test90(){
        Scanner sc = new Scanner(System.in);
        int aNum = 0, bNum = 0, cNum = 0, dNum = 0, eNum = 0, error = 0, pNum = 0;
        while (sc.hasNextLine()) {


            String inputStr = sc.nextLine();
            if ("".equals(inputStr)) {
                break;
            }
            String[] StrArr = inputStr.split("~");
            String Ip = StrArr[0];
            String netMask = StrArr[1];


            String[] IpArr = Ip.split("[.]");
            int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, p = 0;
            //分析IP
            //判断基本格式
            int m = 0;
            for (int i = 0; i < IpArr.length; i++) {
                if ("".equals(IpArr[i])) {
                    err++;
                    m++;
                    break;
                }
            }
            if (m == 0) {
                for (int i = 0; i < IpArr.length; i++) {
                    int v = v = Integer.valueOf(IpArr[i]);
                    ;
                    if (i == 0) {
                        if (v == 0) {
                            break;
                        }
                        if (1 <= v && v <= 126) {
                            a++;
                            if (10 == v) {
                                p++;
                            }
                        }
                        if (128 <= v && v <= 191) {
                            b++;
                        }
                        if (192 <= v && v <= 223) {
                            c++;
                        }
                        if (224 <= v && v <= 239) {
                            d++;
                        }
                        if (240 <= v && v <= 255) {
                            e++;
                        }
                    }

                    if (v < 0 || v > 255) {
                        err++;
                        a = 0;
                        b = 0;
                        c = 0;
                        d = 0;
                        e = 0;
                        p = 0;
                        break;
                    }
                }
            }
            //判断私有IP
            if (4 == IpArr.length) {
                if (172 == Integer.valueOf(IpArr[0]) && 16 <= Integer.valueOf(IpArr[1]) && 31 >= Integer.valueOf(IpArr[1]) && 0 <= Integer.valueOf(IpArr[3]) && 255 >= Integer.valueOf(IpArr[3]) && 0 <= Integer.valueOf(IpArr[2]) && 255 >= Integer.valueOf(IpArr[2])) {
                    p++;
                }
                if (192 == Integer.valueOf(IpArr[0]) && 168 == Integer.valueOf(IpArr[1]) && 0 <= Integer.valueOf(IpArr[3]) && 255 >= Integer.valueOf(IpArr[3]) && 0 <= Integer.valueOf(IpArr[2]) && 255 >= Integer.valueOf(IpArr[2])) {
                    p++;
                }
            }


            //分析掩码
            String[] netMaskArr = netMask.split("[.]");
            String netMaskTwo = "";
            for (int i = 0; i < netMaskArr.length; i++) {
                String cnm = Integer.toBinaryString(Integer.valueOf(netMaskArr[i]));
                //保存掩码的二进制为8位
                if (cnm.length() < 8) {
                    String l = "";
                    for (int j = 0; j < 8 - cnm.length(); j++) {
                        l = l + "0";
                    }
                    cnm = l + cnm;
                }
                netMaskTwo = netMaskTwo + cnm;
            }
            int key = 0;
            for (int i = 0; i < netMaskTwo.length(); i++) {
                if (Integer.valueOf(netMaskTwo.charAt(i) + "") == 0) {
                    key = 1;
                    continue;
                }
                if (Integer.valueOf(netMaskTwo.charAt(i) + "") == 1 && key == 1) {
                    key = 2;
                    break;
                }
            }
            //key为2表示为错误掩码
            if (key == 2 || key == 0) {
                err++;
            }

            if (err != 0) {
                error++;
            } else {
                aNum = aNum + a;
                bNum = bNum + b;
                cNum = cNum + c;
                dNum = dNum + d;
                eNum = eNum + e;
                pNum = pNum + p;
            }

        }
        System.out.println(aNum + " " + bNum + " " + cNum + " " + dNum + " " + eNum + " " + error + " " + pNum);

    }

    /**
     *开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     * 处理：
     * 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
     * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * 3、 输入的文件可能带路径，记录文件名称不能带路径。
     * 输入描述:
     * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
     * 输出描述:
     * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
     * 示例1
     * 输入
     * 复制
     * E:\V1R2\product\fpgadrive.c   1325
     * 输出
     * 复制
     * fpgadrive.c 1325 1
     */
    public static void test89(){//测试没通过
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> map=new LinkedHashMap<String,Integer>();
        String path;
        String fileName;
        int lineNum;
        String key;
        while(sc.hasNext())
        {
            path=sc.next();
            int id=path.lastIndexOf('\\');
            fileName=id<0?path:path.substring(id+1);
            lineNum=sc.nextInt();
            key=fileName+" "+lineNum;
            if(map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key, 1);
        }
        sc.close();

        //记录错误信息
        List<Map.Entry<String,Integer>> lists=new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(lists,new Comparator<Map.Entry<String,Integer>>()
        {
            public int compare(Map.Entry<String, Integer> arg1, Map.Entry<String, Integer> arg2)
            {
                return (arg2.getValue()-arg1.getValue())==0?(arg1.getValue()-arg2.getValue()):(arg2.getValue()-arg1.getValue());
            }
        });

        int count=0;
        for(Map.Entry<String, Integer> list:lists)
        {
            if(count<8)
            {
                String[] str=list.getKey().split(" ");
                String k=str[0].length()>16?str[0].substring(str[0].length()-16):str[0];
                String n=str[1];
                System.out.println(k+" "+n+" "+list.getValue());
            }
            else
                break;
            count++;
        }

    }

    /**
     *密码要求:
     * 1.长度超过8位
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     * 3.不能有相同长度超2的子串重复
     * 说明:长度超过2的子串
     * 输入描述:
     * 一组或多组长度超过2的子符串。每组占一行
     * 输出描述:
     * 如果符合要求输出：OK，否则输出NG
     * 示例1
     * 输入
     * 复制
     * 021Abc9000
     * 021Abc9Abc1
     * 021ABC9000
     * 021$bc9000
     * 输出
     * 复制
     * OK
     * NG
     * NG
     * OK
     */
    public static void test88(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String key=sc.next();
            if(isQualified(key))
            {
                System.out.println("OK");
            }
            else{
                System.out.println("NG");
            }
        }
    }


    public static boolean isQualified(String key)
    {
        int Low=0,Up=0,num=0,other=0;
        if(key.length()<=8){
            return false;
        }
        for(int i=0;i<key.length();i++){
            char ch=key.charAt(i);
            if('0'<=ch&&ch<='9'){
                num=1;
            }
            else if('a'<=ch&&ch<='z'){
                Low=1;
            }
            else if('A'<=ch&&ch<='Z'){
                Up=1;
            }
            else{
                other=1;
            }
        }
        if(num+Low+Up+other<3){
            return false;
        }

        for(int j=0;j<key.length()-4;j++){
            for(int k=j+1;k<key.length()-3;k++){
                if(key.substring(j,j+3).equals(key.substring(k,k+3))){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
     * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
     * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
     * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
     * 输入描述:
     * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
     * 输出描述:
     * 输出渊子真正的密文
     * 示例1
     * 输入
     * YUANzhi1987
     * 输出
     * zvbo9441987
     */
    public static void test87(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0;i<str.length();i++) {
                char ch = str.charAt(i);
                if(Character.isLowerCase(ch)) {//小写字母
                    if(ch=='a'||ch=='b'||ch=='c') {
                        sb.append('2');
                        continue;
                    }else if(ch=='d'||ch=='e'||ch=='f') {
                        sb.append('3');
                        continue;
                    }else if(ch=='g'||ch=='h'||ch=='i') {
                        sb.append('4');
                        continue;
                    }else if(ch=='j'||ch=='k'||ch=='l') {
                        sb.append('5');
                        continue;
                    }else if(ch=='m'||ch=='n'||ch=='o') {
                        sb.append('6');
                        continue;
                    }else if(ch=='p'||ch=='q'||ch=='r'||ch=='s') {
                        sb.append('7');
                        continue;
                    }else if(ch=='t'||ch=='u'||ch=='v') {
                        sb.append('8');
                        continue;
                    }else if(ch=='w'||ch=='x'||ch=='y'||ch=='z') {
                        sb.append('9');
                        continue;
                    }
                }else if(Character.isUpperCase(ch)) {//大写字母
                    ch = Character.toLowerCase(ch);
                    if(ch =='z') {
                        sb.append('a');
                        continue;
                    }else {
                        int temp = ch+1;
                        char chh = (char) temp;
                        sb.append(chh);
                        continue;
                    }
                }else {//其他不变
                    sb.append(ch);
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     *有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，
     * 喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，
     * 喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
     * 输入描述:
     * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
     *
     * 输出描述:
     * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
     * 示例1
     * 输入
     * 复制
     * 3
     * 10
     * 81
     * 0
     * 输出
     * 复制
     * 1
     * 5
     * 40
     */
    public static void test86(){
        Scanner sc = new Scanner(System.in);
        int num2 = 0;

        while(sc.hasNext()){
            num2 = sc.nextInt();
            bottle(num2);
        }
        sc.close();
    }

    private static void bottle(int num2) {
        int num=0,num1=0,bnum=0,bnum1=0;
        num = num2;

        bnum1 = num/3;
        num = num%3;
        bnum = bnum1 + bnum;
        num1 = num + bnum1;

        while(num1>=3){
            num = num1%3;
            bnum1 = num1/3;
            bnum = bnum1 + bnum;
            num1 = num + bnum1;
        }
        if(num1==2)
            bnum++;
        System.out.println(bnum);

    }

    /**
     * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     * 注意每个输入文件有多组输入，即多个字符串用回车隔开
     * 输入描述:
     * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
     *
     * 输出描述:
     * 删除字符串中出现次数最少的字符后的字符串。
     * abcdd
     * 输出
     * 复制
     * dd
     */
    public static void test85(){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String ne = scan.next();
            System.out.println(deleteMixChar(ne));
        }
    }
    private static String deleteMixChar(String s) {
        //创建一个hashMap存储，存储字符串中的字符和其出现的次数
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            //如果hm集合中已经有这个键，则存入时直接将值加1
            if(hm.containsKey(ch[i])){
                hm.put(ch[i], hm.get(ch[i])+1);
            }else{
                hm.put(ch[i], 1);
            }
        }
        Collection<Integer> values = hm.values();
        Integer min = Collections.min(values);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < ch.length; i++) {
            if(hm.get(ch[i])!=min){
                str.append(ch[i]);
            }
        }
        return str.toString();
    }

    /**
     *计算最少出列多少位同学，使得剩下的同学排成合唱队形
     * 说明：
     * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
     * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
     * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
     * 注意不允许改变队列元素的先后顺序
     * 请注意处理多组输入输出！
     * 输入描述:
     * 整数N
     * 输出描述:
     * 最少需要几位同学出列
     * 示例1
     * 输入
     * 复制
     * 8
     * 186 186 150 200 160 130 197 200
     * 输出
     * 复制
     * 4
     */
    public static void test84(){//没找到

    }

    /**
     * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
     * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
     * 输入描述:
     * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~0xFFFFFFFF，序列个数不限
     * 输出描述:
     * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I<j>：
     * I<j>整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I<j>为231，那么I<j>包含了R<i>，条件满足 。
     * 按R<i>从小到大的顺序:
     * (1)先输出R<i>；
     * (2)再输出满足条件的I<j>的个数；
     * (3)然后输出满足条件的I<j>在I序列中的位置索引(从0开始)；
     * (4)最后再输出I<j>。
     * 附加条件：
     * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I<j>，索引大的需要过滤掉
     * (2)如果没有满足条件的I<j>，对应的R<i>不用输出
     * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
     * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
     * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
     * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
     * 说明：
     * 30----后续有30个整数
     * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I<j>，不输出0，而下一个R<i>是3
     * 6--- 存在6个包含3的I<j>
     * 0--- 123所在的原序号为0
     * 123--- 123包含3，满足条件
     * 输入
     * 复制
     * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
     * 5 6 3 6 3 0
     * 输出
     * 复制
     * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
     */
    public static void test83(){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int iNum = scan.nextInt();
            String[] iStr = new String[iNum];
            for(int i = 0 ; i < iNum ; i++){
                iStr[i] = Integer.toString(scan.nextInt());
            }
//			print(iStr);
            int rNum = scan.nextInt();
            TreeSet<Integer> ts = new TreeSet<Integer>();
            for(int i = 0 ; i < rNum ; i++){
                ts.add(scan.nextInt());
            }
//			System.out.println(ts);
            dataClassific(iStr, ts);
        }//endwhile
        scan.close();
    }
    private static void dataClassific(String[] iStr , TreeSet<Integer> ts){
        StringBuilder sb = new StringBuilder();
        int length = iStr.length;
        String temp_ts = "";
        Iterator<Integer> it = ts.iterator();
        int total_count = 0;
        while(it.hasNext()){
            int count = 0;//统计个数
            temp_ts = it.next().toString();
            for(int i = 0 ; i < length ; i++){
                if(iStr[i].contains(temp_ts)){
                    count++;
                }
            }
            if(count > 0){
                sb.append(temp_ts + " " + count + " ");
                total_count = total_count + 2 + count * 2;
                for(int i = 0 ; i < length ; i++){
                    if(iStr[i].contains(temp_ts)){
                        sb.append(i + " " + iStr[i] + " ");
                    }
                }
            }
        }//endwhile
        //删除最后一个空格
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(total_count + " " + sb);
    }
    private static void print(String[] str){
        int length = str.length;
        System.out.println("数组长度：" + length);
        for(int i = 0 ; i < length ; i++){
            if(i == length - 1){
                System.out.println(str[i]);
            }else{
                System.out.print(str[i] + " ");
            }
        }
    }

    /**
     *编写一个程序，将输入字符串中的字符按如下规则排序。
     * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
     * 如，输入： Type 输出： epTy
     * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
     * 如，输入： BabA 输出： aABb
     * 规则 3 ：非英文字母的其它字符保持原来的位置。
     * 如，输入： By?e 输出： Be?y
     * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
     * 输入描述:
     * 输入字符串
     * 输出描述:
     * 输出字符串
     * 示例1
     * 输入
     * 复制
     * A Famous Saying: Much Ado About Nothing (2012/8).
     * 输出
     * 复制
     * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
     */
    public static void test82(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String s=sc.nextLine();
            char[] chArray=s.toCharArray();
            System.out.println(stringSort(chArray));
        }
    }
    public static String stringSort(char chArray[]){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<26;i++){
            char ch=(char) ('a'+i);
            for(int j=0;j<chArray.length;j++){
                if(chArray[j]==ch||chArray[j]==(char)(ch+'A'-'a')){
                    sb.append(chArray[j]);
                }
            }
        }
        for(int i=0;i<chArray.length;i++){
            if(!(chArray[i]>='a'&&chArray[i]<='z'||chArray[i]>='A'&&chArray[i]<='Z')){
                sb.insert(i, chArray[i]);
            }
        }
        return sb.toString();
    }
    /**
     * 题目：查找兄弟单词
     *先输入字典中单词的个数，再输入n个单词作为字典单词。
     * 输入一个单词，查找其在字典中兄弟单词的个数
     * 再输入数字n
     *
     * 输出描述:
     * 根据输入，输出查找到的兄弟单词的个数
     * 示例1
     * 输入
     * 3 abc bca cab abc 1
     * 输出
     * 2
     * bca
     */
    public static void test81() throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader( System.in) );
        String s;
        while( ( s = bf.readLine() ) != null ) {
            String str[] = s.split("\\s+");
            String brother[] = new String[ str.length ];

            int n = Integer.parseInt(str[ 0 ]);
            String words = str[ n + 1 ];
            int k = Integer.parseInt( str[ str.length - 1 ] );

            int j = 0;
            for( int i = 1 ; i <= n ; i++ ) {
                if ( match( words , str[ i ] ) ) {
                    brother[ j ] = str[ i ];
                    j++;
                }
            }

            String a[] = new String[ j ];
            for ( int i = 0 ; i < j ; i++ ) {
                a[ i ] = brother[ i ];
            }


            if ( j == 0 ) {
                System.out.println( 0 );
            }
            else if ( k - 1 > j ) {
                System.out.println( j );
            }
            else {
                System.out.println( j );
                Arrays.sort( a );
                System.out.println( a[ k - 1 ] );
            }
        }
    }


    static boolean match( String s1 , String s2 ) {

        int a1[] = new int[ 26 ];
        int a2[] = new int[ 26 ];

        if ( !s1.equals( s2 ) ) {
            for ( int i = 0 ; i < 26 ; i++ ) {
                char c = (char) (i + 'a');
                for ( int j = 0 ; j < s1.length(); j++ ) {
                    if ( c == s1.charAt( j ) ) {
                        a1[ i ]++;
                    }
                }
                for ( int k = 0 ; k < s2.length(); k++ ) {
                    if ( c == s2.charAt( k ) ) {
                        a2[ i ]++;
                    }
                }
            }
            int judgement = 0;
            for ( int i = 0 ; i < 26 ; i++ ) {
                if ( a1[ i ] != a2[ i ] ) {
                    judgement++;
                }
            }

            if ( judgement == 0 ) {
                return true;
            }
            else {
                return false;
            }
        }

        else {
            return false;
        }
    }
    /**
     *题目描述
     * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
     * 输入:
     * 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。
     * 输出:
     * 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
     * 输入描述:
     * 输入说明
     * 1 输入一个正偶数n
     * 2 输入n个整数
     * 输出描述:
     * 求得的“最佳方案”组成“素数伴侣”的对数。
     * 示例1
     * 输入
     * 4
     * 2 5 6 13
     * 输出
     * 2
     */
    public static void test80(){

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int N = Integer.parseInt(str);
            long[] nums = new long[N];
            String[] str1 = sc.nextLine().split(" ");
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(str1[i]);
            }
            // 偶数部分
            ArrayList<Long> evens = new ArrayList<Long>();
            // 奇数部分
            ArrayList<Long> odds = new ArrayList<Long>();
            for (int i = 0; i < N; i++) {
                if (nums[i] % 2 == 0) { // 偶数
                    evens.add(nums[i]);
                } else { // 奇数
                    odds.add(nums[i]);
                }
            }
            long[] evensMatch = new long[evens.size()];
            int result = 0;
            for (int i = 0; i < odds.size(); i++) {
                int[] used = new int[evens.size()];
                if (find(odds.get(i), evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);

        }
        sc.close();
    }

    private static boolean isPrime(long num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
            if (num == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean find(long x, ArrayList<Long> evens, int[] used, long[] evensMatch) {
        int j;
        for (j = 0; j < evens.size(); j++) {
            if (isPrime(x + evens.get(j)) && used[j] == 0) {
                used[j] = 1;
                if (evensMatch[j] == 0 || find(evensMatch[j], evens, used, evensMatch)) {
                    evensMatch[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *1、对输入的字符串进行加解密，并输出。
     * 2加密方法为：
     * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
     * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
     * 其他字符不做变化。
     * 3、解密方法为加密的逆过程。
     * 接口描述：
     *     实现接口，每个接口实现1个基本操作：
     * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
     * 说明：
     * 1、字符串以\0结尾。
     * 2、字符串最长100个字符。
     * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
     * 说明：
     * 1、字符串以\0结尾。
     *     2、字符串最长100个字符。
     * 输入描述:
     * 输入说明
     * 输入一串要加密的密码
     * 输入一串加过密的密码
     * 输出描述:
     * 输出说明
     * 输出加密后的字符
     * 输出解密后的字符
     *输入
     * abcdefg
     * BCDEFGH
     * 输出
     * 复制
     * BCDEFGH
     * abcdefg
     */
    public static void test79() throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader( System.in ) );
        String s ;
        while( ( s = bf.readLine() ) != null ) {

            char aucPassword[] = s.toCharArray();
            char result[] = bf.readLine().toCharArray();

            int length1;
            if ( aucPassword.length <= 100 ) {
                length1 = aucPassword.length;
            }
            else {
                length1 = 100;
            }
            char aucResult[] = new char[ length1 ];

            int length2;
            if ( result.length <= 100 ) {
                length2 = result.length;
            }
            else {
                length2 = 100;
            }
            char password[] = new char[ length2 ];

            Encrypt ( aucPassword , aucResult );
            unEncrypt ( result , password );
        }
        bf.close();
    }
    static void Encrypt (char aucPassword[], char aucResult[]) {

        for ( int i = 0 ; i < aucResult.length ; i++ ) {
            if ( aucPassword[ i ] >= 65 && aucPassword[ i ] <= 90 ) {
                if ( aucPassword[ i ] == 'Z' ) {
                    aucResult[ i ] = 'a';
                }
                else {
                    aucResult[ i ] = (char) (aucPassword[ i ] + 33 );
                }
            }else  if ( aucPassword[ i ] >= 97 && aucPassword[ i ] <= 122 ) {
                if ( aucPassword[ i ] == 'z' ) {
                    aucResult[ i ] = 'A';
                }else {
                    aucResult[ i ] = (char) (aucPassword[ i ] - 31 );
                }
            }else if ( aucPassword[ i ] >= 48 && aucPassword[ i ] <= 57 ) {
                if ( aucPassword[ i ] == '9' ) {
                    aucResult[ i ] = '0';
                }else {
                    aucResult[ i ] = (char) (aucPassword[ i ] + 1 );
                }
            }else {
                aucResult[ i ] = aucPassword[ i ];
            }
        }

        System.out.println( String.valueOf( aucResult ) );
    }

    static int unEncrypt (char result[], char password[]) {
        for ( int i = 0 ; i < password.length ; i++ ) {
            if ( result[ i ] >= 65 && result[ i ] <= 90 ) {
                if ( result[ i ] == 'A' ) {
                    password[ i ] = 'z';
                }else {
                    password[ i ] = (char) ( result[ i ] + 31 );
                }
            }else if ( result[ i ] >= 97 && result[ i ] <= 122 ) {
                if ( result[ i ] == 'a' ) {
                    password[ i ] = 'Z';
                }else {
                    password[ i ] = ( char )( result[ i ] - 33 );
                }
            }else if ( result[ i ] >= 48 && result[ i ] <= 57 ) {
                if ( result[ i ] == '0' ) {
                    password[ i ] = '9';
                }else {
                    password[ i ] = ( char )( result[ i ] - 1 );
                }
            }else {
                password[ i ] = result[ i ];
            }
        }
        System.out.println( String.valueOf( password ) );
        return 0;
    }
    /**
     * 按照指定规则对输入的字符串进行处理。
     * 详细描述：
     * 将输入的两个字符串合并。
     * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
     * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
     * 如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
     * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
     * 接口设计及说明：
     * 功能:字符串处理
     * 输入:两个字符串,需要异常处理
     * 输出:合并处理后的字符串，具体要求参考文档
     * 返回:无
    void ProcessString(char*str1, char *str2, char *strOutput)
             *
             *输入描述:
            *输入两个字符串
             *输出描述:
            *输出转化后的结果
     * 输入描述:
     * 输入两个字符串
     *
     * 输出描述:
     * 输出转化后的结果
     *
     * 示例1
     * 输入
     * 复制
     * dec fab
     * 输出
     * 复制
     * 5D37BF
     */
    public static void test78(){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.next()+scan.next();
            int len=str.length()/2;
            char[] c1;
            if(str.length()%2!=0){
                c1=new char[len+1];
            }else{
                c1=new char[len];
            }
            char[] c2=new char[len];
            boolean b=true;
            int i1=0;
            int i2=0;
            for(int i=0; i<str.length(); i++){//奇位置和偶位置分离
                if(b){
                    c1[i1++]=str.charAt(i);
                    b=false;
                }else{
                    c2[i2++]=str.charAt(i);
                    b=true;
                }
            }
            Arrays.sort(c1);
            Arrays.sort(c2);
            StringBuilder sb=new StringBuilder();
            i1=0;
            while(i1<c1.length && i1<c2.length){
                sb.append(c1[i1]);
                sb.append(c2[i1]);
                i1++;
            }
            while(i1<c1.length){
                sb.append(c1[i1++]);
            }
            while(i1<c2.length){
                sb.append(c2[i1++]);
            }
            StringBuilder res=new StringBuilder();
            for(int i=0; i<sb.length(); i++){
                char c=sb.charAt(i);
                if((c>='0' && c<='9') || (c>='a' && c<='f') || (c>='A' && c<='F')){
                    res.append(process(c));
                }else{
                    res.append(c);
                }
            }
            System.out.println(res.toString());
        }

    }
    public static char process(char c){
        String s = "";
        if(c>='0' && c<='9'){
            s=Integer.toBinaryString(c-'0');
        }
        if(c>='a' && c<='f'){
            s=Integer.toBinaryString(c-'a'+10);//a=10 b=11
        }
        if(c>='A' && c<='F'){
            s=Integer.toBinaryString(c-'A'+10);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }
        while(sb.length()<4){
            sb.append('0');
        }
        int a=Integer.parseInt(sb.toString(), 2);
        if(a>=0 && a<=9){
            return (char) (a+'0');
        }else{
            return (char) (a-10+'A');
        }
    }
    /**
     *对字符串中的所有单词进行倒排。
     * 说明：
     * 1、构成单词的字符只有26个大写或小写英文字母；
     * 2、非构成单词的字符均视为单词间隔符；
     * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
     * 4、每个单词最长20个字母；
     * 输入描述:
     * 输入一行以空格来分隔的句子
     * 输出描述:
     * 输出句子的逆序
     * 示例1
     * 输入
     * 复制
     * I am a student
     * 输出
     * 复制
     * student a am I
     */
    public static void test77(){
        Scanner sc = new Scanner(System.in);
        System.out.println(reverse(sc.nextLine()));
    }
    private static String reverse(String line) {
        char[] chararray = line.toCharArray();

        // 将多个空格合并为一个
        StringBuilder sb1 = new StringBuilder();
        int firstSpace = 0;
        int indexFirst = 0, indexLast = 0;
        for (int i = 0; i < chararray.length; i++) {
            //将非字母处理一下
            if(!(chararray[i]>='A'&&chararray[i]<='Z')&&!(chararray[i]>='a'&&chararray[i]<='z')){
                chararray[i] = ' ';
            }

            if (chararray[i] == ' ') {
                if (firstSpace == 0) {
                    firstSpace = 1;
                    indexFirst = i;
                    sb1.append(chararray[i]);
                } else {
                    indexLast = i;
                }
            } else {
                firstSpace = 0;
                sb1.append(chararray[i]);
            }
        }
        // System.out.println(list);

        // 分割
        String[] arr = sb1.toString().split(" ");
        List<String> list = Arrays.asList(arr);

        // 逆序
        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(' ');
            }
        }
        return sb.toString().trim();//处理一下两端的空格
    }

    /**
     *Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
     * 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
     * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，
     * 你能帮Catcher找出最长的有效密码串吗？
     * 输入描述:
     * 输入一个字符串
     * 输出描述:
     * 返回有效密码串的最大长度
     * 示例1
     * 输入
     * 复制
     * ABBA
     * 输出
     * 复制
     * 4
     */
    public static void test76(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            if(!(password==null || Objects.equals(password, "") )){
                System.out.println(findPassword1(password));
            }

        }
    }
    /**
     *  遍历字符串
     *  如果当前字符只有一个，直接跳到下一个字符
     *  如果当前字符的最大下标差值小于maxLen，跳过(无意义，就算有回文，也一定小于最大)
     *  前后同时进行遍历子字符串，如果前后字符中有任何一位不相同，将lastIndex改变
     *  扔掉遍历过的字符串(使indexOf()起到作用)
     */
    private static int findPassword1(String password) {
        int lenth = password.length();
        String pa = password;
        int maxLen = 1;
        for (int i = 0; i <= lenth - maxLen; i++) {
            char c = pa.charAt(i);
            int index = password.indexOf(c + "");
            int lastIndex = password.lastIndexOf(c + "");
            if (index == lastIndex) {//如果当前 char 只有一个的话，
                continue;
            }else if(lastIndex - index <= maxLen){//
                continue;
            }else {
                while (index != lastIndex){
                    int len = 2;
                    int frontPoint = index + 1;
                    int rearPoint = lastIndex - 1;
                    while (frontPoint < rearPoint ) {
                        if(password.charAt(frontPoint) != password.charAt(rearPoint)){
                            len = -1;
                            break;
                        }
                        len += 2;
                        frontPoint++;
                        rearPoint--;
                    }
                    if (frontPoint == rearPoint) {
                        len++;
                    }
                    maxLen = maxLen > len ? maxLen : len;
                    lastIndex =  password.substring(0,lastIndex).lastIndexOf(c+"");
                }
            }
            password = password.substring(password.indexOf(c + "")+1);
        }
        return maxLen;
    }
    /**
     *原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
     * 一个长整数。
     * 举例：一个ip地址为10.0.3.193
     * 每段数字             相对应的二进制数
     * 10                   00001010
     * 0                    00000000
     * 3                    00000011
     * 193                  11000001
     * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
     * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验
     * 输入描述:
     * 输入
     * 1 输入IP地址
     * 2 输入10进制型的IP地址
     * 输出描述:
     * 输出
     * 1 输出转换成10进制的IP地址
     * 2 输出转换后的IP地址
     * 示例1
     * 输入
     * 复制
     * 10.0.3.193
     * 167969729
     * 输出
     * 复制
     * 167773121
     * 10.3.3.193
     */
    public static void test75(){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext())
        {
            String str1=scan.nextLine();
            String str2=scan.nextLine();
            ipToshi(str1);
            shiToip(str2);
        }
    }
    //输出转换成10进制的IP地址
    static void ipToshi(String str1){
        String[] strs=str1.split("\\.");//.在正则表达式汇总有特殊含义，这里s需要转以
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            if(Integer.parseInt(str)>=0 && Integer.parseInt(str)<=255){
                String str_er=Integer.toBinaryString(Integer.parseInt(str));
                for(int i=0;i<8-str_er.length();i++){
                    sb.append("0");//不足8位的补0
                }
                sb.append(Integer.toBinaryString(Integer.parseInt(str)));
            }
        }
        //将已获取的二进制转换为十进制

        System.out.println(Long.valueOf(sb.toString(),2).toString());
    }
    //输出转换后的IP地址
    static void shiToip(String str2){
        String ip = "";
        Long input = Long.parseLong(str2);
        for (int i=3;i>=0;i--){
            ip=(input%256)+"."+ip;
            input/=256;
        }
        System.out.println(ip.substring(0, ip.length() - 1));
    }

    /**
     *Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
     * 输入描述:
     * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
     *
     * 输出描述:
     * Lily的所有图片按照从小到大的顺序输出
     * 示例1
     * 输入
     * 复制
     * Ihave1nose2hands10fingers
     * 输出
     * 复制
     * 0112Iaadeeefghhinnnorsssv
     */
    public static void test74(){
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(quickSort(input));
        }

        scanner.close();
    }
    private static String quickSort(String s) {
        char[] chars = s.toCharArray();
        quickSort(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private static void quickSort(char[] chars, int beg, int end) {
        if (beg < end) {
            int lo = beg;
            int hi = end;
            char pivot = chars[lo];
            while (lo < hi) {
                while (lo < hi && chars[hi] >= pivot) {
                    hi--;
                }
                chars[lo] = chars[hi];
                while (lo < hi && chars[lo] <= pivot) {
                    lo++;
                }
                chars[hi] = chars[lo];
            }
            chars[lo] = pivot;
            quickSort(chars, beg, lo - 1);
            quickSort(chars, lo + 1, end);
        }
    }

    /**
     *题目说明
     * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
     * 样例输入
     * 5
     * 样例输出
     * 1 3 6 10 15
     * 2 5 9 14
     * 4 8 13
     * 7 12
     * 11
     * 接口说明
     * 原型
     * void GetResult(int Num, char * pResult);
     * 输入参数：
     *         int Num：输入的正整数N
     * 输出参数：
     *         int * pResult：指向存放蛇形矩阵的字符串指针
     *         指针指向的内存区域保证有效
     * 返回值：
     *         void
     *         输入描述:
     * 输入正整数N（N不大于100）
     *
     * 输出描述:
     * 输出一个N行的蛇形矩阵。
     *
     * 示例1
     * 输入
     * 复制
     * 4
     * 输出
     * 复制
     * 1 3 6 10
     * 2 5 9
     * 4 8
     * 7
     */
    public static void test73(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String[] strings = new String[num];
            for (int i = 0; i < strings.length; i++) {
                strings[i] = "";
            }
            GetResult(num, strings);

            for (int i = 0; i < strings.length; i++) {
                System.out.println(strings[i]);
            }

        }
    }
    private static void GetResult(int num, String[] strings) {

        int startNum = 1;
        int startLeft = 1;
        int add = 2;
        int end = num;
        int currentAdd = 2;
        int hangAdd = 1;
        for (int i = 0; i < num; i++) {
            currentAdd = i + 2;
            startNum = startLeft;
            for (int j = 0; j < end; j++) {
                if (j != end - 1) {
                    strings[i] += startNum + " ";
                } else {
                    strings[i] += startNum;
                }

                startNum += currentAdd;
                currentAdd++;
            }
            startLeft += hangAdd;
            hangAdd++;
            end--;
        }
    }

    /**
     *有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
     * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
     * 请实现下述接口，通过指定的密匙和明文得到密文。
     * 详细描述：
     * 接口说明
     * 原型：
     * voidencrypt(char * key,char * data,char * encrypt);
     * 输入参数：
     * char * key：密匙
     * char * data：明文
     * 输出参数：
     * char * encrypt：密文
     * 返回值：
     * void
     * 输入描述:
     * 先输入key和要加密的字符串
     *
     * 输出描述:
     * 返回加密后的字符串
     *
     * 示例1
     * 输入
     * 复制
     * nihao
     * ni
     * 输出
     * 复制
     * le
     */
    public static void test72(){
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(encrypt(s1, s2));
        }
        scanner.close();
    }
    private static String encrypt(String mask, String s) {
        HashSet<Character> set = new LinkedHashSet<>(32);
        // 添加掩码中出现了的字母并且除去重复的字母
        for (int i = 0; i < mask.length(); i++) {
            char c = mask.charAt(i);
            if (c >= 'a' && c <= 'z') {
                set.add((char) (c - 'a' + 'A'));
            } else if (c >= 'A' && c <= 'Z') {
                set.add(c);
            }
        }
        // 添加余下的字母
        for (int i = 0; i < 26; i++) {
            set.add((char) ('A' + i));
        }
        // 转换成字符数组，都是用大写表示的
        Character[] convert = set.toArray(new Character[set.size()]);
        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; i++) {
            char c = result[i];
            if (c >= 'a' && c <= 'z') {
                result[i] = (char) (convert[c - 'a'] - 'A' + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                result[i] = convert[c - 'A'];
            }
        }
        return new String(result);
    }

    /**
     *有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
     *      * 统计出兔子总数。
     *      * @param monthCount 第几个月
     *      * @return 兔子总数
    public static int getTotalCount(int monthCount)
    {
     *return 0;
     *}
     * 输入描述:
     * 输入int型表示month
     *
     * 输出描述:
     * 输出兔子总数int型
     *
     * 示例1
     * 输入
     * 复制
     * 9
     * 输出
     * 复制
     * 34
     */
    public static void test71(){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int month=scan.nextInt();
            System.out.println(Sum(month));
        }
    }
    static int Sum(int month)
    {
        int sum=0;
        if(month==1){
            sum=1;
        }else if(month==2){
            sum=1;
        }else if(month==3){
            sum=2;
        }else{
            sum=Sum(month-1)+Sum(month-2);
        }
        return sum;
    }


    /**
     *假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
     * 最后的误差判断是小数点6位
     * 输入描述:
     * 输入起始高度，int型
     * 输出描述:
     * 分别输出第5次落地时，共经过多少米第5次反弹多高
     * 示例1
     * 输入
     * 复制
     * 1
     * 输出
     * 复制
     * 2.875
     * 0.03125
     */
    public static void test70(){
// System.out.println("Test");
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int a = scan.nextInt();
            double b = 2.875*a;
            double c = 0.03125 * a;
            System.out.println(b);
            System.out.println(c);
        }
    }



    /**
     * 题目：判断两个IP是否属于同一子网
     *
     *子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
     * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
     * 示例：
     * I P 地址　 192.168.0.1
     * 子网掩码　 255.255.255.0
     * 转化为二进制进行运算：
     * I P 地址　11010000.10101000.00000000.00000001
     * 子网掩码　11111111.11111111.11111111.00000000
     * AND运算
     *  　　　　11000000.10101000.00000000.00000000
     * 转化为十进制后为：
     *  　　　　192.168.0.0
     * I P 地址　 192.168.0.254
     * 子网掩码　 255.255.255.0
     * 转化为二进制进行运算：
     * I P 地址　11010000.10101000.00000000.11111110
     * 子网掩码　11111111.11111111.11111111.00000000
     * AND运算
     * 　　　　　11000000.10101000.00000000.00000000
     * 转化为十进制后为：
     * 　　　　　192.168.0.0
     * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
     * 输入描述:
     * 输入子网掩码、两个ip地址
     * 输出描述:
     * 得到计算结果
     * 示例1
     * 输入
     * 复制
     * 255.255.255.0
     * 192.168.224.256
     * 192.168.10.4
     * 输出
     * 复制
     * 1
     */
    public static void test69(){//39 空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
        Scanner scan=new Scanner(System.in);
        String[] str1=scan.nextLine().split("\\.");
        String[] str2=scan.nextLine().split("\\.");
        String[] str3=scan.nextLine().split("\\.");

        if(Yu(str1,str2).equals("1")){
            System.out.println("1");
        }
        else if(Yu(str1,str3).equals("1")){
            System.out.println("1");
        }else if(Yu(str1,str2).equals(Yu(str1,str3)))
        {
            System.out.println("0");
        }else{
            System.out.println("2");
        }

    }
    //两个数相与
    static String Yu(String[] str1,String[] str2)
    {
        int result=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;i++){
            if(Integer.parseInt(str1[i])<0 ||Integer.parseInt(str1[i])>255){
                result=1;
            }else if(Integer.parseInt(str2[i])<0 ||Integer.parseInt(str2[i])>255){
                result=1;
            }else{
                result=(Integer.parseInt(str1[i])&Integer.parseInt(str2[i]));
                sb.append(result);
                if(i!=3) sb.append(".");
            }
        }
        if(result!=0){
            return "1";
        }else{
            return sb.toString();
        }
    }
    /**
     *输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
     *      * 统计出英文字母字符的个数。
     *      * @param str 需要输入的字符串
     *      * @return 英文字母的个数
     public static int getEnglishCharCount(String str)
     {
     *return 0;
     *}
     *      * 统计出空格字符的个数。
     *      * @param str 需要输入的字符串
     *      * @return 空格的个数
     public static int getBlankCharCount(String str)
     {
     *return 0;
     *      * 统计出数字字符的个数。
     *      * @param str 需要输入的字符串
     *      * @return 英文字母的个数
     public static int getNumberCharCount(String str)
     {
     *return 0;
     *}
     *      * 统计出其它字符的个数。
     *      * @param str 需要输入的字符串
     *      * @return 英文字母的个数
     public static int getOtherCharCount(String str)
     {
     *return 0;
     *}
     * 输入描述:
     * 输入一行字符串，可以有空格
     * 输出描述:
     * 统计其中英文字符，空格字符，数字字符，其他字符的个数
     * 示例1
     * 输入
     * 复制
     * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
     * 输出
     * 复制
     * 26
     * 3
     * 10
     * 12
     */
    public static void test68() {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.print(count(input));
        }
        scanner.close();
    }
    private static String count(String s) {
        int[] result = new int[4];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                result[0]++;
            } else if (c == ' ') {
                result[1]++;
            } else if (c >= '0' && c <= '9') {
                result[2]++;
            } else {
                result[3]++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i : result) {
            builder.append(i).append('\n');
        }
        return builder.toString();
    }



    /**
     *现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
     * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
     * 注：
     * 称重重量包括0
     * 方法原型：public static int fama(int n, int[] weight, int[] nums)
     * 输入描述:
     * 输入包含多组测试数据。
     * 对于每组测试数据：
     * 第一行：n --- 砝码数(范围[1,10])
     * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
     * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
     * 输出描述:
     * 利用给定的砝码可以称出的不同的重量数
     * 输出描述:
     * 利用给定的砝码可以称出的不同的重量数
     *
     * 示例1
     * 输入
     * 复制
     * 2
     * 1 2
     * 2 1
     * 输出
     * 复制
     * 5
     */
    public static void test67(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            int n = Integer.parseInt(in.nextLine()); // n 种砝码
            String str1 = in.nextLine();
            String str2 = in.nextLine();
            System.out.println(getNums(n, str1, str2));
        }
        in.close();
    }


    private static int getNums(int n, String s1, String s2) {
        String[] s1Arr = s1.split(" ");
        String[] s2Arr = s2.split(" ");
        int[] m = new int[n];
        int[] x = new int[n];
        int sum = 0; // 总的重量
        for (int i = 0; i < n; i++) {
            m[i] = Integer.valueOf(s1Arr[i]); // 每种砝码的重量
            x[i] = Integer.valueOf(s2Arr[i]); // 每种砝码的数量
            sum += x[i] * m[i];
        }
        boolean[] temp = new boolean[sum+1];//能测的质量种类，最多是：总质量+1
        temp[0] = true;//质量为0，也为true
        temp[sum] = true;//质量满了也为true
        for (int i = 0; i < n; i++) {//砝码的种类数
            for (int j = 0; j < x[i]; j++) {//每种砝码对应的个数
                for (int k = sum; k >= m[i]; k--) {//总重量往下减
                    //假设k-m[i]为1，即质量为1的值，已经存在temp数组
                    //temp[k-m[i]]为true,当前m[i]代表的当前质量，在1的基础上累加是可以的，即累加后的值为k
                    //所以可以设置temp[k]=true,后面依次递归
                    if (temp[k - m[i]])//递归思想的应用
                        temp[k] = true;//若质量相同的会被覆盖，所以不用额外处理相同的质量
                }
            }
        }
        int count = 0;
        for (int i = 0; i <= sum; i++) {
            if (temp[i])
                count++;
        }//找到temp[]为true的，这是可以被称出来的；
        return count;
    }

    /**
     *Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
     * 如22：twenty two，123：one hundred and twenty three。
     * 说明：
     * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
     * 输出格式为twenty two；
     * 非法数据请返回“error”；
     * 关键字提示：and，billion，million，thousand，hundred。
     * 方法原型：public static String parse(long num)
     * 输入描述:
     * 输入一个long型整数
     * 输出描述:
     * 输出相应的英文写法
     * 示例1
     * 输入
     * 复制
     * 2356
     * 输出
     * 复制
     * two thousand three hundred and fifty six
     */
    public static void test66(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            Long n=sc.nextLong();
            String str=parse(n);
            System.out.println(str);
        }
        sc.close();
    }
    public static String[] bit_num = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static String[] ten_num = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    public static String[] twenty_more = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    public static String parse(long num){
        if(num < 0) return "error";
        StringBuffer sb=new StringBuffer();
        long billion = num / 1000000000;
        if(billion != 0){
            sb.append(trans(billion) + " billion ");
        }
        num %= 1000000000;
        long million = num / 1000000;
        if(million != 0){
            sb.append(trans(million) + " million ");
        }
        num %= 1000000;
        long thousand = num / 1000;
        if(thousand != 0){
            sb.append(trans(thousand) + " thousand ");
        }
        num %= 1000;
        long hundred = num;
        if(hundred != 0){
            sb.append(trans(hundred));
        }
        return sb.toString().trim();//去掉首尾的空格
    }
    public static String trans(long num){
        StringBuffer sb = new StringBuffer();
        int h = (int)(num / 100);
        if(h != 0){
            sb.append(bit_num[h] + " hundred");
        }
        num %= 100;
        int t = (int)(num / 10);
        if(t != 0){
            if(h != 0){
                sb.append(" and ");
            }
            if(t == 1){
                sb.append(ten_num[(int)(num%10)]);
            }else{
                sb.append(twenty_more[(int)(t - 2)] + " ");
                if(num % 10 != 0){
                    sb.append(bit_num[(int)(num%10)]);
                }
            }
        }else if(num % 10 != 0){
            if(h != 0){
                sb.append(" and ");
            }
            sb.append(bit_num[(int)(num%10)]);
        }
        return sb.toString().trim();
    }


    /**
     * 题目：迷宫问题
     *定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
     * int maze[5][5] = {
     *         0, 1, 0, 0, 0,
     *         0, 1, 0, 1, 0,
     *         0, 0, 0, 0, 0,
     *         0, 1, 1, 1, 0,
     *         0, 0, 0, 1, 0,
     * };
     * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
     * Input
     * 一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
     * Output
     * 左上角到右下角的最短路径，格式如样例所示。
     * Sample Input
     * 0 1 0 0 0
     * 0 1 0 1 0
     * 0 0 0 0 0
     * 0 1 1 1 0
     * 0 0 0 1 0
     * Sample Output
     * (0, 0)
     * (1, 0)
     * (2, 0)
     * (2, 1)
     * (2, 2)
     * (2, 3)
     * (2, 4)
     * (3, 4)
     * (4, 4)
     * 输入描述:
     * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
     * 输出描述:
     * 左上角到右下角的最短路径，格式如样例所示。
     * 示例1
     * 输入
     * 复制
     * 5 5
     * 0 1 0 0 0
     * 0 1 0 1 0
     * 0 0 0 0 0
     * 0 1 1 1 0
     * 0 0 0 1 0
     * 输出
     * 复制
     * (0,0)
     * (1,0)
     * (2,0)
     * (2,1)
     * (2,2)
     * (2,3)
     * (2,4)
     * (3,4)
     * (4,4)
     */
    static Position[][] maze = new Position[8][8];
    public static void test65(){//43 没找到正确的  空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {// 全部初始化，不然搜索的时候会报错
            for (int j = 0; j < 8; j++) {
                maze[i][j] = new Position(i, j, 1);// 人工建墙，围上迷宫，免得判范围
            }
        }
        int[][] operate = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };// 表驱动法代替连续if
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                maze[i][j].value = sc.nextInt();
            }
        }
        Queue<Position> wait = new LinkedList<Position>();
        wait.add(maze[1][1]);
        while (!wait.isEmpty()) {
            Position cur = wait.poll();
            if (cur.x == 5 && cur.y == 5)
            {
                // 写了个递归，从终点开始回退，到达起点为止开始输出，达到题目从头输出的要求
                outPut(5, 5);
                break;
            }
            cur.value = 1;// 标记为走过
            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + operate[i][0];
                int nextY = cur.y + operate[i][1];
                if (maze[nextX][nextY].value == 0) {
                    wait.add(maze[nextX][nextY]);
                    maze[nextX][nextY].pre = cur;// 链式记录
                }
            }
        }
    }
    public static void outPut(int x, int y) {
        if (maze[x][y].pre == null) {
            System.out.println("(0, 0)");
            return;
        }
        outPut(maze[x][y].pre.x, maze[x][y].pre.y);
        int realX = x - 1;
        int realY = y - 1;
        System.out.println("(" + realX + ", " + realY + ")");
    }


    /**
     *问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、
     * 每一个粗线宫内的数字均含1-9，并且不重复。
     * 输入：
     * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
     * 输出：
     * 完整的9X9盘面数组
     * 输入描述:
     * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
     * 输出描述:
     * 完整的9X9盘面数组
     * 示例1
     * 输入
     * 复制
     * 0 9 2 4 8 1 7 6 3
     * 4 1 3 7 6 2 9 8 5
     * 8 6 7 3 5 9 4 1 2
     * 6 2 4 1 9 5 3 7 8
     * 7 5 9 8 4 3 1 2 6
     * 1 3 8 6 2 7 5 9 4
     * 2 7 1 5 3 8 6 4 9
     * 3 8 6 9 1 4 2 5 7
     * 0 4 5 2 7 6 8 3 1
     * 输出
     * 复制
     * 5 9 2 4 8 1 7 6 3
     * 4 1 3 7 6 2 9 8 5
     * 8 6 7 3 5 9 4 1 2
     * 6 2 4 1 9 5 3 7 8
     * 7 5 9 8 4 3 1 2 6
     * 1 3 8 6 2 7 5 9 4
     * 2 7 1 5 3 8 6 4 9
     * 3 8 6 9 1 4 2 5 7
     * 9 4 5 2 7 6 8 3 1
     */
    public static void test64(){
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];
        while (sc.hasNext()) {
            for (int i = 0; i < 9; i ++) {
                for (int j = 0; j < 9; j ++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            sudoku(matrix, 0, 0);
            for (int i = 0; i < 9; i ++) {
                for (int j = 0; j < 9; j ++) {
                    if(j == 8) System.out.println(matrix[i][j]);
                    else System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    public static boolean sudoku(int[][] matrix, int i, int j) {
        if(i > 8) return true;
        if(matrix[i][j] != 0) {
            if(j < 8 && sudoku(matrix, i, j + 1)) return true; // 未到行位,求解同行下一个
            else if(j >= 8 && sudoku(matrix, i + 1, 0)) return true; // 已到行位,求解下一行第一个
        } else {
            for (int num = 1; num <= 9; num ++) {
                if(check(matrix, i, j, num)) {
                    matrix[i][j] = num;
                    if(j < 8 && sudoku(matrix, i, j + 1)) return true;
                    else if(j >= 8 && sudoku(matrix, i + 1, 0)) return true;
                    matrix[i][j] = 0; // 回溯
                }
            }
        }
        return false;
    }
    // 检查行、列、3*3格
    public static boolean check(int[][] matrix, int i, int j, int num) {
        if(check_row(matrix, i, j, num) && check_col(matrix, i, j, num) && check_3_by_3(matrix, i, j, num)) return true;
        return false;
    }
    // 检查所在行
    public static boolean check_row(int[][] matrix, int i, int j, int num) {
        for (int k = 0; k < 9; k ++) {
            if(matrix[i][k] == num) return false;
        }
        return true;
    }
    // 检查所在列
    public static boolean check_col(int[][] matrix, int i, int j, int num) {
        for (int k = 0; k < 9; k ++) {
            if(matrix[k][j] == num) return false;
        }
        return true;
    }
    // 检查所在3*3格
    public static boolean check_3_by_3(int[][] matrix, int i, int j, int num) {
        int row_from = i / 3 * 3;
        int row_to = row_from + 2;
        int col_from = j / 3 * 3;
        int col_to = col_from + 2;
        for (int x = row_from; x <= row_to; x ++) {
            for (int y = col_from; y <= col_to; y ++) {
                if(matrix[x][y] == num) return false;
            }
        }
        return true;
    }



    /**
     * 题目：名字的漂亮度
     *给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
     * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
     * 给出多个名字，计算每个名字最大可能的“漂亮度”。
     * 输入描述:
     * 整数N，后续N个名字
     *
     * 输出描述:
     * 每个名称可能的最大漂亮程度
     * 示例1
     * 输入
     * 复制
     * 2
     * zhangsan
     * lisi
     * 输出
     * 复制
     * 192
     * 101
     */
    public static void test63(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int num = scanner.nextInt();
            for(int i = 0;i < num;i++){
                String s = scanner.next();
                helper(s);
            }
        }
    }


    private static void helper(String s){
        s = s.toLowerCase();
        int[] chars = new int[26];
        int i = 0;
        for(;i < s.length();i++)
            chars[s.charAt(i) - 'a']++;
        Arrays.sort(chars);
        int n = 26;
        i = 25;
        int res = 0;
        while(i >= 0 && chars[i] != 0){
            res += chars[i] * n--;
            i--;
        }
        System.out.println(res);
    }



    /**
     * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，
     * 应该输出为"我ABC"而不是"我ABC+汉的半个"。
     * 输入描述:
     * 输入待截取的字符串及长度
     * 输出描述:
     * 截取后的字符串
     * 示例1
     * 输入
     * 复制
     * 我ABC汉DEF
     * 6
     * 输出
     * 复制
     * 我ABC
     */
    public static void test62(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            jiequ(in.next(),in.nextInt());
        }
        in.close();
    }
    public static void jiequ(String s,int num)  {
        int count=0;
        String temp="";
        for(char a:s.toCharArray()) {
            count+=(a+"").getBytes().length;
            if (count>num) {
                break;
            }
            temp+=a;
        }
        System.out.println(temp);
    }



    /**
     *信号测量的结果包括测量编号和测量值。存在信号测量结果丢弃及测量结果重复的情况。
     *   1.测量编号不连续的情况，认为是测量结果丢弃。对应测量结果丢弃的情况，需要进行插值操作以更准确的评估信号。
     *   采用简化的一阶插值方法,由丢失的测量结果两头的测量值算出两者中间的丢失值。
     *   假设第M个测量结果的测量值为A，第N个测量结果的测量值为B。则需要进行(N-M-1)个测量结果的插值处理。进行一阶线性插值估计的第N+i个测量结果的测量值为A+( (B-A)/(N-M) )*i  (注：N的编号比M大。)
     *   例如：只有测量编号为4的测量结果和测量编号为7的测量结果，测量值分别为4和10
     *         则需要补充测量编号为5和6的测量结果。
     *          其中测量编号为5的测量值=4 + ((10-4)/(7-4))*1 = 6
     *          其中测量编号为6的测量值=4 + ((10-4)/(7-4))*2 = 8
     *       2.测量编号相同，则认为测量结果重复，需要对丢弃后来出现的测量结果。
     *   请根据以上规则进行测量结果的整理。
     * 详细描述：
     * 接口说明
     * 原型：
     * intCleanUpMeasureInfo(MEASURE_INFO_STRUCT* pOriMeasureInfo,intnOriMINum,intnMaxMIRst, MEASURE_INFO_STRUCT* pMeasureInfoRst);
     * 输入参数：
     *         MEASURE_INFO_STRUCT* pOriMeasureInfo:         原始测量结果内容，以结构数组方式存放。测量编号已经按升序排列。MEASURE_INFO_STRUCT定义包含编号和测量值，见OJ.h
     *           int nOriMINum:                                原始测量结果个数。
     *           int nMaxMIRst:                                整理的测量结果最大个数。
     * 输入参数：
     *     MEASURE_INFO_STRUCT* pMeasureInfoRst：         整理的测量结果
     * 返回值：
     *     Int
     *          整理的测量结果个数
     * 输入描述:
     * 输入说明
     * 1 输入两个整数m, n
     * 2 输入m个数据组
     * 输出描述:
     * 输出整理后的结果
     * 示例1
     * 输入
     * 复制
     * 2 3
     * 4 5
     * 5 7
     * 输出
     * 复制
     * 4 5
     * 5 7
     */
    public static void test61(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int m=in.nextInt();
            int n=in.nextInt();//没什么用
            int[][]data=new int[m][2];
            for (int i = 0; i < m; i++) {
                data[i][0]=in.nextInt();
                data[i][1]=in.nextInt();
            }
            int KEY=data[0][0];
            int VALUE=data[0][1];
            List<String>list=new ArrayList<String>();
            list.add(KEY+" "+VALUE);
            for (int i = 1; i <m; i++) {
                int diff=data[i][0]-data[i-1][0];//相邻的差值
                if(diff>1){//不连续的情况
                    for (int j = 1; j <=diff-1; j++) {
                        //编号，这里必须用KEY,而不能用data[i-1][0],是因为可能上一个点是连续点，被跳过
                        int key=KEY+j;
                        int value=VALUE+(data[i][1]-VALUE)/(data[i][0]-KEY)*j;
                        list.add(key+" "+value);
                    }
                }else if(diff==0)//连续的点不做处理
                    continue;
                list.add(data[i][0]+" "+data[i][1]);
                KEY=data[i][0];
                VALUE=data[i][1];
            }

            for (String s : list) {
                System.out.println(s);
            }
        }
        in.close();
    }


    /**
     *输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
     * 链表结点定义如下：
     * struct ListNode
     * {
     * int       m_nKey;
     * ListNode* m_pNext;
     * };
     * 详细描述：
     * 本题为考察链表的插入和删除知识。
     * 链表的值不能重复
     * 构造过程，例如
     * 1 <- 2
     * 3 <- 2
     * 5 <- 1
     * 4 <- 5
     * 7 <- 2
     * 最后的链表的顺序为 2 7 3 1 5 4
     * 删除 结点 2
     * 则结果为 7 3 1 5 4
     * 输入描述:
     * 1 输入链表结点个数
     * 2 输入头结点的值
     * 3 按照格式插入各个结点
     * 4 输入要删除的结点的值
     *
     * 输出描述:
     * 输出删除结点后的序列，每个数后都要加空格
     *
     * 示例1
     * 输入
     * 复制
     * 5
     * 2
     * 3 2
     * 4 3
     * 5 2
     * 1 4
     * 3
     * 输出
     * 复制
     * 2 5 4 1
     */
    public static void test60(){
        Scanner sc =new Scanner(System.in);
        while (sc.hasNextInt()){
            //这两行代码要写在这个while循环里面
            int number = sc.nextInt();
            int head = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(head);
            for (int i=1;i<number;i++)
            {
                int insertNode = sc.nextInt();
                int preNode = sc.nextInt();
                int index = list.indexOf(preNode);
                //在preNode这个点后面一个位置插入，index_insert=index+1
                list.add(index+1,insertNode);
            }
            Object delectNode = sc.nextInt();
            list.remove(delectNode);
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            //这里有个超坑的设置，输出完毕后记得换行，不然检测不通过！！！！马的，找了好久的bug！
            System.out.println();
        }
        sc.close();
    }


    /**
     *问题描述：有4个线程和1个公共的字符数组。线程1的功能就是向数组输出A，线程2的功能就是向字符输出B，线程3的功能就是向数组输出C，线程4的功能就是向数组输出D。要求按顺序向数组赋值ABCDABCDABCD，ABCD的个数由线程函数1的参数指定。[注：C语言选手可使用WINDOWS SDK库函数]
     * 接口说明：
     * void init();  //初始化函数
     * void Release(); //资源释放函数
     * unsignedint__stdcall ThreadFun1(PVOID pM)  ; //线程函数1，传入一个int类型的指针[取值范围：1 – 250，测试用例保证]，用于初始化输出A次数，资源需要线程释放
     * unsignedint__stdcall ThreadFun2(PVOID pM)  ;//线程函数2，无参数传入
     * unsignedint__stdcall ThreadFun3(PVOID pM)  ;//线程函数3，无参数传入
     * Unsigned int __stdcall ThreadFunc4(PVOID pM);//线程函数4，无参数传入
     * char  g_write[1032]; //线程1,2,3,4按顺序向该数组赋值。不用考虑数组是否越界，测试用例保证
     */
    public static void test59(){// 49题：没找到答案
        Scanner sca = new Scanner(System.in);
        while(sca.hasNext()){
            int N = sca.nextInt();
            sca.close();

            final TestThread obj = new TestThread();
            Thread tA = new Thread()
            {
                public void run()
                {
                    obj.m1(N);
                }
            };
            tA.start();
            Thread tB = new Thread()
            {
                public void run()
                {
                    obj.m2(N);
                }
            };
            tB.start();
            Thread tC = new Thread()
            {
                public void run()
                {
                    obj.m3(N);
                }
            };
            tC.start();
            Thread tD = new Thread()
            {
                public void run()
                {
                    obj.m4(N);
                }
            };
            tD.start();
            try {
                tA.join();
                tB.join();
                tC.join();
                tD.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(obj.ch);
        }

    }


    /**
     * 题目描述
     * 请实现如下接口
     *     /* 功能：四则运算
     *      * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
     *          * 返回：算术表达式的计算结果
    public static int calculate(String strExpression)
     *return 0;
     *}
     *pucExpression字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。
     * pucExpression算术表达式的有效性由调用者保证;
     * 输入描述:
     * 输入一个算术表达式
     * 输出描述:
     * 得到计算结果
     * 示例1
     * 输入
     * 复制
     * 3+2*{1+2*[-4/(8-6)+7]}
     * 输出
     * 复制
     * 25
     */
    public static void test58(){
        Scanner sc = new Scanner(System.in);
        // 初始化正括号集合
        brace.add('{');
        brace.add('(');
        brace.add('[');
        while(sc.hasNextLine()){
            // 对字符串做初始化处理，原则有二:
            // 1、处理负数，这里在-前面的位置加入一个0，如-4变为0-4，
            // 细节：注意-开头的地方前面一定不能是数字或者反括号，如9-0,(3-4)-5，这里地方是不能加0的
            // 它的后面可以是数字或者正括号，如-9=>0-9, -(3*3)=>0-(3*3)
            // 2、处理字符串，在最后的位置加#, 主要是为了防止最后一个整数无法处理的问题
            String exp = sc.nextLine().replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0") + "#";
            System.out.println(calculate(exp));
        }
    }

    static Set<Character> brace = new HashSet<>();
    private static int calculate(String exp){
        // 初始化栈
        Stack<Integer> opStack = new Stack<>();
        Stack<Character> otStack = new Stack<>();

        // 整数记录器
        String num = "";
        for(int i = 0; i < exp.length(); i++){
            // 抽取字符
            char c = exp.charAt(i);
            // 如果字符是数字，则加这个数字累加到num后面
            if(Character.isDigit(c)){
                num += c;
            }
            // 如果不是数字
            else{
                // 如果有字符串被记录，则操作数入栈，并清空
                if(!num.isEmpty()){
                    int n = Integer.parseInt(num);
                    num = "";
                    opStack.push(n);
                }
                // 如果遇上了终结符则退出
                if(c == '#')
                    break;
                    // 如果遇上了+-
                else if(c == '+' || c == '-'){
                    // 空栈或者操作符栈顶遇到正括号，则入栈
                    if(otStack.isEmpty() || brace.contains(otStack.peek())){
                        otStack.push(c);
                    } else {
                        // 否则一直做弹栈计算，直到空或者遇到正括号为止，最后入栈
                        while(!otStack.isEmpty() && !brace.contains(otStack.peek()))
                            popAndCal(opStack, otStack);
                        otStack.push(c);
                    }
                }
                // 如果遇上*/
                else if(c == '*' || c == '/'){
                    // 空栈或者遇到操作符栈顶是括号，或者遇到优先级低的运算符，则入栈
                    if(otStack.isEmpty()
                            || brace.contains(otStack.peek())
                            || otStack.peek() == '+' || otStack.peek() == '-'){
                        otStack.push(c);
                    }else{
                        // 否则遇到*或/则一直做弹栈计算，直到栈顶是优先级比自己低的符号，最后入栈
                        while(!otStack.isEmpty()
                                && otStack.peek() != '+' && otStack.peek() != '-'
                                && !brace.contains(otStack.peek()))
                            popAndCal(opStack, otStack);
                        otStack.push(c);
                    }
                } else {
                    // 如果是正括号就压栈
                    if(brace.contains(c))
                        otStack.push(c);
                    else{
                        // 反括号就一直做弹栈计算，直到遇到正括号为止
                        char r = getBrace(c);
                        while(otStack.peek() != r){
                            popAndCal(opStack, otStack);
                        }
                        // 最后弹出正括号
                        otStack.pop();
                    }
                }
            }
        }
        // 将剩下的计算完，直到运算符栈为空
        while(!otStack.isEmpty())
            popAndCal(opStack, otStack);
        // 返回结果
        return opStack.pop();
    }
    private static void popAndCal(Stack<Integer> opStack, Stack<Character> otStack){
        int op2 = opStack.pop();
        int op1 = opStack.pop();
        char ot = otStack.pop();
        int res = 0;
        switch(ot){
            case '+':
                res = op1 + op2;
                break;
            case '-':
                res = op1 - op2;
                break;
            case '*':
                res = op1 * op2;
                break;
            case '/':
                res = op1 / op2;
                break;
        }
        opStack.push(res);
    }
    private static char getBrace(char brace){
        switch(brace){
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return '#';
    }


    /**
     *输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
     * 链表结点定义如下：
     * struct ListNode
     * {
     * int       m_nKey;
     * ListNode* m_pNext;
     * };
     * 详细描述：
     * 接口说明
     * 原型：
     * ListNode* FindKthToTail(ListNode* pListHead, unsignedint k);
     * 输入参数：
     * ListNode* pListHead  单向链表
     * unsigned int k  倒数第k个结点
     * 输出参数（指针指向的内存区域保证有效）：
     * 无
     * 返回值：
     * 正常返回倒数第k个结点指针，异常返回空指针
     * 输入描述:
     * 输入说明
     * 1 输入链表结点个数
     * 2 输入链表的值
     * 3 输入k的值
     * 输出描述:
     * 输出一个整数
     * 示例1
     * 输入
     * 复制
     * 8
     * 1 2 3 4 5 6 7 8
     * 4
     * 输出
     * 复制
     * 5
     */
    public static void test57(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            int[] values = new int[num];
            for (int i = 0; i < num; i++) {
                values[i]=in.nextInt();
            }
            int k = in.nextInt();
            //初始化链表
            Node head = createList(values);
            //找到倒数第K个链表节点
            if(k==0){
                System.out.println(0);
            }else{
                Node result = lastKValueList(head, k);
                System.out.println(result.value);
            }

        }
        in.close();
    }

    public static Node createList(int[] values) {
        if(values.length<=0){
            return null;
        }
        Node head = new Node(values[0]);//创建头节点
        Node temp = head;//将头节点对象的地址赋值给temp
        for(int i=1;i<values.length;i++){
            temp.next = new Node(values[i]);//实际上指明了头结点的next节点
            temp = temp.next;//将下一个结点，赋值给temp,即对下一个结点操作
        }
        return head;//得到一个以head为头结点的单向链表，有点递归的味道
    }

    public static Node lastKValueList(Node head, int k) {
        Node fast = head;
        Node slow = head;

        for(int i=0;i<k-1;i++){
            fast = fast.next;//先顺着数k-1个结点
        }

        while(fast.next != null){//由于前面数了k-1个结点，则只能输出倒数k个结点
            //总结点数为n,fast还能走n-k个点，也是slow结点能走的点数，但是倒数就是，n-(n-k)=k个点
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     *Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。编辑距离的算法是首先由俄国科学家Levenshtein提出的，故又叫Levenshtein Distance。
     * Ex：
     * 字符串A:abcdefg
     * 字符串B: abcdef
     * 通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
     * 要求：
     * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
     * 输入描述:
     * 输入两个字符串
     * 输出描述:
     * 得到计算结果
     * 示例1
     * 输入
     * 复制
     * abcdefg
     * abcdef
     * 输出
     * 复制
     * 1
     */
    public static void test56(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(calStringDistance(str1,str2));
        }
    }

    public static int calStringDistance(String str1, String str2){
        int[][] arr = new int[str1.length()+1][str2.length()+1];
        for(int i = 0;i<=str2.length();i++){
            arr[0][i] = i;
        }
        for(int i = 0;i<=str1.length();i++){
            arr[i][0] = i;
        }
        for(int i=1;i<=str2.length();i++){
            for(int j=1;j<=str1.length();j++){
                int u1 = arr[j-1][i-1];
                if(str1.charAt(j-1)!=str2.charAt(i-1))
                    u1++;
                int u2 = arr[j-1][i]+1;
                int u3 = arr[j][i-1]+1;
                arr[j][i] = Math.min(Math.min(u1, u2),u3);
            }
        }
        return arr[str1.length()][str2.length()];
    }

    /**
     *          1
     *          1  1  1
     *       1  2  3  2  1
     *    1  3  6  7  6  3  1
     * 1  4  10 16 19  16 10  4  1
     * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
     * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
     * 输入n(n <= 1000000000)
     * 输入描述:
     * 输入一个int整数
     * 输出描述:
     * 输出返回的int值
     * 示例1
     * 输入
     * 复制
     * 4
     * 输出
     * 复制
     * 3
     */
    public static void test55(){
        Scanner cin = new Scanner(System.in) ;
        while(cin.hasNext()){
            int line = cin.nextInt() ;


            System.out.println(run(line)) ;
        }
        cin.close();
    }

    /**
     * 计算返回值
     * @param x
     * @return
     */
    public static  int run(int x){
        if(x == 1 || x == 2){
            return -1 ;
        }
        //每一行的第一个数为1，第二个数为n-1；第三个数为 n*(n-1)/2
        if(x%2 == 1){
            return 2 ;
        }else if(x*(x-1)%4 == 0){
            return 3 ;
        }
        //若前三个均不是偶数，则从第四个数开始计算，由于是对称的的，所以判断到第x行的第x个数就可以了
        for(int i = 4 ; i <= x ; i++){
            int res = cal1(x,i) ;
            if(res%2 == 0){
                return i ;
            }
        }
        return -1 ;
    }

    /**
     * 传入n,i表示第n行的第i个，返回其值，递归的方法求解
     * @param n
     * @param i
     * @return
     */
    public static int cal1(int n, int i){
        if(i > n){
            return cal1(n,2*n-i) ;
        }
        if(n == 2 && i > 0){
            return 1 ;
        }
        if(i == 1){
            return 1 ;
        }
        if(i <= 0){
            return 0 ;
        }
        int res ;
        res = cal1(n-1,i) + cal1(n-1,i-1) + cal1(n-1,i-2) ;
        return res ;
    }

    /**
     *给定一个字符串描述的算术表达式，计算出结果值。
     * 输入字符串长度不超过100，合法的字符包括”+, -, *, /, (, )”，”0-9”，字符串内容的合法性及表达式语法的合法性由做题者检查。本题目只涉及整型计算。
     * 输入描述:
     * 输入算术表达式
     * 输出描述:
     * 计算出结果值
     * 示例1
     * 输入
     * 复制
     * 400+5
     * 输出
     * 复制
     * 405
     */
    public static void test54(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
            List<String> all=new ArrayList<>();
            int len=str.length();
            for(int i=0;i<len;){
                if(str.charAt(i)>=40 && str.charAt(i)<=47){
                    all.add(String.valueOf(str.charAt(i)));
                    i++;
                    continue;
                }else if(str.charAt(i)>=48 && str.charAt(i)<=57){
                    if(i==len-1){
                        all.add(str.substring(i));
                        break;
                    }else{
                        int j=0;
                        for(j=i+1;j<len;j++){
                            if(str.charAt(j)>=40 && str.charAt(j)<=47){//非数字
                                all.add(str.substring(i, j));
                                all.add(str.substring(j, j+1));
                                i=j+1;
                                break;
                            }
                        }
                        if(j==len-1 && str.charAt(j)>=48 && str.charAt(j)<=57){
                            all.add(str.substring(i, len));
                            break;
                        }
                    }
                }
            }
            //读入完毕，all里面存放所有的元素，包括数字和符号

            //下面开始算法：利用栈，将中缀转换为后缀
            List<String> number=new ArrayList<>();
            Stack<String> symbol=new Stack<>();
            int len2=all.size();
            for(int i=0;i<len2;i++){
                String temp=all.get(i);
                if(!temp.equals("(") && !temp.equals(")") && !temp.equals("+") && !temp.equals("-") && !temp.equals("*") && !temp.equals("/")){//如果是数字,则加入List number
                    number.add(temp);
                }
                else if(temp.equals("(") || temp.equals("*") || temp.equals("/")){//如果是开括号，则进入符号栈
                    symbol.push(temp);
                }
                else if(temp.equals(")")){//如果是闭括号，则将对应的开括号之前的符号存入数字栈
                    for(int j=symbol.size()-1;j>=0;j--){
                        String ch=symbol.pop();
                        if(!ch.equals("("))
                            number.add(ch);
                        else if(ch.equals("("))
                            break;
                    }
                }
                else if(temp.equals("+") || temp.equals("-")){
                    if(symbol.size()==0 || (symbol.size()>=1 && symbol.get(symbol.size()-1).equals("(")))
                        symbol.push(temp);
                    else{
                        for(int j=symbol.size()-1;j>=0;j--){
                            String ch=symbol.get(symbol.size()-1);
                            if(!ch.equals("("))
                                number.add(symbol.pop());
                            else
                                break;
                        }
                        symbol.push(temp);
                    }
                }
            }
            int len3=symbol.size();
            for(int i=0;i<len3;i++)
                number.add(symbol.pop());
            //构造后缀完成

            //求表达式的值
            int len4=number.size();
            Stack<Integer> newNumber=new Stack<>();
            for(int i=0;i<len4;i++){
                String temp=number.get(i);
                if(!temp.equals("(") && !temp.equals(")") && !temp.equals("+") && !temp.equals("-") && !temp.equals("*") && !temp.equals("/"))//数字的话，直接入栈
                    newNumber.push(Integer.parseInt(temp));
                else{//如果是运算符号，则两个出栈，运算以后再入栈
                    int n1=newNumber.pop();
                    int n2=newNumber.pop();
                    int n3=0;
                    if(temp.equals("+"))
                        n3=n2+n1;
                    else if(temp.equals("-"))
                        n3=n2-n1;
                    else if(temp.equals("*"))
                        n3=n2*n1;
                    else if(temp.equals("/"))
                        n3=n2/n1;
                    newNumber.push(n3);
                }
            }
            System.out.println(newNumber.pop());
        }
        sc.close();
    }

    /**
     *输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
     *
     * 输入描述:
     * 一个正整数N。(N不大于30000)
     *
     * 输出描述:
     * 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
     * 示例1
     * 输入
     * 复制
     * 20
     * 输出
     * 复制
     * 3
     */
    public static void test53(){
        Scanner scStr = new Scanner(System.in); //从键盘获取字符串
        while (scStr.hasNext()){
            int count= scStr.nextInt();              //将Scanner对象中的内容以字符串的形式取出来
            int count1=count;int count2=0;
            Vector<Integer> store=new Vector<Integer>();
            for(int i=1;i<count1+1;i++){
                if(i%7==0){
                    store.addElement(i);  count2++;
                }
                else{
                    //将i拆分成字符串形式
                    int sqy=0;int mxf=0;
                    mxf=i;
                    while(true){
                        sqy=mxf-(mxf/10)*10;
                        if(sqy==7){
                            store.addElement(i);count2++;
                            break;
                        } //一位一位开始break，一旦各位开始就break
                        mxf=(mxf/10);
                        if(mxf==0){ //如果为0跳出循环
                            break;
                        }
                    }
                }//else
            }
            System.out.println(count2);
        }

    }


    /**
     * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
     * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
     * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
     * 给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
     * 返回n以内完全数的个数。 异常情况返回-1
     * *  完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
     *  *  它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
     *  *  例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
     *  *  给定函数count(int n),用于计算n以内(含n)完全数的个数
     *  * @param n  计算范围, 0 < n <= 500000
     *  * @return n 以内完全数的个数, 异常情况返回-1
     *  输入描述:
     * 输入一个数字
     * 输出描述:
     * 输出完全数的个数
     * 示例1
     * 输入
     * 复制
     * 1000
     * 输出
     * 复制
     * 3
     */
    public static void test52(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(count(n));
        }

        scanner.close();
    }
    private static int count(int n) {

        int result = 0;

        for (int i = 2; i < n; i++) {
            int sum = 1;
            int sqrt = i / 2;
            for (int j = 2; j <= sqrt; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }

            if (sum == i) {
                result++;
            }
        }

        return result;
    }


    /**
     * 在计算机中，由于处理器位宽限制，只能处理有限精度的十进制整数加减法，比如在32位宽处理器计算机中，
     * 参与运算的操作数和结果必须在-2^31~2^31-1之间。如果需要进行更大范围的十进制整数加法，需要使用特殊
     * 的方式实现，比如使用字符串保存操作数和结果，采取逐位运算的方式。如下：
     * 9876543210 + 1234567890 = ?
     * 让字符串 num1="9876543210"，字符串 num2="1234567890"，结果保存在字符串 result = "11111111100"。
     * -9876543210 + (-1234567890) = ?
     * 让字符串 num1="-9876543210"，字符串 num2="-1234567890"，结果保存在字符串 result = "-11111111100"。
     * 要求编程实现上述高精度的十进制加法。
     * 要求实现方法：
     * public String add (String num1, String num2)
     * 【输入】num1：字符串形式操作数1，如果操作数为负，则num1的前缀为符号位'-'
     * num2：字符串形式操作数2，如果操作数为负，则num2的前缀为符号位'-'
     * 【返回】保存加法计算结果字符串，如果结果为负，则字符串的前缀为'-'
     * 注：
     * (1)当输入为正数时，'+'不会出现在输入字符串中；当输入为负数时，'-'会出现在输入字符串中，且一定在输入字符串最左边位置；
     * (2)输入字符串所有位均代表有效数字，即不存在由'0'开始的输入字符串，比如"0012", "-0012"不会出现；
     * (3)要求输出字符串所有位均为有效数字，结果为正或0时'+'不出现在输出字符串，结果为负时输出字符串最左边位置为'-'。
     * 输入描述:
     * 输入两个字符串
     * 输出描述:
     * 输出给求和后的结果
     * 示例1
     * 输入
     * 复制
     * 9876543210
     * 1234567890
     * 输出
     * 复制
     * 11111111100
     */
    public static void test51(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            BigInteger c = new BigInteger(a);
            BigInteger d = new BigInteger(b);
            System.out.println(c.add(d));
        }

    }

    /**
     * 输入n个整数，输出其中最小的k个。
     * 详细描述：
     * 接口说明
     * 原型：
     * bool GetMinK(unsignedint uiInputNum, int * pInputArray, unsignedint uiK, int * pOutputArray);
     * 输入参数：
     * unsignedint uiInputNum //输入整数个数
     * int * pInputArray  //输入整数数组
     * unsignedint uiK   //需输出uiK个整数
     * 输出参数（指针指向的内存区域保证有效）：
     * int * pOutputArray //最小的uiK个整数
     * 返回值：
     * false 异常失败
     * true  输出成功
     * 本题有多组输入样例，请使用while(cin>>)等方式处理
     * 输入描述:
     * 输入说明
     * 1 输入两个整数
     * 2 输入一个整数数组
     *
     * 输出描述:
     * 输出一个整数数组
     *
     * 示例1
     * 输入
     * 复制
     * 5 2
     * 1 3 5 7 2
     * 输出
     * 复制
     * 1 2
     */
    public static void test50(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
            {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            int i = 0;
            for (; i < k - 1; i++)
                System.out.print(arr[i] + " ");
            System.out.println(arr[i]);
        }
    }

    /**
     * 找出字符串中第一个只出现一次的字符
     * 输入描述:
     * 输入一个非空字符串
     *
     * 输出描述:
     * 输出第一个只出现一次的字符，如果不存在输出-1
     * 输入
     * asdfasdfo
     * 输出
     * o
     */
    public static void test49(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {

            String str = scanner.nextLine();
            if (str == null || str.length() == 0)
                System.out.println(-1);
            else if (str.length() == 1)
                System.out.println(str);
            else
            {
                char res = '#';
                for (int i = 0; i <= str.length() - 1; i++)
                {
                    char c = str.charAt(i);
                    if (i == 0)
                    {
                        String sub = str.substring(i + 1);
                        if (sub.contains(c + ""))
                            continue;
                        else
                        {
                            res = c;
                            break;
                        }
                    }
                    else if (i == str.length() - 1)
                    {
                        String sub = str.substring(0, i);
                        if (sub.contains(c + ""))
                            continue;
                        else
                        {
                            res = c;
                            break;
                        }
                    }
                    else
                    {
                        String sub1 = str.substring(0, i);
                        String sub2 = str.substring(i + 1);
                        if (sub1.contains(c + "") || sub2.contains(c + ""))
                            continue;
                        else
                        {
                            res = c;
                            break;
                        }
                    }
                }
                if (res == '#')
                    System.out.println(-1);
                else
                    System.out.println(res);
            }
        }

    }


    /**
     * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对
     * 输入描述:
     * 输入一个偶数
     * 输出描述:
     * 输出两个素数
     * 示例1
     * 输入
     * 复制
     * 20
     * 输出
     * 复制
     * 7
     * 13
     */
    public static void test48(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(findPrime(n));
        }

        scanner.close();
    }
    private static String findPrime(int n) {

        for (int i = n / 2; i >= 2; i--) {
            if (isPrime(i) && isPrime(n - i)) {
                return i + "\n" + (n - i);
            }
        }

        return null;
    }

    private static boolean isPrime(int n) {//判断n是否为素数（也叫质数）
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }


    /**
     * 题目描述
     * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
     * 输入
     * 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
     * 计算放苹果方法数目
     * * 输入值非法时返回-1
     * * 1 <= m,n <= 10
     * * @param m 苹果数目
     * * @param n 盘子数目数
     * * @return 放置方法总数
     * 输入描述:
     * 输入两个int整数
     *
     * 输出描述:
     * 输出结果，int型
     * 样例输入
     * 7 3
     * 样例输出
     * 8
     */
    public static void test47(){ // 61 空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
        Scanner in = new Scanner(System.in);
            int N, M; // M Apple, N Disk
            M = in.nextInt();
            N = in.nextInt();
            System.out.print(cal(M, N));

    }

    private static int cal(int m, int n) {
        if (m < 0)
            return 0;
        if (m == 0 || n == 1)
            return 1;
        return cal(m - n, n) + cal(m, n - 1);

    }


    /**
     * 题目：查找输入整数二进制中1的个数
     * 请实现如下接口
     *
     * public static int findNumberOf1( int num)
     * {
             *return 0;
             *
} 譬如：输入5 ，5的二进制为101，输出2
        *
        *
        *涉及知识点：
        *
        *注意多组输入输出！！！！！！
        *输入描述:
        *输入一个整数
        *
        *输出描述:
        *计算整数二进制中1的个数
     */
    public static void test46(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int num = scanner.nextInt();
            System.out.println(Main.findNumberOf1(num));
        }
    }


    public  static  int  findNumberOf1( int num)
    {
        String str = Integer.toBinaryString(num);
        int numOfOne = 0;
        for(int i=0;i<str.length();i++){
            if('1' == str.charAt(i)){
                numOfOne++;
            }
        }
        return  numOfOne;
    }

    /**
     * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
     * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
     *
     * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
     * 输入一个string型基因序列，和int型子串的长度
     *
     * 输出描述:
     * 找出GC比例最高的子串,如果有多个输出第一个的子串
     * 示例1
     * 输入
     * 复制
     * AACTGTGCACGACCTGA
     * 5
     * 输出
     * 复制
     * GCACG
     */
    public static void test45(){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int n=sc.nextInt();
        int max=0;
        int maxIndex=0;
        //String res="";
        for(int i=0;i<=str.length()-n;i++){
            //String sub=str.substring(i,i+n);//截取子串
            int count=0;
            for(int j=i;j<i+n;j++){
                if(str.charAt(j)=='C'||str.charAt(j)=='G'){
                    count++;
                }
                if(count>max){
                    max=count;
                    maxIndex=i;
                }
            }
        }
        System.out.println(str.substring(maxIndex,maxIndex+n));
    }

    /**
     * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
     * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
     * 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
     * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
     * 输入描述:
     * 输入说明：
     * 1 输入歌曲数量
     * 2 输入命令 U或者D
     *
     * 输出描述:
     * 输出说明
     * 1 输出当前列表
     * 2 输出当前选中歌曲
     *
     * 示例1
     * 输入
     * 复制
     * 10
     * UUUU
     * 输出
     * 复制
     * 7 8 9 10
     * 7
     */
    public static void test44(){
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String command = scanner.next();
//            System.out.println(num + " " + command);
            System.out.println(locatePointer(num, command));
        }
        scanner.close();
    }


    private static String locatePointer(int num, String command) {

        if (num < 5) {
            return lessThan5(num, command);
        } else {
            return greatThan4(num, command);
        }


    }

    /**
     * 求光标的位置，歌曲数大于4
     *
     * @param num     总共的歌曲数目
     * @param command 命令
     * @return 当前选中歌曲
     */
    private static String greatThan4(int num, String command) {
        int curr = 1;
        // 屏幕可以显示的第一个光标
        int top = 1;
        // 屏幕可以显示的最后一个光标
        int bot = 4;


        StringBuilder builder = new StringBuilder(command.length() * 2);

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            // 如果是向上的
            if (c == 'U') {
                curr--;

                // 如果翻到第一首歌的上面
                if (curr < 1) {
                    curr = num;
                    // 更新窗口可以显示的范围
                    bot = num;
                    top = num - 3;
                }
                // 非第一首歌上面
                else {
                    // 已经超过显示的范围
                    if (curr < top) {
                        top = curr;
                        bot = curr + 3;
                    }
                }
            } else if (c == 'D') {
                curr++;

                // 如果翻到最后一首歌的下面了
                if (curr > num) {
                    curr = 1;

                    // 更新窗口可以显示的范围
                    bot = 4;
                    top = 1;
                }
                // 不是最后一首歌
                else {
                    // 已经超过显示的范围
                    if (curr > bot) {
                        bot = curr;
                        top = curr - 3;
                    }
                }
            }

            // 如果是最后一个命令，记录页面显示的范围和光标的位置
            if (i == command.length() - 1) {
                for (int j = top; j <= bot; j++) {
                    // 计录光标的范围
                    builder.append(j).append(' ');
                }
                builder.setCharAt(builder.length() - 1, '\n');
                // 计录光标的位置
                builder.append(curr).append('\n');
            }
        }


        return builder.substring(0, builder.length() - 1);
    }

    /**
     * 求光标的位置，歌曲数小于5
     *
     * @param num     总共的歌曲数目
     * @param command 命令
     * @return 当前选中歌曲
     */
    private static String lessThan5(int num, String command) {

        StringBuilder builder = new StringBuilder(command.length() * 2);

        // 当前光标的位置，以0计
        int curr = 0;
        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);
            if (c == 'U') {
                curr = (curr - 1 + num) % num;

            } else if (c == 'D') {
                curr = (curr + 1 + num) % num;
            }

            // 如果是最后一个命令，记录页面显示的范围和光标的位置
            if (i == command.length() - 1) {
                for (int j = 1; j <= num; j++) {
                    // 计录光标的范围
                    builder.append(j).append(' ');
                }
                builder.setCharAt(builder.length() - 1, '\n');
                // 计录光标的位置
                builder.append(curr + 1).append('\n');
            }


        }

        return builder.substring(0, builder.length() - 1);
    }

    /**
     * 找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
     * 输入描述:
     * 输入两个字符串
     * 输出描述:
     * 返回重复出现的字符
     * 示例1
     * 输入
     * 复制
     * abcdefghijklmnop
     * abcsafjklmnopqrstuvw
     * 输出
     * 复制
     * jklmnop
     */
    public static void test43(){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s = null;
            String longstring = (s1.length()>s2.length())?s1:s2;
            String shortstring = (s1.length()<s2.length())?s1:s2;
            int len = 0;
            for (int i = 0;i<shortstring.length();i++){
                for(int j=i+1;j<shortstring.length();j++){
                    if(longstring.contains(shortstring.substring(i,j+1))){
                        if(len < j-i){
                            len = j-i;
                            s = shortstring.substring(i,j+1);
                        }
                    }
                }
            }
            System.out.println(s);
        }
    }

    /**
     * 有6条配置命令，它们执行的结果分别是：
     *
     * 命   令	执   行
     * reset	reset what
     * reset board	board fault
     * board add	where to add
     * board delet	no board at all
     * reboot backplane	impossible
     * backplane abort	install first
     * he he	unkown command
     * 注意：he he不是命令。
     *
     * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
     * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
     * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unkown command
     * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unkown command。
     *
     * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
     * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
     * 6、若匹配失败，打印“unkown command”
     * 输入描述:
     * 输入描述:
     * 多行字符串，每行字符串一条命令
     *
     * 输出描述:
     * 执行结果，每条命令输出一行
     *
     * 示例1
     * 输入
     * 复制
     * reset
     * reset board
     * board add
     * board delet
     * reboot backplane
     * backplane abort
     * 输出
     * 复制
     * reset what
     * board fault
     * where to add
     * no board at all
     * impossible
     * install first
     */
    public static void test42() throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> hMap = new HashMap<>();
        hMap.put("reset", "reset what");
        hMap.put("reset board", "board fault");
        hMap.put("board add", "where to add");
        hMap.put("board delet", "no board at all");
        hMap.put("reboot backplane", "impossible");
        hMap.put("backplane abort", "install first");
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            if(hMap.containsKey(strs)){
                System.out.println(hMap.get(strs));
            }else{
                System.out.println("unkown command");
            }
        }
        sc.close();
    }

    /**
     * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
     * 输入：
     * 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字]
     * 输出：
     * true or false
     *
     * 输入描述:
     * 输入4个int整数
     *
     * 输出描述:
     * 返回能否得到24点，能输出true，不能输出false
     * 示例1
     * 输入
     * 复制
     * 7 2 1 10
     * 输出
     * 复制
     * true
     */
    public static void test41() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] strs = line.split(" ");
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < 4; i++) {
                list.add(Integer.parseInt(strs[i]));
            }
            boolean flag = fun(list);
            System.out.println(flag);
        }
    }

    public static boolean fun(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);
            if (getResult(list, temp)) {
                return true;
            }
            list.add(i, temp);
        }
        return false;
    }

    public static boolean getResult(List<Integer> list, int temp) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                list.remove(i);
                if (getResult(list, temp * n) || getResult(list, temp + n) || getResult(list, temp - n)) {
                    return true;
                } else if (temp % n == 0) {
                    if (getResult(list, temp / n)) {
                        return true;
                    }
                }
                list.add(i, n);
            }
            return false;
        } else {
            if (temp == 24) {
                return true;
            } else {
                return false;
            }
        }
    }


    /**
     * 查找和排序
     *
     * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
     * 都按先录入排列在前的规则处理。
     *
     * 例示：
     * jack      70
     * peter     96
     * Tom       70
     * smith     67
     *
     * 从高到低  成绩
     * peter     96
     * jack      70
     * Tom       70
     * smith     67
     *
     * 从低到高
     *
     * smith     67
     *
     * Tom       70
     * jack      70
     *
     * peter     96
     * 注：0代表从高到低，1代表从低到高
     * 输入描述:
     * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
     *
     * 输出描述:
     * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
     *
     * 示例1
     * 输入
     * 复制
     * 3
     * 0
     * fang 90
     * yang 50
     * ning 70
     * 输出
     * 复制
     * fang 90
     * ning 70
     * yang 50
     */
    public static void test40(){//成绩排序
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int option = sc.nextInt();//排序方法
            List<Person> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new Person(sc.next(),sc.nextInt()));
            }
            if(option == 0){//降序
                list.sort((o1,o2) -> o2.score-o1.score);
            }else if(option == 1){
                list.sort((o1,o2) -> o1.score-o2.score);
            }
            for(Person person :list ){
                System.out.println(person.name+" "+person.score);
            }
        }
    }

    /**
     * 题目：矩阵乘法
     * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
     * 输入包含多组数据，每组数据包含：
     * 第一行包含一个正整数x，代表第一个矩阵的行数
     * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
     * 第三行包含一个正整数z，代表第二个矩阵的列数
     * 之后x行，每行y个整数，代表第一个矩阵的值
     * 之后y行，每行z个整数，代表第二个矩阵的值
     * 输出描述:
     * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
     * 示例1
     * 输入
     * 复制
     * 2
     * 3
     * 2
     * 1 2 3
     * 3 2 1
     * 1 2
     * 2 1
     * 3 3
     * 输出
     * 复制
     * 14 13
     * 10 11
     */
    public static void test39(){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext())
        {
            int row1=scan.nextInt();    //第一个矩阵的行
            int column1=scan.nextInt(); //第一个矩阵的列
            int row2=column1;    //第二个矩阵的行
            int column2=scan.nextInt(); //第二个矩阵的列

            int[][] num1=new int[row1][column1];//定义一个数组接收第一个矩阵
            int[][] num2=new int[row2][column2];//定义一个数组接收第二个矩阵
            int[][] result=new int[row1][column2];//定义一个数组储存计算结果
            //接收输入的矩阵
            for(int i=0;i<row1;i++){
                for(int j=0;j<column1;j++){
                    num1[i][j]=scan.nextInt();
                }
            }
            for(int i=0;i<row2;i++){
                for(int j=0;j<column2;j++){
                    num2[i][j]=scan.nextInt();
                }
            }
            //计算并赋值
            for(int i=0;i<row1;i++){
                for(int j=0;j<column2;j++){
                    for(int k=0;k<column1;k++){
                        result[i][j] += num1[i][k]*num2[k][j];
                    }
                }
            }
            //输出结果
            for(int i=0;i<row1;i++ ){
                for (int j=0;j<column2;j++){
                    if(j==column2-1)
                        System.out.print(result[i][j]);
                    else
                        System.out.print(result[i][j]+" ");
                }
                System.out.println();
            }
        }

    }

    /**
     *题目：矩阵乘法计算量估值
     * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
     * 例如：
     *     A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
     * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
     * 编写程序计算不同的计算顺序需要进行的乘法次数
     * 输入描述:
     * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
     *
     * 输出描述:
     * 输出需要进行的乘法次数
     *
     * 示例1
     * 输入
     * 复制
     * 3
     * 50 10
     * 10 20
     * 20 5
     * (A(BC))
     * 输出
     * 复制
     * 3500
     */
    public static void test38(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[n][2];
            for(int i=0; i<n; i++) {
                String str = in.nextLine();
                String[] temp =str.split(" ");
                matrix[i][0] = Integer.parseInt(temp[0]);
                matrix[i][1] = Integer.parseInt(temp[1]);
            }
            String rule = in.nextLine();

            int result = calculate(matrix,rule );
            System.out.println(result);
        }
        in.close();
    }
    // 若矩阵表达式为(A(BC(D(EF)))), 首先将表达式化成(A(X(D(Y)))), 然后通过找")"依次计算
    private static int calculate(int[][] matrix, String rule) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i=0; i<rule.length(); i++) {
            char item = rule.charAt(i);
            if (Character.isLetter(item)) {   //若为一个矩阵
                if (!stack.isEmpty() && stack.peek() != -1) { //栈顶不为"("时, 计算矩阵并合并
                    int col = stack.pop();
                    int row = stack.pop();
                    int col2 = matrix[index][1];
                    result += row * col * col2;

                    stack.push(row);
                    stack.push(col2);
                } else {
                    stack.push(matrix[index][0]);
                    stack.push(matrix[index][1]);
                }
                index++;
            }else if (item == '(') {
                stack.push(-1);//代表该位置为"("
            }else if (item == ')') {
                int col1 = stack.pop();  //弹出栈顶的矩阵
                int row1 = stack.pop();
                stack.pop();             //弹出"("
                if (stack.size() <= 1) {
                    return result;
                }
                if (stack.peek() != -1) { //若栈顶不为"(", 弹出栈顶矩阵并计算
                    stack.pop();  //col2 排在前面的矩阵
                    int row2 = stack.pop();
                    result += row2 * row1 * col1;
                    row1 = row2;
                }
                stack.push(row1);
                stack.push(col1);
            }
        }
        return result;
    }

    /**
     * 正则匹配*和？
     * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
     * 要求：
     * 实现如下2个通配符：
     * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
     * ？：匹配1个字符
     * 输入：
     * 通配符表达式；
     * 一组字符串。
     * 输出：
     * 返回匹配的结果，正确输出true，错误输出false
     */
    public static void test37(){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.next();
            String str2=sc.next();
            int[][]dp=new int[str1.length()+1][str2.length()+1];
            for(int i=1;i<str1.length()+1;i++){
                for (int j=1;j<str2.length()+1; j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }else {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            if(str1.replaceAll("[?*]","").length()==dp[str1.length()][str2.length()]){
                System.out.println(true);
            }else {
                System.out.println(false);
            }


        }
    }

    /**
     * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
     * 详细描述：
     * 接口说明
     * 原型：
     * int GetResult(vector &list)
     * 输入参数：
     *         无
     * 输出参数（指针指向的内存区域保证有效）：
     *     list  鸡翁、鸡母、鸡雏组合的列表
     * 返回值：
     *      -1 失败
     *      0 成功
     *      输入描述:
     * 输入任何一个整数，即可运行程序。
     *
     * 输出描述:
     *
     *
     * 示例1
     * 输入
     * 复制
     * 1
     * 输出
     * 复制
     * 0 25 75
     * 4 18 78
     * 8 11 81
     * 12 4 84
     */
    public static void test36(){//空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
            int max4=0;
//公：100%5=20
            for(int i=0;i<=20;i++){
                //母：100%3=33.33....
                for (int j=1;j<=33;j++){
                    //小鸡数量
                    int z = 100 - i - j;
                    if((i*5 + j*3 + z/3 == 100) && z%3 == 0)
                    {
                        max4++;
//                    System.out.println("公鸡的只数：" + i + "  " + "母鸡的只数：" + j + "  " + "小鸡的只数：" + z);
                        System.out.println("  "+i + "  " + j + "  " + z);
                    }
                }
            }

    }

    /**
     * 题目：计算日期到天数转换
     * 根据输入的日期，计算是这一年的第几天。。
     * 详细描述：
     * 输入某年某月某日，判断这一天是这一年的第几天？。
     * 输入描述:
     * 输入三行，分别是年，月，日
     *
     * 输出描述:
     * 成功:返回outDay输出计算后的第几天;
     *                                            失败:返回-1
     *
     * 示例1
     * 输入
     * 复制
     * 2012
     * 12
     * 31
     * 输出
     * 复制
     * 366
     */
    public static void test35(){
        int[] leapYear= {0,31,60,91,121,152,182,213,244,274,305,335,366};//闰年
        int[] commonYear= {0,31,59,90,120,151,181,212,243,273,304,334,365};//平年
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int year=input.nextInt();
            int month=input.nextInt();
            int day=input.nextInt();
            int sumDays=0;
            if(month>12||month<1) {
                System.out.println("请输入正确的月份!");
            }else{
                //判断是否为闰年
                if((year%4==0&&year%100!=0)||year%400==0) {
                    //天数为31天的月份
                    if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
                        //判断天数是否在31天之内
                        if(day<1||day>31) {
                            System.out.println("请输入正确的天数!");
                        }else {
                            sumDays=leapYear[month-1]+day;
                        }
                    }else if(month==2) {
                        //判断天数是否在28天之内
                        if(day<1||day>28) {
                            System.out.println("请输入正确的天数!");
                        }else {
                            sumDays=leapYear[month-1]+day;
                        }
                    }else {//为4、6、9、11月中的一月
                        //判断天数是否在30天之内
                        if(day<1||day>30) {
                            System.out.println("请输入正确的天数!");
                        }else {
                            sumDays=leapYear[month-1]+day;
                        }
                    }
                }else {
                    //为平年
                    //天数为31天的月份
                    if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
                        //判断天数是否在31天之内
                        if(day<1||day>31) {
                        }else {
                            sumDays=commonYear[month-1]+day;
                        }
                    }else if(month==2) {
                        //判断天数是否在29天之内
                        if(day<1||day>29) {
                        }else {
                            sumDays=commonYear[month-1]+day;
                        }
                    }else {//为4、6、9、11月中的一月
                        //判断天数是否在30天之内
                        if(day<1||day>30) {
                        }else {
                            sumDays=commonYear[month-1]+day;
                        }
                    }
                }
            }
            System.out.println(sumDays);
        }

    }

    /**
     * 题目：参数解析
     * 在命令行输入如下命令：
     * xcopy /s c:\ d:\，
     * 各个参数如下：
     * 参数1：命令字xcopy
     * 参数2：字符串/s
     * 参数3：字符串c:\
     * 参数4: 字符串d:\
     * 请编写一个参数解析程序，实现将命令行各个参数解析出来。
     * 解析规则：
     * 1.参数分隔符为空格
     * 2.对于用“”包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s “C:\program files” “d:\”时，参数仍然是4个，第3个参数应该是字符串C:\program files，而不是C:\program，注意输出参数时，需要将“”去掉，引号不存在嵌套情况。
     * 3.参数不定长
     * 4.输入由用例保证，不会出现不符合要求的输入
     * 输入描述:
     * 输入一行字符串，可以有空格
     *
     * 输出描述:
     * 输出参数个数，分解后的参数，每个参数都独占一行
     *
     * 示例1
     * 输入
     * 复制
     * xcopy /s c:\\ d:\\
     * 输出
     * 复制
     * 4
     * xcopy
     * /s
     * c:\\
     * d:\\
     */
    public static void test34(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int len = 0;
        int quotaNum = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '\"'){ quotaNum++; continue;
            }
            if (str.charAt(i) != ' '){
                sb.append(str.charAt(i));
            } else if (quotaNum % 2 == 0){ sb.append('\n');
            len++;
            }else {
                sb.append(' ');
            }
        }
        System.out.println(len+1);
        System.out.println(sb.toString());
    }

    /**
     * 题目：公共字串计算
     * 计算两个字符串的最大公共字串的长度，字符不区分大小写
     * 详细描述：
     * 接口说明
     * 原型：
     * int getCommonStrLength(char * pFirstStr, char * pSecondStr);
     * 输入参数：
     *      char * pFirstStr //第一个字符串
     *      char * pSecondStr//第二个字符串
     *      输入描述:
     * 输入两个字符串
     *
     * 输出描述:
     * 输出一个整数
     *
     * 示例1
     * 输入
     * 复制
     * asdfas
     * werasdfaswer
     * 输出
     * 复制
     * 6
     */
    public static void test33(){
        Scanner sc=new Scanner(System.in);
        String str1 = sc.next().toLowerCase();
        String str2 = sc.next().toLowerCase();
        sc.close();
        System.out.println(getCommonStrLength(str1, str2));
    }
    public static int getCommonStrLength(String str1,String str2){
        int length=0;
        /**
         * 定义两个for循环遍历整个字符串，这样字符串每一个字段都能便利到
         * 注意这里都是i <= str1.length()，因为使用substring()，如果只是 i<str1.length(), 会导致最后一个字符读取不到
         */
        for(int i=0;i<=str1.length();i++){
            for(int j=0;j<=str1.length();j++){
                if(i+j<=str1.length()){
                    if(str2.contains(str1.substring(j, i+j))){
                        if(length<=str1.substring(j, i+j).length())
                            length=str1.substring(j, i + j).length();
                    }
                }
            }
        }
        return length;
    }

    /**
     * 功能: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
     *  原型：
     *      int GetSequeOddNum(int m,char * pcSequeOddNum);
     *  输入参数：
     *      int m：整数(取值范围：1～100)
     *
     *  返回值：
     *      m个连续奇数(格式：“7+9+11”);输入描述:
     * 输入一个int整数
     *
     * 输出描述:
     * 输出分解后的string
     *
     * 示例1
     * 输入
     * 复制
     * 6
     * 输出
     * 复制
     * 31+33+35+37+39+41
     *
     */
    public static void test32(){
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int pop = in.nextInt();
            String str = Main.GetSequeOddNum(pop);
            System.out.println(str);
        }
    }
    public static String GetSequeOddNum(int m){
        StringBuilder str = new StringBuilder();
        int nums = (int)Math.pow(m,3);
        Queue<Integer> queue = new LinkedList<>();
        int sums = 0;
        int i = 0;
        for (i = 1; i < 1000000; i += 2) {
            queue.offer(i);
            if(queue.size() > m){
                sums -= queue.poll();
            }
            sums += i;
            if(sums == nums){
                break;
            }
        }
        if(i < 1000000){
            while(!queue.isEmpty()){
                str.append(queue.poll());
                if(!queue.isEmpty()){
                    str.append("+");
                }
            }
        }
        return str.toString();
    }

    /**
     * 题目：火车进站
     * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号。
     * 输入描述:
     * 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
     * 输出描述:
     * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
     * 示例1
     * 输入
     * 复制
     * 3
     * 1 2 3
     * 输出
     * 复制
     * 1 2 3
     * 1 3 2
     * 2 1 3
     * 2 3 1
     * 3 2 1
     */
    public static void test31(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //输入火车数量
            int n = in.nextInt();
            //输入火车编号
            int[] A = new int[n];
            for(int i=0;i<n;i++){
                A[i] = in.nextInt();
            }
            int start = 0;
            //计算n个火车的出站的编号的排列组合
            ArrayList<int[]> result = new ArrayList<int[]>();
            Permutation(A,start,n,result);
            //出栈的结果，一个元素一个记录，例如：1 2 3 ； 1 3 2
            Set<String> sortResult = new TreeSet<String>();
            //循环排列组合
            for(int[] out : result){
                //判断是否满足出栈要求（后进先出）
                if(isLegal(A,out,n)){
                    //满足的组合，输入结果，每一个编号用空格分隔
                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<n-1;i++){
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    sortResult.add(sb.toString());
                }
            }
            //最后输出所有的符合出栈要求的组合
            for(String list:sortResult){
                System.out. println(list);
            }
        }
        in.close();
    }
    private static boolean isLegal(int[] in,int[] out,int n){
        //栈：存储进站的火车编号
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int i=0; int j=0;
        while(i<n){
            // in 还有元素的时候都需要判断
            if(in[i] == out[j]){
                //相等时候就不用入栈，直接后移
                i++;
                j++;
            }else{
                if(stack.isEmpty()){
                    //空stack 就只有入栈了
                    stack.push(in[i]);
                    i++;
                }else{
                    int top = stack.peek();
                    // 栈顶元素相等，进行出栈
                    if(top==out[j]){
                        j++;
                        stack.pop();
                    }else if(i<n){
                        //不相等时候入栈，说明还有待进站的车
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while(!stack.isEmpty() && j<n){
            // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素相同
            int top = stack.pop();
            if(top == out[j]){
                j++;
            }else{
                return false;
            }
        }
        return true;
    }

    private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){
        if(start == n){
            return;
        }
        if(start == n-1){
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for(int i=start;i<n;i++){
            swap(A,start,i) ;
            Permutation(A,start+1,n,result);
            swap(A,start,i);
        }
    }
    private static void swap(int[] A,int i,int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    /**
     * 题目：超长正整数相加
     * 请设计一个算法完成两个超长正整数的加法。
     * 接口说明
     * 输入描述:
     * 输入两个字符串数字
     * 输出描述:
     * 输出相加后的结果，string型
     * 示例1
     * 输入
     * 复制
     * 99999999999999999999999999999999999999999999999999
     * 1
     * 输出
     * 复制
     * 100000000000000000000000000000000000000000000000000
     */
    public static void test30(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String a=sc.next();
            String b=sc.next();
            BigInteger sum=new BigInteger(a);
            BigInteger sum1=new BigInteger(b);
            BigInteger res=sum.add(sum1);
            System.out.println(res);
        }

    }
    /**
     * 题目：计算字符串的相似度
     * 对于不同的字符串，我们希望能有办法判断相似程度，我们定义了一套操作方法来把两个不相同的字符串变得相同，具体的操作方法如下：
     * 1 修改一个字符，如把“a”替换为“b”。
     * 2 增加一个字符，如把“abdd”变为“aebdd”。
     * 3 删除一个字符，如把“travelling”变为“traveling”。
     * 比如，对于“abcdefg”和“abcdef”两个字符串来说，我们认为可以通过增加和减少一个“g”的方式来达到目的。上面的两种方案，都只需要一次操作。把这个操作所需要的次数定义为两个字符串的距离，而相似度等于“距离＋1”的倒数。也就是说，“abcdefg”和“abcdef”的距离为1，相似度为1/2=0.5.
     * 给定任意两个字符串，你是否能写出一个算法来计算出它们的相似度呢？
     * 约束：
     *
     * 1、PucAExpression/ PucBExpression字符串中的有效字符包括26个小写字母。
     *
     * 2、PucAExpression/ PucBExpression算术表达式的有效性由调用者保证;
     * 3、超过result范围导致信息无法正确表达的，返回null。
     * 输入描述:
     * 输入两个字符串
     *
     * 输出描述:
     * 输出相似度，string类型
     *
     * 示例1
     * 输入
     * 复制
     * abcdef
     * abcdefg
     * 输出
     * 复制
     * 1/2
     */
    public static void test29(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String strA = in.next();
            String strB = in.next();
            int ic = 1;
            int dc = 1;
            int rc = 1;
            int cost = strEditCost(strA, strB, ic, dc, rc);
            System.out.println("1/"+ (cost+1));
        }
        in.close();
    }

    public static int strEditCost(String strA, String strB, int ic, int dc, int rc){
        int m = strA.length();
        int n = strB.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= n; i++) dp[0][i] = i*ic;
        for (int i = 1; i <= m; i++) dp[i][0] = i*dc;
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                int cost1 = dp[x-1][y] + dc;
                int cost2 = dp[x][y-1] + ic;
                int cost3 = 0;
                if(strA.charAt(x-1) == strB.charAt(y-1))
                    cost3 = dp[x-1][y-1];
                else
                    cost3 = dp[x-1][y-1] + rc;
                dp[x][y] = Math.min(cost1, cost2);
                dp[x][y] = Math.min(dp[x][y], cost3);
            }
        }
        return dp[m][n];
    }


    /**
     * 题目：整型数组合并并升序排列
     * 题目标题：
     * 将两个整型数组按照升序合并，并且过滤掉重复数组元素[注: 题目更新了。输出之后有换行]
     * 详细描述：
     * 接口说明
     * 原型：
     * voidCombineBySort(int* pArray1,intiArray1Num,int* pArray2,intiArray2Num,int* pOutputArray,int* iOutputNum);
     * 输入参数：
     * int* pArray1 ：整型数组1
     * intiArray1Num：数组1元素个数
     * int* pArray2 ：整型数组2
     * intiArray2Num：数组2元素个数
     * 输出参数（指针指向的内存区域保证有效）：
     * int* pOutputArray：合并后的数组
     * int* iOutputNum：合并后数组元素个数
     * 返回值：
     * void
     * 输入描述:
     * 输入说明，按下列顺序输入：
     * 1 输入第一个数组的个数
     * 2 输入第一个数组的数值
     * 3 输入第二个数组的个数
     * 4 输入第二个数组的数值
     * 输出描述:
     * 输出合并之后的数组
     * 示例1
     * 输入
     * 复制
     * 3
     * 1 2 5
     * 4
     * -1 0 3 2
     * 输出
     * 复制
     * -101235
     */
    public static void test28(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //输入第一个数
            int num1 = sc.nextInt();
            //tree 有序且去重复
            TreeSet<Integer> set = new TreeSet<>();
            for(int i=0;i<num1;i++){
                set.add(sc.nextInt());
            }
            int num2 = sc.nextInt();
            for(int i=0;i<num2;i++){
                set.add(sc.nextInt());
            }
            //遍历treeset
            for(int temp:set){
                System.out.print(temp);
            }
            System.out.println();
        }
        sc.close();
    }

    /**
     * 题目标题：
     * 判断短字符串中的所有字符是否在长字符串中全部出现
     * 详细描述：
     * 接口说明
     * 原型：
     * boolIsAllCharExist(char* pShortString,char* pLongString);
     * 输入参数：
     *     char* pShortString：短字符串
     *     char* pLongString：长字符串
     *     输入描述:
     * 输入两个字符串。第一个为短字符，第二个为长字符。
     * 输出描述:
     * 返回值：
     * 示例1
     * 输入
     * 复制
     * bc
     * abc
     * 输出
     * 复制
     * true
     */
    public static void test27(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s1=in.nextLine();
            String s2=in.nextLine();
            int num=0;
            for (int i = 0; i < s1.length(); i++) {
                if(s2.contains(String.valueOf(s1.charAt(i))))
                    num++;
            }
            if(num==s1.length())
                System.out.println(true);
            else
                System.out.println(false);
        }
        in.close();
    }

    /**
     * 题目：将真数分解为埃及分数
     * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。输入描述:
     * 输入一个真分数，String型
     *
     * 输出描述:
     * 输出分解后的string
     *
     * 示例1
     * 输入
     * 复制
     * 8/11
     * 输出
     * 复制
     * 1/2+1/5+1/55+1/110
     *
     */
    public static void test26(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s=in.next();
            egyptAnalyse(s);
        }
        in.close();
    }

    private static void egyptAnalyse(String s) {
        String[] parts=s.split("/");
        int a=Integer.parseInt(parts[0]);//分子
        int b=Integer.parseInt(parts[1]);//分母
        StringBuilder sb=new StringBuilder();
        int c;
        while (a != 1) {
            //类似3/110的情况，这里加着方便快速得出结果
            //虽然没有这个if条件判断，也能得出，但是会慢很多，而且埃及分解结果不唯一，加了该判断结果会更快
            if (b % (a - 1) == 0) {
                sb.append("1/").append(b / (a - 1)).append('+');
                a = 1;
            } else {
                c = b / a + 1; //重要点
                sb.append("1/").append(c).append('+');
                a = a * c - b;      //  a/b-1/c=(a*c-b)/(b*c)，所以分子a = a * c - b;
                b = c * b;          //  分母b = c * b;
                if (b % a == 0) {
                    b = b / a;
                    a = 1;//直接跳出循环
                }
            }
        }
        sb.append("1/").append(b);
        System.out.println(sb.toString());
    }

    /**
     * 题目：二维数组操作
     * 有一个数据表格为二维数组（数组元素为int类型），行长度为ROW_LENGTH,列长度为COLUMN_LENGTH。对该表格中数据的操作可以在单个单元内，
     * 也可以对一个整行或整列进行操作，操作包括交换两个单元中的数据；插入某些行或列。
     * 请编写程序，判断对表格的各种操作是否合法。
     * 详细要求:
     *
     *
     * 1.数据表规格的表示方式为“行*列”, 数据表元素的位置表示方式为[行,列]，行列均从0开始编号
     *
     * 2.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误
     *
     * 3.插入操作时，对m*n表格，插入行号只允许0~m，插入列号只允许0~n。超出范围应该返回错误
     *
     * 4.只需记录初始表格中数据的变化轨迹，查询超出初始表格的数据应返回错误
     *
     * 例如:  初始表格为4*4，可查询的元素范围为[0,0]~[3,3]，假设插入了第2行，数组变为5*4，查询元素[4,0]时应该返回错误
     *
     *
     * 输入描述:
     * 输入数据按下列顺序输入：
     * 1 表格的行列值
     * 2 要交换的两个单元格的行列值
     * 3 输入要插入的行的数值
     * 4 输入要插入的列的数值
     * 5 输入要获取运动轨迹的单元格的值
     *
     * 输出描述:
     * 输出按下列顺序输出：
     * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
     * 2 输出交换单元格是否成功
     * 3 输出插入行是否成功
     * 4 输出插入列是否成功
     * 5 输出要查询的运动轨迹的单元查询是否成功
     *
     * 示例1
     * 输入
     * 复制
     * 3 4
     * 1 1
     * 0 1
     * 2
     * 1
     * 2 2
     * 输出
     * 复制
     * 0
     * 0
     * 0
     * 0
     * 0
     */
    public static void test25(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int row1 = scanner.nextInt();
            int col1 = scanner.nextInt();
            int row2 = scanner.nextInt();
            int col2 = scanner.nextInt();
            int insertRow = scanner.nextInt();
            int insertCol = scanner.nextInt();
            int consultRow = scanner.nextInt();
            int consultCol = scanner.nextInt();
            if (row > 0 && row <= 9 && col > 0 && col <= 9)
                System.out.println(0);
            else
                System.out.println(-1);
            if (row1 >= 0 && row1 < row && col1 >= 0 && col1 < col && row2 >= 0 && row2 < row && col2 >= 0 && col2 < col )
                System.out.println(0);
            else
                System.out.println(-1);
            if (insertRow >= 0 && insertRow < row)
                System.out.println(0);
            else
                System.out.println(-1);
            if (insertCol >= 0 && insertCol < col)
                System.out.println(0);
            else
                System.out.println(-1);
            if (consultRow >= 0 && consultRow < row && consultCol >= 0 && consultCol < col)
                System.out.println(0);
            else
                System.out.println(-1);

        }

    }

    /**
     * 找出给定字符串中大写字符(即'A'-'Z')的个数
     * 接口说明
     * 原型：int CalcCapital(String str);
     * 返回值：int
     * 输入描述:
     * 输入一个String数据
     *
     * 输出描述:
     * 输出string中大写字母的个数
     *
     * 示例1
     * 输入
     * 复制
     * add123#$%#%#O
     * 输出
     * 复制
     * 1
     */
    public static void test24(){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String string = scan.nextLine();
            int a = CalcCapital(string);
            System.out.println(a);
        }
    }
    private static int CalcCapital(String string) {
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Catcher 是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，
     * 但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，
     * 而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
     * （注意：记得加上while处理多个测试用例）
     *
     * 输入描述:
     * 输入一个字符串
     *
     * 输出描述:
     * 返回有效密码串的最大长度
     *
     * 示例1
     * 输入
     * 复制
     * ABBA
     * 输出
     * 复制
     * 4
     */
    public static void test23(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String password = scanner.nextLine();
            if(!(password==null || Objects.equals(password, "") )){
                System.out.println(findPassword(password));
            }

        }
    }

    /**
     *  遍历字符串
     *  如果当前字符只有一个，直接跳到下一个字符
     *  如果当前字符的最大下标差值小于maxLen，跳过(无意义，就算有回文，也一定小于最大)
     *  前后同时进行遍历子字符串，如果前后字符中有任何一位不相同，将lastIndex改变
     *  扔掉遍历过的字符串(使indexOf()起到作用)
     */
    private static int findPassword(String password) {
        int lenth = password.length();
        String pa = password;
        int maxLen = 1;
        for (int i = 0; i <= lenth - maxLen; i++) {
            char c = pa.charAt(i);
            int index = password.indexOf(c + "");
            int lastIndex = password.lastIndexOf(c + "");
            if (index == lastIndex) {//如果当前 char 只有一个的话，
                continue;
            }else if(lastIndex - index <= maxLen){
                continue;
            }else {
                while (index != lastIndex){
                    int len = 2;
                    int frontPoint = index + 1;
                    int rearPoint = lastIndex - 1;
                    while (frontPoint < rearPoint ) {
                        if(password.charAt(frontPoint) != password.charAt(rearPoint)){
                            len = -1;
                            break;
                        }
                        len += 2;
                        frontPoint++;
                        rearPoint--;
                    }
                    if (frontPoint == rearPoint) {
                        len++;
                    }
                    maxLen = maxLen > len ? maxLen : len;
                    lastIndex =  password.substring(0,lastIndex).lastIndexOf(c+"");
                }
            }
            password = password.substring(password.indexOf(c + "")+1);
        }
        return maxLen;
    }
    /**
     * 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
     * 输入: 一个byte型的数字
     * 输出: 无
     * 返回: 对应的二进制数字中1的最大连续数
     * 输入描述:
     * 输入一个byte数字
     *
     * 输出描述:
     * 输出转成二进制之后连续1的个数
     *
     * 示例1
     * 输入
     * 复制
     * 3
     * 输出
     * 复制
     * 2
     */
    public static void test22(){
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            int m=cin.nextInt();
            /*动态规划：array[i]表示数字在bit i位置上的01数字
             * max[i]表示以bit i结尾的的最长连续1个数 */
            /*  max[i]=max[i-1]+1,array[i]=1
             *  max[i]=0,array[i]=0
             *  边界条件：
             *  max[0]=array[0]
             *  max数组中存储了以每个bit位结尾的最大连续bit数
             *  所求的最大连续bit数的连续bit必定是以某个bit位结尾的
             *  因此max数组中的最大值就是最大的连续bit数*/
            /*将数字转化为二进制字符串*/
            String s=Integer.toBinaryString(m);
//            System.out.println(m+" to binary:"+s);
            /*将字符串转化为char数组*/
            char[] array=s.toCharArray();
            /*状态转移表*/
            int[] max=new int[32];
            /*边界条件*/
            max[0]=charToInt(array[0]);
            for(int i=1;i<array.length;i++){
                /*状态转移方程*/
                if(charToInt(array[i])==1){
                    max[i]=max[i-1]+1;
                }else{
                    max[i]=0;
                }

            }
            int result=0;
            /*从max数组遍历一次找到最大值*/
            for(int i=0;i<max.length;i++){
                if(max[i]>result){
                    result=max[i];
                }
            }
            System.out.println(result);
        }
    }
    public static int charToInt(char c){
        if(c=='1')return 1;
        else return 0;
    }



    /**
     * 题目：密码强度等级
     * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
     * 一、密码长度:
     * 5 分: 小于等于4 个字符
     * 10 分: 5 到7 字符
     * 25 分: 大于等于8 个字符
     * 二、字母:
     *
     * 0 分: 没有字母
     *
     * 10 分: 全都是小（大）写字母
     *
     * 20 分: 大小写混合字母
     *
     * 三、数字:
     *
     * 0 分: 没有数字
     *
     * 10 分: 1 个数字
     *
     * 20 分: 大于1 个数字
     *
     * 四、符号:
     *
     * 0 分: 没有符号
     *
     * 10 分: 1 个符号
     *
     * 25 分: 大于1 个符号
     *
     * 五、奖励:
     *
     * 2 分: 字母和数字
     *
     * 3 分: 字母、数字和符号
     *
     * 5 分: 大小写字母、数字和符号
     *
     * 最后的评分标准:
     *
     * >= 90: 非常安全
     *
     * >= 80: 安全（Secure）
     *
     * >= 70: 非常强
     *
     * >= 60: 强（Strong）
     *
     * >= 50: 一般（Average）
     *
     * >= 25: 弱（Weak）
     *
     * >= 0:  非常弱
     *
     *
     * 对应输出为：
     *
     * VERY_SECURE
     *
     * SECURE,
     *
     * VERY_STRONG,
     *
     * STRONG,
     *
     * AVERAGE,
     *
     * WEAK,
     *
     * VERY_WEAK,
     *
     *
     * 请根据输入的密码字符串，进行安全评定。
     *
     * 注：
     *
     * 字母：a-z, A-Z
     *
     * 数字：-9
     *
     * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
     *
     * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
     *
     * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
     *
     * [\]^_`              (ASCII码：x5B~0x60)
     *
     * {|}~                (ASCII码：x7B~0x7E)
     *
     * 接口描述：
     *
     *
     * Input Param
     * String pPasswordStr:    密码，以字符串方式存放。
     *
     * Return Value
     * 根据规则评定的安全等级。
     *
     *
     *
     * public static Safelevel GetPwdSecurityLevel(String pPasswordStr)
     * {
     *return null;
             *输入描述:
             *输入一个string的密码
             *输出描述:
             *输出密码等级
             *
             *示例1
             *输入
             *复制
             *38$@NoNoNo
     *输出
             *复制
             *VERY_SECURE
     */
    public static void test21(){
        Scanner scn=new Scanner(System.in);
        while(scn.hasNext()){
            String str=scn.nextLine();
            panDuanMiMa(str);
        }

    }

    public static void panDuanMiMa(String str){
        int sum=0;
        if(str.length()<=4&&str.length()>=0){
            sum+=5;
        }else if(str.length()>=5&&str.length()<=7){
            sum+=10;
        }else if(str.length()>=8){
            sum+=25;
        }
        //System.out.println(sum);
        boolean flag1=false;
        boolean flag2=false;
        boolean flag3=false;
        boolean flag4=false;
        int count1=0;
        int count2=0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                flag1=true;
            }else if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                flag2=true;
            }
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                flag3=true;
                //System.out.println(str.charAt(i));
                count1++;
            }
            if(!(str.charAt(i)>='0'&&str.charAt(i)<='9'||str.charAt(i)>='A'
                    &&str.charAt(i)<='Z'||str.charAt(i)>='a'
                    &&str.charAt(i)<='z')){
                flag4=true;
                count2++;
            }
        }
        if(flag1&&flag2){
            sum+=20;
        }else if(!flag1&&!flag2){
            sum+=0;
        }else {
            sum+=10;
        }
        //System.out.println(sum);
        if(count1==1){
            sum+=10;
        }else if(count1>=2){
            sum+=20;
        }
        //System.out.println(sum);
        if(count2==1){
            sum+=10;
        }else if(count2>=2){
            sum+=25;
        }
        //System.out.println(sum);
        if(flag1&&flag2&&flag3&&flag4){
            sum+=5;
        }else if(!flag1&&flag2&&flag3&&flag4||flag1&&!flag2&&flag3&&flag4){
            sum+=3;
        }else if(!flag1&&flag2&&flag3&&!flag4||flag1&&!flag2&&flag3&&!flag4){
            sum+=2;
        }
        //System.out.println("sum :"+sum);
        if(sum>=90){
            System.out.println("VERY_SECURE");
        }else if(sum>=80){
            System.out.println("SECURE");
        }else if(sum>=70){
            System.out.println("VERY_STRONG");
        }else if(sum>=60){
            System.out.println("STRONG");
        }else if(sum>=50){
            System.out.println("AVERAGE");
        }else if(sum>=25){
            System.out.println("WEAK");
        }else if(sum>=0){
            System.out.println("VERY_WEAK");
        }

    }

    /**
     * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，
     * 其中，小写joker表示小王，大写JOKER表示大王：
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     *
     * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
     *
     * 详细说明：
     *
     * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心；
     * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
     * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
     * 4.输出的算式格式为4张牌通过+-
    四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
            *5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
     *6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
            *
            *输入描述:
            *输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
            *
            *输出描述:
            *如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
            *示例1
     *输入
     *复制
     *
    A A
    A A
     *输出
     *复制
     *NONE
     */
    public static void test20(){//没找到

    }

    /**
     * 题目：24点运算
     * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，
     * 其中，小写joker表示小王，大写JOKER表示大王
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     *
     * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
     *
     * 详细说明：
     *
     * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心；
     * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
     * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
     * 4.输出的算式格式为4张牌通过+-
    四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
            *5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
     *6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
            *
            *输入描述:
            *输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
            *
            *输出描述:
            *如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
            *示例1
     *输入
     *复制
     *
    A A
    A A
     *输出
     *复制
     *NONE
     */
    public static void test19(){
        try {
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] strArr = line.split(" ");
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = String.valueOf(convert(strArr[i]));
                }
                //1取出四个字符串的全排列
                String[][] aOrdered = getFullOrder(strArr);
                //全排列中加入三个运算符字符串,输出表达式字符串
                String[][] aWithOper = addOper(aOrdered);
                //计算表达式
                checkAll(aWithOper);
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }


    /**
     * 对字符串数组进行计算,校验是否等于24
     *
     * @param a
     * @return
     */
    public static String checkAll(String[][] a) {
        String out = "NONE";
        for (int i = 0; i < a.length; i++) {
            float re = calculate(a[i]);
            if (re == 24f) {
                out = join(a[i]);
                break;
            }
        }
        System.out.println(out);
        return out;
    }

    /**
     * 将字符串数组转换成表达式,数字转换成牌面,11->J...
     *
     * @param a
     * @return
     */
    public static String join(String[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if ("11".equals(a[i])) {
                sb.append("J");
            } else if ("12".equals(a[i])) {
                sb.append("Q");
            }else if ("13".equals(a[i])) {
                sb.append("K");
            } else if ("1".equals(a[i])) {
                sb.append("A");
            } else {
                sb.append(a[i]);
            }
        }
        return sb.toString();
    }

    public static float calculate(String[] a) {
        float r1 = oper(a[0], a[1], a[2]);
        float r2 = oper(String.valueOf(r1), a[3], a[4]);
        float r3 = oper(String.valueOf(r2), a[5], a[6]);
        return r3;
    }

    public static float oper(String a, String o, String b) {
        Float a_ = Float.valueOf(a);
        Float b_ = Float.valueOf(b);
        switch (o) {
            case "+":
                return a_ + b_;
            case "-":
                return a_ - b_;
            case "*":
                return a_ * b_;
            case "/":
                return a_ / b_;
        }
        return 0;
    }

    /**
     * 对全排列的数组中加入所有可能的运算符
     *
     * @param arr
     * @return
     */
    public static String[][] addOper(String[][] arr) {
        int operLen = oper.length;
        int numLen = arr[0].length;
        int innerlen = numLen + numLen - 1;
        int outlen = arr.length * 64;
        String[][] re = new String[outlen][innerlen];
        int c = 0;
        for (int i = 0; i < operLen; i++) {
            for (int j = 0; j < operLen; j++) {
                for (int k = 0; k < operLen; k++) {
                    for (int x = 0; x < arr.length; x++) {
                        re[c][0] = arr[x][0];
                        re[c][1] = oper[i];
                        re[c][2] = arr[x][1];
                        re[c][3] = oper[j];
                        re[c][4] = arr[x][2];
                        re[c][5] = oper[k];
                        re[c][6] = arr[x][3];
                        c++;
                    }
                }
            }
        }
        return re;
    }


    /**
     * 数组全排列
     *
     * @param arr
     * @return
     */
    public static String[][] getFullOrder(String[] arr) {
        int len = arr.length;
        int num = getNum(len);
        String[][] re = new String[num][len];
        if (len == 2) {
            re[0] = arr;
            String[] t = new String[len];
            t[0] = arr[1];
            t[1] = arr[0];
            re[1] = t;
            return re;
        } else {
            int r = 0;
            for (int i = 0; i < len; i++) {
                String[] t = new String[len];
                String[] surfixArr = cut(arr, i);
                String[][] surfixArrOrders = getFullOrder(surfixArr);
                for (int j = 0; j < surfixArrOrders.length; j++) {
                    t = append(arr[i], surfixArrOrders[j]);
                    re[r] = t;
                    r++;
                }
            }
        }
        return re;
    }

    public static String[] append(String pre, String[] sur) {
        int len = sur.length + 1;
        String[] re = new String[len];
        re[0] = pre;
        for (int i = 0; i < sur.length; i++) {
            re[i + 1] = sur[i];
        }
        return re;
    }

    /**
     * 对数组剪切,取出一个,剩下的组成新的数组
     *
     * @param arr
     * @param index
     * @return
     */
    public static String[] cut(String[] arr, int index) {
        int len = arr.length;
        String[] re = new String[len - 1];
        for (int i = 0, j = 0; i < len; i++) {
            if (i != index) {
                re[j] = arr[i];
                j++;
            }
        }
        return re;
    }

    public static int getNum(int len) {
        int re = 1;
        for (int i = 1; i <= len; i++) {
            re *= i;
        }
        return re;
    }

    public static String[] getInput() throws Exception {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strArr = line.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(convert(strArr[i]));
        }
        return strArr;
    }

    public static int convert(String s) {
        s = s.toUpperCase();
        switch (s) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.valueOf(s);
        }
    }

    /**
     * 题目：合法IP
     * 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），
     * 如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。
     * 现在需要你用程序来判断IP是否合法。
     * 输入描述:
     * 输入一个ip地址
     *
     * 输出描述:
     * 返回判断的结果YES or NO
     *
     * 示例1
     * 输入
     * 复制
     * 10.138.15.1
     * 输出
     * 复制
     * YES
     */
    public static void test18(){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            String str = scanner.nextLine();
            if (str.contains(" "))
                System.out.println("NO");
            else
            {
                String[] ip = str.split("\\.");
                if (ip.length != 4)
                    System.out.println("NO");
                else
                {
                    int i = 0;
                    for (; i < ip.length; i++)
                    {
                        int n = Integer.valueOf(ip[i]);
                        if (n < 0 || n > 255)
                        {
                            System.out.println("NO");
                            break;
                        }
                    }
                    if (i == ip.length)
                        System.out.println("YES");
                }
            }
        }

    }

    /**
     * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，
     * 要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
     * 输入描述:
     * 输入两个正整数
     *
     * 输出描述:
     * 返回结果
     *
     * 示例1
     * 输入
     * 复制
     * 2
     * 2
     * 输出
     * 复制
     * 6
     */
    public static void test17(){//测试没通过，结果正确 报错：空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(fac(n, m));
    }
    public static int fac(int a, int b){
        if(a == 0 && b != 0 || a != 0 && b == 0){
            return 1;
        }else if(a == 0 && b == 0){
            return 0;
        }else
            return fac(a-1, b) + fac(a, b-1);

    }

    /**
     * 样例输出
     * 输出123058789，函数返回值9
     * 输出54761，函数返回值5
     * 接口说明
     * 函数原型：
     *    unsignedint Continumax(char** pOutputstr,  char* intputstr)
     * 输入参数：
     *    char* intputstr  输入字符串；
     * 输出参数：
     *    char** pOutputstr: 连续最长的数字串，如果连续最长的数字串的长度为0，应该返回空字符串；如果输入字符串是空，也应该返回空字符串；
     * 返回值：
     *   连续最长的数字串的长度
     *   输入描述:
     * 输入一个字符串。
     *
     * 输出描述:
     * 输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
     *
     * 示例1
     * 输入
     * 复制
     * abcd12345ed125ss123058789
     * 输出
     * 复制
     * 123058789,9
     */
    public static void test16(){//测试没通过，结果正确 报错：空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String  str=scanner.nextLine();
        }

        //System.out.println(continueMax(str));

    }
    private static int continueMax(String str) {
        if(str==""){
            return 0;
        }
        int length=0;
        int j=0;
        int value=0;
        int maxStart=0;
        int maxEnd=0;
        for(int i=0;i<str.length();i++){
            j=i;
            length=0;
            while(i<str.length() && str.charAt(i)>='0' &&str.charAt(i)<='9'){
                length++;
                i++;
            }
            if(value<=length){
                value=length;
                maxStart=j;
                maxEnd=i;
            }

        }
        System.out.println(str.substring(maxStart, maxEnd)+","+value);
//        System.out.println(Double.parseDouble(new DecimalFormat("#0.0").format(continueMax(str.substring(maxStart, maxEnd)))));
        return value;

    }

    /**
     * 编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中
     * （不包括5的倍数），能满足以上条件，返回true；不满足时返回false。
     * 输入描述:
     * 第一行是数据个数，第二行是输入的数据
     *
     * 输出描述:
     * 返回true或者false
     *
     * 示例1
     * 输入
     * 复制
     * 4
     * 1 5 -5 1
     * 输出
     * 复制
     * true
     */

    public static void test15() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int arrayLength = sc.nextInt();
            int[] intArray = new int[arrayLength];
            for(int i = 0; i < intArray.length; i++){
                intArray[i] = sc.nextInt();
            }

            boolean isSplitTwoEqualArrays = Main.isSplitTwoEqualArray(intArray);
            System.out.println(isSplitTwoEqualArrays);
        }


    }
    public static boolean isSplitTwoEqualArray(int[] intArray){
        int multipleOfFiveSum = 0;
        int multipleOfThreeSum = 0;
        ArrayList<Integer> otherInts = new ArrayList<Integer>();
        for(int i = 0; i < intArray.length; i++){
            if(intArray[i] % 5 == 0){
                multipleOfFiveSum += intArray[i];
            } else if(intArray[i] % 3 == 0){
                multipleOfThreeSum += intArray[i];
            } else {
                otherInts.add(intArray[i]);
            }
        }

        int difference = multipleOfFiveSum - multipleOfThreeSum;
        ArrayList<Integer> accumulationSum = new ArrayList<Integer>();
        accumulationSum.add(0);
        for (Integer otherInt : otherInts) {
            accumulationSum = Main.expressionsAccumulation(accumulationSum, otherInt);
        }
        for (Integer sum : accumulationSum) {
            if((sum == difference) || (sum == difference * (-1)))
                return true;
        }

        return false;
    }

    public static ArrayList<Integer> expressionsAccumulation(ArrayList<Integer> preSums, int extraInt){
        ArrayList<Integer> accumulationSum = new ArrayList<Integer>();
        for (Integer preSum : preSums) {
            accumulationSum.add(preSum + extraInt);
            accumulationSum.add(preSum - extraInt);
        }
        return accumulationSum;
    }



    /**
     * 题目：计票统计
     * 请实现接口：
     * unsigned int  AddCandidate (char* pCandidateName);
     * 功能：设置候选人姓名
     * 输入： char* pCandidateName 候选人姓名
     * 输出：无
     * 返回：输入值非法返回0，已经添加过返回0 ，添加成功返回1
     * Void Vote(char* pCandidateName);
     * 功能：投票
     * 输入： char* pCandidateName 候选人姓名
     * 输出：无
     * 返回：无
     *
     *
     * unsigned int  GetVoteResult (char* pCandidateName);
     *
     * 功能：获取候选人的票数。如果传入为空指针，返回无效的票数，同时说明本次投票活动结束，释放资源
     * 输入： char* pCandidateName 候选人姓名。当输入一个空指针时，返回无效的票数
     *
     * 输出：无
     * 返回：该候选人获取的票数
     *
     *
     *
     * void Clear()
     *
     * // 功能：清除投票结果，释放所有资源
     * // 输入：
     * // 输出：无
     * // 返回
     *
     *
     * 输入描述:
     * 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。
     *
     * 输出描述:
     * 每行输出候选人的名字和得票数量。
     *
     * 示例1
     * 输入
     * 复制
     * 4
     * A B C D
     * 8
     * A B C D E F G H
     * 输出
     * 复制
     * A : 1
     * B : 1
     * C : 1
     * D : 1
     * Invalid : 4
     */
    public static void test14(){//测试没通过，结果正确 报错：空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();//input n
        String[] name=new String[n];
        int[] score=new int[n];
        int Invalid=0;
        for(int i=0;i<n;i++){
            name[i]=scanner.next();
        }
        int m=scanner.nextInt();
        for(int i=0;i<m;i++){
            String name0=scanner.next();
            boolean found=false;
            for(int j=0;j<n;j++){
                if(name0.equals(name[j])&&!found){
                    score[j]+=1;
                    found=true;
                }

            }
            if(!found){
                Invalid++;
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(name[i]+" : "+score[i]);
        }
        System.out.println("Invalid"+" : "+Invalid);
    }

    /**
     * 考试题目和要点：
     * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。（30分）
     * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如￥ 532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。（30分）
     * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如￥6007.14，应写成“人民币陆仟零柒元壹角肆分“。（
     */
    public static void test13(){//没找到答案

    }

    /**
     * 题目：表示数字
     * 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
     * public static String MarkNum(String pInStr)
     * {
     *
     * return null;
     * }
     * 注意：输入数据可能有多行
     * 输入描述:
     * 输入一个字符串
     *
     * 输出描述:
     * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
     *
     * 示例1
     * 输入
     * 复制
     * Jkdi234klowe90a3
     * 输出
     * 复制
     * Jkdi*234*klowe*90*a*3*
     */
    public static void test12(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            str =MarkNum(str);
            System.out.println(str);
        }
    }
    public static String MarkNum(String pInStr) {
        char[] arr = pInStr.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - '0' >= 0) && (arr[i] - '0' <= 9)) { // 判断为数字
                sb.append("*" + arr[i] + "*"); //两边都加上*
             } else
                 sb.append(arr[i]);
        }
        return sb.toString().replace("**", "");//两个数字中间有** 替换掉
     }


    /**
     * 题目：记负均正
     * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
     * 输入描述:
     * 首先输入一个正整数n，
     * 然后输入n个整数。
     *
     * 输出描述:
     * 输出负数的个数，和所有正整数的平均值。
     * 示例1
     * 输入
     * 复制
     * 5
     * 1
     * 2
     * 3
     * 4
     * 5
     * 输出
     * 复制
     * 0 3
     */
    public static void test11(){//测试没通过，结果正确 报错：空.请检查一下你的代码，有没有循环输入处理多个case.点击查看如何处理多个case
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int size = 0;
        int sizez = 0;
        double sum = 0;
        for (int i = 0; i < a; i++){
            double b = sc.nextInt();
            if(b < 0){
                size++;
            }else if(b > 0){
                sum += b;
                sizez++;
            }
        }
        System.out.println(size + " " +Double.parseDouble(new DecimalFormat("#0.0").format(sum / sizez))+"\n");
    }

    /**
     * 考生需要模拟实现一个简单的自动售货系统，实现投币、购买商品、退币、查询库存商品及存钱盒信息的功能。
     * 系统初始化时自动售货机中商品为6种商品,商品的单价参见1.1规格说明，存钱盒内放置1元、2元、5元、10元钱币，商品数量和钱币张数通过初始化命令设置，参见2.1 系统初始化。
     */
    public static void test10(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            doString(s);
        }
        sc.close();
    }

    public static void doString(String input){
        String[] arr = input.split(";");
        String initial = arr[0];
        Goods goods = OpReset(initial);
        for(int i=1;i<arr.length;i++){
            String temp = arr[i];
            String[] temp2 = temp.split(" ");
            if(temp2[0].equals("p")){
                goods = OpPay(temp,goods);
            }else if(temp2[0].equals("b")){
                goods = OpBuy(temp,goods);
            }else if(temp2[0].equals("c")){
                goods = OpChange(temp,goods);
            }else if(temp2[0].equals("q")||temp2[0].matches("q\\d")){
                OpQuery(temp,goods);
            }

        }
    }
    public static Goods OpReset(String initial){//初始化
        String[] arr = initial.split(" ");
        String[] Asome = arr[1].split("-");
        String[] Moneysome = arr[2].split("-");
        int[] A = new int[Asome.length];
        int[] B = new int[Moneysome.length];
        for(int i=0;i<Asome.length;i++){
            A[i]=Integer.valueOf(Asome[i]);
        }
        for(int i=0;i<Moneysome.length;i++){
            B[i]=Integer.valueOf(Moneysome[i]);
        }
        Goods goods = new Goods(A,B,0);
        System.out.println("S001:Initialization is successful");
        return goods;
    }
    public static Goods OpPay(String payString,Goods goods){//投币
        String[] arr = payString.split(" ");
        int payNum = Integer.valueOf(arr[1]);
        if(payNum!=1&&payNum!=2&&payNum!=5&&payNum!=10){
            System.out.println("E002:Denomination error");
            return goods;
        }
        else if((payNum==5||payNum==10)&&(goods.num_coin[0]*1+goods.num_coin[1]*2<payNum)){
            System.out.println("E003:Change is not enough, pay fail");
            return goods;
        }
        else if(payNum>10){
            System.out.println("E004:Pay the balance is beyond the scope biggest");
            return goods;
        }
        else if(goods.num_goods[0]==0&&goods.num_goods[1]==0&&goods.num_goods[2]==0&&goods.num_goods[3]==0&&goods.num_goods[4]==0&&goods.num_goods[5]==0){
            System.out.println("E005:All the goods sold out");
            return goods;
        }
        else{
            switch(payNum){
                case 1:goods.num_coin[0]++;break;
                case 2:goods.num_coin[1]++;break;
                case 5:goods.num_coin[2]++;break;
                case 10:goods.num_coin[3]++;break;
            }
            int tmp = payNum + goods.toubi_yu_e;
            goods.toubi_yu_e += payNum;
            System.out.println("S002:Pay success,balance="+tmp);
            return goods;
        }

    }
    public static Goods OpBuy(String buyString,Goods goods){//购买商品
        String[] goodsString = {"A1","A2","A3","A4","A5","A6"};
        String[] arr = buyString.split(" ");
        String buy = arr[1];
        int price = 0;
        int index = 10;
        for(int i=0;i<goodsString.length;i++){
            if(buy.equals(goodsString[i])){
                switch(i){
                    case 0:price = 2;index=i;break;
                    case 1:price = 3;index=i;break;
                    case 2:price = 4;index=i;break;
                    case 3:price = 5;index=i;break;
                    case 4:price = 8;index=i;break;
                    case 5:price = 6;index=i;break;
                }

            }
        }
        if(index==10){
            System.out.println("E006:Goods does not exist");
            return goods;
        }
        else if(goods.toubi_yu_e<price){
            System.out.println("E008:Lack of balance");
            return goods;
        }
        else if(goods.num_goods[index]==0){
            System.out.println("E007:The goods sold out");
            return goods;
        }
        else{
            goods.toubi_yu_e=goods.toubi_yu_e-price;
            System.out.println("S003:Buy success,balance="+goods.toubi_yu_e);
            return goods;
        }
    }
    public static Goods OpChange(String changeString,Goods goods){//退币
        if(goods.toubi_yu_e==0){
            System.out.print("E009:Work failure");
            return goods;
        }else{
            int tuibi = goods.toubi_yu_e;
            int num_shi = tuibi/10;

            if(goods.num_coin[3]-num_shi<0){
                num_shi = goods.num_coin[3];
            }
            int num_wu = (tuibi-10*num_shi)/5;
            if(goods.num_coin[2]-num_wu<0){
                num_wu = goods.num_coin[2];
            }
            int num_er = (tuibi-10*num_shi-5*num_wu)/2;
            if(goods.num_coin[1]-num_er<0){
                num_er = goods.num_coin[1];
            }
            int num_yi = (tuibi-10*num_shi-5*num_wu-2*num_er)/1;
            if(goods.num_coin[0]-num_yi<0){
                num_yi = goods.num_coin[0];
            }
            goods.num_coin[3] = goods.num_coin[3]-num_shi;
            goods.num_coin[0] = goods.num_coin[0]-num_yi;
            goods.num_coin[1] = goods.num_coin[1]-num_er;
            goods.num_coin[2] = goods.num_coin[2]-num_wu;

            goods.toubi_yu_e=0;
            System.out.println("1 yuan coin number="+num_yi);
            System.out.println("2 yuan coin number="+num_er);
            System.out.println("5 yuan coin number="+num_wu);
            System.out.println("10 yuan coin number="+num_shi);
            return goods;
        }
    }
    public static void OpQuery(String queryString,Goods goods){
        String[] arr = queryString.split(" ");
        String query = "";
        if(arr.length==2){
            query = arr[1];
        }
        else{
            System.out.print("E010:Parameter error");
        }
        if(query.equals("0")){
            System.out.println("A1 "+"2 "+goods.num_goods[0]);
            System.out.println("A2 "+"3 "+goods.num_goods[1]);
            System.out.println("A3 "+"4 "+goods.num_goods[2]);
            System.out.println("A4 "+"5 "+goods.num_goods[3]);
            System.out.println("A5 "+"6 "+goods.num_goods[4]);
            System.out.println("A6 "+"7 "+goods.num_goods[5]);
        }else if(query.equals("1")){
            System.out.println("1 yuan coin number="+goods.num_coin[0]);
            System.out.println("2 yuan coin number="+goods.num_coin[1]);
            System.out.println("5 yuan coin number="+goods.num_coin[2]);
            System.out.println("10 yuan coin number="+goods.num_coin[3]);
        }
    }



    /**
     * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
     */
    public static void test9(){//没搜到答案

    }


    /**
     * 功能:等差数列 2，5，8，11，14。。。。
     * 输入:正整数N >0
     * 输出:求等差数列前N项和
     * 返回:转换成功返回 0 ,非法输入与异常返回-1
     * 输入描述:
     * 输入一个正整数。
     * 输出描述:
     * 输出一个相加后的整数。
     * 示例1
     * 输入
     * 复制
     * 2
     * 输出
     * 复制
     * 7
     */
    public static void test8(){
        Scanner sc  = new Scanner(System.in);
        int sum=0;
        while(sc.hasNext()){
            int a=sc.nextInt();
            if(!(a>0)){
                System.out.println(-1);
            }else{
                sum= 2*a+a*(a-1)*3/2;
                System.out.println(sum);
            }
        }
    }

    /**
     * 题目描述
     * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
     * 原型：
     * void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
     * 输入参数：
     * Integer[] pIntegerArray：整型数组
     * int  iSortFlag：排序标识：0表示按升序，1表示按降序
     * 输出参数：
     * 无
     * 返回值：
     * void
     * 输入描述:
     * 1、输入需要输入的整型数个数
     * 输出描述:
     * 输出排好序的数字
     * 示例1
     * 输入
     * 复制
     * 8
     * 1 2 4 9 3 55 64 25
     * 0
     * 输出
     * 复制
     * 1 2 3 4 9 25 55 64
     */
    public static void test7(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] arr = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            int type = sc.nextInt();
            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();
            if (type == 0){
                for (int i = 0; i < arr.length; i++) {
                    sb.append(arr[i]+" ");
                }
            } else {
                for (int i = arr.length-1; i >= 0; i--) {
                    sb.append(arr[i]+" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
    }
    /**
     * 题目描述
     * 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
     * 实现以下接口：
     * 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
     * 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASII码由小到大排序输出
     * 清空目前的统计结果，重新统计
     * 调用者会保证：
     * 输入的字符串以‘\0’结尾。
     * 输入描述:
     * 输入一串字符。
     * 输出描述:
     * 对字符中的
     * 各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
     * 示例1
     * 输入
     * aadddccddc
     * 输出
     * dca
     */
    public static void test6(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            char[] words = sc.nextLine().toCharArray();
            Map<String,Integer> map=new HashMap<>();
            for (char word:words){
                String temp=String.valueOf(word);
                if(word>='a'&&word<='z'||word>='A'&&word<='Z'||word>='0'&&word<='9'||word==' '){
                    if(map.containsKey(temp)){
                        map.put(temp,map.get(temp)+1);
                    }else{
                        map.put(temp,1);
                    }
                }
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o1.getValue()<o2.getValue())
                        return 1;
                    else if(o1.getValue()==o2.getValue()){
                        return o1.getKey().compareTo(o2.getKey());
                    }else{
                        return -1;
                    }
                }
            });
            for (Map.Entry<String,Integer> entry:list) {
                System.out.print(entry.getKey());
            }
            System.out.println();


        }
    }

    /**
     * 题目描述
     *    Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？
     * 样例输入
     * 6
     * 2 5 1 5 4 5
     * 样例输出
     * 3
     * 提示
     * Example:
     * 6个点的高度各为 2 5 1 5 4 5
     * 如从第1格开始走,最多为3步, 2 4 5
     * 从第2格开始走,最多只有1步,5
     * 而从第3格开始走最多有3步,1 4 5
     * 从第5格开始走最多有2步,4 5
     * 所以这个结果是3。
     */
    public static void test5(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int[] dp=new int[n];
            for(int i=0;i<n;i++){
                dp[i]=1;
            }
            for(int i=1;i<n;i++){
                for(int j = 0;j<i;j++){
                    if(arr[j]<arr[i]){
                        dp[i]=Math.max(dp[i], dp[j]+1);
                    }
                }
            }
            int max=1;
            for(int i=0;i<n;i++){
                if(max<dp[i]){
                    max=dp[i];
                }
            }
            System.out.println(max);
        }
    }



    /**
     * 连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
     * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     * 首先输入一个整数，为要输入的字符串个数。
     * 例如：
     * 输入：2
     * abc
     * 12345789
     * 输出：abc00000
     * 12345678
     * 90000000
     */
    public static void test4(){//测试没通过
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++){
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j = j + 8){
                if(j+8 < line.length()){
                    list.add(line.substring(j,j+8));
                }else{
                    String s = line.substring(j);
                    for (int m = s.length(); m < 8; m ++){
                        s += "0";
                    }
                    list.add(s);
                }
            }
        }

        list.forEach(System.out::println);
    }
    //从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数
    public static void test3(){
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        String[] strs = next.split("\\s+");
        int size = 0;
        double sum = 0;
        for (int i = 0; i < strs.length; i++){
            double in = Double.parseDouble(strs[i]);
            if(in < 0){
                size++;
            }else {
                sum += in;
            }
        }
        System.out.println(size);
        System.out.println(Double.parseDouble(new DecimalFormat("#0.0").format(sum/(strs.length-size))));
    }

    /**
     * 两个三位数，倒序相加
     * @return
     */
    public static int test1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个数字");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if ((num1<1)||(num1>700000)||(num2<1)||(num2>700000)) {
            return -1;
        }

        String res1 = "";
        String res2 = "";

        while ( num1 != 0 ){
            int r1 = num1 % 10;
            num1 = num1 / 10;
            if ( r1==0 ) {
                continue;
            }else {
                res1 += r1;
            }
        }

        while ( num2 != 0 ){
            int r2 = num2 % 10;
            num2 = num2 / 10;
            if ( r2==0 ) {
                continue;
            }else {
                res2 += r2;
            }
        }

        int reserveresult1 = Integer.parseInt(res1);
        int reserveresult2 = Integer.parseInt(res2);

        int sum = reserveresult1 + reserveresult2;

        return sum;
    }

    //求最大公约数bai
    public static int commonDivisor(int n,int m){
        //辗转相除是用大的除以小的du。如果n<m，第一次相当zhin与m值交换
        while(n%m!=0){
            int temp=n%m;
            n=m;
            m=temp;
        }
        return m;
    }
    //求最小公倍数
    public static int commonMultiple(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        return n*m/commonDivisor(n,m); // 两数相乘dao除以最大公约数
    }
    //计算立方根
    public static double getCubeRoot(){
        Scanner sc = new Scanner(System.in);;
        double input = sc.nextInt();
        double min = 0;
        double max = input;
        double mid =0;
        while((max-min)>0.1){
            mid =(max+min)/2;
            if(mid*mid*mid>input){
                max = mid;
                continue;
            }
            if(mid*mid*mid<input){
                min = mid;
                continue;
            }
             return Double.parseDouble(new DecimalFormat("#0.0").format(mid));
        }
        return Double.parseDouble(new DecimalFormat("#0.0").format(max));
    }

    //字符串逆序
    public static void str(){
        Scanner sc = new Scanner(System.in);//cocvugcnaxkojkb zlzmambwrbj m
        String next = sc.nextLine();
//        next = sc.nextLine()
        String result = "";
        for (int i = 0; i < next.length(); i++){
            result += next.charAt(next.length() - i -1);
        }
        System.out.println(result);
    }


    @Test
    public void test(){
        System.out.println(23%10);
        System.out.println(23/10);

    }
    @Test
    public void test2(){
        int i = Integer.parseInt("a", 16);
        System.out.println(i);

    }


}
class Goods{
    int[] num_goods = new int[6];
    int[] num_coin = new int[4];
    int toubi_yu_e;
    public Goods(int[] num_goods,int[] num_coin,int toubi_yu_e){
        this.num_goods = num_goods;
        this.num_coin = num_coin;
        this.toubi_yu_e = toubi_yu_e;
    }

}
class Person{
    public String name;
    public int score;

    public Person(String name,int score) {
        this.name = name;
        this.score = score;
    }
}
class Node{
    int value ;
    Node next = null;
    Node(int value ){
        this.value = value;
    }
}

class TestThread
{
    static int count;

    volatile int target = 1;

    public static String ch = "";

    synchronized void m1(int n)
    {
        for (int i = 0; i < n; i++)
        {
            while (target != 1)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            ch += "A";
            target = 2;
            notifyAll();
        }
    }
    synchronized void m2(int n)
    {
        for (int i = 0; i < n; i++)
        {
            while (target != 2)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            ch += "B";
            target = 3;
            notifyAll();
        }
    }
    synchronized void m3(int n)
    {
        for (int i = 0; i < n; i++)
        {
            while (target != 3)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            ch += "C";
            target = 4;
            notifyAll();
        }
    }
    synchronized void m4(int n)
    {
        for (int i = 0; i < n; i++)
        {
            while (target != 4)
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            ch += "D";
            target = 1;
            notifyAll();
        }
    }
}
class Position {
    int x;
    int y;
    int value;
    Position pre;

    public Position(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

}
class Point{  //x，y是int类型，默认为0，不需要赋值
    int x;
    int y;
}
class Good{
    int value;//价格
    int weight;//价格*等级
    int q;//是否为主件，或从属于哪个主件
    public Good(int value, int weight, int q) {
        this.value = value;
        this.weight = weight;
        this.q=q;
    }
}
