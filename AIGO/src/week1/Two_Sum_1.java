package week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Two_Sum_1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
//        int[] solu = solution_1(nums,17);
//        System.out.println(Arrays.toString(solution_1(nums, 7)));
        System.out.println(Arrays.toString(solution_2(nums, 6)));
    }

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
