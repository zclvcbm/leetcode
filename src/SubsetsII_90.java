import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Admin on 2016/8/17.
 */
public class SubsetsII_90 {
    public static void help(int[] num, int now, List<Integer> path, List<List<Integer>> answer)
    {
        answer.add(new ArrayList<Integer>(path));
        for(int i=now;i<num.length;i++){
            if(i > now && num[i] == num[i-1])
                continue;
            path.add(num[i]);
            help(num,i+1,path,answer);
            path.remove(path.size()-1);
        }
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        help(nums,0,path,answer);
        return answer;
    }

    public static void main(String[] args){
        int nums[] ={1,2,2};
        subsetsWithDup(nums);
    }
}
