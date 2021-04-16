package course;

public class Pow_x_n_50 {
    public static void main(String[] args) {
        int x = 3;
        x >>= 1;
//        System.out.println(x);
//        System.out.println(solution_2(3, -1));
//        System.out.println(solution_2(8.95371, -1));
        System.out.println(solution_2(2, 9));
        System.out.println(solution_2(3.64302, 5));
        System.out.println(Math.pow(3.64302, 5));
    }

    //递归写法
    public static double solution_1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / (solution_1(x, -n - 1) * x);
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            n >>= 1;
            return solution_1(x * x, n);
        } else {
            n >>= 1;
            return x * solution_1(x * x, n);
        }
    }

    //非递归写法,单独写一个函数的目的解决溢出问题
    // 当n为最小的int数时，n如果直接取相反数则会溢出
    // 因此需要使用long数据类型，需要单独再写一个函数
    public static double solution_2(double x, int n) {
        long N = n;
        return N > 0 ? QuickMul(x, N) : 1.0 / QuickMul(x, -n);
    }

    public static double QuickMul(double x, long N) {
        double ans = 1.0;
        double sum = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= sum;
            }
            sum *= sum;
            N /= 2;
        }
        return ans;
    }
}
