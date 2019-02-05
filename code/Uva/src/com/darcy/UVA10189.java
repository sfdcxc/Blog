package com.darcy;


import java.util.Scanner;

public class UVA10189 {
    public static int n, m;

    public static int checkNum(char input[][], int x, int y){
        if(input[x][y] == '*')
            return 0;
        int sum = 0;
        if( x-1 >= 0 && y-1 >=0)
            if(input[x-1][y-1] == '*')
                sum++;
        if( x-1 >= 0)
            if(input[x-1][y] == '*')
                sum++;
        if( x-1 >= 0 && y+1 <= m-1)
            if(input[x-1][y+1] == '*')
                sum++;
        if( y+1 <= m-1)
            if(input[x][y+1] == '*')
                sum++;
        if( x+1 <= n-1 && y+1 <= m-1)
            if(input[x+1][y+1] == '*')
                sum++;
        if( x+1 <= n-1 )
            if(input[x+1][y] == '*')
                sum++;
        if( x+1 <= n-1 && y-1>=0)
            if(input[x+1][y-1] == '*')
                sum++;
        if(y-1 >= 0)
            if(input[x][y-1] == '*')
                sum++;
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = 1;
        while(in.hasNext()) {
            n = Integer.valueOf(in.next());
            m = Integer.valueOf(in.next());
            if (n == 0 && m == 0)
                break;
            char input[][] = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = in.next();
                for (int j = 0; j < m; j++)
                    input[i][j] = s.charAt(j);
            }

            if (num != 1)
                System.out.println();
            System.out.println("Field #" + num++ + ":");

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++) {
                    if (input[i][j] == '*')
                        System.out.print("*");
                    else
                        System.out.print(checkNum(input, i, j));
                }
                System.out.println();
            }
        }
    }
}