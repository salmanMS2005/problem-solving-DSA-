public class Maze {
    public static void main(String[] args) {
        int ans1=findpaths1(3,3);
        int ans2=findpaths2(2,1,3,3);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(pathsDiagonal("",3,3));
        boolean[][] arr={
                {true,true,true},
                {true,false,true},
                {true,true,true},
        };
        pathRestriction("",arr,0,0);

    }
//======================================================================================================================================
//Starting from the 0,0 and reaching the end:
    static int findpaths1(int n,int m){
        if(n==1 || m==1){
            return 1;
        }
        int count=0;
        count+=findpaths1(n-1,m)+findpaths1(n,m-1);
        return count;
    }
//======================================================================================================================================
//Starting from the strow,stcol and reaching the end:
    static int findpaths2(int strow,int stcol,int row,int col){
        if(strow==row || stcol==col){
            return 1;
        }
        int count=0;
        count+=findpaths2(strow+1,stcol,row,col)+findpaths2(strow,stcol+1,row,col);
        return count;
    }
//======================================================================================================================================
    static void printpaths(String p,int r,int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            printpaths(p+"D",r-1,c);
        }
        if(c>1){
            printpaths(p+"R",r,c-1);
        }
    }
/*
DDRR
DRDR
DRRD
RDDR
RDRD
RRDD
*/
//=====================================================================================================================================
    

   static ArrayList<String> pathsDiagonal(String p,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> ans=new ArrayList<>();
            ans.add(p);
            return ans;
        }
        ArrayList<String> paths=new ArrayList<>();
        if(r>1 && c>1){
            paths.addAll(pathsDiagonal(p+"Dia ",r-1,c-1));
        }
        if(r>1){
            paths.addAll(pathsDiagonal(p+"Down ",r-1,c));
        }
        if(c>1){
            paths.addAll(pathsDiagonal(p+"R ",r,c-1));
        }
        return paths;
    }
/*
[Dia Dia , Dia Down R , Dia R Down , Down Dia R , Down Down R R , Down R Dia , Down R Down R , 
Down R R Down , R Dia Down , R Down Dia , R Down Down R , R Down R Down , R R Down Down ]
*/
//======================================================================================================================================
    static void pathRestriction(String p,boolean[][] maze, int r,int c){
        if(r==maze.length-1 && c==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[r][c]){
            return;
        }
        if(r<maze.length-1){
            pathRestriction(p+"D",maze,r+1,c);
        }
        if(c<maze[0].length-1){
            pathRestriction(p+"R",maze,r,c+1);
        }
    }
/*
DDRR
RRDD
*/
//======================================================================================================================================
}
