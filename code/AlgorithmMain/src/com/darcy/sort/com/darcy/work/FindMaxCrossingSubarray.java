package com.darcy.sort.com.darcy.work;

import java.util.Scanner;

public class FindMaxCrossingSubarray {
    public static int[] A;
    public static int N;

    public static void main(String[] args) {

//        A = new int[]{13, -3  -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        A = new int[]{1, -3, -25, 20, -3};
        int max = MaximumSubarray(A, 0, A.length-1);
        System.out.println(max);
    }

    public static int MaxCrossingSubarray(int[] A, int low, int mid, int high){
        int leftSum = A[mid];
        int sum = 0;
        for(int i = mid; i > low; i--){
            sum = sum + A[i];
            if(sum > leftSum){
                leftSum = sum;
            }
        }
        int rightSum = A[mid + 1];
        sum = 0;
        for(int j = mid + 1; j < high; j++){
            sum = sum + A[j];
            if(sum > rightSum){
                rightSum = sum;
            }
        }
        return rightSum + leftSum;
    }

    public static int MaximumSubarray(int[] A, int low, int high){
        if(high == low)
            return A[low];
        int mid = (low + high)  / 2;
        int leftMax = MaximumSubarray(A, low, mid);
        int rightMax = MaximumSubarray(A, mid + 1, high);
        int crossMax = MaxCrossingSubarray(A, low, mid, high);
        if(leftMax > rightMax && leftMax > crossMax){
            return leftMax;
        }else if(rightMax > leftMax && rightMax > crossMax){
            return rightMax;
        }else{
            return crossMax;
        }
    }
}
