/**
 * Created by Admin on 2016/7/29.
 */

/**
 * Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 *
 * find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity.

 Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return 1;
        int n = nums.length;
        for(int i=0;i<n;){
            if(nums[i]==i+1)
                i++;
            else if(nums[i]<=i || nums[i]>n || nums[nums[i]-1]==nums[i])
                nums[i] = nums[--n];
            else
            {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        if(n==nums.length) //如果数组中不缺少数字，即满足此条件
            return 0;
        return n+1;
    }

    public static void main(String[] args){
//        int[] array = {1,0}
        int[] array = {1};
        missingNumber(array);
    }
}
