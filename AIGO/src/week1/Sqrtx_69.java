package week1;

public class Sqrtx_69 {
    public static void main(String[] args) {
//        System.out.println(solution_1(2147395600));
//        System.out.println(289399L*289399L);
//        System.out.println(solution_3(2147483647));
        System.out.println(solution_4(2147483647));

    }

    public static int solution_1(int x) {
        long i = 1;
        long y = (long) x;
        while (i * i <= y) {
            i++;
        }
        int j = (int) i;
        return j - 1;
    }

    public static int solution_2(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 0;
        int right = x;
        int mid = (left + right) / 2;
        while (left < mid) {
            if (mid < (x / mid)) {
                left = mid;
                mid = (left + right) / 2;
            } else if (mid > (x / mid)) {
                right = mid;
                mid = (left + right) / 2;
            } else {
                break;
            }
        }
        return mid;
    }

    public static int solution_3(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int solution_4(int x) {
        double x_n = x;
        double y_n = (x_n + (x / x_n)) / 2;
        double e = Math.abs(y_n - x_n);
        while (e > (0.01)) {
            x_n = y_n;
            y_n = (x_n + (x / x_n)) / 2;
            e = Math.abs(y_n - x_n);
        }
        System.out.println(y_n);
        return (int) y_n;
    }

}
