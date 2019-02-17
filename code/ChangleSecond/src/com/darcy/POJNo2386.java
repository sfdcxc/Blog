package com.darcy;

import java.util.Scanner;

public class POJNo2386 {

    public static int N , M ;
    public static int[][] input;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        input = new int[N][M];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                input[i][j] = in.nextInt();
            }
        }
        int sum = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(input[i][j] == 1) {
                    dfs(i, j);
                    sum++;
                }
            }
        }

        System.out.println(sum);
    }

    public static void dfs(int x, int y) {
        input[x][y] = 0;

        for (int dx = -1; dx <= 1; dx++){
            for (int dy = -1; dy <= 1; dy++) {
                //移动坐标方向
                int nx = dx + x;
                int ny = dy + y;
                if(ny >= 0 && ny < M && nx >= 0 && nx < N ){
                    if(input[nx][ny] != 1) {
                    }else {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }
}
