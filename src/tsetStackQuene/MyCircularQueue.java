package tsetStackQuene;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

public class MyCircularQueue {
    public int[] array;
    public int size = 0;
    public int head = 0;
    public int tail = -1;
    public MyCircularQueue(int k) {
        array = new int[k];
    }

    public int Front() {
        //从队首获取元素
        if (size == 0) {
            return -1;
        }
        return array[head];
    }

    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return array[tail];
    }
    public boolean enQueue(int value) {
        if (size >= array.length) {
            return false;
        }
        tail++;
        array[tail] = value;
        if (tail >= array.length) {
            tail = 0;
        }
        size++;
        return true;
    }
    public boolean deQueue() {
        //头删
        if (size == 0) {
            return false;
        }
        head++;
        if (head >= array.length) {
            head = 0;
        }
        size--;
        return true;
    }
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        }
        return true;
    }

    public boolean isFull() {
        if (size >= array.length) {
            return true;
        }
        return false;
    }
}
