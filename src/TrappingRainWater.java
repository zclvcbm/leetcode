/**
 * Created by Admin on 2016/7/25.
 */
/*
题目描述


Given n non-negative integers representing an elevation map
where the width of each bar is 1, compute how much water
it is able to trap after raining.
For example,
Given[0,1,0,2,1,0,1,3,2,1,2,1], return6.
 */
public class TrappingRainWater {
    public static void main(String[] args){
        TrappingRainWater trw = new TrappingRainWater();
        int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
        trw.trap4(A);
    }

    public int trap(int[] A){
        if(A==null || A.length==0)
            return 0;
        int n = A.length;
        int lmaxs[] = new int[n];
        int rmaxs[] = new int[n];
        lmaxs[0] = A[0];
        rmaxs[n-1] = A[n-1];
        int lmax = A[0];
        int rmax = A[n-1];
        for(int i=1;i<n;i++){
            lmaxs[i] = lmax;
            if(A[i]>lmax)
                lmax = A[i];
        }
        for(int i=n-1;i>=0;i--){
            rmaxs[i] = rmax;
            if(A[i]>rmax)
                rmax = A[i];
        }
        int value = 0;
        for(int i=1;i<n-1;i++){
            if(lmaxs[i]>A[i] && rmaxs[i]>A[i])
                value += lmaxs[i]>rmaxs[i]?(rmaxs[i]-A[i]):(lmaxs[i]-A[i]);
        }

        return value;

    }

    public int trap2(int[] A){
        if(A==null || A.length==0)
            return 0;
        int n = A.length;
        int rmaxs[] = new int[n];
        rmaxs[n-1] = A[n-1];
        int lmax = A[0];
        int rmax = A[n-1];
        for(int i=n-1;i>=0;i--){
            rmaxs[i] = rmax;
            if(A[i]>rmax)
                rmax = A[i];
        }

        int value = 0;
        for(int i=1;i<n-1;i++){
            if(lmax>A[i] && rmaxs[i]>A[i])
                value += lmax>rmaxs[i]?(rmaxs[i]-A[i]):(lmax-A[i]);
            if(A[i]>lmax)
                lmax = A[i];
        }

        return value;

    }

    public int trap3(int[] A){
        if(A==null || A.length==0)
            return 0;
        int n = A.length;
        int lmax = A[0];
        int rmax = A[n-1];
        int water = 0;
        int left = 1;
        int right = n-2;
        while(left<=right){
            int value = 0;
            if(lmax<=rmax){
                value = Math.max(lmax-A[left],0);
                if(A[left]>lmax)
                    lmax = A[left];
                left++;
            }
            else{
                value = Math.max(rmax-A[right],0);
                if(A[right]>rmax)
                    rmax = A[right];
                right--;
            }
            water += value;
        }
        return water;
    }

    public int trap4(int[] height) {
        if(height==null || height.length<=2)
            return 0;
        int value = 0;
        int n = height.length;
        int lmax = height[0];
        int rmax = height[n-1];
        int left=1;
        int right=n-2;
        while(left<=right)
        {
            if(lmax<=rmax)
            {
                value += Math.max(0,(lmax-height[left]));
                if(height[left]>lmax)
                    lmax = height[left];
                left++;
            }else{
                value += Math.max(0,(rmax-height[right]));
                if(height[right]>rmax)
                    rmax = height[right];
                right--;
            }
        }
        return value;
    }
}
