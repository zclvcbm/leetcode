/**
 * Created by Admin on 2016/8/17.
 */

/**
 * Single Number III
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumberIII_260 {
    public int[] singleNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        int xor = 0;
        for(int i=0;i<nums.length;i++)
        {
            xor ^= nums[i];
        }
        xor &= (-xor); //找到两个数二进制位第一次出现不同的位置
        int res[] = new int[2];
        res[0] = 0;
        res[1] = 0;
        for(int i=0;i<nums.length;i++)
        {
            // 以xor位二进制的值的不同进行分组，为0的在res[0]中进行异或操作，为1的在res[1]中进行异或操作，出现两次的被过滤掉，最后剩下的即为分别出现一次的数字
            if((nums[i] & xor)==0)
            {
                res[0] ^= nums[i];
            }else{
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
