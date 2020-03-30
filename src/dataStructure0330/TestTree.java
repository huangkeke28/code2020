package dataStructure0330;

import java.util.LinkedList;
import java.util.List;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}
public class TestTree {
    public static void main(String[] args) {
        System.out.print("先序: ");
        preOrder(bulid());
        System.out.println();
        System.out.print("中序: ");
        midOrder(bulid());
        System.out.println();
        System.out.print("后序: ");
        postOrder(bulid());
    }
    //先去构造一颗二叉树
    public static Node bulid() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        G.right = H;
        C.right = F;
        return A;
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void midOrder(Node node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        System.out.print(node.val + " ");
        midOrder(node.right);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
    //写一个方法求二叉树中结点的个数
    public static int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }
    //求二叉树叶子结点的个数
    public static int leafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }
    //求二叉树第k层的结点个数
    public static int KLevelSize(Node root, int k) {
        if (k < 1 || root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return KLevelSize(root.left, k - 1) + KLevelSize(root.right,  k - 1);
    }
    //在二叉树中查找指定元素
    public static Node find(Node root, char toFind) {
        if (root == null) {
            return null;
        }
        if (root.val == toFind) {
            return root;
        }
        Node result = find(root.left, toFind);
        if (result != null) {
            return result;
        }
        return find(root.right, toFind);
    }
    //给定一个二叉树返回它的前序遍历
    public List<Character> preorderTraversal(Node root) {
        List<Character> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }
}
