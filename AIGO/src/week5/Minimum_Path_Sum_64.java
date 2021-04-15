package week5;

public class Minimum_Path_Sum_64 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid1 = new int[][]{{1, 2, 3}, {4, 5, 6}};
//        System.out.println(grid[0].length);
//        System.out.println(grid.length);
//        System.out.println(grid[0][1]);
//        System.out.println(grid[1][0]);
        System.out.println(solution_1(grid1));
    }

    public static int solution_1(int[][] grid) {
        //处理边界情况
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //m,n分别为方格的行和列
        int m = grid.length;
        int n = grid[0].length;
        //dp[i][j]存放走到坐标为（i，j）的点的最小路径长度
        int[][] dp = new int[m][n];
        //原点的最小路径长度为它自身
        dp[0][0] = grid[0][0];
        //先求出第一行每个点的最小路径长度
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //求出第一列每个点的最小路径长度
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //用两个变量存放每个点从上走到下和从左走到右的两种走法的最小路径长度
        int GoRight = 0;
        int GoDown = 0;
        //求出每个点的最小路径长度
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //求出该点是从左走到右的最小路径长度
                GoRight = dp[i][j-1]+grid[i][j];
                //求出该点是从上走到下的最小路径长度
                GoDown = dp[i-1][j]+grid[i][j];
                //取两种走法中的较小值作为该点的最小路径长度
                dp[i][j] = Math.min(GoDown,GoRight);
            }
        }
        //返回最右下角的最小路径长度
        return dp[m-1][n-1];
    }
}
