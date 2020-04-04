package dataStructure0404;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class TreeInterviewTest2 {
    public static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        //二叉树的层序遍历
        result.clear();
        if (root == null) {
            return result;
        }
        helper(root,0);
        return result;
    }

    private static void helper(TreeNode root, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }
//    private TreeNode lca = null;
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        //二叉树的最近公共祖先
//        if (root == null) {
//            return null;
//        }
//        findNode(root, p, q);
//        return lca;
//
//    }
//
//    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) {
//            return false;
//        }
//        int left = findNode(root.left, p, q) ? 1 : 0;
//        int right = findNode(root.right, p, q) ? 1 : 0;
//        int mid = (root == q || root == p) ? 1 : 0;
//        if (left + right + mid == 2) {
//            lca = root;
//        }
//        return (left + right + mid) > 0;
//    }
    private static TreeNode cls;
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //二叉树的最近公共祖先
         if (root == null) {
             return null;
         }
         helpers(root, p, q);
         return cls;
    }

    private boolean helpers(TreeNode root, TreeNode p, TreeNode q) {
         //采用后序遍历的方法
        if (root == null) {
            return false;
        }
        int left = helpers(root.left, p, q) ? 1 : 0;
        int right = helpers(root.right,p , q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if ((left + right + mid) == 2) {
            cls = root;
        }
        return (left + right + mid) > 0;
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
         //二叉树搜索树转换成排序双向链表
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode lefttail = left;
        while (lefttail != null && lefttail.right != null) {
            lefttail = lefttail.right;
        }
        if (left != null) {
            lefttail.right = pRootOfTree;
            pRootOfTree.left = lefttail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left == null ? pRootOfTree : left;
    }

    private int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //根据一棵树的前序遍历与中序遍历构造二叉树
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int pos = find(inorder, left, right, root.val);
        root.left = buildTreeHelper(preorder, inorder, left, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1 , right);
        return root;
    }
    private int find(int[] inorder, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if (inorder[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    private StringBuilder stringBuilder = new StringBuilder();
    public String tree2str(TreeNode t) {
        //根据二叉树创建字符串
        if (t == null) {
            return "";
        }
        helpersss(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void helpersss(TreeNode t) {
        if (t == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(t.val);
        helpersss(t.left);
        if (t.left == null && t.right != null) {
            stringBuilder.append("()");
        }
        helpersss(t.right);
        stringBuilder.append(")");
    }
}
