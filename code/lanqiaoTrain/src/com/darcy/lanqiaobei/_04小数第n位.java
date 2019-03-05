package com.darcy.lanqiaobei;

import java.math.BigDecimal;
import java.util.Scanner;

public class _04小数第n位 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        for(int i = 1; i < n; i++){
            int mod = a % b;
            a = mod * 10;
        }
        for(int i = 0; i < 3; i++){
            int mod = a % b;
            a = mod * 10;
            System.out.printf("%d", a/b);
        }
    }
}
