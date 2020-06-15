/**
 * Created by Administrator on 2020/6/15.
 */
public class Reverse_2 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        //2147483647
        System.out.println(reverse(1463847412));
//        System.out.println((Integer.MAX_VALUE));
    }

    public static int reverse(int x) {
        int y = 0;
        int flag = 1; //0表示x为非负数，1表示x为正数

        if (x < 0) {
            flag = -1;
            x *=  flag;
        }
        while (x > 0) {
            //正数,翻转后值大于Integer.MAX_VALUE
            if (flag == 1 && y > (Integer.MAX_VALUE -1 - x%10)/10) {
                return 0;
            }
            //负数,翻转后值小于Integer.MIN_VALUE
            if (flag == -1 && y > (Integer.MAX_VALUE - x%10)/10) {
                return 0;
            }
            y = y*10 + x%10;
            x /= 10;
        }
        y *= flag;
        return y;
    }
}
