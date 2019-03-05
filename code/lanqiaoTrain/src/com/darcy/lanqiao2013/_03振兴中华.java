package com.darcy.lanqiao2013;

public class _03振兴中华 {
    public static void main(String[] args) {
        //重复
        //变化
        //边界
        int ans = dfs(0, 0);
        System.out.println(ans);
    }

    private static int dfs(int x, int y) {
        if(x == 3 || y == 4){
            return 1;
        }
        return dfs(x + 1, y) + dfs(x, y + 1);   //两种走法的路线数相加
    }


}
