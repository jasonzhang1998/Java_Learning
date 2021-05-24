package week8;

import course.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
    public static void main(String[] args) {
        System.out.println("hello");
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println(solution_1(root, root.left.right.right, root.right).val);
    }

    //找到二叉搜索树的最近公共祖先节点
    public static TreeNode solution_1(TreeNode root, TreeNode p, TreeNode q) {
        //得到两个节点值的最小值与最大值，方便后面处理
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        TreeNode node = root;
        //从根节点开始往下遍历，判断待求节点在左子树还是右子树
        //终止条件为待求与某个节点重合了
        while (node != p || node != q) {
            if (node.val > max) {
                node = node.left;
            } else if (node.val < min) {
                node = node.right;
            } else {
                return node;
            }
        }
        return node;
    }
}
