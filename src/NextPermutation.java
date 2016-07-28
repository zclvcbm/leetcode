/**
 * Created by Admin on 2016/7/26.
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {

        if(nums==null || nums.length<1)
            return ;
        int n = nums.length;

        // 从右到左找到数组中第一个升序位置
        int i;
        for(i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
                break;
        }

        // 从右到左找到数组中第一个比升序位置数值大的位置
        if(i<0)
        {
            reverse(nums,0,n-1);
            return ;
        }
        int j;
        for(j=n-1;j>i;j--)
        {
            if(nums[j]>nums[i])
                break;
        }
        // 交换前面找到位置的数字
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

        //将升序位置以后的所有元素转置
        i=i+1;
        j = n-1;
        while(i<j)
        {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


    public static void reverse(int[] nums,int i,int j)
    {
        while(i<j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args){
//        int[] array = {1,5,2,4,3};
        int[] array = {1,1,5};
//        int[] array = {3,2,1};
//        int[] array = {1};
        nextPermutation(array);
        for(int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
        System.out.println();
    }
}
