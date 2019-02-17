package com.darcy;

import java.util.Scanner;

public class tanxin01 {
    //硬币的面值
    public static int[] V = {1, 5, 10, 50, 100, 500};

    //输入
    public static int[] C = new int[6];
    public static int A;

    public static void solve(){
        int ans = 0;
        for(int i = 5; i >= 0; i--){
            int t = Math.min(A / V[i], C[i]);
            A -= t * V[i];
            ans += t;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 6; i++){
            C[i] = in.nextInt();
        }
        A = in.nextInt();
        solve();
    }
}
