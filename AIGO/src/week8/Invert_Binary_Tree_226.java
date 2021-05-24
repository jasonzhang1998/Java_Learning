package week8;

import course.TreeNode;

public class Invert_Binary_Tree_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode res = solution_1(root);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right.val);
    }

    public static void print(TreeNode root) {

    }

    public static TreeNode solution_1(TreeNode root) {
        //如果根节点不为空，则将左子树和右子树反转交换
        if (root != null) {
            TreeNode temp;
            temp = solution_1(root.left);
            root.left = solution_1(root.right);
            root.right = temp;
            return root;
        }
        //如果根节点为空，则直接返回节点
        return root;
    }
}
