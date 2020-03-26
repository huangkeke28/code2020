package dataStructure0326;

public class MyStack {
    private int[] array = new int[100];
    private int size = 0;
    //出栈
    public int pop() {
        int ret = array[size - 1];
        size--;
        return ret;
    }

    //入栈
    public void push(int data) {
        array[size] = data;
        size++;
        return;
    }

    //取栈顶元素
    public int peek() {
        return array[size - 1];
    }
}
