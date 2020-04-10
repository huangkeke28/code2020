package dataStructure0410;

import java.util.Arrays;

public class TestSort2 {
    //插入排序
    //a. 直接插入排序
    //时间复杂度 O(N ^ 2)
    //空间复杂度 O(1)
    //稳定性：稳定排序
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;
            for(; cur >= 0; cur--) {
                if (array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    //b.希尔排序
    //理论时间复杂度O(N ^ 1.3) 此处O(N ^ 2)
    //空间复杂度O(1)
    //稳定性： 不稳定
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortGap(array, gap);
            gap /= 2;
        }
        insertSortGap(array, 1);
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;

        }
    }

    //选择排序
    //时间复杂度O(N ^ 2)
    //空间复杂度O(1)
    //稳定性：不稳定
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            int v = array[bound];
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    int temp = array[bound];
                    array[bound] =array[cur];
                    array[cur] = temp;
                }
            }
        }
    }

    //堆排序
    //时间复杂度 O (N * log N)
    //空间复杂度O(1)
    //稳定性：不稳定排序
    public static void heapSort(int[] array) {
        //建堆 建个大堆
        createHeap(array);
        //取元素
        for (int i = 0; i < array.length - 1; i++) {
            int temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = array[0];
            array[0] = temp;
            shiftDown(array, array.length - 1 - i, 0);
        }
    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * index + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    //冒泡排序
    //时间复杂度O(N ^ 2)
    //空间复杂度O(1)
    //稳定性: 稳定排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    int temp = array[cur -1];
                    array[cur - 1] = array[cur];
                    array[cur] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        heapSort(array);
        //bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

}
