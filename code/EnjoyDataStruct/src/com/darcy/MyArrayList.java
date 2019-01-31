package com.darcy;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 线性表顺序存储代码
 * 假设Type为Int类型
 */
public class MyArrayList {
    private static final int MAXSIZE = 20;       //存储空间初始分配量
    private int size = 0;         //线性表当前长度
    private int[] list = new int[MAXSIZE];

    public MyArrayList(){
    }

    public MyArrayList(int n){
        this.list = new int[n];
    }

    public int getElem(int index){
        if(index > size){
            System.out.println("索引大于线性表长度");
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    public void add(int index, int element){

    }

    @Test
    public void test(){
        MyArrayList list = new MyArrayList();
        list.getElem(0);
    }
}
