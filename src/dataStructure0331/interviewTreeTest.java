package dataStructure0331;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
}
public class interviewTreeTest {
    //给定一个二叉树，返回它的 前序 遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        //中序遍历
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        //后序遍历
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //检查两颗树是否相同
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean cur = true;
        if (p.val != q.val) {
            cur = false;
        }
        return cur && isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        //另一个树的子树
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean flag = false;
        if (s.val == t.val) {
            flag = isSameTree(s, t);
        }
        return flag || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public int maxDepth(TreeNode root) {
        //给定一个二叉树，找出其最大深度
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftSum = 1 + maxDepth(root.left);
        int rightSum = 1 + maxDepth(root.right);
        return Math.max(leftSum, rightSum);
    }

    public boolean isBalanced(TreeNode root) {
        //给定一个二叉树，判断它是否是高度平衡的二叉树。
        //一棵高度平衡二叉树定义为：
        //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        //对称二叉树（镜像对称）
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public void levelOrderTraversal(TreeNode root) {
        //用队列的方式来实现二叉树的层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode ret = queue.poll();
            System.out.print(ret.val + " ");
            if (ret.left != null) {
                queue.offer(ret.left);
            }
            if (ret.right != null) {
                queue.offer(ret.right);
            }
        }
    }


}
