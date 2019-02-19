package com.darcy;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PKU3253 {

    public static int N;
    public static int[] L;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        L = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            L[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++){
            queue.add(L[i]);
        }
        int ans = 0;
        //循环到只剩一块木板为止
        while(queue.size() > 1){
            int l1, l2;
            l1 = queue.peek();
            l2 = queue.peek();

            ans += l1 + l2;
            queue.add(l1 + l2);
        }
        System.out.println(ans);
    }
}
