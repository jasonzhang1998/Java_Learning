package easy_plan;

//搜索插入位置
public class Day1_35 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert(nums, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        while (i <= j) {
            k = i + (j - i) / 2;
            if (nums[k] == target) {
                return k;
            }
            if (nums[k] < target) {
                i = k + 1;
            } else {
                j = k - 1;
            }
        }
        return nums[k] > target ? k : k + 1;
    }
}
