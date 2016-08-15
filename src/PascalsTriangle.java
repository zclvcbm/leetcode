import java.util.ArrayList;

/**
 * Created by Admin on 2016/8/8.
 */
public class PascalsTriangle {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        if(numRows<=0)
            return null;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        lists.add(list);
        for(int i=1;i<numRows;i++){
            list = new ArrayList<Integer>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                    list.add(1);
                else
                    list.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args){
        generate(0);
        generate(1);
        generate(2);
        generate(5);
        generate(6);
    }
}
