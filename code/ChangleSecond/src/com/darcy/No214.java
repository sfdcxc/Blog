package com.darcy;

public class No214 {

    public static int[] input = {1, 2, 4, 7};
    public static int n = 4, k = 14;

    public static void main(String[] args) {
        if(dfs(0, 0))
            System.out.println("Yes");
        else
            System.out.println("No");

    }

    public static boolean dfs(int i, int sum){
        if(i == n)
            return sum == k;
        if(dfs(i + 1, sum))
            return true;
        if(dfs(i + 1, sum + input[i]))
            return true;
        return false;
    }

}
