package course;

import java.util.Stack;

public class Ten_To_Two {
    //十进制转二进制
    public static void main(String[] args) {
        System.out.println(solution_1(9));
        System.out.println(solution_1(5));
        System.out.println(solution_1(789));
    }

    //使用一个栈，存放每次对2取余后的结果，最后出栈即为所求
    public static String solution_1(int x) {
        int res;
        Stack num = new Stack();
        while (x != 0) {
            res = x % 2;
            num.push(res);
            x = x / 2;
        }
        String s = "";
        while (!num.empty()) {
            s = s.concat(num.pop().toString());
        }
        return s;
    }
}
