import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Admin on 2016/8/16.
 */
class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class NumberOfIslands_200 {
    public void helpDFS(char[][] grid, int x ,int y){
        if(x<0 || x>=grid.length || y<0 || y>=grid[x].length || grid[x][y]!='1')
            return;
        grid[x][y] = '0';
        helpDFS(grid,x,y-1);
        helpDFS(grid,x,y+1);
        helpDFS(grid,x-1,y);
        helpDFS(grid,x+1,y);
    }

    public void helpBFS(char[][] grid, int x,int y){
        Queue<Pair> queue = new LinkedList();
        int dx[] = {-1,0,1,0};
        int dy[] = {0,-1,0,1};
        grid[x][y] = '0';
        for(queue.add(new Pair(x,y));!queue.isEmpty();queue.remove())
        {
            x = queue.peek().x;
            y = queue.peek().y;
            for(int i=0;i<4;i++)
            {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]=='1')
                {
                    grid[nx][ny] = '0';
                    queue.add(new Pair(nx,ny));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    answer++;
                    helpDFS(grid,i,j);
//                    helpBFS(grid,i,j);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        char grid[][] = {{'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}};
        NumberOfIslands_200 test = new NumberOfIslands_200();
        System.out.println(test.numIslands(grid));
        Set<Integer> set = new TreeSet<>();

    }
}
