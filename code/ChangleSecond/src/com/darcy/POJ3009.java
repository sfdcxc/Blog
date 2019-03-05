package com.darcy;

import java.util.Scanner;

public class POJ3009 {
    public static int N;
    public static int M;
    public static int minn = Integer.MAX_VALUE;
    public static int[][] input;
    public static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static int sx, sy, ex, ey;
    public static int step;

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        input = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                input[i][j] = in.nextInt();
                if(input[i][j] == 2){
                    sx = i;
                    sy = j;
                    input[i][j] = 0;
                }
                if(input[i][j] == 3){
                    ex = i;
                    ey = j;
                }
            }
        }
        step = 0;
        dfs(sx, sy, step);
        System.out.println(step);

    }

    public static boolean judge(int x, int y){
        if(x < 0 || x >= M || y < 0 || y >= N)
            return false;
        return true;
    }

    public static void dfs(int x, int y, int step){
        if(step >= 10 || step > minn)
            return;
        for(int i = 0; i < 4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(!judge(nx, ny))
                continue;

            if(input[nx][ny] == 1)
                continue;

            if(input[nx][ny] == 3){
                if(step + 1 < minn){
                    minn = step +  1;
                    return;
                }

                boolean flag = false;
                while(true){
                    nx = nx + dir[i][0];
                    ny = ny + dir[i][1];
                    if(judge(nx, ny)){
                        if(input[nx][ny] == 1)
                            break;
                        else if(input[nx][ny] == 3){
                            if(step + 1 < minn)
                                minn = step + 1;
                            return;
                        }
                    }else{
                        flag = true;
                        break;
                    }
                }
                if(flag == true)
                    continue;

                input[nx][ny] = 0;
                step = step + 1;
                dfs(nx - dir[i][0], ny - dir[i][1], step);
                step = step - 1;
                input[nx][ny] = 1;
            }
        }
    }
}
