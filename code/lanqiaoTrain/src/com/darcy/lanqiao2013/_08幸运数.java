package com.darcy.lanqiao2013;

import java.util.Scanner;

public class _08幸运数 {

    public static int[] a;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        a = new int[n];     //存储数据的数组
        for(int i = 0; i < n; i++){
            a[i] = 2 * i + 1;
        }
        // 第一轮筛选完成 把2的倍数删除
        int l = 1;      //幸运数下标 a[l]是幸运数
        int p = 0;
        while(true) {
            p = l + 1;  //记录数字向前挪动的坑位
            for (int i = l + 1; i < n; i++) {
                if ((i + 1) % a[l] == 0) {

                } else {
                    a[p++] = a[i];
                }
            }
            l++;
            if(a[l] > n){
                break;
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(a[i] >= n){
                break;
            }
            if(a[i] > m) {
                ans++;
            }
        }
        System.out.println(ans);

    }
}
