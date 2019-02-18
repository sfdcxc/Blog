package com.darcy;

import java.util.ArrayList;
import java.util.Scanner;

public class leetCode121 {
    // 121. 购买股票的最好时机
    public static int[] prices;
    public static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        prices = new int[N];
        for(int i = 0; i < N; i++){
            prices[i] = in.nextInt();
        }
        System.out.println(maxProfit1(prices));
    }

    public static int maxProfit1(int[] prices){
        if(prices.length <= 1)
            return 0;

        int N = prices.length;
        int[] buy = new int[N];
        int[] sell = new int[N];

        buy[0] = prices[0];
        sell[0] = 0;

        for(int i=1; i < N; i++){
            buy[i] = Math.min(buy[i-1], prices[i] - sell[i - 1]);
            sell[i] = Math.max(sell[i-1], prices[i] - buy[i - 1]);
        }
        return sell[N - 1];
    }
}
