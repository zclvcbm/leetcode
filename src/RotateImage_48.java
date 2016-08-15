/**
 * Created by Admin on 2016/8/8.
 */

/**
 *
 * Rotate Image
 *
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 *
 * Follow up:
 * Could you do this in-place?


 *
 * 解题思路：
 1 2 3 4
 5 6 7 8
 9 10 11 12
 13 14 15 16

 13 14 15 16
 9 10 11 12
 5 6 7 8
 1 2 3 4

 13 9 5 1
 14 10 6 2
 15 11 7 3
 16 12 8 4

 */
public class RotateImage_48 {
    public static void rotate(int[][] matrix) {
        if(matrix==null)
            return;
        int n = matrix.length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }
        System.out.println();

        // 左右对换
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n/2;j++)
            {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[n-1-j][i];
                matrix[n-1-j][i] = temp;
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }
        System.out.println();

        //以对角线为对称轴对换
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }
        System.out.println();
    }

    public static void main(String[] args){
//        int[][] array={{1,2,3},{4,5,6},{7,8,9}};
        int[][] array={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(array);

    }
}
