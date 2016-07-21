import java.util.Stack;

/**
 * Created by Admin on 2016/7/21.
 */
/*
evaluate-reverse-polish-notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are+,-,*,/. Each operand may be an integer or another expression.
Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens){
        if(tokens==null || tokens.length==0)
            return 0;
        Stack<String> numStack = new Stack();
        for (int i=0;i<tokens.length;i++){
            if(isOperator(tokens[i]))
            {
                int b = new Integer(numStack.pop());
                int a = new Integer(numStack.pop());
                if("-".equals(tokens[i]))
                    numStack.push((a-b)+"");
                else if("+".equals(tokens[i]))
                    numStack.push((a+b)+"");
                else if("*".equals(tokens[i]))
                    numStack.push((a*b)+"");
                if("/".equals(tokens[i]))
                    numStack.push((a/b)+"");
            }
            else{
                numStack.push(tokens[i]);
            }
        }
        return new Integer(numStack.peek());
    }

    public boolean isOperator(String str){
        if(str==null || str.length()==0)
            return  false;
        if("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str))
            return true;
        return false;
    }

    public static void main(String[] args){
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
        //String[] strs = {"2", "1", "+", "3", "*"};
        String[] strs = {"4", "13", "5", "/", "+"};
        int result = e.evalRPN(strs);
        System.out.println(result);
    }
}
