package com.darcy;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueLearn {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();

        queue2.add(2);
        queue2.add(4);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(3);
        queue.add(2);

        //让队列中的元素出队列
        Integer peek = queue.peek();
        System.out.println("优先队列出队的元素: " + peek);

        //判断队列中是否包含该元素,包含返回true,否则返回false
        boolean flag = queue.contains(1);
        System.out.println("是否存在: " + flag);

        //是否该队列包含该集合，包含返回true,否则返回false
        boolean contains = queue.containsAll(queue2);

        //获取队列的头元素
        Integer element = queue.element();
        System.out.println("元素是: " + element);

        //遍历优先级队列中的元素
        Iterator<Integer> iterator = queue.iterator();
        while(iterator.hasNext()){
            Integer integer = (Integer) iterator.next();
            System.out.println(" " + integer);
        }
        System.out.println();

        //检索并删除此队列的头部，如果为空， 返回null
        Integer poll = queue.poll();
        System.out.println(poll);

        //遍历优先级队列中的每个元素
        Iterator<Integer> iterator1 = queue.iterator();
        System.out.println("使用poll方法后遍历优先级队列中的元素 ： ");
        while (iterator1.hasNext()) {
            Integer integer = (Integer) iterator1.next();
            System.out.print("  " + integer);
        }

    }
}
