package week4;

import java.util.Arrays;

public class H_Index_274 {
    public static void main(String[] args) {
        int[] citations = new int[]{9, 9, 9};
        System.out.println(solution_1(citations));
    }

    public static int solution_1(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        System.out.println("============================");
        int i = 0;
        int length = citations.length;
        while (i < length && citations[length - i - 1] > i) {
            i++;
        }
        return i;
    }
}
