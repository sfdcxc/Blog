package com.darcy.Base;

import java.util.Scanner;

public class base1006 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int j = n / 100;
        int k = n / 10 % 10;
        int l = n  % 10;
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
    }
}
