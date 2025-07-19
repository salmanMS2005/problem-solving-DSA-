import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
      boolean[][] arr2={
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        allpathsprint("",arr2,0,0);
        boolean[][] arr3={
                {true,true,true},
                {true,true,true},
                {true,true,true},
        };
        int[][] arr4 =new int[arr3.length][arr3[0].length];
        allDirPaths("",arr3,0,0,arr4,1);
        //NQueens
        int n=4;
        boolean[][] board=new boolean[n][n];
        System.out.println(NQueens(board,0));

  }
//=====================================================================================================================================
  static void allpathsprint(String p,boolean[][] maze,int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        if(r< maze.length-1){
            allpathsprint(p+"Down ",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            allpathsprint(p+"Right ",maze,r,c+1);
        }
        if(r>0){
            allpathsprint(p+"Up ",maze,r-1,c);
        }
        if(c>0){
            allpathsprint(p+"Left ",maze,r,c-1);
        }
        //Backtracking starts here
        maze[r][c]=true;
    }
  /*
Output:
Down Down Right Right 
Down Down Right Up Right Down 
Down Down Right Up Up Right Down Down 
Down Right Down Right 
Down Right Right Down 
Down Right Up Right Down Down 
Right Down Down Right 
Right Down Right Down 
Right Down Left Down Right Right 
Right Right Down Down 
Right Right Down Left Down Right 
Right Right Down Left Left Down Right Right 
  */

  //==========================================================================================================================================
    static void allDirPaths(String p,boolean[][] maze,int r,int c,int[][] track,int step){
        if(r==maze.length-1 && c==maze[0].length-1){
            track[r][c]=step;
            for(int[] path: track){
                System.out.println(Arrays.toString(path));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[r][c]){
            return;
        }
        maze[r][c]=false;
        track[r][c]=step;
        if(r< maze.length-1){
            allDirPaths(p+"Down ",maze,r+1,c,track,step+1);
        }
        if(c<maze[0].length-1){
            allDirPaths(p+"Right ",maze,r,c+1,track,step+1);
        }
        if(r>0){
            allDirPaths(p+"Up ",maze,r-1,c,track,step+1);
        }
        if(c>0){
            allDirPaths(p+"Left ",maze,r,c-1,track,step+1);
        }
      //Backtracking starts here
        maze[r][c]=true;
        track[r][c]=0;

    }
/*
Output:
[1, 0, 0]
[2, 0, 0]
[3, 4, 5]
Down Down Right Right 

[1, 0, 0]
[2, 5, 6]
[3, 4, 7]
Down Down Right Up Right Down 

[1, 6, 7]
[2, 5, 8]
[3, 4, 9]
Down Down Right Up Up Right Down Down 

[1, 0, 0]
[2, 3, 0]
[0, 4, 5]
Down Right Down Right 

[1, 0, 0]
[2, 3, 4]
[0, 0, 5]
Down Right Right Down 

[1, 4, 5]
[2, 3, 6]
[0, 0, 7]
Down Right Up Right Down Down 

[1, 2, 0]
[0, 3, 0]
[0, 4, 5]
Right Down Down Right 

[1, 2, 0]
[0, 3, 4]
[0, 0, 5]
Right Down Right Down 

[1, 2, 0]
[4, 3, 0]
[5, 6, 7]
Right Down Left Down Right Right 

[1, 2, 3]
[0, 0, 4]
[0, 0, 5]
Right Right Down Down 

[1, 2, 3]
[0, 5, 4]
[0, 6, 7]
Right Right Down Left Down Right 

[1, 2, 3]
[6, 5, 4]
[7, 8, 9]
Right Right Down Left Left Down Right Right 

*/
//===================================================================================================================================
static int NQueens(boolean[][] board,int row){
        if(row==board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        for(int col=0;col<board[0].length;col++){
            if(issafe(board,row,col)) {
                board[row][col] = true;
                count += NQueens(board, row + 1);
                board[row][col]=false;
            }
        }
        return count;
    }

    private static void display(boolean[][] Qboard) {
        for(boolean[] row: Qboard){
            for (boolean col: row){
                if(col) {
                    System.out.print("Q");
                }
                else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
    private static boolean issafe(boolean[][] board,int row,int col){
        for(int i=0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }
        int left=Math.min(row,col);
        for(int j=1;j<=left;j++){
            if(board[row-j][col-j]){
                return false;
            }
        }
        int right=Math.min(row,board.length-col-1);
        for(int k=1;k<=right;k++){
            if(board[row-k][col+k]){
                return false;
            }
        }
        return true;

    }
/*
XQXX
XXXQ
QXXX
XXQX

XXQX
QXXX
XXXQ
XQXX

2
*/

}
