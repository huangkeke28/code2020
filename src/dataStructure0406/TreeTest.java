package dataStructure0406;

import javax.xml.soap.Node;
import java.util.Stack;

public class TreeTest {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    public void build() {

    }

    //前序遍历的非递归实现
    public void preOrderTraversal(TreeNode root) {
        //用栈实现   后进先出
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.val + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.right);
            }
        }
    }

    public static void shiftDown(int[] array, int size, int index) {
        //向下调整
            int left = 2 * index + 1;
            while (left < size) {
                int min = left;
                int right = 2 * index + 2;
                if (right < size) {
                    if (array[right] < array[left]) {
                        min = right;
                    }
                }
                if (array[index] <= array[min]) {
                    break;
                }
                int temp = array[index];
                array[index] = array[min];
                array[min] = temp;
                index = min;
                left = 2 * index + 1;
            }
    }
}
