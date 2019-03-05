package com.darcy;

import java.util.Scanner;

public class HOJ1010 {
    public static int N = 55;
    public static boolean flag;
    public static int n, m, T, dis;
    public static int tx, ty, sx, sy;
    public static char[][] map = new char[N][N];
    public static boolean[][] vis = new boolean[N][N];
    public static int[][] dir = new int[][]{
            {1, -1, 0, 0},
            {0, 0, 1, -1},
    };

    public static boolean check(int x, int y){
        if(x >= 0 && x < n && y >= 0 && y < m)
            return true;
        else
            return false;
    }

    public static void DFS(int x, int y, int t){
        vis[x][y] = true;
        if(map[x][y] == 'D' && t == T){
            flag = true;
            return;
        }
        int temp = T - t - (Math.abs(x - tx) + Math.abs(y - ty));
        if(temp < 0 || temp % 2 != 0)
            return;
        for (int i = 0; i < 4; i++){
            int dx = x + dir[0][i];
            int dy = y + dir[0][y];
            if(check(dx, dy) && !vis[dx][dy] && map[dx][dy] != 'X'){
                DFS(dx, dy, t + 1);
                if (flag)
                    return;
                //回溯
                vis[dx][dy] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        T = in.nextInt();
        flag = false;
        dis = 0;
        for(int i = 0; i < n; i++){
            String s = in.next();
            for(int j = 0; j < s.length(); j++){
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (map[i][j] == 'D'){
                    tx = i;
                    ty = j;
                }
                if (map[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }
        dis = Math.abs(sx - tx) + Math.abs(sy - ty);
        DFS(sx, sy, 0);
        if(flag)
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
