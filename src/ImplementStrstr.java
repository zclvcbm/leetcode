/**
 * Created by Admin on 2016/7/22.
 */
public class ImplementStrstr {
    public String strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return null;
        int hlen = haystack.length();
        int nlen = needle.length();
        if(nlen>hlen)
            return null;
        int i=0,j=0;
        while(i<hlen && j<nlen){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
            else{
                i = i-j+1;
                j=0;
            }
        }
        if(j==nlen)
            return haystack.substring(i-j);
        else
            return null;
    }

    public static void main(String[] args){
        /*String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";*/
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        ImplementStrstr is = new ImplementStrstr();
        System.out.println(is.strStr(str1,str2));
        System.out.println(is.strStr(null,str2));
        System.out.println(is.strStr(str1,null));
        System.out.println(is.strStr("ACD","ABCE"));
        System.out.println(is.strStr("",""));
    }
}
