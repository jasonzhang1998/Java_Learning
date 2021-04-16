package course;

import java.lang.reflect.Array;
import java.util.*;

public class Hot_Potato {
    public static void main(String[] args) {
        List<String> namelist = new ArrayList<>();
        Collections.addAll(namelist, "a", "b", "c", "d", "e", "f");
        System.out.println(namelist);
        String[] s = new String[]{"a", "b", "c", "d", "e", "f"};
        System.out.println(Arrays.asList(s));
        System.out.println(solution_1(namelist, 7));
    }

    //队列实现烫手山芋（约瑟夫环）问题
    public static Object solution_1(List namelist, int num) {
        Queue ysf = new LinkedList();
        for (Object s : namelist) {
            ysf.add(s);
        }
        while (ysf.size() > 1) {
            for (int i = 0; i < num; i++) {
                ysf.add(ysf.poll());
            }
            ysf.poll();
        }
        return ysf.poll();
    }
}
