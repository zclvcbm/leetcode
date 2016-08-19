import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 2016/8/18.
 */

/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 For example, given candidate set [2, 3, 6, 7] and target 7,
 A solution set is:
 [
 [7],
 [2, 2, 3]
 ]
 */
public class CombinationSum_39 {
    public void help(int[] candidates, int now, int sum, int target, List<Integer> path, List<List<Integer>> answer)
    {
        if(sum>target)
            return;
        if(now>=candidates.length)
        {
            if(sum==target)
                answer.add(new ArrayList(path));
            return;
        }
        // candidates[now-1]==candidates[now] 表示候选项中有重复，只用取其中一个即可，每个可以重复取多次
        if((now==0)||(candidates[now-1]!=candidates[now]))
        {
            path.add(candidates[now]);
            help(candidates,now,sum+candidates[now],target,path,answer);
            path.remove(path.size()-1);
        }
        help(candidates,now+1,sum,target,path,answer);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        help(candidates,0,0,target,path,answer);
        return answer;
    }
}
