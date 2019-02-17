package com.darcy;

import java.util.Scanner;

public class POJ3253 {

    public static int N;    //切割木板的个数
    public static int[] L;  //切成木板的长度
    public static int[] T;  //记录木板的深度
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        L = new int[N];
        for(int i = 0; i < N; i++){
            L[i] = in.nextInt();
        }
        solve();

    }

    public static void solve(){
        int ans = 0;
        //直到计算到木板为1块时为止
        while(N > 1){
            // 求出最短的板m1 和 次短板m2
            int m1 = 0, m2 = 1;
            if(L[m1] > L[m2])
                swap(m1, m2);
            for(int i = 2; i < N; i++){
                if(L[i] < L[m1]){
                    m2 = m1;
                    m1 = i;
                }else if(L[i] < L[m2]){
                    m2 = i;
                }
            }

            //将两块板合并
            int t = L[m1] + L[m2];
            ans += t;

            if(m1 == N - 1)
                swap(m1, m2);
            L[m1] = t;
            L[m2] = L[N - 1];
            N--;
        }
        System.out.println(ans);
    }

    public static void swap(int i1, int i2){
        int temp = i1;
        i1 = i2;
        i2 = temp;
    }
}
