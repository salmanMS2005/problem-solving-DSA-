/*
Leetcode 323 : no.of . Connected Components


Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. 
The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi.
We say two vertices u and v belong to a same component if there is a path from u to v or v to u. Find the number of connected components in the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices,
and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

Examples:
Input: V=4, edges=[[0,1],[1,2]]

Output: 2

Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.

Input: V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]

Output: 3

Explanation:

The edges [0, 1], [1, 2], [2, 3] form a connected component with vertices {0, 1, 2, 3}.

The edge [4, 5] forms another connected component with vertices {4, 5}.

Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the isolated vertices {6} (vertices 6 and any other unconnected vertices).
*/

class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
    int count=0;
    boolean[] visited = new boolean[V];

    for(int i=0;i<V;i++){
        if(!visited[i]){
            dfs(i,visited,edges);
            count++;
        }
    }
    return count;
  }
  void dfs(int node,boolean[] visited,List<List<Integer>> adj){
      visited[node]=true;
      for(Integer v:adj.get(node)){
          if(!visited[v]){
              dfs(v,visited,adj);
          }
      }
  }
          
}
//====================================================================================================================

/*
994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/
class Pair{
    int x,y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        Queue<Pair> que=new LinkedList();

        
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    que.add(new Pair(i,j));
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int minutes=0;
        while(!que.isEmpty()){
            int size=que.size();
            boolean isFresh=false;
            while(size-->0){
                Pair node=que.poll();
                for(int k=0;k<dir.length;k++){
                    int nr=node.x + dir[k][0];
                    int nc=node.y + dir[k][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        que.add(new Pair(nr,nc));
                        fresh--;
                        isFresh=true;
                    }
                }
            }
            //only incrementing the minutes if we rotten the oranges
            if(isFresh) minutes++;
        }
        //checking for the oranges that is fresh , if so return -1;
        if(fresh>0) return -1;
        //if no fresh orange found, then return the mins
        return minutes;
    }
}
//======================================================================================================================
/*
 Walls And Gates
 
You are given a matrix having ‘N’ rows and ‘M’ columns. Each cell of the matrix can only contain three values as given below:

-1 -> It denotes a wall or an obstacle

0  -> It denotes a gate

2^31 - 1 =  2147483647 ( INF ) -> An infinitely large value  denotes the empty room.

For each empty room (denoted by INF), you have to refill it with the distance to its nearest gate. If none of the gates is reachable from an empty room then the value ‘INF’ will remain as it is.
Example
For the matrix [[0,-1],[0,2147483647]] the updated matrix will be [[0,-1],[0,1]].
Note
The distance between two cells having their coordinates (x1,y1) and (x2,y2) are abs(x2-x1) + abs(y2-y1).
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 50
1 <= N <= 10^4  
1 <= M <= 10^4
1 <= N*M <= 10^4 

Time Limit: 1 sec
Sample Input 1:
2
2 2
2147483647 -1
-1 0
4 4
2147483647 -1 0 2147483647
2147483647 2147483647 2147483647 -1
2147483647 -1 2147483647 -1
0 -1 2147483647 2147483647
Sample Output 1:
2147483647 -1
-1 0
3 -1 0 1
2 2 1 -1
1 -1 2 -1
0 -1 3 4
Explanation For Sample Input 1:
Test case 1:

There is no path from the empty cell at [0.0] to the only gate at [1,1] .

Test case 2:

Sample Input 2:
2
2 3
-1 0 2147483647
-1 0 2147483647
3 3
0 -1 2147483647
0 -1 2147483647
0 -1 2147483647
Sample Output 2:
-1 0 1
-1 0 1
0 -1 2147483647
0 -1 2147483647
0 -1 2147483647
*/
import java.util.* ;
import java.io.*; 
class Pair{
    int x, y,level;
    public Pair(int x,int y,int level){
        this.x=x;
        this.y=y;
        this.level=level;
    }
}

public class Solution {
    public static int[][] wallsAndGates(int[][] a, int n, int m) {
        // Write you code here
        Queue<Pair> que= new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==0){
                    que.add(new Pair(i,j,0));
                }
            }
        }
        int[][] dir= new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                Pair node=que.poll();
                for(int i=0;i<dir.length;i++){
                    int nr=node.x + dir[i][0];
                    int nc=node.y + dir[i][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m){
                        if(a[nr][nc]==Integer.MAX_VALUE){
                            a[nr][nc]=node.level+1;
                            que.add(new Pair(nr,nc,node.level+1));
                        }else if(a[nr][nc]==-1 || a[nr][nc]!=Integer.MAX_VALUE){
                            continue;
                        }
                    }
                }
            }
        }
        return a;
    }
}
//========================================================================================================================
/*

Code

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]

 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is 'X' or 'O'.
*/
class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(board[i][j]=='O'){
                        dfs(i,j,board,n,m);
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }else if(board[i][j]=='M'){
                    board[i][j]='O';
                }
            }
        }
    }
    void dfs(int row,int col,char[][] board,int n,int m){
        if(row<0 || row>n-1 || col<0 || col>m-1) return;
        if(board[row][col]!='O') return;

        board[row][col]='M';
            
        dfs(row,col+1,board,n,m);
        dfs(row,col-1,board,n,m);
        dfs(row-1,col,board,n,m);
        dfs(row+1,col,board,n,m);
    }
}
//===============================================================================================================================
/*
1293. Shortest Path in a Grid with Obstacles Elimination

You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.

 

Example 1:


Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0
*/

class Pair{
    int x;
    int y;
    int power;
    public Pair(int x,int y,int power){
        this.x=x;
        this.y=y;
        this.power=power;
    }
}
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int level=0;

        if(m==1 && n==1) return level;

        int[][] visitedPower=new int[n][m];

        for(int[] row: visitedPower){
            Arrays.fill(row,-1);
        }
        visitedPower[0][0]=k;

        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(0,0,k));
        
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                Pair node=que.poll();
                int currRow=node.x;
                int currCol=node.y;
                int currPower=node.power;
                for(int i=0;i<dir.length;i++){
                    int nextRow=currRow+dir[i][0];
                    int nextCol=currCol+dir[i][1];

                    if(nextRow==n-1 && nextCol==m-1) return level+1;
                    
                    if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m)  {
                        if(grid[nextRow][nextCol]==1 && visitedPower[currRow][currCol] >0 && visitedPower[nextRow][nextCol]< currPower-1){
                            que.add(new Pair(nextRow,nextCol,currPower-1));
                            visitedPower[nextRow][nextCol]= currPower-1; 
                        }else if(grid[nextRow][nextCol]==0 && visitedPower[nextRow][nextCol]< currPower){
                            que.add(new Pair(nextRow,nextCol,currPower));
                            visitedPower[nextRow][nextCol]= currPower;
                        }

                    }
                }
            }
            level++;
        }
    return -1;
    }
}
//========================================================================================================
/*
542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.

 

Example 1:


Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
Example 2:


Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
*/
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int[][] ans= new int[row][col];
        Queue<Integer> que=new LinkedList<>();
   
        //making 0 as source node and 1 as destination node . first marking 0 as the answer directly.
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    que.add(i*col+j);
                }else{
                     ans[i][j]=-1;
                }
            }
        }
        //bfs 
        int[][] dir=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int level=0;
        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                int node=que.poll();
                int r=node/col;
                int c=node%col;
                for(int i=0;i<dir.length;i++){
                    int nr=r+dir[i][0];
                    int nc=c+dir[i][1];
                    if(nr>=0 && nc>=0 && nr<row && nc<col && ans[nr][nc]==-1){
                        que.add(nr*col+nc);
                        ans[nr][nc]=level+1;
                    }
                }
            }
            level++;
        }
    return ans;

    }
}
//================================================================================================================================
/*
547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

 

Example 1:


Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
Example 2:


Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

Constraints:

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] is 1 or 0.
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
*/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        boolean[] visited = new boolean[v];
        int count=0;

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(visited,isConnected,i);
                count++;
            }
        }
    return count;
    }
    void dfs(boolean[] visited,int[][] isConnected,int i){
        visited[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(visited,isConnected,j);
            }
        }
    }
}
//========================================================================================================================
/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/
class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited= new boolean[grid.length][grid[0].length];
        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
     
    void dfs(char[][] grid,boolean[][] visited,int r,int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || visited[r][c] || grid[r][c] == '0') return;

        visited[r][c]=true;
        
        dfs(grid,visited,r+1,c);
        dfs(grid,visited,r-1,c);
        dfs(grid,visited,r,c+1);
        dfs(grid,visited,r,c-1);
        
        }                       
    
}
//========================================================================================================================
/*
733. Flood Fill

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

 

Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]

Explanation:



From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.

Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0

Output: [[0,0,0],[0,0,0]]

Explanation:

The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.

 

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n
*/
/*
*********DFS*********************
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int ogColor=image[sr][sc];

        if(ogColor==color) return image;

        dfs(image,sr,sc,color,n,m,ogColor);
        return image;
    }
    private void dfs(int[][] image,int sr,int sc,int color,int n,int m,int ogColor){
        if(sr<0 || sr>=n ||sc>=m|| sc<0 ) return;

        if(image[sr][sc]!=ogColor) return;

            image[sr][sc]=color;
        
        dfs(image,sr+1,sc,color,n,m,ogColor);
        dfs(image,sr-1,sc,color,n,m,ogColor);
        dfs(image,sr,sc+1,color,n,m,ogColor);
        dfs(image,sr,sc-1,color,n,m,ogColor);
    }
}*/

//**********************BFS: */
class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int ogColor=image[sr][sc];       

        if(ogColor==color) return image;

        Queue<Pair> que=new LinkedList();
        que.add(new Pair(sr,sc));
        image[sr][sc]=color;

        int[][] dir =new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                Pair loc=que.poll();
                int r=loc.x;
                int c=loc.y;
                for(int i=0;i<dir.length;i++){
                    int nr=r+dir[i][0];
                    int nc=c+dir[i][1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m){
                        
                        if(image[nr][nc]==ogColor){
                            que.add(new Pair(nr,nc));
                            image[nr][nc]=color;
                        }
                        if(image[nr][nc]!=ogColor){
                            continue;
                        }
                    }
                }
            }
        }
        return image;
    }
}
//=====================================================================================================
/*
1020. Number of Enclaves

You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
*/
class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> que=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        grid[i][j]=-1;
                        que.add(new Pair(i,j));
                    }
                }
            }
        }

        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                Pair loc=que.poll();
                int r=loc.x;
                int c=loc.y;
                for(int i=0;i<dir.length;i++){
                    int nr=r+dir[i][0];
                    int nc=c+dir[i][1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m){
                        if(grid[nr][nc]==1){
                            grid[nr][nc]=-1;
                            que.add(new Pair(nr,nc));
                        }
                    }
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    cnt++;    
                }
            }
        }
        return cnt;
    }
}
//=============================================================================================
/*
1020. Number of Enclaves
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
Example 2:


Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 500
grid[i][j] is either 0 or 1.
*/
class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> que=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(grid[i][j]==1){
                        grid[i][j]=-1;
                        que.add(new Pair(i,j));
                    }
                }
            }
        }

        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!que.isEmpty()){
            int size=que.size();
            while(size-->0){
                Pair loc=que.poll();
                int r=loc.x;
                int c=loc.y;
                for(int i=0;i<dir.length;i++){
                    int nr=r+dir[i][0];
                    int nc=c+dir[i][1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m){
                        if(grid[nr][nc]==1){
                            grid[nr][nc]=-1;
                            que.add(new Pair(nr,nc));
                        }
                    }
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    cnt++;    
                }
            }
        }
        return cnt;
    }
}
//=========================================================================================
/*
Undirected Graph Cycle
Difficulty: MediumAccuracy: 30.13%Submissions: 622K+Points: 4Average Time: 20m
Given an undirected graph with V vertices and E edges, represented as a 2D vector edges[][], where each entry edges[i] = [u, v] denotes an edge between vertices u and v, determine whether the graph contains a cycle or not. The graph can have multiple component.

Examples:

Input: V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: true
Explanation: 
 
1 -> 2 -> 0 -> 1 is a cycle.
Input: V = 4, E = 3, edges[][] = [[0, 1], [1, 2], [2, 3]]
Output: false
Explanation: 
 
No cycle in the graph.
Constraints:
1 ≤ V ≤ 105
1 ≤ E = edges.size() ≤ 105
*/
class Pair{
    int node;
    int parent;
    public Pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        List<Integer>[] adj = new ArrayList[V];
        
        for (int i = 0; i < V; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u); // undirected
        }
        
        boolean[] visited = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isCycle(i,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean isCycle(int v,List<Integer>[] adj,boolean[] visited){
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(v,-1));
        visited[v]=true;
        
        while(!que.isEmpty()){
            
            Pair pair=que.poll();
            int node=pair.node;
            int parent=pair.parent;
            

            for(int nextNode : adj[node]){
                if(visited[nextNode]==false){
                    visited[nextNode]=true;
                    que.add(new Pair(nextNode,node));
                }else if(parent!=nextNode){
                    return true;
                }
            }
        }
        return false;
        
    }
}
//==============================================================================================
/*

*/
