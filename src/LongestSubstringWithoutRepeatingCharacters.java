import java.util.HashSet;
import java.util.Set;

/**
 * Created by Admin on 2016/7/26.
 */
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.

Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        int i=0,j=0;
        int n = s.length();
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        while(i<n && j<n) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
            }else{
                max = max>(j-i)?max:(j-i);
                while(i<j){
                    if(s.charAt(i)!=s.charAt(j))
                    {
                        set.remove(s.charAt(i));
                        i++;
                    }
                    else{
                        set.remove(s.charAt(i));
                        i++;
                        break;
                    }
                }
            }
        }
        return max>(j-i)?max:(j-i);
    }

    public static void main(String[] args){
//        lengthOfLongestSubstring("abcabcbb");
//        lengthOfLongestSubstring("bbbbbb");
//        lengthOfLongestSubstring("pwwkew");
        lengthOfLongestSubstring("c");
    }
}
