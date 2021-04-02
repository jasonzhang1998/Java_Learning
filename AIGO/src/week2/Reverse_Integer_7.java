package week2;

public class Reverse_Integer_7 {
    public static void main(String[] args) {
//        System.out.println(-56%10);
        System.out.println(solution_2(2147483646));
    }

    public static int solution_1(int x) {
        int[] a = new int[32];
        int i = 0;
        while (x != 0) {
            a[i] = x % 10;
            x = x / 10;
            i++;
        }
        long sum = 0;
        for (int j = 0; j < i; j++) {
            sum += a[j] * Math.pow(10, i - j - 1);
        }
        if (Math.abs(sum) <= Math.pow(2, 31)) {
            return (int) sum;
        } else {
            return 0;
        }
    }
    public static int solution_2(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
