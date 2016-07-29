import java.util.Stack;

/**
 * Created by Admin on 2016/7/25.
 */

/*
largest-rectangle-in-histogram

题目描述


Given n non-negative integers representing the histogram's bar height
where the width of each bar is 1, find the area of largest rectangle
in the histogram.

Above is a histogram where width of each bar is 1, given height =[2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area =10unit.

For example,
Given height =[2,1,5,6,2,3],
return10.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        int result = 0;
        Stack<Integer> s  = new Stack();
        for(int i=0; i<n; i++){
            while((!s.empty()) && (height[s.peek()] >= height[i])){
                int h = height[s.peek()];
                s.pop();
                result =Math.max(result,(i-1-(s.empty()?(-1):s.peek()))*h);
            }
            s.push(i); //确定左边界
        }
        while(!s.empty()){
            int h = height[s.peek()];
            s.pop();
            result = Math.max(result,(n-1-(s.empty()?(-1):s.peek()))*h);
        }
        return result;
    }

    public static void main(String[] args){
        LargestRectangleInHistogram lh = new LargestRectangleInHistogram();
////        int[] array = {2,1,5,6,6,2,3};
//        int[] array = {2,1,5,6,2,3};
//        System.out.println(lh.largestRectangleArea2(array));


        int[] array = {3,2,1,4};
        System.out.println(lh.largestRectangleArea2(array));
    }

    public int largestRectangleArea2(int[] heights){
        int n = heights.length;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.empty() && (heights[stack.peek()]>=heights[i]))
            {
                int h = heights[stack.peek()];
                stack.pop();
                result = Math.max(result,(i-1-(stack.empty()?(-1):stack.peek()))*h);
            }
            stack.push(i);
        }

        while (!stack.empty())
        {
            int h = heights[stack.peek()];
            stack.pop();
            result = Math.max(result,(n-1-(stack.empty()?(-1):stack.peek()))*h);
        }
        return result;
    }

}
