/**
 * Created by Admin on 2016/7/27.
 */

import java.util.Stack;

/**
 * Implement Queue using Stacks
 *
 * Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Notes:
 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

/**
 * 解题思路：
 * stack1负责“入队”，stack2负责“出队”（方向）
 * 入队直接入到stack1里
 * 要出队如果stack2非空，则先从stack2出，否则把stack1里的全部元素压入stack2中
 */
class Queue{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
       stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stack2.empty())
            stack2.pop();
        else{
            while(!stack1.empty())
            {
                stack2.push(stack1.pop());
            }
            stack1.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!stack2.empty())
        {
            return stack2.peek();
        }else{
            if(stack1.empty())
                return -1;
            else{
                while (!stack1.empty())
                    stack2.push(stack1.pop());
                return stack2.peek();
            }
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(stack2.empty() && stack1.empty())
            return true;
        return false;
    }
}
public class ImplementQueueUsingStacks {

    public static void main(String[] args){
        Queue queue = new Queue();
        System.out.println(queue.peek());
        queue.push(4);
        System.out.println(queue.peek());
        queue.push(5);
        System.out.println(queue.peek());
        queue.push(4);
        System.out.println(queue.peek());
        queue.push(5);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());

    }
}
