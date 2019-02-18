package com.darcy;

import java.util.Scanner;

public class moreNumSum {
    public static int N;        //数字种类个数
    public static int[] a;      //数字种类数组
    public static int[] m;      //每个数字个数
    public static int K;        //要求总和

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        a = new int[N];
        m = new int[N];
        K = in.nextInt();
        for(int i = 0; i < N; i++){
            a[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++){
            m[i] = in.nextInt();
        }
        int[][] dp = new int[N+1][N+1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= K; j++){
                for(int k = 0; k <= m[i] && k * a[i] <= j; k++){
                    dp[i+1][j] |= dp[i][j - k * a[i]];
                }
            }
        }
        if(dp[N][K] == K) {
            System.out.println("yes");
        }
        System.out.println("no");
    }
}
