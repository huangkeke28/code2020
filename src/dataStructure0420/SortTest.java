package dataStructure0420;

import java.util.Arrays;

import static dataStructure0414.SortTest.merge;

public class SortTest {
    //七种排序算法
    //统一按照升序排列
    //1. 插入排序
    //时间复杂度O(N ^ 2)
    //空间复杂度O(1)
    //稳定性: 稳定排序
    //每次取待排序区间的第一个元素 往前面的有序区间中插入 和顺序表插入类似(搬运)
    public static void insertSort(int[] array) {
        //bound 来划分出两个区间
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > bound) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    public static void insertSort2(int[] array) {
        //每次取待排序区间的第一个元素,往前面的有序区间中插入
        for (int bound = 1; bound < array.length; bound++) {
            int v = array[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur--) {
                if (array[cur] > v) {
                    array[cur + 1] = array[cur];
                } else {
                    break;
                }
            }
            array[cur + 1] = v;
        }
    }

    //2. 希尔排序
    //插入排序的更近一步
    //时间复杂度理想情况下O(N ^ 1.3)
    //空间复杂度 O(1)
    //稳定性：不稳定排序
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
            for (;cur >= 0; cur -= gap) {
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
    public static void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[bound] > array[cur]) {
                    swap(array, bound, cur);
                }
            }
        }
    }
    //堆排序
    //时间复杂度O(NlogN)
    //空间复杂度O(1)
    //稳定性 不稳定排序
    public static void heapSort(int[] array) {
        //基本思路 先建立一个小堆
        //每次取堆顶元素 然后再向下调整堆
        creatHeap(array);
        for (int i = 0; i < array.length; i++) {
            swap(array, 0, array.length - 1 - i);
            shiftDown(array, 0, array.length - 1 - i);
        }
    }

    private static void shiftDown(int[] array, int index, int heapLength) {
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

    private static void creatHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, i, array.length);
        }
    }

    private static void swap(int[] array, int cur, int bound) {
        int tmp = array[cur];
        array[cur] = array[bound];
        array[bound] = tmp;
    }

    //冒泡排序
    //时间复杂度O(N ^ 2)
    //空间复杂度O(1)
    //稳定性 不稳定排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] > array[cur]) {
                    swap(array, cur, cur - 1);
                }
            }
        }
    }

    //快速排序
    //时间复杂度O(NlogN)
    //空间复杂度O(N)
    //稳定性 稳定排序
    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partation(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partation(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        int base = array[right];
        while (beg < end) {
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            while (beg < end && array[end] >= base) {
                end--;
            }
            swap(array, beg, end);
        }
        swap(array, beg, right);
        return beg;
    }

    //归并排序
    public static void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    private static void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(array, low, mid);
        mergeSortHelper(array, mid, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputindex = 0;
        int cur1 = low;
        int cur2 = mid;
        while (cur1 < mid && cur2 < high) {
            if (array[cur1] <= array[cur2]) {
                output[outputindex] = array[cur1];
                outputindex++;
                cur1++;
            } else {
                output[outputindex] = array[cur2];
                outputindex++;
                cur2++;
            }
        }
        while (cur1 < mid) {
            output[outputindex] = array[cur1];
            outputindex++;
            cur1++;
        }
        while (cur2 < high) {
            output[outputindex] = array[cur2];
            outputindex++;
            cur2++;
        }
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //insertSort2(array);
        //shellSort(array);
        //selectSort(array);
        //heapSort(array);
        //bubbleSort(array);
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

}
