import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2016/7/29.
 */

/**
 * Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 */
public class IntersectionofTwoArraysII {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null)
            return null;
        int n = nums1.length;
        int n2 = nums2.length;
        int j=0;
        int result[] = new int[n];
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(hash.containsKey(nums1[i]))
                hash.put(nums1[i],hash.get(nums1[i])+1);
            else
                hash.put(nums1[i],1);
        }

        for(int i=0;i<n2;i++)
        {
            if(hash.get(nums2[i])!=null && hash.get(nums2[i])>0)
            {
                result[j++] = nums2[i];
                hash.put(nums2[i],hash.get(nums2[i])-1);
            }
        }

        int[] res = new int[j];
        int k=0;
        for(int i=0;i<j;i++)
            res[k++]=result[i];
        return res;
    }

    public static void main(String[] args){
//        int[] arr1 = {1,2,2,1};
//        int[] arr2 = {2,2};
//        int[] arr1 = {1};
//        int[] arr2 = {1,1};
//        int[] arr1 = {};
//        int[] arr2 = {1};

        int arr1[] = {4,7,9,7,6,7};
        int arr2[] = {5,0,0,6,1,6,2,2,4};
        intersection(arr1,arr2);

        String s = "abac";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb1 = new StringBuilder("hello");
        String s2 = new String(sb1);
        char[] chars = s.toCharArray();
    }
}
