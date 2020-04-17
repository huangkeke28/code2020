package dataStructure0414;



public class BinarySearchTree {
    static class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int key) {
            this.key = key;
        }
    }
    private Node root = null;
    public Node find(int key) {
        Node cur = root;
        while (cur != null) {
            if (key < cur.key) {
                cur = cur.left;
            } else if (key > cur.key) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public boolean insert(int key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }
        //先找到合适的位置
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                return false;
            }
        }
        if (key < parent.key) {
            parent.left = new Node(key);
        } else {
            parent.right = new Node(key);
        }
        return true;
    }

    public boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if (key < cur.key) {
                parent = cur;
                cur = cur.left;
            } else if (key > cur.key) {
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
            //待删除元素的左子树为空
            if (cur == root) {
                //要删除元素为根节点
                root = cur.right;
            } else if (parent.left == cur) {
                //要删除元素是根节点的左子树
                parent.left = cur.right;
            } else if (parent.right == cur) {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            //待删除元素的右子树为空
            if (cur.right == null) {
                if (cur == root) {
                    root = cur.left;
                } else if (parent.left == cur) {
                    parent.left = cur.left;
                } else if (parent.right == cur) {
                    parent.right = cur.left;
                }
            }
        } else {
            //待删除元素的左右子树都不为空
            Node goatParent = cur;
            Node scapeGoat = cur.right;
            while (scapeGoat.left != null) {
                goatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            cur.key = scapeGoat.key;
            if (scapeGoat == goatParent.left) {
                goatParent.left = scapeGoat.right;
            } else {
                scapeGoat.right = scapeGoat.right;
            }
        }
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
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
        //System.out.println(tree.find(7));
        System.out.print("先序遍历：");
        preOrder(tree.root);
        System.out.println();
        System.out.print("中序遍历：");
        inOrder(tree.root);
        System.out.println();
        Node cur = tree.find(2);
        System.out.println(cur.key);
        tree.remove(5);
        System.out.print("先序遍历：");
        preOrder(tree.root);
        System.out.println();
        System.out.print("中序遍历：");
        inOrder(tree.root);
        System.out.println();


    }

//    private void removeNode(Node parent, Node cur) {
//        if (cur.left == null) {
//            //1. 要删除的元素没有左子树
//            if (cur == root) {
//                // 1.1 要删除结点为root;
//                root = cur.right;
//            } else if (cur == parent.left) {
//                // 1.2 cur是parent的左子树
//                parent.left = cur.right;
//            } else {
//                //1.3 cur是parent的右子树
//                parent.right = cur.right;
//            }
//        } else if (cur.right == null) {
//            if (cur == root) {
//                root = cur.left;
//            } else if (cur == parent.left) {
//                parent.left = cur.left;
//            } else if (cur == parent.right) {
//                parent.right = cur.left;
//            }
//        } else {
//            Node scapeGoat = cur.right;
//            Node goatParent = parent;
//            while (scapeGoat.right != null) {
//                goatParent = scapeGoat;
//                scapeGoat = scapeGoat.left;
//            }
//            cur.key = scapeGoat.key;
//            if (scapeGoat == goatParent.left) {
//                goatParent.left = scapeGoat.right;
//            } else {
//                goatParent.right = scapeGoat.right;
//            }
//        }
//    }
}
