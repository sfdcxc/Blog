package com.darcy;

import java.util.Scanner;

public class POJ1979 {
    public static int N, M;
    public static int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public static char[][] input;
    public static int step = 0;

    public static int dfsz(int x, int y){
        input[x][y] = '#';
        step++;
        for (int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && input[nx][ny] == '.'){
                dfsz(nx, ny);
            }
        }
        return step;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res = 0;        //走过的瓦片
        while(in.hasNext()){
            N = Integer.valueOf(in.next());
            M = Integer.valueOf(in.next());
            if(N == 0 && M == 0)
                break;
            input = new char[N][M];
            for(int i = 0; i < N; i++){
                String s = in.next();
                for(int j = 0; j < M; j++)
                    input[i][j] = s.charAt(j);
            }
            int x = 0;
            int y = 0;
            for(; x < N; x++){
                for(; y < M; y++){
                    if(input[x][y] == '@'){
                        break;
                    }
                }
            }
            dfsz(x, y);


        }
    }
}
