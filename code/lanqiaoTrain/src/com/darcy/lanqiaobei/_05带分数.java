package com.darcy.lanqiaobei;

import java.util.Scanner;

public class _05带分数 {
    public static int res = 0;
    public static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(toInt(arr, 2, 4));
        dfs(arr, 0);
        System.out.printf("%d", res);
    }

    private static void dfs(int[] arr, int i) {
        if(i == 9){
            check(arr);
            return;
        }
        for(int j = i; j < arr.length; j++){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            dfs(arr, i + 1);
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    private static void check(int[] arr) {
        for(int i = 0; i <= 7; i++){
            int num1 = toInt(arr, 0, i);
            if(num1 > n)
                continue;
            for(int j = 1; j < 8 - i; j++){
                int num2 = toInt(arr, i, j);
                int num3 = toInt(arr, i + j, 9 - i - j);
                if(num1 + num2 / num3 == n && num2 % num3 == 0){
                    res++;
                }
            }

        }
    }

    private static int toInt(int[] arr, int i, int len) {
        int res = 0;
        int t = 1;
        for(int k = i + len - 1; k >= i; k--){
            res = arr[k] * t + res;
            t = t * 10;
        }
        return res;
    }
}
