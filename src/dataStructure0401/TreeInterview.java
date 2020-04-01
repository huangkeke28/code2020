package dataStructure0401;

import javax.swing.plaf.basic.BasicMenuUI;
import javax.xml.soap.Node;
import java.sql.ClientInfoStatus;
import java.util.*;

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}
public class TreeInterview {
    public TreeNode build() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        G.right = H;
        C.right = F;
        return A;
    }
    public void preOrderTraversal(TreeNode root) {
        //前序遍历
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(TreeNode root) {
        //中序遍历
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public void cengOrderTraversal(TreeNode root) {
        //层序遍历
        //使用队列来实现
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public int getSize(TreeNode root) {
        //求结点个数
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public int getLeafSize(TreeNode root) {
        //求叶子结点个数
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    public int getKLevelSize(TreeNode root, int val) {
        //求第k层采用递归先求上一层的结点个数
        if (root == null) {
            return 0;
        }
        if (val == 1) {
            return 1;
        }
        return getKLevelSize(root.left, val - 1) +
                getKLevelSize(root.right, val - 1);
    }

    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode result = find(root.left, val);
        if (result != null) {
            return result;
        }
        return find(root.right, val);
    }

    public List<Character> preorderTraversal(TreeNode root) {
        //给定一个二叉树 返回它的前序遍历
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    public List<Character> inorderTraversal(TreeNode root) {
        //给定一个二叉树 返回它的中序遍历
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    public List<Character> postorderTraversal(TreeNode root) {
        //给定一个二叉树 返回他的后序遍历
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return Collections.emptyList();
        }
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        list.add(root.val);
        return list;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        //检查两棵树是否相同
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean falg = false;
        if (p.val == q.val) {
            falg = true;
        }
        return falg && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t){
        //另一颗树的子树；
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
        //二叉树的最大深度
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }

    public boolean isBalanced(TreeNode root) {
        //给定一颗二叉树判定是否为平衡二叉树 高度差绝对值为1
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

    private boolean isMirror(TreeNode l1, TreeNode l2) {
        if (l1 == null && l2 == null) {
            return true;
        }
        if (l1 == null || l2 == null) {
            return false;
        }
        boolean flag = false;
        if (l1.val == l2.val) {
            flag = true;
        }
        return flag && isMirror(l1.left, l2.right) && isMirror(l1.right, l2.left);
    }

    public void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeInterview treeInterview = new TreeInterview();
        TreeNode root = treeInterview.build();
        int ret = treeInterview.getKLevelSize(root, 2);
        System.out.println(ret);
    }
}
