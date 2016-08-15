/**
 * Created by Admin on 2016/8/8.
 */

/**
 * Implement strStr()
 *
 * Implement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 */
public class ImplementStrStr_28 {
    public static int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return -1;
        int hlen = haystack.length();
        int nlen = needle.length();
        int j = 0;
        int i = 0;
        while(i<hlen && j<nlen)
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
            }else{
                i = i-j+1;
                j = 0;
            }
        }
        if(j==nlen)
            return i-j;
        else
            return -1;
    }

    public static void main(String[] args){
        String haystack = "zhangchong";
        String needle = "anga";
        System.out.println(strStr(haystack,needle));
        System.out.println(strStr("",""));
    }
}
