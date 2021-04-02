package week3;

import java.util.Arrays;

public class Three_Sum_Closest_16 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(solution_1(nums, 1));
//        System.out.println(Math.pow(2,31)-1);
    }

    //先将数组排序，然后使用双指针去使得三数之和慢慢逼近target
    public static int solution_1(int[] nums, int target) {
        //将数组排序
        Arrays.sort(nums);
        //三数之和
        int sum = 0;
        //中间指针
        int medium = 0;
        //尾指针
        int end = nums.length - 1;
        //target和sum之间的距离度量
        int distance = 2000;
        //存放每次最接近target的sum值
        int res = 0;
        for (int start = 0; start < nums.length - 1; start++) {
            //中间指针每次从首指针后一位开始
            medium = start + 1;
            //尾指针每次从最后一位开始
            end = nums.length - 1;
            //中间指针和尾指针重合则这轮循环结束
            while (medium < end) {
                sum = nums[start] + nums[medium] + nums[end];
                //每得到一个更接近target的sum值，更新distance，同时记录此时sum值
                if (Math.abs(sum - target) < distance) {
                    distance = Math.abs(sum - target);
                    res = sum;
                }
                //sum和target相等，则直接返回sum值
                if (sum == target) {
                    return sum;
                }
                //sum小于target时，说明应增大sum，因此中间指针后移一位
                if (sum < target) {
                    medium++;
                    //sum大于target时，说明应减小sum，因此尾指针前移一位
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
