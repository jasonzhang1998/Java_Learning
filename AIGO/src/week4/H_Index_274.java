package week4;

import java.util.Arrays;

public class H_Index_274 {
    //求出一个数组中最大数i，其中i满足大于等于i的数出现的次数不少于i次，其他的数不大于i
    public static void main(String[] args) {
        int[] citations = new int[]{9, 9, 9};
        System.out.println(solution_1(citations));
    }

    //先将数组排序，然后从大到小遍历，找出满足某个数小于等于i时的i值
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
