package com.darcy.sort;

public class MergreSort {
    public static int[] A;
    public static int[] L;
    public static int[] R;

    public static void main(String[] args) {
        A = new int[]{2, 4,5 ,7, 1, 2, 3, 5 ,7,};
        int n = A.length;
        MergeSort(A, 0, n - 1);
        for(int i : A){
            System.out.println(i);
        }
    }

    public static void MergeSort(int[] a, int p, int r){
        if(p < r){
            int q = (p + r) / 2;
            MergeSort(A, p, q);
            MergeSort(A, q + 1, r);
            Merge(A, p, q, r);
        }
    }

    public static void Merge(int []A, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        L = new int[n1 + 1];
        R = new int[n2 + 1];
        for(int i = 0; i < n1; i++){
            L[i] = A[p + i];
        }
        for(int i = 0; i < n2; i++){
            R[i] = A[q + i + 1];
        }
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++){
            if (L[i] <= R[j] ){
                A[k] = L[i];
                i = i + 1;
            }else{
                A[k] = R[j];
                j = j + 1;
            }
        }
    }
}
