import java.util.Stack;

/**
 * Created by Admin on 2016/7/28.
 */

/**
 * Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s){
        if(s==null || s.length()==0)
            return 0;

        int n = s.length();
        Stack<Character> stack1 = new Stack(); //存放未匹配括号
        Stack<Integer> stack2 = new Stack();   //存放未匹配括号下标
        stack1.push(')');  /* import */
        stack2.push(-1);   /* import */
        int max = 0;
        for(int i=0;i<n;i++){
            if(stack1.empty())
            {
                stack1.push(s.charAt(i));   //进栈确定左边界
                stack2.push(i);
            }else{
                if(s.charAt(i)==')' && stack1.peek()=='(')  //当前括号与栈顶括号匹配，两个栈出栈，确定右边界
                {
                    stack1.pop();
                    stack2.pop();
                    int value = i-stack2.peek();
                    max = Math.max(max,value);              //更新最大长度

                }else{
                    stack1.push(s.charAt(i));
                    stack2.push(i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses(null));
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
    }
}
