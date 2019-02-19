package com.darcy;

import javafx.scene.control.Cell;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class POJ2431 {

    public static int N;    //加油站个数
    public static int L;    //卡车行驶的距离
    public static int P;    //原有的汽油
    public static int[] A;  //加油站距离起点的距离数组
    public static int[] B;  //加油站每次最多的加油数组

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        L = in.nextInt();
        P = in.nextInt();
        A = new int[N + 1];
        B = new int[N + 1];

        // 把终点认为是加油站
        A[N] = L;
        B[N] = 0;
        for(int i = 0; i < N; i++){
            A[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++){
            B[i] = in.nextInt();
        }
        N++;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // ans:加油次数 pos:现在所在的位置，tank:油箱中汽油的量
        int ans = 0, pos = 0, tank = P;

        for(int i = 0; i < N; i++){
            // 接下来要前进的距离
            int d = A[i] - pos;

            while(tank - d < 0){
                if(queue.isEmpty()){
                    System.out.println("-1");
                    return;
                }
                tank += queue.peek();
                queue.poll();
                ans++;
            }

            tank -= d;
            pos = A[i];
            queue.add(B[i]);
        }
        System.out.println(ans);

    }
}
