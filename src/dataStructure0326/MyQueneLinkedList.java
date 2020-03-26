package dataStructure0326;

public class MyQueneLinkedList {
    static class Node {
        public int val;
        public Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node head = null;
    private Node tail = null;
    //入队列
    public void offer(int val) {
        //offer提供
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }


    //出队列
    public Integer poll() {
        if (head == null) {
            return null;
        }
        Integer ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }
    //取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }


}
