/*
Top View of Binary Tree
Difficulty: MediumAccuracy: 38.43%Submissions: 396K+Points: 4Average Time: 45m
You are given a binary tree, and your task is to return its top view. The top view of a binary tree is the set of nodes visible when the tree is viewed from the top.

Note: 

Return the nodes from the leftmost node to the rightmost node.
If two nodes are at the same position (horizontal distance) and are outside the shadow of the tree, consider the leftmost node only. 
Examples:

Input: root[] = [1, 2, 3] 
 
Output: [2, 1, 3]
Input: root[] = [10, 20, 30, 40, 60, 90, 100]
 
Output: [40, 20, 10, 30, 100]
Explanation: The root 10 is visible.
On the left, 40 is the leftmost node and visible, followed by 20.
On the right, 30 and 100 are visible. Thus, the top view is 40 20 10 30 100.
Input: root[] = [1, 2, 3, N, 4, N, N, N, 5, N, 6]
       1
     /   \
    2     3
     \   
      4
       \
        5
         \
          6
Output: [2, 1, 3, 6]
Explanation: Node 1 is the root and visible.
Node 2 is the left child and visible from the left side.
Node 3 is the right child and visible from the right side.
Nodes 4, 5, and 6 are vertically aligned, but only the lowest node 6 is visible from the top view. Thus, the top view is 2 1 3 6.
Constraints:
1 ≤ number of nodes ≤ 105
1 ≤ node->data ≤ 105

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Tuple{
    Node node;
    int col;
    public Tuple(Node node,int col){
        this.node=node;
        this.col=col;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Tuple> que=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        que.offer(new Tuple(root,0));
        
        
        while(!que.isEmpty()){
            Tuple tuple=que.poll();
            Node node=tuple.node;
            int col=tuple.col;
            
            if(!map.containsKey(col)){
                map.put(col,node.data);
            }
            
            if(node.left!=null){
                que.offer(new Tuple(node.left,col-1));
            }
            if(node.right!=null){
                que.offer(new Tuple(node.right,col+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
//==============================================================================================================================
/*
Bottom View of Binary Tree
Difficulty: MediumAccuracy: 54.18%Submissions: 314K+Points: 4Average Time: 45m
Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.

Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the later one in the level order traversal is considered. For example, in the below diagram, 7 and 34 both are the bottommost nodes at a horizontal distance of 0 from the root, here 34 will be considered.

For the above tree, the output should be 5 8 34 22 25

Examples :

Input: root[] = [1, 3, 2]

Output: [3 1 2]
Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.

Thus bottom view of the binary tree will be 3 1 2.
Input: root[] = [10, 20, 30, 40, 60]
         
Output: [40 20 60 30]
Constraints:
1 <= number of nodes <= 105
1 <= node->data <= 105


class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/
class Tuple{
    Node node;
    int col;
    public Tuple(Node node,int col){
        this.node=node;
        this.col=col;
    }
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        ArrayList<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        
        Queue<Tuple> que=new LinkedList<>();
        que.offer(new Tuple(root,0));
        
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        while(!que.isEmpty()){
            Tuple tuple=que.poll();
            Node node=tuple.node;
            int col=tuple.col;
            
            if(!tm.containsKey(col)){
                tm.put(col,node.data);
            }else{
                tm.put(col,node.data);
            }
            
            if(node.left!=null){
                que.offer(new Tuple(node.left,col-1));
            }
            if(node.right!=null){
                que.offer(new Tuple(node.right,col+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry:tm.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
//================================================================================================================================
