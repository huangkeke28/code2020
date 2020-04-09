package dataStructure0409;

import java.util.PriorityQueue;

public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //标准库中的优先队列搞得是一个小堆
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(8);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
        }

    }

}
