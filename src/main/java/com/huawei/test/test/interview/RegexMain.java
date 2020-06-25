package com.huawei.test.test.interview;

import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegexMain {

    public static void main(String[] args) {
        //test2();
    }


    /**
     * 1.  . 和 \
     *            . 在正则表达式中表示任意一个字符
     *            \ 在正则表达式当中表示转义字符，比如.在正则表达式当中表示任意一个字符，要是单纯的想要表达一个.的时候，就需
     *            要用到\转义字符来表示， \. 在java程序当中\也是被认为特殊字符，也需要进行转义，应该用\\.
     *         2.字符集合[]
     *           [] 用来描述一个单一的字符，方括号内部可以定义这个字符的内容，也可以描述一个范围
     *           [abc] abc中的任意一个字符
     *           [a-z] 小写字母当中a-z的任意一个单词
     *           [A-Z] 大写字母当中A-Z中的任意一个单词
     *           [0-9] 数字0-9中的任意一个数字
     *           [a-zA-Z0-9] a-zA-z0-9中的任意一个字符
     *           [a-z&&[^bc]] a-z中除了bc以外的任意一个字母
     *         3.预定义字符集
     *           \d 表示一个数字字符
     *           \w 表示任意一个数字字母_中的一个字符
     *           \s 表示空白字符  相当于[\t\n]
     *           \D 表示非数字字符
     *           \W 表示非数字字母下划线字符
     *           \S 表示非空白字符
     *         4.数量词
     *           x?  表示0个或者1个x
     *           x*  表示0个或多个x
     *           x+  表示1个到任意多个x，相当于大于等于1个x
     *           x{n} 表示可以有n个x
     *           x{n，} 表示可以有n到任意多个x
     *           x{n，m}表示n到m个x
     *         5.（） 分组和捕获
     *           它有两个用途，可以将一段正则表达式括起来看做一个整体来对这个整体进行匹配，
     *           另一个用途就是捕获组的用法，可以通过（）来做一个或者多个捕获组，根据某个捕获组来匹配给定的字符串当中的
     *           一部分内容，捕获组是根据（来进行匹配的，发现有一个（就对应一个捕获组，如果想让（）里面的正则表达式单纯的
     *           当做一个整体来进行匹配，在（后面加上“?:”即可，就不会当做一个捕获组来进行处理
     *         6. ^ 和 $
     *           ^ 代表字符串的开始
     *           $ 代表字符串的结束
     *           可以对一个给定的字符串进行从头到尾的整体匹配
     * 二.根据正则从给定的字符串当中提取出想要的内容，捕获组
     *         1.捕获组可以通过从左到右计算其开括号来编号。例如，在表达式 ((A)(B(C))) 中，存在四个这样的组： 
     *                     1     ((A)(B(C))) 
     *                     2     (A) 
     *                     3     (B(C)) 
     *                     4     (C) 
     *         2.捕获到组的内容可以在操作完成后从匹配器当中获取
     *         3.组零始终代表整个表达式
     *         4.与组关联的捕获输入始终是与组最近匹配的子序列，如果一个捕获组连续匹配了给定字符串中的多个子串，那么捕获组匹配器只会记录最后一个匹配到的子串，之前捕获到的都会被丢弃
     *         5.以 (?:) 开头的组是纯的非捕获组，它不捕获文本，也不针对组合计进行计数,只是当做一个普通的整体来对待
     * .*?是非贪婪模式
     */
    public static void test0(){

    }
    /**
     *
     */
    @Test
    public void test2(){
        String str = "aacac";
        String pattern = "[abc&&[^b]]*";
        System.out.println(str.matches(pattern));
    }
    @Test
    public void test3(){
//        String str = "daaacac";
//        String pattern = "([abc&&[^b]])*.*";
        String str="This order was placed for QT3000! OK?";
        String pattern="(\\D*)(\\d+)(.*)";
        Pattern com = Pattern.compile(pattern);
        Matcher matcher = com.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.groupCount());
            for (int i = 0; i < matcher.groupCount()+1; i++) {
                System.out.println(matcher.group(i));
            }
        }
    }
    @Test
    public void test4(){
        String str="This order was placed for QT3000! OK?";
        String pattern=".*\\s+(\\S*)$";
        Pattern com = Pattern.compile(pattern);
        Matcher matcher = com.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.groupCount());
            for (int i = 0; i < matcher.groupCount()+1; i++) {
                System.out.println(matcher.group(i));
            }
        }
    }

    //比较
    @Test
    public void test5(){
        Integer a[] = new Integer[]{3,4,6,2,1,5,6};
        Stream<Integer> stream = Arrays.stream(a);
       stream.sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer - t1;
            }
        }).forEach(System.out::print);
    }
    @Test
    public void test6(){
        Integer a[] = new Integer[]{3,4,6,2,1,5,6};
        Integer dest[] = new Integer[3];
        /*
        public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
        src:源数组；
        srcPos:源数组要复制的起始位置；
        dest:目的数组；
        destPos:目的数组放置的起始位置；
        length:复制的长度
         */
        System.arraycopy(a,2,dest,0,2);
        Arrays.stream(dest).forEach(System.out::print);//62null
    }
    //递归调用
    @Test
    public void test7(){
        int sum = getSum(5);
        System.out.println(sum);
    }
    public static int getSum(int n){//n=3
        if (n==1) {
            return 1;
        }else{
            return n*getSum(n-1);//3*getSum(2);getSum(2)=2*getSum(1)
        }
    }

    //递归打印文件
    @Test
    public void test8(){
//		File file=new File("d:\\test");
        File file=new File("D:\\Appium-Python-Client-0.17");
        getFileAll(file);
    }
    //获取制定目录以及子目录中的所有的文件
    public static void getFileAll(File file) {
        File[] files=file.listFiles();
        //遍历当前目录下的所有文件和文件夹
        for (File f:files) {
            //判断当前遍历到的是否为目录
            if(f.isDirectory()) {
                //是目录，继续获取这个目录下的所有文件夹
                getFileAll(f);
            }else {
                //不是目录，说明当前f就是文件，那么就打印出来
                System.out.println(f);
            }
        }
    }

    //冒泡排序
    @Test
    public void bubbleSort() {
        int[] a = new int[]{1,8,5,6,3,8,9,4};
        int length = a.length;
        int temp = 0;
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    // change
                    temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
        Arrays.stream(a).forEach(System.out::print);
    }

    //选择排序
    @Test
    public void bubbleSort1() {
        int[] a = new int[]{1,8,5,6,3,8,9,4};
        int length = a.length;
        int temp = 0;
        int minIndex;
        for (int j = 0; j <length- 1;j++) {
            minIndex = j;
            for (int i = j; i < length- 1; i++) {
                if (a[minIndex] > a[i + 1]) {
                    minIndex = i+1;
                }
            }
            temp = a[minIndex];
            a[minIndex]= a[j];
            a[j]=temp;
        }
        Arrays.stream(a).forEach(System.out::print);
    }

    //插入排序
    @Test
    public void bubbleSort2() {
        int[] arr = new int[]{1,8,5,6,3,8,9,4};
        int i, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++){
            j = i;
            target = arr[i];
            while (j > 0 && target < arr[j - 1]){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    //Math各方法验证
    @Test
    public void test9() {
        double v = Math.pow(2, 3);//2的3次方
        double v1 = Math.pow(2, 3);//2的3次方
        long v2 = Math.round(5.5);//四舍五入
        double v3 = Math.ceil(2.4);//进位
        Math.floor(2.4);//去掉小数，不进位
        Math.sqrt(16);//计算平方根
        Math.cbrt(8);//计算立方根
        Math.hypot(3,4);//计算 (x的平方+y的平方)的平方根
        Math.pow(2,3);//计算a的b次方
        Math.exp(3);//计算e^x的值
        Math.random();//输出[0,1)间的随机数 0.8979626325354049
        double b = Math.random()*100;//输出[0,100)间的随机数 32.783762836248144
        //Math.rint 四舍五入 返回double值
        //Math.round 四舍五入 float时返回int值，double时返回long值

    }
    //字符串转字节数组
    @Test
    public void test10() {
        String a = "abcdef023/";
        byte[] b = a.getBytes();
        for (int i = b.length-1; i >= 0; i--) {
            System.out.print((char)b[i]);
        }

    }
    @Test
    public void test11() {
        //排序
        ArrayList<Integer> list = Lists.newArrayList(1, 2);
        Collections.sort(list);
        //十进制转2进制
        String str = Integer.toBinaryString(8);
        //字符串转字符数组
        char [] ints =str.toCharArray();

        //判断是不是小写吗
        Character.isLowerCase('s');
        //判断是不是大写吗
        Character.isUpperCase('s');
        //获取map中的values
        Map hm = Maps.newHashMap();
        Collection<Integer> values = hm.values();
        Integer min = Collections.min(values);
        //'A'=65 'a'=97
        StringBuilder sb = new StringBuilder("abcdef");
        sb.insert(2,"oo");
        System.out.println(sb);

    }
    @Test
    public void test12() {
        //'A'=65 'a'=97
        StringBuilder sb = new StringBuilder("abcdef");
        sb.insert(2,"oo");
        System.out.println(sb);//aboocdef

    }
    //进制转换
    @Test
    public void test13() {
        int n = 18;
        Integer.toHexString(n);
        System.out.println(n + "的二进制是:" + Integer.toBinaryString(n));
        System.out.println(n + "的八进制是:" + Integer.toOctalString(n));
        System.out.println(n + "的十六进制是:" + Integer.toHexString(n));
        System.out.println(n + "的三进制是:" + Integer.toString(n, 3));

        String s = "10101";//1+4+16==21  第一个参数s为当前字符串的进制状态，第二个参数为当前为几进制。 输出结果为对应的十进制数
        System.out.println(Integer.parseInt(s,2));//结果是21
        // Integer 中封装好了一个方法：
        // 能够直接计算二进制中的1的个数，在竞赛中很有用.
        // JDk8中的实现方法使用的是 & 操作，所以比正常的遍历要快的多.
        System.out.println(Integer.bitCount(21));

        //数字0 为48  数字9为57
        char a = 48;
        System.out.println(a);
        Character [] ch = new Character[]{'h','a','b','d'};
        //字符数组排序，由小到大
        Arrays.sort(ch);
        //字符数组倒序
        Arrays.sort(ch,new Comparator(){
            @Override
            public int compare(Object o, Object t1) {
                return (char)t1 - (char)o;
            }
        });
        Arrays.sort(ch,(Object o, Object t1) -> {return (char)t1 - (char)o;});

    }
    //进制转换
    @Test
    public void test14() {
        Character [] ch = new Character[]{'h','a','b','d','0','5','9','A','O','D'};
        Arrays.sort(ch);
        Arrays.stream(ch).forEach(System.out::print);
    }



}
