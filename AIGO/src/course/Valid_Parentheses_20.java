package course;

import java.util.Stack;

public class Valid_Parentheses_20 {
    //判断一个字符串是不是有效的括弧，有效括弧的定义：
    //小括号、中括号、大括号有内外层级，且左括号必须有
    // 对应的右括号
    public static void main(String[] args) {
        String s = "{[]()}";
        System.out.println(solution_1(s));
    }

    //用一个栈来存放括弧，遇到左括弧就压栈，遇到右括弧就判断此时
    //的栈顶元素是不是对应的做括弧，是就弹栈，否则返回false，最后
    //判断栈是否为空即可
    public static boolean solution_1(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return stack.empty();
    }
}
