/**
 * Created by Admin on 2016/7/21.
 */
/*
题目描述

Given an array of integers, every element appears twice except for one.
Find that single one.
Note:
Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?

 */
public class SingleNumber {
    public int singleNumber(int[] A){
        if(A==null || A.length==0)
            return 0;
        for(int i=1;i<A.length;i++)
        {
            A[0] = A[0]^A[i];
        }
        return A[0];
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,3,2,1};
//        int result = new SingleNumber().singleNumber(array);
        int result = new SingleNumber().singleNumber(null);
        System.out.println(result);
    }
}
