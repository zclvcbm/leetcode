/**
 * Created by Admin on 2016/8/8.
 */

/**
 * First Bad Version
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
 *
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 */
public class FirstBadBVersion_278 {
    static int[] nums = {0,0,0,0,1,1,1,1,1};

    public static boolean isBadVersion(int n){
        System.out.println("**");
        if(nums[n-1]==1)
            return true;
        return false;
    }

    public static int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        int mid = 1;
        while(low<=high){
            mid = (low+high)/2;
            if(isBadVersion(mid))
            {
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return high+1;
    }

    public static void main(String[] args){
        System.out.println(firstBadVersion(7));
    }
}
