package dataStructure0414;

import java.util.Arrays;

public class SortTest {
    //归并排序
    //[low, mid)有序区间
    //[mid, high)有序区间
    //把这两个有序区间合并成一个有序区间
    public static void merge(int[] array, int low, int mid, int high) {
        int[] outPut = new int[high - low];
        int outPutIndex = 0; //记录当前output数组中被放入多少个元素
        int cur1 = low;
        int cur2 = mid;

        while (cur1 < mid && cur2 < high) {
            // 这里的小于等于才能保证稳定性
            if (array[cur1] <= array[cur2]) {
                outPut[outPutIndex] = array[cur1];
                outPutIndex++;
                cur1++;
            } else {
                outPut[outPutIndex] = array[cur2];
                outPutIndex++;
                cur2++;
            }
            //当上面的循环结束的时候，肯定是cur1或cur2有一个先到达末尾，另一个还剩下一些内容
            //把剩下的内容全都拷贝到outPut中
            while (cur1 < mid) {
                outPut[outPutIndex] = array[cur1];
                outPutIndex++;
                cur1++;
            }
            while (cur2 < high) {
                outPut[outPutIndex] = array[cur2];
                outPutIndex++;
                cur2++;
            }

            //把outPut中的元素搬运到原来的数组
            for (int i = 0; i < high - low; i++) {
                array[low + i] = outPut[i];
            }
        }

    }

    public static void mergeSort(int[] array) {
        mergeHelper(array, 0, array.length);
    }

    //[low, high) 前闭后开区间 两者插值小于等于1 区间中就只有0个元素 或者 1 个元素
    private static void mergeHelper(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = (low + high) / 2;
        mergeHelper(array, low, mid);
        mergeHelper(array, mid, high);
        merge(array, low, mid, high);
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
