package dataStructure0410;


public class MyPriorityQueue {
    //自己实现一个优先级对了 标准库中实现的是小堆 这里实现大堆
    //堆的特点：堆是由完全二叉树转过来的 堆存储在一个数组中 队首元素为最小值(小堆) 队首元素为最大值(大堆)
    private int[] array = new int[100];
    private int size = 0;


    public void offer(int val) {
        array[size] = val;
        size++;
        shiftup(array, size - 1);
    }

    private static void shiftup(int[] array, int index) {
        //找到最后一个结点的父节点
        int child = index;
        int partent = (child - 1) / 2;
        while (child > 0) {
            if (array[child] > array[partent]) {
                int temp = array[child];
                array[child] = array[partent];
                array[partent] = temp;
            } else {
                break;
            }
            child = partent;
            partent = (child - 1) / 2;
        }
    }

    public int poll(){
        //出队列
        int oldValue = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return oldValue;
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                int temp = array[parent];
                array[parent] = array[child];
                array[child] = temp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    public int peek() {
        return array[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(6);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
        }
    }
}
