/**
 * Created by Admin on 2016/8/13.
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        if(s==null || s.length()==0)
            return 0;
        int d[] = new int[s.length()+1];
        d[0] =1;
        d[1] = 1;
        int n = s.length();
        for(int i=2;i<=n;i++)
        {
            String temp = s.charAt(i-2)+""+s.charAt(i-1);
            int t = Integer.valueOf(temp);
            if(t>=10 && t<=26 && s.charAt(i-1)!='0')
                d[i] = d[i-1]+d[i-2];
            else
                d[i] = d[i-1];
        }
        return d[n];
    }

    public static void main(String[] args){
        String str = "ewew";

        numDecodings("1203");
    }
}
