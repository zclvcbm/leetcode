import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Admin on 2016/8/16.
 */

/**
 * Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */

class Node{
    int x,y;
    String now;
}
public class GenerateParentheses_22 {
    public void helpDFS(int n, int x, int y, String s, ArrayList<String> list)
    {
        // 终止条件
        if(y==n)
        {
            list.add(s);
        }
        if(x<n)
        {
            helpDFS(n,x+1,y,s+"(",list);
        }
        // 递归过程中 左括号x的个数必须大于等于右括号个数
        if(x>y)
        {
            helpDFS(n,x,y+1,s+")",list);
        }
    }

    public void helpBFS(int n, List<String> list)
    {
        if(n==0)
        {
            list.add("");
            return ;
        }

        Node temp = new Node();
        temp.x = 0;
        temp.y = 0;
        temp.now = "";
        Queue<Node> queue = new LinkedList();
        for(queue.add(temp);!queue.isEmpty();queue.remove())
        {
            temp = queue.peek();
            Node other= null;
            if(temp.x<n)
            {
                other = new Node();
                other.x = temp.x+1;
                other.y = temp.y;
                other.now = temp.now+"(";
                queue.add(other);
            }
            if(temp.x>temp.y)
            {
                other = new Node();
                other.x = temp.x;
                other.y = temp.y+1;
                other.now = temp.now+")";
                if(other.y==n)
                {
                    list.add(other.now);
                }else{
                    queue.add(other);
                }
            }
        }
    }

    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<String>();
//        helpDFS(n,0,0,"",list);
        helpBFS(n,list);
        return list;
    }

    public static void main(String[] args){
        GenerateParentheses_22 test = new GenerateParentheses_22();
        test.generateParenthesis(3);
    }
}
