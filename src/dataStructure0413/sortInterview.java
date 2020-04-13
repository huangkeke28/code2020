package dataStructure0413;

import java.util.Arrays;
import java.util.Stack;

public class sortInterview {
    //快速排序
    public static void quickSort(int[] array) {
        //辅助完成递归
        //此处为了代码简单，区间设定成前闭后闭
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            //区间中有0个或者1个元素，此时不需要排序
            return;
        }
        //针对[left, right]区间进行整理
        //index 返回值就是整理完毕后， left 和 right 的重合位置. 知道这个位置才能进一步进行递归
        int index = partation(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partation(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        //取最右侧元素为基准值
        int base = array[right];
        while (beg < end) {
            //从左往右找比基准值大的元素
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            //当上面的循环结束时，i 要么和 j重合， 要么i就指向一个大于base的值
            //从右往左找比基准值小的元素
            while (beg < end && array[end] >= base) {
                end--;
            }
            //当上面的循环结束时，i 要么和 j重合， 要么j就指向一个小于base的值
            swap(array, beg, end);
        }
        //当i 和 j 重合的时候，最后一步，要把重合位置的元素和基准值进行交换
        //[思考]：为什么下面交换了之后，仍然能满足快排的要求呢?
        //right 这是序列中最后的位置.就要求i j 重合位置的元素必须大于等于基准值的元素，才可以放到后面
        //如何证明找到的 i 位置的元素一定 >= 基准值呢?
        //a) i++ 导致和 j 重合
        //   此时最终的值取决于上次循环中 j 指向的值  j应该是找到了一个小于基准值的元素,然后和一个大于基准值的元素交换了
        //   此时最终的j一定是大于基准值的元素
        //b) j-- 导致和 i 重合
        //   此时上面 i++ 的循环退出就一定是因为 i 位置找到了一个比基准值大的元素 j 和 i  重合最终元素也一定大于等于基准值
        swap(array, beg, right);
        return beg;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    //快速排序核心过程
    //1. 先针对整个区间进行整理，整理成左侧小于等于基准值，右侧大于等于基准值
    //2. 递归针对左侧区间和右侧区间分别进行整理
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        quickSort2(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSortByLoop(int[] array) {
        //借助栈模拟实现递归的过程
        //stack用来存放数组下标，通过下标来表示接下来要处理的区间是啥
        Stack<Integer> stack = new Stack<>();
        //初始情况下先把右侧区间入栈 再把左侧区间入栈，仍然构成前闭后闭区间
        stack.push(array.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            if (left >= right) {
                continue;
            }
            int index = partation(array, left, right);
            stack.push(right);
            stack.push(index + 1);
            stack.push(index - 1);
            stack.push(left);
        }
    }

    public static void quickSort2(int[] array) {
        quickSort2Helper(array, 0, array.length - 1);
    }

    private static void quickSort2Helper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partation2(array, left, right);
        quickSort2Helper(array, left, index - 1);
        quickSort2Helper(array, index + 1, right);
    }

    private static int partation2(int[] array, int left, int right) {
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
}
