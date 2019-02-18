package com.darcy;

import java.util.Scanner;

public class compBag {
    public static int N;    //背包数量
    public static int[] w;  //物品重量
    public static int[] v;  //物品价值
    public static int W;    //总重量
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        w = new int[N];
        v = new int[N];
        dp = new int[100][100];
        for(int i = 0; i < N; i++){
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }
        W = in.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= W; j++){
                for(int k = 0; k * w[i] <= j; k++){
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j - k * w[i]] + k * v[i]);
                }
            }
        }
        System.out.println(dp[N][W]);
    }
}
