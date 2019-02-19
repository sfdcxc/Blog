package com.darcy.Base;

import java.util.*;

public class base1005 {

    public static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        Set<Integer> contain = new HashSet<>();
        List<Integer> tempList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int C = in.nextInt();
            if(contain.contains(C)){
                continue;
            }else {
                tempList.add(C);
            }
            while(C != 1){
                if(C % 2 == 0){
                    C = C / 2;
                    contain.add(C);
                }else{
                    C = (3 * C + 1) / 2;
                    contain.add(C);
                }
            }
        }
        for(int i = 0; i < tempList.size(); i++){
            if(contain.contains(tempList.get(i))){
                tempList.remove(i);
            }
        }
        Collections.sort(tempList);
        for(int i = tempList.size()-1; i >= 0; i--){
            if(i != tempList.size() - 1){
                System.out.printf(" ");
            }
            System.out.printf(String.valueOf(tempList.get(i)));
        }
    }
}
