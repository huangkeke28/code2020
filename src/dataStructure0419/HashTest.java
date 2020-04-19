package dataStructure0419;

import javax.swing.plaf.IconUIResource;

public class HashTest {
    static class Node {
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] array = new Node[101];
    private int size = 0; //表示当前hash表中的元素个数
    private static final double LOAD_FACTOR = 0.75;

    private int hashfunc(int key) {
        return key % array.length;
    }
    //如果key已经存在 就修改当前的value值 如果key不存在 就插入新得键值对
    public void put(int key, int value) {
        //1. 需要把key映射成数组下标
        int index = hashfunc(key);
        //2. 根据下标找到对应的链表
        Node list = array[index];
        //3. 当前得key在链表中是否存在
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                //key 已经存在了 直接修改value即可
                cur.value = value;
                return;
            }
        }
        //如果刚才循环没有相同key得值，直接插到当前链表得头部
        Node newNode = new Node(key, value);
        newNode.next = list;
        array[index] = newNode;
        size++;

        if (size / array.length >= LOAD_FACTOR) {
            reSize();
        }
    }

    private void reSize() {
        Node[] newArray = new Node[2 * array.length];
        // 把原来Hash表中的所有元素搬运到新的数组上
        for (int i = 0; i < array.length; i++) {
            for (Node cur = array[i]; cur != null; cur = cur.next) {
                int index = cur.key % newArray.length;
                Node newNode = new Node(cur.key, cur.value);
                newNode.next = newArray[index];
                newArray[index] = newNode;
            }
        }
        //让新的数组代替原来的数组
        array = newArray;
    }

    //根据key去查找指定元素 如果找到返回对应value 如果没找到 返回null
    public Integer get(int key) {
        //1. 先去找到key对应的下标
        int index = hashfunc(key);
        //2. 根据下标找到对应链表
        Node list = array[index];
        //3. 在链表中查找指定元素
        for (Node cur = list; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }

}