/**
 * Created by Admin on 2016/7/29.
 */

/**
 *
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container,
 * such that the container contains the most water.

 Note: You may not slant the container.
 */

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int n = height.length;
        int i=0;
        int j=n-1;
        int max = 0;
        while(i<j)
        {
            max = Math.max(Math.min(height[i],height[j])*(j-i),max);
            if(height[i]<=height[j])
                i++;
            else
                j--;
        }
        return max;
    }

    public static void main(String[] args){
//        int[] array = {3,2,1,3};
//        int[] array = {3};
//        int[] array = {3,4};
//        int[] array = {1,1};
        int[] array = {2,3,4,5};
        maxArea(array);
    }
}
