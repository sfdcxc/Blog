package com.darcy.lanqiao2013;

public class _02马虎的算式 {
    public static void main(String[] args) {
        int res = 0;
        for(int a = 1; a < 10; a++){
            for(int b = 1; b < 10; b++){
                if(b != a){
                    for(int c = 1; c < 10; c++){
                        if(c != a && c != b){
                            for(int d = 1; d < 10; d++){
                                if(d != a && d != b && d != c){
                                    for(int e = 1; e < 10; e++) {
                                        if (e != a && e != b && e != c && e != d) {
                                            if ((10 * a + b) * (c * 100 + 10 * d + e) == (100 * a + 10 * d + b) * (10 * c + e)) {
                                                res = res + 1;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
