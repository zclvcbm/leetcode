/**
 * Created by Admin on 2016/8/19.
 */

/**
 * 79. Word Search  QuestionEditorial Solution  My Submissions
 Total Accepted: 85853
 Total Submissions: 357407
 Difficulty: Medium
 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class WordSearch_79 {
    public static boolean help(char[][] board, int i, int j, boolean[][] visited, String word, int now){
        if(now>=word.length() || i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || word.charAt(now)!=board[i][j])
            return false;
        if(now==word.length()-1)
            return true;
        visited[i][j] = true;
        if(help(board,i-1,j,visited,word,now+1) || help(board,i+1,j,visited,word,now+1)
                    || help(board,i,j-1,visited,word,now+1) || help(board,i,j+1,visited,word,now+1))
            return true;
        visited[i][j] = false;
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0 || word==null)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(help(board,i,j,visited,word,0))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        System.out.println(exist(board,"ABCCED"));
        System.out.println(exist(board,"SEE"));
        System.out.println(exist(board,"ABCB"));
        System.out.println(exist(board,"QWT"));
    }
}
