/**
 * Created by Admin on 2016/8/8.
 */
public class SearchForaRange_34 {
    static int min = Integer.MAX_VALUE;
    static int max = -1;

    public static void main(String[] args){
        int[] array = {5, 7, 7, 8, 8, 10};
        int[] array1 = {1};
//        searchRange(array,8);
//        searchRange(array,9);
        int[] result = searchRange(array1,1);
        System.out.println(result[0]+"  "+result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[]{-1,-1};
        help(nums,0,nums.length-1,target);
        if(max==-1)
            min = -1;
        return new int[]{min,max};
    }

    public static void help(int[] nums, int low, int high, int target){
        int i = low;
        int j = high;
        int mid;
        while(i<=j)
        {
            mid = (i+j)/2;
            if(nums[mid]==target)
            {
                if(mid>max)
                    max = mid;
                if(mid<min)
                    min = mid;
                help(nums,i,mid-1,target);
                help(nums,mid+1,j,target);
                break;
            }
            else if(nums[mid]<target)
            {
                i = mid+1;
            }
            else
            {
                j = mid-1;
            }
        }
    }
}
