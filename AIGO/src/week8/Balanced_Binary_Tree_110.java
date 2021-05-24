package week8;

import course.TreeNode;

public class Balanced_Binary_Tree_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution_1(root));
    }

    //自顶向下使用递归的方法判断这棵树的每个节点是不是都符合平衡因子
    // 小于等于1的条件
    public static boolean solution_1(TreeNode root) {
        //递归出口
        if (root == null) {
            return true;
        }
        //如果有一个节点不满足条件则不是平衡二叉树
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        } else {
            //根节点满足条件，则继续判断左右子树是不是平衡二叉树
            return solution_1(root.left) && solution_1(root.right);
        }
    }

    //使用递归的方法求出任意一棵树的高度
    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    //自底向上的使用递归来判断是不是平衡二叉树
    //从叶子节点开始求每个节点为根的子树是不是平衡二叉树
    //如果是，则返回树的高度，否则返回-1
    //当有一个子树返回-1时，以其父节点为根的树也会返回-1
    //一直往上直至根节点返回-1，从而判断不是平衡二叉树
    public static boolean solution_2(TreeNode root) {
        if (root == null) {
            return true;
        }
        //如果树的高度不是-1则为平衡二叉树
        return Height(root) >= 0;
    }

    public static int Height(TreeNode root){
        if(root == null){
            return 0;
        }
        //递归地求子树的高度
        int leftHeight = Height(root.left);
        int rightHight = Height(root.right);
        //根据子树高度判断该树是否为平衡二叉树并返回高度
        if(leftHeight == -1 || rightHight == -1 || Math.abs(leftHeight - rightHight) > 1){
            return -1;
        } else {
            return Math.max(leftHeight,rightHight)+1;
        }
    }
}
