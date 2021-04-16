package course;

import java.util.Stack;

public class MyQueue_232 {
    //用栈实现队列，实现的队列需要有push、pop、peek、empty方法
    public static void main(String[] args) {
        MyQueue_232 my = new MyQueue_232();
        my.push(1);
        my.push(2);
        my.pop();
        my.push(3);
        System.out.println(my.peek());
        System.out.println(my);
    }

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    //队列MyQueue的构造方法
    public MyQueue_232() {

    }

    //入队时，将元素压入输入栈
    public void push(int x) {
        stack1.push(x);
    }

    //出队时，首先判断输出栈是否为空，不为空直接弹栈，否则将输入栈
    //中的元素全部弹栈到输出栈之后再从输出栈弹栈
    public int pop() {
        if (stack2.empty()) {
            trans();
        }
        return stack2.pop();
    }

    //peek时先判断输出栈是否为空，不为空直接peek输出栈，否则将输入栈
    //中的元素全部弹栈到输出栈之后再peek输出栈
    public int peek() {
        if (stack2.empty()) {
            trans();
        }
        return stack2.peek();
    }

    //判断队列是否为空，得两个栈都为空，队列才为空
    public boolean empty() {
        trans();
        return stack2.empty();
    }

    //将输入栈元素弹栈，然后压栈到输出栈
    public void trans() {
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
    }
}
