package com.darcy;

import java.util.Scanner;

public class UVA10137 {

    public static void main(String[] args) {
        int flag = 1;
        Scanner in = new Scanner(System.in);
        double sum = 0, avg = 0;
        while(flag == 1){
            int n = in.nextInt();
            if(n == 0){
                flag = 0;
                break;
            }
            sum = 0;
            avg = 0;
            double[] trace = new double[n];
            for(int i = 0; i < n; i++){
                trace[i] = in.nextDouble();
                sum = sum + trace[i];
            }
            avg = sum / trace.length;

            double sum1 = 0, sum2 = 0, dif = 0;
            for(int i = 0; i < n; i++){
                dif = (double)(long)((trace[i] -avg) * 100) / 100.0;
                if(dif < 0)
                    sum2 = sum2 - dif;
                else
                    sum1 = sum1 + dif;
            }
            if(sum2 > sum1)
                System.out.printf("$%.2f\n", sum2);
            else
                System.out.printf("$%.2f\n", sum1);
        }

    }
}
