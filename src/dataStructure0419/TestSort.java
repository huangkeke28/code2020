package dataStructure0419;

import com.sun.javaws.IconUtil;

import java.util.Arrays;

public class TestSort {
    public void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            //只有0个元素或者1个元素 不需要排序
            return;
        }
        int index = partation(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private int partation(int[] array, int left, int right) {
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

    private void swap(int[] array, int beg, int end) {
        int tmp = array[end];
        array[end] = array[beg];
        array[beg] = tmp;
    }

    //[low, mid)有序区间
    //[mid, high)有序区间
    //把两个有序区间合并成一个有序区间
    private void merge(int[] array, int low, int mid, int high) {
        int[] output = new int[high - low];
        int outputindex = 0; // 记录当前output数组中放入多少元素
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
        //把output中的元素搬运回原数组
        for (int i = 0; i < high - low; i++) {
            array[low + i] = output[i];
        }
    }

    public void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length);
    }

    //[low, high)区间 两者插值为1 说明区间中只有0个元素或者1个元素
    private void mergeSortHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(array, low, mid);
        mergeSortHelper(array, mid, high);
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        TestSort testSort = new TestSort();
//        testSort.quickSort(array);
        testSort.mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
