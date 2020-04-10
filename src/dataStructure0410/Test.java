package dataStructure0410;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pairs implements Comparable<Pairs>{
    public int s1;
    public int s2;
    public int sum;
    public Pairs(int s1, int s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.sum = s1 + s2;
    }

    @Override
    public int compareTo(Pairs o) {
        return this.sum - o.sum;
    }
}
public class Test {
    public List<List<Integer>> KSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        PriorityQueue<Pairs> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                queue.offer(new Pairs(nums1[i], nums2[j]));
            }
        }
        for (int j = 0; j < k && !queue.isEmpty(); j++) {
            Pairs cur = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(cur.s1);
            list.add(cur.s2);
            result.add(list);
        }
        return result;
    }
}
