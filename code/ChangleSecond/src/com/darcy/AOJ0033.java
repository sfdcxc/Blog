package com.darcy;

import java.util.Scanner;

public class AOJ0033 {
    public static int N;
    public static int[] A;
    public static int[] L;
    public static int[] R;
    public static boolean flag;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        A = new int[N+1];
        L = new int[N+1];
        R = new int[N+1];
        for(int i = 1; i <= N; i++){
            A[i] =  in.nextInt();
        }
        flag = false;
        dfs(1, 1, 1);
        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    public static void dfs(int i, int l, int r){
        if(i > 10){
            flag = true;
            return;
        }
        if (flag){
            return;
        }
        if(A[i] > L[l-1]){
            L[l] = A[i];
            dfs(i+1, l+1, r);
        }
        if(A[i] > R[r-1]){
            R[r] = A[i];
            dfs(i+1, l, r+1);
        }
    }
}
