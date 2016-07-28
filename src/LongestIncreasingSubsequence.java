/**
 * Created by Admin on 2016/7/28.
 */

/**
 * Longest Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be

 more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        int h[] = new int[n];
        int max[] = new int[n];
        h[0] = nums[0];
        max[0] = 1;
        int result = 1;
        for(int i=1,j=0;i<n;i++){
            if(nums[i]>=h[j])
            {
                h[++j] = nums[i];
                max[i] = j+1;
                result = Math.max(result,max[i]);
            }else{
                int right = j-1;
                int left = 0;
                while(left<=right)
                {
                    int mid = (left+right)/2;
                    if(h[mid]<nums[i])
                        left = mid+1;
                    else
                        right = mid-1;
                }
                h[right+1] = nums[i];
                max[i] = right+2;
                result = Math.max(result,max[i]);
            }
        }

        return result;
    }

    public static int lengthOfLIS2(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        int h[] = new int[n];
        int max[] = new int[n];
        h[0] = nums[0];
        int result = 1;
        for(int i=1,j=0;i<n;i++){
            if(nums[i]>h[j])
            {
                h[++j] = nums[i];
                result = Math.max(result,j+1);
            }else{
                int right = j-1;
                int left = 0;
                while(left<=right)
                {
                    int mid = (left+right)/2;
                    if(h[mid]<nums[i])
                        left = mid+1;
                    else
                        right = mid-1;
                }
                h[right+1] = nums[i];
                result = Math.max(result,right+2);
            }
        }

        return result;
    }

    public static void main(String[] args){
//        int array[] = {10};
        int array[] = {10,10};
//        int array[] = {10,9,2,5,3,7,101,18};
        lengthOfLIS2(array);
    }
}
