package week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Triangle_120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(triangle);
        System.out.println(solution_1(triangle));
    }

    public static int solution_1(List<List<Integer>> triangle) {
        //获取三角形的行数
        int len = triangle.size();
        //dp[i][j]代表走到第i行第j列时的最小路径和
        int[][] dp = new int[len][len];
        //顶点的最小路径和是它本身的权值
        dp[0][0] = triangle.get(0).get(0);
        //求三角形最两侧的路径上的点的最小路径和
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
        }
        for (int j = 1; j < len; j++) {
            dp[j][j] = dp[j - 1][j - 1] + triangle.get(j).get(j);
        }
        //求出每个点的最小路径和，即两条走法中较小的路径和
        int left ;
        int right ;
        for (int i = 2; i < len; i++) {
            for (int j = 1; j < i; j++) {
                left = triangle.get(i).get(j) + dp[i - 1][j - 1];
                right = triangle.get(i).get(j) + dp[i - 1][j];
                dp[i][j] = Math.min(left, right);
            }
        }
        //在三角形底边中找出最小路径和最小的点
        int minPath = dp[len - 1][0];
        for (int i = 1; i < len; i++) {
            if (dp[len - 1][i] < minPath) {
                minPath = dp[len - 1][i];
            }
        }
        return minPath;
    }
}
