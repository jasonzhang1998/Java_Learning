package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Single_Number_136 {
    //找出单独出现的数字
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 3,};
        System.out.println(solution_3(nums));
    }

    //遍历数组，当数字第一次出现时将其存入hash表，第二次出现则删除，最后还剩一个单独的数字
    public static int solution_1(int[] nums) {
        HashMap<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashtable.containsKey(nums[i])) {
                hashtable.put(nums[i], 1);
            } else {
                hashtable.remove(nums[i]);
            }
        }
        return (int) hashtable.keySet().toArray()[0];
    }

    //遍历数组，当数字第一次出现时将其存入一个集合，第二次出现则删除，最后还剩一个单独的数字
    public static int solution_2(int[] nums) {
        List list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            } else {
                list.remove(new Integer(nums[i]));
            }
        }
        return (int) list.get(0);
    }

    //将所有的数都与0进行一次异或运算，最后运算结果就是单独的数字
    public static int solution_3(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
