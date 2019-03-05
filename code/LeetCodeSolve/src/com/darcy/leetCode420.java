package com.darcy;

import java.util.Scanner;

public class leetCode420 {

    public static String s;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        s = in.nextLine();
        System.out.println(strongPasswordChecker(s));
//        System.out.println(isHaveNum && isHaveHightChar && isHaveLowChar);
    }
    public static int strongPasswordChecker(String s) {
        int ans = 0;
        boolean hasLower = false, hasUpper = false, hasDight = false;

        int n = s.length();
        if(n < 2)
            return 6 - n;
        char ch;
        char pre = ' ';

        int count = 1;
        int[] nums = new int[3];
        for(int i = 0; i < n; i++){
            ch = s.charAt(i);
            if(ch == pre)
                count++;
            else {
                if(count >= 3){
                    nums[count % 3]++;
                    ans += count / 3;
                }
                count = 1;
                pre = ch;
                if(ch >= 'a' && ch <= 'z')
                    hasLower = true;
                else if(ch >= 'A' && ch <= 'Z')
                    hasUpper = true;
                else if(ch >= '0' && ch <= '9')
                    hasDight = true;
            }
        }
        if (count >= 3){
            nums[count % 3]++;
            ans += count / 3;
        }
        int lose = (hasLower?0:1) + (hasUpper?0:1) + (hasDight?0:1);

        if(n > 20){
            int remain = n - 20;
            if(remain <= nums[0]){
                ans -= remain;
            }else if((remain - nums[0]) <= 2 * nums[1])
                ans -= nums[0] + (remain - nums[0]) / 2;
            else
                ans -= nums[0] + nums[1] + (remain - nums[0] - nums[1] * 2) / 3;
            return Math.max(Math.max(ans,lose),(6-n));

        }else {
            return Math.max(Math.max(ans,lose),(6-n));
        }

    }
}
