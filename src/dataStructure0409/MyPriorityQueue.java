package dataStructure0409;

public class MyPriorityQueue {
    private int[] array = new int[100];
    private int size = 0;

    public void offer(int x) {
        array[size] = x;
        size++;
        //把新加入的元素进行向上调整
        shiftUp(array, size - 1);

    }

    public static void shiftUp(int[] array, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (array[child] > array[parent]) {
                //大堆
                int temp = array[child];
                array[child] =array[parent];
                array[parent] = temp;
            } else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public int poll() {
        int oldValue = array[0];
        array[0] = array[size - 1];
        size--;
        shiftDown(array, size, 0);
        return oldValue;
    }

    public static void shiftDown(int[] array, int size, int index) {
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
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.println(cur);
        }
    }
}
