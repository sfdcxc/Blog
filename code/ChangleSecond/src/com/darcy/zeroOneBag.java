package com.darcy;

import java.util.Scanner;

public class zeroOneBag {
    public static int N;    //背包个数
    public static int W;    //重量
    public static int[] w;  //重量数组
    public static int[] v;  //价值数组
    public static int[][] dp;   //记忆化数组

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
//        System.out.println(rec(0, W));
        for(int i = N - 1; i >= 0; i--){
            for(int j = 0; j <= W; j++){
                if(j < w[i]){
                    dp[i][j] = dp[i + 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[0][W]);
//        System.out.println(recDp(0, W));
    }

    //从第i个物品开始挑选总重小于j的部分
    public static int rec(int i, int j){
        int res;
        if(i == N){
            //没有剩余物品了
            res = 0;
        }else if(j < w[i]){
            // 无法挑选这个物品
            res = rec(i + 1, j);
        }else {
            // 挑选 不调休都试一下
            res = Math.max(rec(i + 1, j), rec(i + 1, j - w[i]) + v[i]);
        }
        return res;
    }

    // dp算法
    public static int recDp(int i, int j){
        if( dp[i][j] > 0){
            //已经计算过的话直接使用之前的结果
            return dp[i][j];
        }
        int res;
        if(i == N){
            res = 0;
        } else if(j < w[i]){
            res = rec(i + 1, j);
        } else{
            res = Math.max(rec(i + 1, j), rec(i + 1, j - w[i]) + v[i]);
        }
        dp[i][j] = res;
        return  res;
    }

}