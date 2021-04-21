package week6;

import java.util.Arrays;

public class Bag_Problem {
    public static void main(String[] args) {
        int[][] f = new int[][]{{1, 3, 5, 9}, {2, 3, 4, 7}};
        System.out.println(solution_1(f, 10));
    }

    public static int solution_1(int[][] f, int b) {
        int n = f[0].length;
        int[][] ans = new int[n][b + 1];
        //定义边界条件
        for (int i = 0; i < b + 1; i++) {
            ans[0][i] = (i / f[1][0]) * f[0][0];
        }
        for (int i = 0; i < n; i++) {
            ans[i][0] = 0;
        }
        //实现递推公式
        for (int k = 1; k < n; k++) {
            for (int y = 1; y < b + 1; y++) {
                if (y - f[1][k] < 0) {
                    ans[k][y] = ans[k - 1][y];
                } else {
                    ans[k][y] = Math.max(ans[k - 1][y], ans[k][y - f[1][k]] + f[0][k]);
                }
            }
        }
        return ans[n - 1][b];
    }
}