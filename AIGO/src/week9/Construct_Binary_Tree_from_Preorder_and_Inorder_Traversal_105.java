package week9;

import course.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        System.out.println(solution_1(preorder, inorder).val);
    }

    //递归解决问题，将建立一整棵树分解为建立根节点和左右子树
    public static TreeNode solution_1(int[] preorder, int[] inorder) {
        //递归出口
        if (inorder.length == 0) {
            return null;
        }
        //先序遍历的第一个节点为根节点
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        //找到中序遍历中的根节点
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                index = i;
                break;
            }
        }
        //根节点将中序遍历序列分割成左右子树的两个中序遍历序列
        //根据左子树的中序遍历序列的长度，求出左子树的先序遍历序列，剩下的就是右子树的先序遍历序列
        int[] left_pre = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] left_in = Arrays.copyOfRange(inorder, 0, index);
        int[] right_pre = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] right_in = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        //通过求出的左右子树的先序、中序遍历序列，构建左右子树
        root.left = solution_1(left_pre, left_in);
        root.right = solution_1(right_pre, right_in);
        return root;
    }

    //针对solution_1进行优化：
    //1、使用哈希表来存放中序遍历的索引值，避免每次都要遍历一遍
    //2、使用四个指针来标识左右子树的区间长度，避免进行数组的复制操作
    public static TreeNode solution_2(int[] preorder, int[] inorder) {
        //哈希表存放inorder的索引，方便快速查找
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, preorder.length, 0, inorder.length, map);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pre_start, int pre_end,
                                           int in_start, int in_end, HashMap<Integer, Integer> map) {
        //递归出口，即输入的根节点的左子树节点数目为零
        if (pre_start == pre_end) {
            return null;
        }
        //先序遍历的第一个节点为根节点
        TreeNode root = new TreeNode(preorder[pre_start]);
        //找到中序遍历中的根节点
        int index = map.get(preorder[pre_start]);
        //左子树节点数目
        int leftNum = index - in_start;
        //递归构建左右子树
        root.left = buildTreeHelper(preorder, inorder, pre_start + 1, pre_start + leftNum + 1,
                in_start, index, map);
        root.right = buildTreeHelper(preorder, inorder, pre_start + leftNum + 1, pre_end,
                index + 1, in_end, map);
        return root;
    }
}
