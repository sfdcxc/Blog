package com.darcy;

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N){
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;      //初始化
        }
    }

    //找到i的根节点
    private int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    //判断是否连接
    public boolean connected(int p, int q){
        return id[p] == id[q];
    }

    //合并p的子集和q的子集
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}
