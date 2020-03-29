package tsetStackQuene;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyStack {
    //用两个队列实现一个栈
    public Queue<Integer> A = new LinkedList<>();
    public Queue<Integer> B = new LinkedList<>();

    public void push(int x) {
        A.add(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            B.offer(A.poll());
        }
        int x = A.poll();
        Queue<Integer> temp = A;
        A = B;
        B = temp;
        return x;
    }

    public Integer top() {
        if (empty()) {
            return null;
        }
        while (A.size() > 1) {
            B.offer(A.poll());
        }
        int x = A.poll();
        B.offer(x);
        Queue<Integer> temp = A;
        A = B;
        B = temp;
        return x;

    }

    public boolean empty() {
        return A.isEmpty() & B.isEmpty();
    }
}
