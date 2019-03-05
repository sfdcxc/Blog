package com.darcy.Base;

import org.junit.Test;

import java.util.Scanner;

public class base1012 {
    public static int N;
    public static int A1 =  0;
    public static double A2 =  0;
    public static int A2Count = 0;
    public static int A3 =  0;
    public static int A4Count =  0;
    public static double A4 = 0;
    public static int A5 = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        for(int i = 0; i < N; i++){
            int n = in.nextInt();
            if(n % 5 == 0 && n % 2 == 0){
                A1 = A1 + n;
            }
            if(n % 5 == 1){
                A2 = Math.pow(-1, A2Count) * n + A2;
                A2Count++;
            }
            if(n % 5  == 2){
                A3 = A3 + 1;
            }
            if(n % 5 == 3){
                A4 = A4 + n;
                A4Count++;
            }
            if(n % 5 == 4 && n > A5){
                A5 = n;
            }
        }
        if(A1 != 0){
            System.out.printf("%d ", A1);
        }else {
            System.out.printf("N ");
        }

        if(A2 != 0){
            System.out.printf("%d ", (int)A2);
        }else {
            System.out.printf("N ");
        }

        if(A3 != 0){
            System.out.printf("%d ", A3);
        }else {
            System.out.printf("N ");
        }

        if(A4 != 0){
            double A4comp = A4 / A4Count;
            System.out.printf("%#.1f ", A4comp);
        }else {
            System.out.printf("N ");
        }

        if(A5 != 0){
            System.out.printf("%d", A5);
        }else {
            System.out.printf("N ");
        }

    }

    @Test
    public void test(){
        for(int i = 0; i < 3; i++){
            System.out.println(Math.pow(-1, i) + " ");
        }
        System.out.println(1 % 5);
        System.out.println(3 % 5);
    }
}
