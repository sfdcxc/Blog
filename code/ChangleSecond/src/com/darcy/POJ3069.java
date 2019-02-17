package com.darcy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class POJ3069 {
    public static int N;    //点的数量
    public static int R;    //范围
    public static int[] X;  //点的数组
    public static int ans;  //记录标记位置

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        R = in.nextInt();
        X = new int[N];
        for(int i = 0; i < N; i++){
            X[i] = in.nextInt();
        }
        Arrays.sort(X);
        System.out.println(solve());
    }

    public static int solve(){
        int i = 0;
        while(i < N){
            // s是没有被覆盖的最左的点的位置
            int s = X[i++];

            // 一直向右前进直到距s的距离大于R的点
            while(i < N && X[i] <= s + R)
                i++;

            // P是新加上标记的点的位置
            int p = X[i - 1];

            // 一直向右前进直到距p的距离大于R的点
            while(i < N && X[i] <= p + R)
                i++;

            ans++;
        }
        return ans;
    }

}
