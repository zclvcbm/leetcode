import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2016/8/17.
 */
public class Subsets_78 {
    public void help(int[] num, int now, List<Integer> path,
                     List<List<Integer>> answer)
    {
        if(now>=num.length)
        {
            answer.add(new ArrayList<Integer>(path));
            return ;
        }

        path.add(num[now]);
        help(num,now+1,path,answer);
        path.remove(path.size()-1);
        help(num,now+1,path,answer);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        help(nums,0,path,answer);
        return answer;
    }
}
