package com.darcy.sort;

public class InsertionSort {
    public static int[] A;

    public static void main(String[] args) {
        A = new int[]{31, 41, 59, 26, 41,58};
        sortDesc(A);
        for(int i = 0; i < A.length; i++){
            System.out.printf(A[i] + " ");
        }
    }

    //升序插入排序
    public static void sort(int[] A){
        for (int j = 1; j < A.length; j++){
            int key = A[j];
            //插入A[j] 进入排序好的序列中
            int i = j - 1;
            while (i >= 0 && A[i] > key){
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i+1] = key;
        }
    }

    //降序插入排序
    public static void sortDesc(int[] A){
        for (int j = 1; j < A.length; j++){
            int key = A[j];
            //插入A[j] 进入排序好的序列中
            int i = j - 1;
            while (i >= 0 && A[i] < key){
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i+1] = key;
        }
    }
}
