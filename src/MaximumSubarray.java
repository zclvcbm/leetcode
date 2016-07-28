import sun.applet.Main;

/**
 * Created by Admin on 2016/7/22.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        if(A==null || A.length==0)
            return 0;
        int n = A.length;
        int max = A[0];
        int cur = A[0];
        for(int i=1;i<n;i++)
        {
            if(cur<0)
                cur = A[i];
            else{
                cur += A[i];
            }
            if(cur>max)
                max = cur;
        }
        return max;
    }

    public static void main(String[] args){
//        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        int[] array = {-1};
        MaximumSubarray ms = new MaximumSubarray();
        ms.maxSubArray(array);
    }
}
