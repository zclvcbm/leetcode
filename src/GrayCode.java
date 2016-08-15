import java.util.ArrayList;

/**
 * Created by Admin on 2016/8/12.
 */
public class GrayCode {
    public static void main(String[] args)
    {
        grayCode(2);
        grayCode(3);
    }

    public static ArrayList<Integer> grayCode(int n) {
        int start = 0;
        int count = (int)Math.pow(2,n);
        int i=0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(i<count)
        {
            i++;
            list.add(start);
            start = getSum(start,1);
        }
        return list;
    }

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
}
