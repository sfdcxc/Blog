package com.darcy;

import java.util.Scanner;

public class POJ3617 {
    public static int N;
    public static String Str;
    public static char[] S;
    public static char[] C;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String s = in.next();
        S = new char[N];
        for(int i = 0; i < N; i++){
            S[i] = s.charAt(i);
        }
        C = new char[N];
        solve();
        for(int i = 0; i < N; i++){
            System.out.print(C[i]);
        }
    }

    public static void solve(){
        int a = 0, b = S.length - 1;
        int j = 0;
        while (a <= b){
            boolean left = false;
            for(int i = 0; a + i <= b; i++){
                if(S[a + i] < S[b - i]){
                    left = true;
                    break;
                }else if(S[a + i] > S[b - i]){
                    left = false;
                    break;
                }
            }
            if(left){
                C[j++] = S[a++];
            }else{
                C[j++] = S[b--];
            }
        }
    }
}
