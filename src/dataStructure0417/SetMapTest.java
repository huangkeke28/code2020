package dataStructure0417;

import org.omg.PortableInterceptor.INACTIVE;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

public class SetMapTest {
    public int singleNumber1(int[] nums) {
        //只出现一次的数字
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null) {
                map.put(x, 1);
            } else {
                map.put(x, value + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }


    public int[] singleNumber(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        int bit = 1;
        int i = 0;
        for (; i < 32; i++) {
            if ((ret & (bit << i)) != 0) {
                break;
            }
        }
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((x & (bit << i)) != 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        int[] num = {a, b};
        return num;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            next = null;
            random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //复制带随机指针的链表
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
        return map.get(head);
    }

    public int numJewelsInStones(String J, String S) {
        //宝石与石头
        Set<Character> set = new HashSet<>();
        char[] array = J.toCharArray();
        for (char x : array) {
            set.add(x);
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char x = S.charAt(i);
            if (set.contains(x)) {
                count++;
            }
        }
        return count;
    }

    static class MyCompartor implements Comparator<String> {
        private Map<String, Integer> map;

        public MyCompartor(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        //1. 先统计每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            Integer count = map.getOrDefault(s, 0);
            map.put(s, count + 1);
        }
        //2. 把刚才这里统计的字符串放到ArrayList中
        // keySet 相当于得到一个Set, Set中存放所有的key
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        //3. 按照刚才字符串出现次数，针对ArrayList进行排序
        // sort 默认是按照元素自身大小进行升序排序(String的字典序)
        //Collections.sort(arrayList, new MyCompartor(map));
        //下面的代码创建了一个匿名内部类
        //你不知道这个类名字是啥 但是你知道这个类实现了 Comparator 接口
        //这个类只需要用一次 用完就丢了 这时候就可以用匿名内部类
//        Collections.sort(arrayList, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int count1 = map.get(o1);
//                int count2 = map.get(o2);
//                if (count1 == count2) {
//                    return o1.compareTo(o2);
//                }
//                return count2 - count1;
//            }
//        });
        //lambda表达式 本质上就是一个匿名方法
        Collections.sort(arrayList, (o1, o2) -> {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        });
        return arrayList.subList(0, k);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
