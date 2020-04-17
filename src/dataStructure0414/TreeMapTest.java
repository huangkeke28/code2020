package dataStructure0414;

import com.sun.xml.internal.ws.api.message.Header;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TreeMapTest {
    //只出现一次的数字
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            Integer value = map.get(x);
            if (value == null) {
                map.put(x, 1);
            } else {
                map.put(x, value + 1);
            }
        }
        //遍历map找到出现次数为一次的数字
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (entry.getValue() == 1) {
//                return entry.getKey();
//            }
//        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getValue();
            }
        }
        Iterator<HashMap.Entry<Integer, Integer>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            HashMap.Entry<Integer, Integer> entry = iterator1.next();
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        Iterator<HashMap.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public int[] singleNumbers(int[] nums) {
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
        int b= 0;
        for (int x : nums) {
            if ((x & (bit << i)) != 0) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        int[] result = {a, b};
        return result;
    }
    static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }
    //复制带随机指针的链表
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.random = map.get(cur.random);
            newCur.next = map.get(cur.next);
        }
        return map.get(head);
    }

    public Node copyRandomList1(Node head) {
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        map.put(4, 40);
        map.put(5, 50);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("--------------------------");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
