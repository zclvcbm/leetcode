import java.util.*;

/**
 * Created by Admin on 2016/7/26.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2 ) {
            return null;
        }
        int n = nums.length;
        int[] result = new int[2];

        Arrays.sort(nums);

        int i=0;
        int j=n-1;
        while(i<j)
        {
            if (nums[i]+nums[j]<target) {
                i++;
            } else if(nums[i]+nums[j]>target) {
                j--;
            } else {
                result[0] = i;
                result[1] = j;
                break;
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        if(nums == null || nums.length < 2 ) {
            return null;
        }

        int[] result = new int[2];

        Map map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int let = target - nums[i];
            if (map.containsKey(let) && (Integer)map.get(let) != i) {
                result[0] = i;
                result[1] = (Integer) map.get(let);
            }
        }
        return result;
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int[] array = {2,7,11,15};
        int[] ints1 = ts.twoSum(array, 9);
    }
}
