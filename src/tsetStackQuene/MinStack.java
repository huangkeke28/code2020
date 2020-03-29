package tsetStackQuene;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
    //能在时间复杂度O(1)内找出栈的最小元素
    //用空间换时间
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    public MinStack() {

    }

    public void push(int x) {
        if (A.empty()) {
            A.push(x);
            B.push(x);
            return;
        }
        int min = B.peek();
        if (x < min) {
            A.push(x);
            B.push(x);
        } else {
            A.push(x);
            B.push(min);
        }
    }

    public void pop() {
        A.pop();
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public Integer getMin() {
        return B.peek();
    }
}
