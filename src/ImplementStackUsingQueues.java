/**
 * Created by Admin on 2016/7/27.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues
 *
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */

/**
 * 解题思路：
 * 队列无论怎么折腾，元素顺序不会改变！
 * 两个队列来回倒，保证一个队列是空的，用空队列临时存储除队尾外所有元素
 * 例如：q1非空，q2是空的，要出“栈”，实际上要出的是q1里面最后一个元素，
 * 我们把q1里面元素一个个放入q2里面（所有元素的顺序不会改变），直到剩下
 * 一个，再让它出队即可
 */
class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if(!queue1.isEmpty()){
            queue1.add(x);
        }else{
            queue2.add(x);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queue1.isEmpty())
        {
            while(queue1.size()>1)
            {
                queue2.add(queue1.remove());
            }
            queue1.remove();
        }else{
            if(queue2.isEmpty())
                return ;
            while(queue2.size()>1)
            {
                queue1.add(queue2.remove());
            }
            queue2.remove();
        }
    }

    // Get the top element.
    public int top() {
        if(!queue1.isEmpty())
        {
            while(queue1.size()>1)
            {
                queue2.add(queue1.remove());
            }
            int x = queue1.peek();
            queue2.add(queue1.remove());
            return x;
        }else{
            if(queue2.isEmpty())
                return -1;
            while(queue2.size()>1)
            {
                queue1.add(queue2.remove());
            }
            int x = queue2.peek();
            queue1.add(queue2.remove());
            return x;
        }
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(queue1.isEmpty() && queue2.isEmpty())
            return true;
        return false;
    }
}

public class ImplementStackUsingQueues {
    public static void main(String[] args){
        MyStack s = new MyStack();

    }
}
