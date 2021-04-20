package course;

public class Unique_Paths_62 {
    //走方格问题，从一个方格的左上角走到右下角，每次只能向下或者
    //向右走一步，求有多少种不同的走法
    public static void main(String[] args) {
        System.out.println("直播间的朋友们好呀");
        System.out.println(solution_1(7, 3));
    }

    //动态规划问题，求出走到每一个方格时的走法，再递推至右下角方格
    //每个方格都是从上走到下或者从左走到右得到，因此每个方格的走法
    //等于其上面一个方格和其左边一个方格的走法之和
    public static int solution_1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
