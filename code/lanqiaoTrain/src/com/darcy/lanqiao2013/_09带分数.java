package com.darcy.lanqiao2013;

import java.util.Scanner;

public class _09带分数 {
//    public static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int ans;
    public static int N;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] arr = {1, 2, 3};
        N = in.nextInt();
        dfs(arr, 0);
        System.out.println(ans);
    }

    // 参数代表确认某一个全排列第k位
    private static void dfs(int[] arr, int i) {
        if(i == 9) {  //全部确认
            check(arr);
            return;
        }
        //选定第k位
        for(int j = i; j < arr.length; j++){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            // 移交下一层确认第k+1位
            dfs(arr, i + 1);
            // 回溯
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    // 枚举加号和除号的位置
    private static void check(int[] arr) {
        // 加号前的字符数 最多是7
        for (int i = 0; i < 7; i++) {
            // 除号前面的字符数
            int num1 = toInt(arr, 0, i);    // 加号前面的结果
            if(num1 >= N) {        //此时加号前的数 超过N没必要验算
                continue;
            }
            for(int j = 1; j < 8 - i; j++){
                int num2 = toInt(arr, i, j);
                int num3 = toInt(arr, i + j, 9 - i - j);
                if(num2 % num3 == 0 && num1 + num2 / num3 == N){
                    ans++;
                }
            }
        }
    }

    private static int toInt(int[] arr, int pos, int len) {
        int t = 1;
        int ans = 0;
        for (int i = pos + len - 1; i >= pos; i--) {
            ans += arr[i] * t;
            t *= 10;
        }
        return ans;
    }
}
