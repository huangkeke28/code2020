package tsetStackQuene;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyQuene {
    //用栈实现队列
    //B 主要实现出队列和取队顶元素
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    public void push(int x) {
        //人生会经历三次成长
        //第一次是发现自己不是世界的中心的时候
        //第二次是发现即使再怎么努力 有些事终究还是无能为力
        //第三次在明知道有些事可能会无能为力，但还是会尽力争取的时候
        //1 2 3 4 5
        //把B中元素往A里倒腾
        if (!B.empty()) {
            A.push(B.pop());
        }
        A.push(x);
    }

    public Integer pop() {
        if (empty()) {
            return null;
        }
        while (!A.empty()) {
            B.push(A.pop()); // 5 4 3 2 1
        }
        return B.pop();
    }

    public Integer peek() {
        if (empty()) {
            return null;
        }
        while (!A.empty()) {
            B.push(A.pop()); // 5 4 3 2 1
        }
        return B.peek();
    }

    public boolean empty() {
        return A.empty() & B.empty();
    }
}
