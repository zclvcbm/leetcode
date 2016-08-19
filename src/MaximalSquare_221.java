import java.util.Stack;

/**
 * Created by Admin on 2016/8/19.
 */
public class MaximalSquare_221 {
    public static int getMax(int[] num){
        int n = num.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!stack.empty() && num[i]<=num[stack.peek()])
            {
                int j = stack.pop(); //
                int k = stack.isEmpty()?-1:stack.peek(); //k为左边界 i为右边界
                if((i-k-1)== num[j]) {
                    int sum = Math.min(i-k-1,num[j])*Math.min(i-k-1,num[j]);
                    max = Math.max(max, sum);
                }
            }
            stack.push(i);
        }
        while(!stack.empty())
        {
            int j = stack.pop();
            int k = stack.isEmpty()?-1:stack.peek();
            int sum = Math.min(n-k-1,num[j])*Math.min(n-k-1,num[j]);
            max = Math.max(max,sum);

        }
        return max;
    }

    public static int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int sum[] = new int[n];
        int max = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='0')
                    sum[j] = 0;
                else
                    sum[j] += (matrix[i][j]-'0');
            }
            max = Math.max(max,getMax(sum));
        }
        return max;
    }

    public static void main(String[] args){
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] matrix1 = {
                {'1', '0','0','1', '1', '0', '1','1'},
                {'1', '0','0','0', '0', '1', '0','0'},
                {'0', '1','1','1','0', '0', '1','1'},
                { '0','0','0','1', '0', '0', '0','1'},
                {'0', '0','0','0','0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0', '1', '1', '0'},
                {'0', '1', '1', '0', '1', '1', '1', '0'}
        };
        int result = maximalSquare(matrix);
//        int result = maximalSquare(matrix1);
        System.out.println(result);
    }
}
