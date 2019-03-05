package com.darcy.Base;

import java.util.Scanner;

public class base1013 {
    public static int M;        //开始的数字
    public static int N;        //结束的数字
    public static int[] P;      //输出素数的数组

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        P = new int[N+1];
        P[0] = 1;
        P[1] = 2;
        int n = 2;              //记录输出的标记
        int p = 3;              //当前素数
        while( n <= N){
            if(isPrim(p)){
                P[n] = p;
                p++;
                n++;
                continue;
            }else {
                p++;
            }
        }
        int flag = 1;
        for(int i = M; i <= N; i++){
            if(flag % 10 == 0 ){
                System.out.printf("%d\n", P[i]);
            }else if(i < N) {
                System.out.printf("%d ", P[i]);
            }else{
                System.out.printf("%d", P[i]);
            }
            flag = flag + 1;
        }
    }

    private static boolean isPrim(int p) {
        for(int i = 2; i * i <= p; i++){
            if(p % i == 0){
                return false;
            }
        }
        return true;
    }


}
