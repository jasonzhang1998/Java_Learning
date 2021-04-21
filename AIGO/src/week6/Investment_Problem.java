package week6;

public class Investment_Problem {
    public static void main(String[] args) {
        //定义效益函数
        int[][] f = new int[][]{{0, 0, 0, 0}, {11, 0, 2, 20}, {12, 5, 10, 21},
                {13, 10, 30, 22}, {14, 15, 32, 23}, {15, 20, 40, 24}};
        System.out.println(solution_1(f));
    }

    public static int solution_1(int[][] f) {
        int m = f.length;
        int n = f[0].length;
        int temp = 0;
        int val =0;
        int[][] ans = new int[m][n];
        //处理边界条件
        for (int i = 0; i < m; i++) {
            ans[i][0] = f[i][0];
        }
        //实现递推公式
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp = 0;
                for (int k = 0; k <= j; k++) {
                    //枚举收益，求max
                    val = f[k][i]+ans[j-k][i-1];
                    if(val>temp){
                        temp = val;
                    }
                }
                ans[j][i] = temp;
            }
        }
        return ans[m-1][n-1];
    }
}
