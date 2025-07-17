public class Maze {
    public static void main(String[] args) {
        int ans1=findpaths1(3,3);
        int ans2=findpaths2(2,1,3,3);
        System.out.println(ans1);
        System.out.println(ans2);

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

}
