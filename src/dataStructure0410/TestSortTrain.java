package dataStructure0410;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;

public class TestSortTrain {
    //插入排序
    //a.直接插入排序
    //时间复杂度O(N ^ 2)
    //空间复杂度O(1)
    //稳定性：稳定排序
    //特点:当待排区间元素比较少时 排序效率比较高
    //     当整个数组接近有序时  排序效率比较高
    public static void insertSort(int[] array) {
        for (int bound = 1; bound < array.length; bound++) {
            //用一个变量记录一下当前要比较的数字
            int v = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                //升序排
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
    //时间复杂度：理论值O(N ^ 1.3) 这里O(N ^ 2)
    //空间复杂度O(1)
    //稳定性：不稳定排序
    public static void shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSort(array, gap);
            gap /= 2;
        }
        insertSort(array, 1);
    }

    private static void insertSort(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - gap;
            for(; cur >= 0; cur -= gap) {
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
            //已排区间[0, bound)
            //待排区间[bound, array.length)
            int cur = bound + 1;
            for (; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    swap(array, bound, cur);
                }
            }
        }
    }
    //堆排序
    //时间复杂度O(N * logN)
    //空间复杂度O(1)
    //稳定性：不稳定排序
    public static void heapSort(int[] array) {
        creatHeap(array,array.length);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - 1 - i);
            shiftDown(array, array.length - 1 - i, 0);
        }
    }

    private static void creatHeap(int[] array, int length) {
        for (int i = (length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, length, i);
        }
    }

    private static void shiftDown(int[] array, int length, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && array[child + 1] > array[child]) {
                child = child + 1;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private static void swap(int[] array, int bound, int cur) {
        int tmp = array[bound];
        array[bound] = array[cur];
        array[cur] = tmp;
    }

    //冒泡排序
    //时间复杂度O(N ^ 2)
    //空间复杂度O(1)
    //稳定性：稳定排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur - 1,  cur);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
