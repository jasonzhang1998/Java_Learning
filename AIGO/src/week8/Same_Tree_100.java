package week8;

import course.TreeNode;

public class Same_Tree_100 {
    public static void main(String[] args) {
        //构造树root1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(3);
        //构造树root2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(solution_1(root1, root2));
    }

    public static boolean solution_1(TreeNode p, TreeNode q) {
        //如果两个树的根节点都为空，则两棵树相同
        if (p == null && q == null) {
            return true;
        }
        //如果两个树的根节点都不为空，那么当根节点的值和左右子树
        // 都相同则两个树相同
        if (p != null && q != null) {
            return p.val == q.val && solution_1(p.left, q.left) && solution_1(p.right, q.right);
        }
        //否则两个树不同
        return false;
    }
}
