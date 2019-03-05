package com.darcy;

import java.util.Scanner;

public class POJ0118 {
    public static int N;
    public static int M;
    public static char[][] input;
    public static int[][] dir = {
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 0},
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            N = Integer.valueOf(in.next());
            M = Integer.valueOf(in.next());
            input = new char[N][M];
            for (int i = 0; i < N; i++){
                String s = in.next();
                for (int j = 0; j < M; j++){
                    input[i][j] = s.charAt(j);
                }
            }
            int res = 0;
            for (int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    char c = input[i][j];
                    if(input[i][j] != '&'){
                        dfs(i, j, c);
                        res++;
                    }
                }
            }
            System.out.println(res);
        }

    }

    public static void dfs(int x, int y, char c){
        input[x][y] = '&';
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= 0 && ny >= 0 && nx < N && ny <M && input[nx][ny] == c){
                dfs(nx, ny, c);
            }
        }
    }
}
