package week8;

import course.TreeNode;

public class Path_Sum_112 {
    public static void main(String[] args) {
        //创建一棵树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        System.out.println(solution_1(root1, 4));
    }

    public static boolean solution_1(TreeNode root, int targetSum) {
        //如果该节点为空，则直接返回false
        if (root == null) {
            return false;
        }
        //如果该节点为叶子节点，且节点的值与目标值相等则返回true
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        int temp = targetSum - root.val;
        //如果该节点不为叶子节点也不为空，则判断其左右子树是否存在满足条件的路径
        return solution_1(root.left, temp) || solution_1(root.right, temp);
    }
}
