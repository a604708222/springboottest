package com.huawei.test.test.interview;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {

    public static void main(String[] args) {
        test2();
    }


    /**
     *
     */
    public static void test0(){

    }
    /**
     *
     */
    public static void test2(){
        String a = "hello world";

    }

    /**
     * 加减乘除
     */
    public static void test1(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        calculatorLISP(line);
        scanner.close();
    }

    private static void calculatorLISP(String str) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> operStack =new Stack<String>();
        int mark = 0;
        int paramOne = 0;
        int paramTwo = 0;

        for(int i = 0; i < str.length() ; i++) {
            char c = str.charAt(i);
            if(c == '('){
                operStack.push(str.substring(i+1,i+4));
                i+=4;
                mark = i+1;
            }else if(c == ')'){
                if(mark < i){
                    numStack.push(Integer.valueOf(str.substring(mark,i)));
                    i++;
                    mark = i+1;
                }
                paramTwo = numStack.pop();
                paramOne = numStack.pop();
                calc(numStack,operStack,paramOne,paramTwo);
            }else{
                if(c == ' '){
                    if(mark < i){
                        numStack.push(Integer.valueOf(str.substring(mark,i)));
                        mark = i + 1;
                    }
                }
            }
        }

        while(!operStack.isEmpty()) {
            paramTwo = numStack.pop();
            paramOne = numStack.pop();
            calc(numStack,operStack,paramOne,paramTwo);
        }

        System.out.println(numStack.pop().toString());

    }

    public static void calc(Stack<Integer> numStack,Stack<String> operStack,int paramOne, int paramTwo){
        switch(operStack.pop()) {
            case "add":
                numStack.push(paramOne + paramTwo);
                break;
            case "sub":
                numStack.push(paramOne - paramTwo);
                break;
            case "mul":
                numStack.push(paramOne * paramTwo);
                break;
            case "div":
                if(paramTwo == 0) {
                    System.out.println("error");
                }else{
                    numStack.push(paramOne / paramTwo);
                }
                break;
        }
    }
}
