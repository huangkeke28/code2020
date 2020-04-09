package dataStructure0409;



import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeInterviewTest {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
    //二叉树的构建
    public static TreeNode build() {
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

    //二叉树的非递归前序遍历
    //根左右
    //采用栈的方式实现（先进后出）
    public static void preOrderTraversal(TreeNode root) {
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
                stack.push(cur.left);
            }
        }
    }

    //二叉树非递归中序遍历
    //左中右
    //栈(先进后出)
    public static void InOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            //这里不能让栈顶元素出栈 而是要取栈顶元素
            TreeNode cur = stack.peek();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            //如果当前节点的左子树为空 或者第二次访问当前结点则可以打印此结点
            //创建一个变量来记录访问的前一个结点 从而实现是否为第二次访问
            if (cur.left == null || cur == prev) {
                TreeNode k = stack.pop();
                System.out.print(k.val + " ");
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            prev = cur;
        }
    }

    public static void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        //准备一个栈起到辅助效果
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                //1。循环往左找，不遇到的元素都入栈
                stack.push(cur);
                cur = cur.left;
            }
            //2. 如果当前栈为空 遍历就结束
            if (stack.isEmpty()) {
                break;
            }
            //3. 取栈顶元素并访问之
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            //4.从当前结点的右子树再出发，继续刚才的过程
            cur = top.right;

            //1. 先从root出发，向左找，路上遇到的元素纷纷入栈，一直找到左子树为空
            //暂时先不找了
            //2.到达最左侧之后，取栈顶元素，同时出栈，并访问这个元素
            //3.把刚才栈顶元素的右子树作为起点，再循环往左找，路径上遇到的元素一次入栈
        }
    }

    public static void postOrderByLoop(TreeNode root) {
        //1.创建一个cur变量，指向root，从cur出发循环往左找，路上遇到的非空结点都入栈
        //2.取出栈顶元素(是peek而不是pop)，此时栈顶元素能否访问还得进一步判断
        //a)如果栈顶元素没有右子树，说明该结点可以访问，访问+pop
        //b)如果栈顶元素得右子树已经访问过了，此时也可以访问该结点，访问 + pop
        //3.从刚才栈顶元素得右子树出发继续刚才得过程
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || pre == top.right) {
                System.out.print(top.val + " ");
                stack.pop();
                pre = top; //时刻维护好pre让它指向已经遍历元素得最后一个
            } else {
                cur = top.right;
            }
        }
    }
    public static void main(String[] args) {
        //TreeInterview t1 = new TreeInterview();
        TreeNode root = build();
        //System.out.println("前序遍历：");
        //preOrderTraversal(root);
        //System.out.println();
        //System.out.println("中序遍历：");
        //inOrderByLoop(root);
        //System.out.println();
        //postOrderByLoop(build());
        System.out.println("层序遍历：");
        levelOrderByLoop3(root);
        System.out.println();
        System.out.println("前序遍历：");
        preOrderByLoop3(root);
        System.out.println();
        System.out.println("中序遍历：");
        inOrderByLoop3(root);
        System.out.println();
        System.out.println("后序遍历：");
        postOrderByLoop3(root);
        System.out.println();

    }

    public static void levelOrderTraversal(TreeNode root) {
        //二叉树的层序遍历
        //使用队列(先进先出)实现
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //队列是一个接口
        queue.offer(root);
        while (!queue.isEmpty()) {
            //取队首元素
            TreeNode top = queue.poll();
            System.out.print(top.val + " ");
            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
        }
    }

    public static void preOrderByLoop(TreeNode root) {
        //二叉树的先序遍历，非递归实现
        //使用栈(后进先出)实现
        //先序遍历：中左右
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public static void inOrderTraversal2(TreeNode root) {
        //二叉树非递归的中序遍历
        //中序遍历：左中右
        //使用栈来实现
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = stack.pop();
        while (true) {
            //先找到最左端的结点,将前面的结点依次入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //此时cur为空
            //判断一下栈是否为空，为空就结束
            if (stack.isEmpty()) {
                break;
            }
            //打印结点
            //这里打印的就是栈中的最后一个元素
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            //将cur变为当前结点的右节点重复找
            cur = top.right;
        }
    }

    public static void postOrderTraversal2(TreeNode root) {
        if (root == null) {
            return;
        }
        //后序遍历的非递归实现
        //后序:左右中
        //使用栈来实现
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            //循环找到二叉树最左端的元素
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //判断栈是否为空
            if (stack.isEmpty()) {
                break;
            }
            //这里不能直接打印中间结点
            //两种情况下就可打印
            //a. 当前栈顶右节点为空
            //b. 当前栈顶右子树全都访问过了
            //如果不是这两种情况 cur 就要变成当前结点的右子树 重复之气的操作
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }

    public static void levelOrderByLoop3(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            System.out.print(top.val + " ");
            if (top.left != null) {
                queue.offer(top.left);
            }
            if (top.right != null) {
                queue.offer(top.right);
            }
        }
    }

    public static void preOrderByLoop3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
    }

    public static void inOrderByLoop3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = stack.pop();
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }

    public static void postOrderByLoop3(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.print(top.val + " ");
                stack.pop();
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }

}
