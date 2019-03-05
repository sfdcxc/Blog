package com.darcy.lanqiaobei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _01小计算器 {
    public static String op = "";   //运算符
    public static int hex = 10;     //进制数
    public static long[] num = new long[2];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < n; i++){
            String[] tmp = bufferedReader.readLine().split(" ");
            operate(tmp);
//            for(String s : tmp){
//                System.out.println(s);
//            }
        }
    }

    public static void operate(String[] tmp) throws IOException{
        switch (tmp[0]){
            case "NUM":
                if(op.equalsIgnoreCase("")){
                    num[0] = Long.valueOf(tmp[1], hex);
                }else{
                    num[1] = Long.valueOf(tmp[1], hex);
                    num[0] = caculate();
                    op = "";
                }
                break;
            case "ADD":
                op = "ADD";
                break;
            case "SUB":
                op = "SUB";
                break;
            case "MUL":
                op = "MUL";
                break;
            case "DIV":
                op = "DIV";
                break;
            case "MOD":
                op = "MOD";
                break;
            case "CHANGE":
                hex = Integer.parseInt(tmp[1]);
                break;
            case "EQUAL":
                print();
                break;
            case "CLEAR":
                num[0] = 0;
                num[1] = 0;
                op = "";
                break;
                default :
                    break;
        }
    }

    private static void print() {
        System.out.println(Long.toString(num[0], hex).toUpperCase());
    }

    private static long caculate() {
        long ret = 0;
        switch (op) {
            case "ADD" :
                ret = num[0]+num[1];
                break;
            case "SUB" :
                ret = num[0]-num[1];;
                break;
            case "MUL" :
                ret = num[0]*num[1];
                break;
            case "DIV" :
                ret = num[0]/num[1];
                break;
            case "MOD":
                ret = num[0]%num[1];
            default :
                break;
        }
        return ret;

    }
}
