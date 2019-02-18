package com.darcy;

import java.util.Scanner;

public class LCS {
    public static int n, m;
    public static char[] s = new char[100], t = new char[100];
    public static int[][] dp = new int[101][101];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        String strS = in.next();
        for(int i = 0; i < n; i++){
            s[i] = strS.charAt(i);
        }
        String strT = in.next();
        for(int i = 0; i < m; i++){
            t[i] = strT.charAt(i);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(s[i] == t[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
