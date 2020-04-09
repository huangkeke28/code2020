package dataStructure0409;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int n1;
    public int n2;
    public int sum;

    public Pair(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.sum = n1 + n2;
    }

    @Override
    public int compareTo(Pair o) {
        // this 比 other 小， 返回 < 0;
        // this 比 other 大， 返回 > 0;
        // this 比 other 一样大， 返回 0;
        return this.sum - o.sum;
    }
}
public class Solution {
    public List<List<Integer>> KSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        PriorityQueue<Pair>  queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pair(nums1[i], nums2[j]));
            }
        }
        for (int i = 0; i < k && queue.isEmpty(); i++) {
            Pair cur = queue.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(cur.n1);
            temp.add(cur.n2);
            result.add(temp);
        }

        return result;
    }
}
