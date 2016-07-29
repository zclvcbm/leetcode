import java.util.Stack;

/**
 * Created by Admin on 2016/7/29.
 */

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
        if(stack2.empty() || (!stack2.empty() && (x<=stack2.peek()))) {
            stack2.push(x);
        }
    }

    public void pop() {
        if(!stack1.empty()) {
            // 注意：stack.peek()得到的是一个对象，而这里是对值进行比较
            if (stack1.peek().intValue() == stack2.peek().intValue())
                stack2.pop();
            stack1.pop();
        }
    }

    public int top() {
        if(!stack1.empty())
            return stack1.peek();
        else
            return 0;
    }

    public int getMin() {
        if(!stack2.empty())
            return stack2.peek();
        else
            return 0;
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        int param_4 = obj.getMin();
        obj.pop();
        int param_5 = obj.getMin();
        obj.pop();
        int param_6 = obj.getMin();
    }
}
