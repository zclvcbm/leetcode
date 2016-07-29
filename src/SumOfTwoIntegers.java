/**
 * Created by Admin on 2016/7/28.
 */

/**
 * Sum of Two Integers
 *
 * Calculate the sum of two integers a and b, but you are not
 * allowed to use the operator + and -.
 *
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
public class SumOfTwoIntegers {
    public static int getSum(int a, int b) {
        int c;
        while((a&b)!=0)
        {
            c = a^b;
            b = (a&b)<<1;
            a = c;
        }
        return a|b;
    }

    public static void main(String[] args){
        System.out.println(getSum(4,5));
    }
}
