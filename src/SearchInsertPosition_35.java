/**
 * Created by Admin on 2016/8/8.
 */

/**
 * Search Insert Position
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0

 */
public class SearchInsertPosition_35 {
    public static int searchInsert(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int mid=0;
        while(low<=high)
        {
            mid = (low+high)/2;
            if(nums[mid]>=target)
            {
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return high+1;
    }

    public static void main(String[] args){
        int[] array = {1,3,5,6};
        System.out.println(searchInsert(array,5));
        System.out.println(searchInsert(array,2));
        System.out.println(searchInsert(array,7));
        System.out.println(searchInsert(array,0));
        System.out.println(searchInsert(null,0));

    }
}
