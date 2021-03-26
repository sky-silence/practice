package leetcode.stack;

import java.util.Stack;

/**
 * 232.用栈实现队列
 *
 * @author chengzeshan
 * @version 1.0, 2021/02/20
 * @since MyLeetCode 1.0.0
 */
public class No232MyQueue {

    private Stack<Integer> a;//输入栈
    private Stack<Integer> b;//输出栈

    /** Initialize your data structure here. */
    public No232MyQueue() {
        a = new Stack<>();
        b = new Stack<>();

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (b.isEmpty()){
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (b.isEmpty()){
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return b.isEmpty() && a.isEmpty();
    }
}
