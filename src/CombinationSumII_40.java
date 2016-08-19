/**
 * Created by Admin on 2016/8/18.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 */
public class CombinationSumII_40 {
    public void help(int[] candidates, int now, int sum, int target, List<Integer> path, List<List<Integer>> answer)
    {
        if(sum>target)
            return;
        if(sum==target)
        {
            answer.add(new ArrayList(path));
            return;
        }

        for(int i=now;i<candidates.length;i++){
            if(i>now && candidates[i-1]==candidates[i])
                continue;
            path.add(candidates[i]);
            help(candidates,i+1,sum+candidates[i],target,path,answer);
            path.remove(path.size()-1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        help(candidates,0,0,target,path,answer);
        return answer;
    }

    public static void main(String[] args){
        CombinationSumII_40 test = new CombinationSumII_40();
        int array[] = {10,1,2,7,6,1,5};
        test.combinationSum2(array,8);
    }
}
