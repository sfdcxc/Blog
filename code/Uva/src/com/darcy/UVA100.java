package com.darcy;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UVA100 {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        while(in.hasNextInt()){
            int i = in.nextInt();
            int j = in.nextInt();
            int _i = i;
            int _j = j;
            if(_i > _j){
                int swap = _i;
                _i = _j;
                _j = swap;
            }
            int maxSum = 0;
            for(int k = _i; k <= _j; k++){
                int sum = getCompNum(k);
                if(sum > maxSum)
                    maxSum = sum;
            }
            System.out.println(_i + " " + _j + " " + maxSum);
        }
    }

    public static int getCompNum(int n){
        int count = 1;
        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
            }else{
                n = 3 * n + 1;
            }
            count++;
        }
        return count;
    }

}
