package easy_plan;

//二分查找
public class Day1_704 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 13));
    }

    public static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        while (i <= j) {
            k = (i + j) / 2;
            //k = i + (j - i) / 2;
            //使用下面的等式可以防止溢出
            if (nums[k] == target) {
                return k;
            } else if (nums[k] < target) {
                i = k + 1;
            } else {
                j = k - 1;
            }
        }
        return -1;
    }
}
