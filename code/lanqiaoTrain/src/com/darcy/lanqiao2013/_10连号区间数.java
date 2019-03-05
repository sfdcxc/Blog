package com.darcy.lanqiao2013;

import java.util.Scanner;

public class _10连号区间数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = in.nextInt();
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int max = arr[i];
            int min = arr[i];
            for(int j = i; j <= n; j++){
                if( arr[j] > max){
                    max = arr[j];
                }
                if( arr[j] < min){
                    min = arr[j];
                }
                if(i == j)
                    ans++;
                else{
                    if(max - min == j -i){
                        ans++;
                    }
                }
            }
        }
    }
}
