package week8;

import course.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        TreeNode q = new TreeNode(1);
        System.out.println(solution_1(root));
        System.out.println(solution_2(root));
    }

    public static List<Integer> solution_1(TreeNode root) {
        //集合存放遍历过的节点值
        List<Integer> list = new ArrayList<>();
        //栈存放还没遍历的左右子树的节点
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode node;
        while (!stack.empty()) {
            node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }

    public static List<TreeNode> solution_2(TreeNode root) {
        List list = new ArrayList();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            list.add(root.val);
            stack.push(root.right);
            stack.push(root.left);
        }
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }

    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    public static void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }
}
