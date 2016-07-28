import sun.awt.image.IntegerInterleavedRaster;

import java.util.*;

/**
 * Created by Admin on 2016/7/26.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length<2)
            return null;
        int n = nums.length;
        int[] result = new int[2];

        Arrays.sort(nums);

        int i=0;
        int j=n-1;
        while(i<j)
        {
            if(nums[i]+nums[j]<target)
                i++;
            else if(nums[i]+nums[j]>target)
                j--;
            else {
                result[0] = i;
                result[1] = j;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args){
        TwoSum ts = new TwoSum();
        int[] array = {2,7,11,15};
        //s.twoSum(array,9);
        ts.twoSum(null,9);
    }
}
