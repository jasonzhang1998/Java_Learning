package course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sliding_Window_Maximum_239 {
    public static void main(String[] args) {
        System.out.println("大家上午好^_^");
        int[] nums = new int[]{7, 2, 4};
        System.out.println(Arrays.toString(solution_1(nums, 2)));
    }

    //单调栈：构造一个栈，保证栈的元素都是从栈底到栈顶递减
    //实现方法为，每一个待入栈元素都先和栈顶元素比较
    //如果该元素大，则弹栈，然后继续比较，直到小于栈顶元素再入栈
    //这样即可保证栈的单调性
    //windows其实就是一个单调栈
    //优化：1、window可以用队列实现，使用arraylist太耗资源，操作也不方便
    //2、res可以用数组实现，不用集合
    public static int[] solution_1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> window = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //维持单调栈的最大大小为k
            if (i >= k && window.get(0) <= i - k) {
                window.remove(0);
            }
            //维持单调栈的单调性
            while (!window.isEmpty() && nums[window.get(window.size() - 1)] <= nums[i]) {
                window.remove(window.size() - 1);
            }
            window.add(i);
            //每次取单调栈中最大的元素
            if (i >= k - 1) {
                res.add(nums[window.get(0)]);
            }
        }
        //将集合类型转为数组类型
        int[] array = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            array[i] = res.get(i);
        }
        return array;
    }
}
