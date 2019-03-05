package com.darcy;

public class leetCode979 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public int distributeCoins(TreeNode root) {
        return root.val;
    }
}
