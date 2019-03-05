package com.darcy.lanqiao2013;

import java.math.BigDecimal;
import java.math.BigInteger;

public class _04黄金分割数 {
    //1. 换位求斐波拉相邻两项的值 越多越精确 n / n + 1 n 再往上增加，这个比值的小数点后101位是精确的 不变的。
    //2. double无法精确 百位的小数 BigInterger 和 BigDecimal
    public static void main(String[] args) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for(int i = 3; i < 2000; i++){
            BigInteger t = b;
            b = a.add(b);
            a = t;
        }
        BigDecimal divide = new BigDecimal(a, 110).divide(new BigDecimal(b,110), BigDecimal.ROUND_HALF_DOWN);
        System.out.println(divide.toPlainString().substring(0, 103));
    }

}
