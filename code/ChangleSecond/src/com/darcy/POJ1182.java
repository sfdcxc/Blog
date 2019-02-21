package com.darcy;

import java.util.Scanner;

public class POJ1182 {
    public static int N = 50005;
    public static int n, m;
    public static int[] f = new int[N];
    public static int[] rank = new int[N];

    public static int find(int x){
        if(x == f[x])
            return x;
        int fa = f[x];
        f[x] = find(f[x]);
        rank[x] = (rank[x] + rank[fa]) % 3;
        return f[x];
    }

    public static boolean Union(int x, int y, int D){
        int a = find(x), b = find(y);
        if(a == b){
            if(D == 1 && rank[x] != rank[y])
                return false;
            if(D == 2){
                if(rank[x] == 2 && rank[y] != 1)
                    return false;
                if(rank[x] == 1 && rank[y] != 0)
                    return false;
                if(rank[x] == 0 && rank[y] != 2)
                    return false;
            }
            return true;
        }
        f[a] = b;
        if(D == 2){
            rank[a] = (rank[y] - rank[x] + 3 + 1) % 3;
        }else {
            rank[a] = (rank[y] - rank[x] + 3) % 3;
        }
        return true;
    }

    public static void main(String[] args) {
        int x, y, d;
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        m = in.nextInt();
        for(int i = 0; i <= N; i++){
            f[i] = i;
            rank[i] = 0;
        }
        int cnt = 0;
        for(int i = 0; i < m; i++){
            d = in.nextInt();
            x = in.nextInt();
            y = in.nextInt();
            if(x > N || y > N || d == 2 && x == y){
                cnt++;
                continue;
            }
            if(!Union(x, y, d)){
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
