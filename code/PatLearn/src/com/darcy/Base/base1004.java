package com.darcy.Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class base1004 {

    static class Student implements Comparable<Student>{
        String name;
        String num;
        int score;

        @Override
        public int compareTo(Student o) {
            return -(score - o.score);
        }
    }

    public static void main(String[] args) {
        List<Student> stds = new ArrayList<>();
        Scanner in  = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        while(N > 0){
            String str = in.nextLine();
            String[] temp = str.split(" ");
            Student std = new Student();
            std.name = temp[0];
            std.num = temp[1];
            std.score = Integer.valueOf(temp[2]);
            stds.add(std);
            N--;
        }
        Collections.sort(stds);
        System.out.println(stds.get(0).name + " " + stds.get(0).num);
        System.out.println(stds.get(stds.size()-1).name+" "+stds.get(stds.size()-1).num);
    }
}
