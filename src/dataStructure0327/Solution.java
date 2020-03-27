package dataStructure0327;

import java.util.*;

public class Solution {
    //字符集合
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (!stringBuffer.toString().contains(c + "")) {
                    stringBuffer.append(c);
                }
            }
            System.out.println(stringBuffer.toString());
        }
    }
    //给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
    //
    //每次「迁移」操作将会引发下述活动：
    //
    //位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
    //位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
    //位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
    //请你返回 k 次迁移操作后最终得到的 二维网格
    public List<List<Integer>> shiftGrid(int[][] grid, int k){
        int[] nums = new int[grid.length * grid[0].length];
        int iMax = grid.length;
        int jMax = grid[0].length;
        for (int i = 0; i < iMax; i++) {
            for (int j = 0; j < jMax; j++) {
                k %= nums.length;
                nums[k] = grid[i][j];
                k++;
            }
        }
        k = 0;
        List<List<Integer>> lists = new ArrayList<>(grid.length);
        for (int i = 0; i < iMax; i++) {
            List<Integer> list = new ArrayList<>(grid[0].length);
            for (int j = 0; j < iMax; j++) {
                list.add(nums[k++]);
            }
            lists.add(list);
        }
        return lists;
    }

    public List<List<Integer>> shiftGrid2(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }
        Queue<Integer> queue = new LinkedList<>();
        int R = grid.length;
        int C = grid[0].length;
        int finalK = grid[0].length;
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C -1; j >= 0; j--) {
                queue.offer(grid[i][j]);
            }
        }
        for (int i = 0; i < finalK; i++) {
            queue.offer(queue.poll());
        }
        List<Integer> list = new ArrayList<>();
        for (int e : queue) {
            list.add(e);
        }
        Collections.reverse(list);
        if (C == 1) {
            for (int i = 0; i < list.size(); i++) {
                result.add(Arrays.asList(list.get(i)));
            }
            return result;
        }
        List<Integer> res = null;
        for (int i = 0; i < list.size(); i++) {
            if (i % C == 0) {
                res = new ArrayList<>();
                res.add(list.get(i));
            } else if (i % (C - 1) == 0) {
                res.add(list.get(i));
                result.add(res);
            } else {
                res.add(list.get(i));
            }
        }
        return result;
    }
}
