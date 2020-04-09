package dataStructure0409;

import java.util.Arrays;

public class Heap {
    //向下调整 左右子树都是堆才能进行这样的调整
    public static void shiftDown(int[] array, int size, int index) {
        //index表示从那个位置的下标开始调整
        int parent = index;
        int child = 2 * parent + 1; //根据parent下标找到左子树
        while (child < size) {
            //比较左右子树 找到较小值
            if (child + 1 < size && array[child + 1] < array[child]) {
                child = child + 1;
            }
            //经过上面的比较 已经不知道child是左子树还是右子树
            //但是知道child是左右子树的最小值下标

            //拿child位置的元素和parent位置的元素比较
            if (array[child] < array[parent]) {
                //不符合小堆规则
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
                //调整完毕不需要继续
            }
            parent = child;
            child = 2 * parent + 1;
            //更新parent 和child，处理下层数据
        }
        //时间复杂度O(logN);
    }

    public static void createHeap(int[] array, int size) {
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
        //时间复杂度O(N);
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        createHeap2(array, array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void shiftDown1(int[] array, int size, int index) {
        //给定一个小堆 进行向下调整
        //index 是指从那个位置开始调整
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child] > array[child + 1]) {
                //取最小值
                child = child + 1;
            }
            //将child和parent位置的值进行比较
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

    public static void createHeap1(int[] array, int size) {
        //建堆
        //向下调整，从最后一个非叶子节点往前遍历；
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown1(array, size, i);
        }
    }

    public static void shiftDown2(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
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
            child = 2 *parent + 1;
        }
    }

    public static void createHeap2(int[] array, int size) {
        for (int i = (size - 1 - 1 ) / 2; i >= 0; i--) {
            shiftDown2(array, size, i);
        }
    }
}
