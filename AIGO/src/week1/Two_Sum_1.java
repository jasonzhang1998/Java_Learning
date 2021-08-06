package week1;

import java.util.Arrays;
import java.util.HashMap;

public class Two_Sum_1 {
    //两数之和问题
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
//        int[] solu = solution_1(nums,17);
//        System.out.println(Arrays.toString(solution_1(nums, 7)));
        System.out.println(Arrays.toString(solution_2(nums, 6)));
    }

    //暴力遍历，遍历两次
    public static int[] solution_1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] index = {i, j};
                    return index;
                }
            }
        }
        return null;

    }

    //使用哈希表存没出现过的数，以及其索引，后面再遍历到其时可以直接返回其索引
    public static int[] solution_2(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                int[] index = {i, hashtable.get(target - nums[i])};
                return index;
            }
            hashtable.put(nums[i], i);
        }
        return null;
    }
}
