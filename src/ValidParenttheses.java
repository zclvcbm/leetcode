import java.util.Stack;

/**
 * Created by Admin on 2016/7/25.
 */
/*
valid-parentheses

题目描述

Given a string containing just the characters'(',')','{','}','['and']',
determine if the input string is valid.
The brackets must close in the correct order,"()"and"()[]{}"are all
valid but"(]"and"([)]"are not.
 */
public class ValidParenttheses {
    public static void main(String[] args){
        String str = "";
        String str1 = "()[]{}";
        String str2 = "()";
        String str3 = "(]";
        String str4 = "([)]";
        String str5 = "]";
        System.out.println(isValid(str));
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
        System.out.println(isValid(str3));
        System.out.println(isValid(str4));
        System.out.println(isValid(str5));
        System.out.println(isValid(null));

    }

    public static boolean isValid(String s) {
        if(s==null || s.length()==0)
            return true;
        Stack stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else{
                if(s.charAt(i)==')' && (stack.empty() || (char)stack.peek()!='('))
                    return false;
                else if(s.charAt(i)==']' && (stack.empty() || (char)stack.peek()!='['))
                    return false;
                else if(s.charAt(i)=='}' && (stack.empty() || (char)stack.peek()!='{'))
                    return false;
                else
                    stack.pop();
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
}
