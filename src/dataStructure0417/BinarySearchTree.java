package dataStructure0417;

public class BinarySearchTree {
    static class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int key) {
            this.key = key;
        }
    }
    private Node head = null;
    public Node find(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.key > key) {
                cur = cur.left;
            } else if (cur.key < key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public boolean insert(int key) {
        //这里的插入 全部都是插入叶子结点上
        if (head == null) {
            head = new Node(key);
            return true;
        }
        Node parent = null;
        Node cur = head;
        while (cur != null) {
            if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            } else if (cur.key < key) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;
            }
        }
        if (parent.key > key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
        return true;
    }

    public boolean remove(int key) {
        Node cur = head;
        Node parent = null;
        while (cur != null) {
            if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            } else if (cur.key < key) {
                parent = cur;
                cur = cur.right;
            } else {
                removeNode(parent, cur);
                return true;
            }
        }
        return false;
    }

    private void removeNode(Node parent, Node cur) {
        if (cur.left == null) {
            if (cur == head) {
                head = cur.right;
            } else if(parent.left == cur) {
                parent.left = cur.right;
            } else if (parent.right == cur) {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (cur == head) {
                head = cur.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else if (parent.right == cur) {
                parent.right = cur.right;
            }
        } else {
            //cur的左右结点都不为空 化位置问题为已知问题 采用替罪羊思想
            Node goatParent = cur; //替罪羊结点的父节点
            Node scapeGoat = cur.right; //替罪羊结点
            while (scapeGoat.left != null) {
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            //循环结束后，scapeGoat指向了右子树的最小值
            cur.key = scapeGoat.key;
            //替罪羊结点一定没有左子树
            if (goatParent.left == scapeGoat) {
                goatParent.left = scapeGoat.right;
            } else if (goatParent.right == scapeGoat) {
                goatParent.right = scapeGoat.right;
            }

        }
    }

    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.key + " ");
        preOrder(head.left);
        preOrder(head.right);
    }

    public static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        inOrder(head.left);
        System.out.print(head.key + " ");
        inOrder(head.right);
    }
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(3);
        tree.insert(6);
        tree.insert(8);
        System.out.print("先序遍历：");


        preOrder(tree.head);
        System.out.println();
        System.out.print("中序遍历：");
        inOrder(tree.head);
        System.out.println();
        System.out.println(tree.find(2).key);
        System.out.println(tree.find(100));
        System.out.println(tree.remove(2));
        System.out.print("先序遍历：");
        preOrder(tree.head);
        System.out.println();
        System.out.print("中序遍历：");
        inOrder(tree.head);

    }
}
