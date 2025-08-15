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
/*
Max and min element in Binary Tree
Difficulty: EasyAccuracy: 60.57%Submissions: 39K+Points: 2
Given a Binary Tree, find maximum and minimum elements in it.

Example:

Input: 
           
Output: 11 1
Explanation: The maximum and minimum element in this binary tree is 11 and 1 respectively.
Input: 
           6
        / \
       5   8
      /
     2
Output: 8 2
Explanation: The maximum and minimum element in this binary tree is 8 and 2 respectively.
Constraints:
1 <= number of nodes <= 105
1 <= data of a node <= 105

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public static int findMax(Node root) {
        // code here
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data,Math.max(findMax(root.left),findMax(root.right)));
    }
     
    public static int findMin(Node root) {
        
        // code here
        if(root==null){
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data,Math.min(findMin(root.left),findMin(root.right)));
    }
}
//==================================================================================================================
/*
Ceil in BST
Difficulty: MediumAccuracy: 62.73%Submissions: 158K+Points: 4Average Time: 30m
Given a BST and a number X, find Ceil of X.
Note: Ceil(X) is a number that is either equal to X or is immediately greater than X.

If Ceil could not be found, return -1.

Examples:

Input: root = [5, 1, 7, N, 2, N, N, N, 3], X = 3

Output: 3
Explanation: We find 3 in BST, so ceil of 3 is 3.
Input: root = [10, 5, 11, 4, 7, N, N, N, N, N, 8], X = 6

Output: 7
Explanation: We find 7 in BST, so ceil of 6 is 7.
Your task:
You don't need to read input or print anything. Just complete the function findCeil() to implement ceil in BST which returns the ceil of X in the given BST.

Constraints:
1 <= Number of nodes <= 105
1 <= Value of nodes<= 105

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Tree {
    int findCeil(Node root, int key) {
        // code here
        int ceil=-1;
        while(root!=null){
            if(root.data==key){
                ceil=root.data;
                return ceil;
            }
            if(root.data<key){
                root=root.right;
            }
            else{
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil;
    }
}
//====================================================================================================
/*
Floor in BST
Difficulty: MediumAccuracy: 51.06%Submissions: 117K+Points: 4Average Time: 20m
You are given a BST(Binary Search Tree) with n number of nodes and value x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
Note: when x is smaller than the smallest node of BST then returns -1.

Examples:

Input:
n = 7               2
                     \
                      81
                    /     \
                 42       87
                   \       \
                    66      90
                   /
                 45
x = 87
Output: 87
Explanation: 87 is present in tree so floor will be 87.
Input:
n = 4                     6
                           \
                            8
                          /   \
                        7       9
x = 11
Output: 9
Input:
n = 4                     6
                           \
                            8
                          /   \
                        7       9
x = 5
Output: -1
Constraint:
1 <= Noda data <= 109
1 <= n <= 105


*/



class Solution {
    public static int floor(Node root, int x) {
        // Code here
        int floor=-1;
        while(root!=null){
            if(root.data==x){
                floor=root.data;
                return floor;
            }
            if(root.data<x){
                floor=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }
}
//==========================================================================================================
