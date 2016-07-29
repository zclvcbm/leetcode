import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 2016/7/29.
 */

/**
 * Largest Divisible Subset
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * nums: [1,2,3]
 *
 * Result: [1,2] (of course, [1,3] will also be ok)
 *
 * Example 2:
 *
 * nums: [1,2,4,8]
 *
 * Result: [1,2,4,8]
 */
public class IntersectionofTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return null;
        int n = nums1.length;
        int n2 = nums2.length;
        int j=0;
        int result[] = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            set.add(nums1[i]);
        }

        for(int i=0;i<n2;i++)
        {
            if(set.contains(nums2[i]))
            {
                result[j++] = nums2[i];
                set.remove(nums2[i]);
            }
        }

        int[] res = new int[j];
        int k=0;
        for(int i=0;i<j;i++)
            res[k++]=result[i];
        return res;
    }

    public static void main(String[] args){
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
//        int[] arr1 = {1};
//        int[] arr2 = {};
        intersection(arr1,arr2);
    }
}
