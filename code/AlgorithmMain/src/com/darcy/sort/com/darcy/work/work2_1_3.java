package com.darcy.sort.com.darcy.work;

public class work2_1_3 {
    // 查找问题
    public static int[] A;

    public static void main(String[] args) {
        A = new int[]{31, 41, 59, 26, 41,58};
        System.out.println(find(32));
    }

    public static int find(int key){
        for (int j = 0; j < A.length; j++){
            if (A[j] == key){
                return j;
            }
        }
        return -1;
    }
}
