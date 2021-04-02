package week2;

import java.util.Arrays;

public class Plus_One_66 {
    public static void main(String[] args) {
        int[] a = new int[]{9, 9, 9, 9};
        System.out.println(Arrays.toString(solution_1(a)));
    }

    public static int[] solution_1(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            a[i]++;
            if (a[i] % 10 != 0) {
                return a;
            }
            a[i]=0;
        }
        int[] s = new int[a.length + 1];
        s[0] = 1;
        return s;
    }
}