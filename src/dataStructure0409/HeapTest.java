package dataStructure0409;

import java.util.Arrays;

public class HeapTest {
    public static void shiftDown(int[] array, int size, int index) {
        //左右子树必须是堆这样的结构才能进行向下调整
        int parent = index;
        int child = index * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            if (array[parent] > array[child]) {
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

    public static void createHeap(int[] array, int size) {
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        createHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
