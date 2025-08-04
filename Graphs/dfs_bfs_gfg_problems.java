/*
BFS of graph
Difficulty: EasyAccuracy: 44.09%Submissions: 505K+Points: 2Average Time: 10m
Given a connected undirected graph containing V vertices, represented by a 2-d adjacency list adj[][],
where each adj[i] represents the list of vertices connected to vertex i. 
Perform a Breadth First Search (BFS) traversal starting from vertex 0,
visiting vertices from left to right according to the given adjacency list, 
and return a list containing the BFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 3, 1, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps: 
Visit 0 → Output: 0 
Visit 2 (first neighbor of 0) → Output: 0, 2 
Visit 3 (next neighbor of 0) → Output: 0, 2, 3 
Visit 1 (next neighbor of 0) → Output: 0, 2, 3, 
Visit 4 (neighbor of 2) → Final Output: 0, 2, 3, 1, 4
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal proceeds as follows: 
Visit 0 → Output: 0 
Visit 1 (the first neighbor of 0) → Output: 0, 1 
Visit 2 (the next neighbor of 0) → Output: 0, 1, 2 
Visit 3 (the first neighbor of 2 that hasn't been visited yet) → Output: 0, 1, 2, 3 
Visit 4 (the next neighbor of 2) → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ V = adj.size() ≤ 104
1 ≤ adj[i][j] ≤ 104
  */

class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v=adj.size();
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean[] visited= new boolean[v];
        Queue<Integer> que=new LinkedList<>();
        
        que.add(0);
        visited[0] =true;
        
        while(!que.isEmpty()){
            int node=que.poll();
            bfs.add(node);
            
            for(Integer edgenode: adj.get(node)){
                if(!visited[edgenode]){
                    visited[edgenode] =true;
                    que.add(edgenode);
                }
            }
        }
        return bfs;
        
    }

}
//=================================================================================================================================

/*
DFS of Graph
Difficulty: EasyAccuracy: 63.07%Submissions: 357K+Points: 2Average Time: 5m
Given a connected undirected graph containing V vertices represented by a 2-d adjacency list adj[][],
where each adj[i] represents the list of vertices connected to vertex i. Perform a Depth First Search (DFS) traversal starting from vertex 0,
visiting vertices from left to right as per the given adjacency list, and return a list containing the DFS traversal of the graph.

Note: Do traverse in the same order as they are in the given adjacency list.

Examples:

Input: adj[][] = [[2, 3, 1], [0], [0, 4], [0], [2]]

Output: [0, 2, 4, 3, 1]
Explanation: Starting from 0, the DFS traversal proceeds as follows:
Visit 0 → Output: 0 
Visit 2 (the first neighbor of 0) → Output: 0, 2 
Visit 4 (the first neighbor of 2) → Output: 0, 2, 4 
Backtrack to 2, then backtrack to 0, and visit 3 → Output: 0, 2, 4, 3 
Finally, backtrack to 0 and visit 1 → Final Output: 0, 2, 4, 3, 1
Input: adj[][] = [[1, 2], [0, 2], [0, 1, 3, 4], [2], [2]]

Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the DFS traversal proceeds as follows: 
Visit 0 → Output: 0 
Visit 1 (the first neighbor of 0) → Output: 0, 1 
Visit 2 (the first neighbor of 1) → Output: 0, 1, 2 
Visit 3 (the first neighbor of 2) → Output: 0, 1, 2, 3 
Backtrack to 2 and visit 4 → Final Output: 0, 1, 2, 3, 4
Constraints:
1 ≤ V = adj.size() ≤ 104
1 ≤ adj[i][j] ≤ 104
*/
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int v=adj.size();
        boolean[] visited = new boolean[v+1];
        ArrayList<Integer> ans=new ArrayList<>();
        
        helper(0,visited,ans,adj);
        
        return ans;
    }
    void helper(int node,boolean[] visited , ArrayList<Integer> list
               ,ArrayList<ArrayList<Integer>> adj){
                   
        visited[node]=true;
        list.add(node);
        
        for(Integer v: adj.get(node)){
            if(!visited[v]){
                helper(v,visited,list,adj);
            }
        }
    }
}
//=============================================================================================================================
