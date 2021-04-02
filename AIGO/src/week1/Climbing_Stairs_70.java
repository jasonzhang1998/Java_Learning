package week1;

public class Climbing_Stairs_70 {
    public static void main(String[] args) {
//        System.out.println(solution_1(8));
//        System.out.println(solution_2(2));
        System.out.println(solution_3(1));
    }

    public static int solution_1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return (solution_1(n - 1) + solution_1(n - 2));
    }

    public static int solution_2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int solution_3(int n) {
        int x = 0;
        int y = 0;
        int z = 1;
        for (int i = 1; i <= n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }
}
