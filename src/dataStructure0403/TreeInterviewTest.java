package dataStructure0403;

import java.util.*;

public class TreeInterviewTest {
    //先序：根左右
    //中序：左根右
    //后序：左右根
    public static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        //判断一颗树是否为完全二叉树
        boolean isSecondStep = false;
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!isSecondStep) {
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left != null && cur.right == null) {
                    isSecondStep = true;
                    queue.offer(cur.left);
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

    public static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        //!!!!!//result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        inOrder(root.left);
        inOrder(root.right);
    }

    private static int index = 0;
    private static TreeNode build(String line) {
        index = 0;
        return creatTreePreOrder(line);
    }

    private static TreeNode creatTreePreOrder(String line) {
        char cur = line.charAt(index);
        if (cur == '#') {
            return null;
        }
        TreeNode root = new TreeNode(cur);
        index++;
        root.left = creatTreePreOrder(line);
        index++;
        root.right = creatTreePreOrder(line);
        return root;
    }
}
