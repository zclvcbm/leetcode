/**
 * Created by Admin on 2016/8/19.
 */

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */

import java.util.ArrayList;

public class Combinations_77 {
    public static void help(int n, int k, int now, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> answer)
    {
        if(path.size()==k)
        {
            answer.add(new ArrayList(path));
        }
        else{
            for(int i=now;i<=n;i++)
            {
                path.add(i);
                help(n,k,i+1,path,answer);
                path.remove(path.size()-1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        help(n,k,1,path,answer);
        return answer;
    }

    public static void main(String[] args){
//        combine(2,1);
//        combine(1,1);
        combine(4,2);
    }
}
