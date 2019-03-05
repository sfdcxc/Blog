package com.darcy.lanqiao2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _07错误系统 {

    public static int N;    //行数

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        in.nextLine();  // 吃掉整数后面的换行符
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String line = in.nextLine();
            String[] split = line.split(" ");
            for(int j = 0; j < split.length; j++){
                list.add(Integer.valueOf(split[j]));
            }
        }
//        System.out.println(list.size());
        Collections.sort(list);
        int a = 0, b = 0;   //a断号 b重号
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) - list.get(i - 1) == 2){     //重载了 -
                a = list.get(i) - 1;
            }
            if(list.get(i).equals(list.get(i - 1))){    //比较对象与对象相同 使用equals
                b = list.get(i);
            }
        }
        System.out.println(a + " " + b);
    }
}
