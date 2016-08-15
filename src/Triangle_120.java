import java.util.ArrayList;

/**
 * Created by Admin on 2016/8/12.
 */

/**
 * triangle
 *
 * 题目描述


 Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]

 The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle_120 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null || triangle.size()==0)
            return 0;
        int n = triangle.size();
        int[] d = new int[n];
        d[0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++)
        {
            for(int j=i;j>=0;j--)
            {
                if(j==i)
                    d[j] = triangle.get(i).get(i)+d[j-1];
                else if(j==0)
                    d[j] = triangle.get(i).get(0)+d[0];
                else
                    d[j] = Math.min(triangle.get(i).get(j)+d[j],triangle.get(i).get(j)+d[j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            if(d[i]<min)
                min = d[i];
        return min;
    }
}
