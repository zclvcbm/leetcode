
/**
 * Created by Admin on 2016/8/15.
 */
public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int r = 0,c=n-1;
        for(;r<m && c>=0;)
        {
            if(matrix[r][c]==target)
                return true;
            else if(matrix[r][c]>target)
            {
                c--;
            }else{
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int i=0;
        i = i++;
        System.out.println(i);
    }
}
