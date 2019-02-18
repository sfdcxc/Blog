package com.darcy;

import java.util.Scanner;

public class LIS {
    public static int N;        //输入的数列
    public static int[] a;      //数列数组

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        a = new int[N];
        int[] dp = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = in.nextInt();
        }
        int res = 0;
        for(int i = 0; i < N; i++){
            dp[i] = 1;
            for (int j = 0; j < N; j++){
                if(a[i] < a[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        System.out.println(res);
    }
}
