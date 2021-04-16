package course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        System.out.println(solution_2(nums));
    }

    //先排序，再用三个指针遍历数组，去找到和为零的三个位置
    public static List<List<Integer>> solution_1(int[] nums) {
        //先将数组排序
        Arrays.sort(nums);
        //首指针
        int i = 0;
        //尾指针
        int j = nums.length - 1;
        //中间指针
        int k = 0;
        //新建嵌套集合
        List<List<Integer>> res = new ArrayList<>();
        //首指针遍历一遍就完成了整个遍历过程
        for (i = 0; i < nums.length; i++) {
            //中间指针每次都从首指针后一位开始
            k = i + 1;
            //尾指针每次从最尾部开始
            j = nums.length - 1;
            //记录三数之和
            int count = 0;
            //尾指针和中间指针重合就跳出循环
            while (k < j) {
                count = nums[i] + nums[k] + nums[j];
                //三数之和为零则将这三个数存进集合中
                if (count == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    k++;
                    j--;
                    //三数之和小于零，说明小了，中间指针后移一位
                } else if (count < 0) {
                    k++;
                    //三数之和大于零，说明大了。尾指针前移一位
                } else {
                    j--;
                }
            }
        }
        //去除集合中重复的结果
        List<List<Integer>> res2 = new ArrayList<>();
        for (int r = 0; r < res.size(); r++) {
            if (!res2.contains(res.get(r))) {
                res2.add(res.get(r));
            }
        }
        return res2;
    }

    //优化版双指针法，遇到相同的数就跳过，避免重复枚举
    public static List<List<Integer>> solution_2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1;
            int k = i + 1;
            int count = 0;
            //当首指针指的数与上一个数相同时就跳过这个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (k < j) {
                //当中间指针所指向的数与上一个数相同时跳过，第一次开始时不能跳过
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    k++;
                    continue;
                }
                count = nums[i] + nums[k] + nums[j];
                if (count == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[k], nums[j])));
                    k++;
                    j--;
                } else if (count > 0) {
                    j--;
                } else {
                    k++;
                }

            }
        }
        return res;
    }
}
