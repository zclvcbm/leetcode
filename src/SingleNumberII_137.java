/**
 * Created by Admin on 2016/8/17.
 */
public class SingleNumberII_137 {
    public static int singleNumber(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for(int i=0;i<n;i++)
        {
            int t = nums[i];
            twos |= ones&nums[i];
            ones ^= t;
            threes = ones&twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public static void main(String[] args){
        int nums[] = {1,2,3,2,2,3,3};
        singleNumber(nums);
    }
}
