package week8;

import course.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        String s = "sdf";
        s = s + "56";
        System.out.println(s);
    }

    //深度优先搜索
    public static List<String> solution_1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public static void constructPaths(TreeNode root, String path, List<String> paths) {
        if(root != null){
            //创建一个可修改的字符串数据结构StringBuffer
            StringBuffer pathSB = new StringBuffer(path);
            //将根节点的值添加到字符串末尾
            pathSB.append(Integer.toString(root.val));
            //如果该节点是叶子节点，则将整个字符串加入到答案集合中
            if(root.left == null && root.right == null){
                paths.add(pathSB.toString());
            } else {
                //如果不是叶子节点，则在字符串末尾加上"->"
                pathSB.append("->");
                //对该节点的左子树和右子树进行递归调用
                constructPaths(root.left, pathSB.toString(),paths);
                constructPaths(root.right, pathSB.toString(),paths);
            }
        }
    }

}
