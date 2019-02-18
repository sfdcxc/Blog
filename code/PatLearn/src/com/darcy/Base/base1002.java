package com.darcy.Base;

import java.util.Scanner;

public class base1002 {
    /*
        读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
     */
    public static String str;   //接受输入的数
    public static String[] letter = {"ling", "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        str = in.next();
        char[] comp = new char[str.length()];
        comp = str.toCharArray();
        int sum = 0;
        for(int i = 0; i < comp.length; i++){
            sum = sum + (int)comp[i] - 48;
        }
        String sumStr = String.valueOf(sum);
        char[] sumChar = sumStr.toCharArray();
        for(int i = 0; i < sumChar.length; i++){
//            System.out.println(sumChar[i]);
            if(i != 0){
                System.out.printf(" ");
            }
            System.out.printf(letter[(int)sumChar[i] - 48]);
        }
    }
}
