package com.darcy.lanqiaobei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _02合根植物 {

    public static int[] head;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int k = in.nextInt();
        head = new int[m * n];
        for(int i = 0; i < m * n; i++){
            head[i] = i;
        }
        for(int i = 0; i < k; i++){
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            u(a, b);
        }
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < m * n; i++){
            res.add(f(i));
        }
        System.out.println(res.size());
    }

    public static void u(int a, int b){
        if(f(a) == f(b))
            return;
        head[f(a)] = f(b);
    }

    public static int f(int i){
        if(head[i]  == i)
            return i;
        return head[i] = f(head[i]);
    }
}
