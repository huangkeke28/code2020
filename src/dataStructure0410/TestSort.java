package dataStructure0410;

import java.util.Arrays;

public class TestSort {
    //插入排序
    //时间复杂度 O(N ^ 2);
    //空间复杂度 O(1);
    //稳定性: 稳定排序

    //插入排序的两个重要特点
    //a. 当待排序元素区间比较少时,排序效率很高
    //b. 当整个数组比较接近有序的时候,排序效率也很高
    public static void insertSort(int[] array) {
        //bound来划分出两个区间
        for (int bound = 1; bound < array.length; bound++) {
            int v =array[bound];
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

    //希尔排序
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            //需要循环进行分组插排
            insertSortGap(array, gap);
            gap /= 2;
        }
        insertSortGap(array, 1);
    }

    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap; //整个操作是找同组的上一个元素
            for (; cur >= 0; cur-= gap) {
                if (array[cur] > v) {
                    array[cur + gap] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + gap] = v;
        }
    }
    //选择排序(打擂台思想)
    //时间复杂度O(N ^ 2)
    //空间复杂度O(1)
    //稳定性：不稳定排序
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int temp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = temp;
                }
            }
        }
    }

    //堆排序
    //时间复杂度 O(N * logN)      O(logN)可近似看成O(1)
    //空间复杂度 O(1)
    //稳定性：不稳定
    public static void heapSort(int[] array) {
        createHeap(array);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - 1 - i);
            shiftDown(array, array.length - i - 1, 0);
        }

    }

    private static void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[parent] < array[child]) {
                swap(array, parent, child);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    //冒泡排序
    //时间复杂度O(N ^ 2);
    //空间复杂度O(1);
    //稳定性：稳定的
    public static void bubbleSort(int[] array) {
        //按照每次找最小的元素进行排序
        for (int bound = 0; bound < array.length; bound++) {
            //[0, bound) 已排序区间
            //[bound, size) 待排序区间
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur - 1, cur);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //insertSort(array);
        //selectSort(array);
        //heapSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
