package dataStructure0404;



import java.net.BindException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeInterviewTest {
    static class Node{
        public char val;
        public Node left;
        public Node right;

        public Node(char val) {
            this.val = val;
        }
    }
    public Node build() {
        //构建一棵树
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
        //E.left = G;
        //G.right = H;
        C.left = G;
        C.right = F;
        return A;
    }
    public void levelOrderTraversal(Node root) {
        //二叉树的层序遍历
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    public boolean isCompleteTree(Node root) {
        //判断一棵树是不是完全二叉树
        //分两个阶段
        boolean isSecondStep = false;
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (!isSecondStep) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left != null && cur.right == null) {
                    queue.offer(cur.left);
                    isSecondStep = true;
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else {
                    isSecondStep = true;
                }
            } else {
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
//        TreeInterviewTest d = new TreeInterviewTest();
//        Node root = d.build();
//        d.levelOrderTraversal(root);
//        System.out.println();
//        System.out.println(d.isCompleteTree(root));

        //二叉树的构造和遍历
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            Node root = build(line);
            inOrder(root);
            System.out.println();
        }

    }
    public static int index = 0;
    private static Node build(String line) {
        index = 0;
        return createTreeNode(line);
    }

    private static Node createTreeNode(String line) {
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        Node root = new Node(cur);
        index++;
        root.left = createTreeNode(line);
        index++;
        root.right = createTreeNode(line);
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root + " ");
        inOrder(root.right);
    }


}
