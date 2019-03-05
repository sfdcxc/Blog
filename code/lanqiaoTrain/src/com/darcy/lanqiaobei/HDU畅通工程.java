package com.darcy.lanqiaobei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HDU畅通工程 {
    public static int[] head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        while(N != 0) {
            int M = in.nextInt();
            head = new int[N];
            for (int i = 0; i < N; i++) {
                head[i] = i;
            }
            for (int i = 0; i < M; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                u(a, b);
            }
            Set<Integer> res = new HashSet<>();
            for (int i = 0; i < N; i++) {
                res.add(f(head[i]));
            }
            System.out.println(res.size() - 1);
            N = in.nextInt();
        }
    }

    public static void u(int a, int b){
        if(f(a) == f(b))
            return;
        head[f(a)] = f(b);
    }

    private static int f(int i) {
        if(head[i] == i)
            return i;
        return head[i] = f(head[i]);
    }
}
