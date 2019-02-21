package com.darcy.Base;

import java.math.BigInteger;
import java.util.Scanner;

public class base1011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N; i++){
            BigInteger b1 = in.nextBigInteger();
            BigInteger b2 = in.nextBigInteger();
            BigInteger b3 = in.nextBigInteger();
            if(b1.add(b2).compareTo(b3) <= 0) {
                System.out.println("Case #" + (i + 1) + ": false");
            }else{
                System.out.println("Case #" + (i + 1) + ": true");
            }
        }

    }
}
