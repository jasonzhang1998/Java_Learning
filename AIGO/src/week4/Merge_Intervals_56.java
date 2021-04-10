package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals_56 {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 2}, {0, 3}, {4, 8}};
        for (int[] item : solution_1(intervals)) {
            System.out.println(Arrays.toString(item));
        }
    }

    public static int[][] solution_1(int[][] intervals) {
        //首先将所有的区间按从小到大的顺序排好序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        //使用一个list集合来存放最后合并后的区间
        List<int[]> merged = new ArrayList<int[]>();
        //遍历所有区间
        for (int i = 0; i < intervals.length; ++i) {
            //找到每个待合并区间的左边界和右边界
            int L = intervals[i][0], R = intervals[i][1];
            /*
            初始集合为空，第一个区间直接放入集合，后面的区间与集合中最后一个区间比较，如果
            存在交叉就合并区间，修改最后一个区间的右边界值，否则不存在交叉，此时将这个区间
            加入到集合的最后一个位置
            */
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        //返回最后合并后的区间集合
        return merged.toArray(new int[merged.size()][]);
    }
}
