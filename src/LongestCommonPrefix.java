import javafx.scene.shape.TriangleMesh;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 2016/8/6.
 */
public class LongestCommonPrefix {
    public class TireNode{
        char val;
        boolean isEnding;
        Map<Character,TireNode> childNode;

        public TireNode(char val,boolean isEnding){
            this.val = val;
            this.isEnding = isEnding;
            childNode = new HashMap<>();
        }
    }
    public static void main(String[] args){
        String[] strs = {"zhang","zhan","zang"};
        LongestCommonPrefix test = new LongestCommonPrefix();
//        String[] strs = {"zhang","zhano",""};
        test.longestCommonPrefix(strs);
   }

    public String longestCommonPrefix(String[] strs){
        if(strs==null)
            return null;
        int n = strs.length;
        int res = 0;
        String resStr = null;
        TireNode root = new TireNode(' ',false);
        for(int i=0;i<n;i++)
        {
            TireNode p = root;
            int len = strs[i]==null?0:strs[i].length();
            for(int j=0;j<len;j++){
                if(p.childNode.containsKey(strs[i].charAt(j)))
                    p = p.childNode.get(strs[i].charAt(j));
                else{
                    if(j==len-1) {
                        TireNode node = new TireNode(strs[0].charAt(j),true);
                        p.childNode.put(strs[0].charAt(j),node);
                        p = node;
                    }else{
                        TireNode node = new TireNode('c',false);
                        p.childNode.put(strs[0].charAt(j),node);
                        p = node;
                    }
                    res = Math.max(res, j + 1);
                    resStr = strs[0].substring(0,j);
                }
            }
        }
        return resStr;
    }

}
