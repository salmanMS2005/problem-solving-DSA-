

/**
//102. Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int level=que.size();
            ArrayList<Integer> ans=new ArrayList<>(1);
            for(int i=0;i<level;i++){
                TreeNode current=que.poll();
                ans.add(current.val);
                if(current.left!=null){
                    que.offer(current.left);
                }
                if(current.right!=null){
                    que.offer(current.right);
                }
            }
            result.add(ans);
        }
        return result;
    }
}

//==========================================================================================================================

/**
637. Average of Levels in Binary Tree
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
Answers within 10-5 of the actual answer will be accepted.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();
            Double avg=0.0;
            for(int i=0;i<size;i++){
                TreeNode current=que.poll();
                avg+=current.val;
                if(current.left!=null){
                    que.offer(current.left);
                }
                if(current.right!=null){
                    que.offer(current.right);
                }
            }
            avg=avg/size;
            result.add(avg);
        }
        return result;
    }
}
//===========================================================================================================================
103. Binary Tree Zigzag Level Order Traversal
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        int level=1;
        while(!que.isEmpty()){
            int levelsize=que.size();
            LinkedList<Integer> zigzag=new LinkedList<>();
            for(int i=0;i<levelsize;i++){
                TreeNode current=que.poll();
                if(level%2==0){
                    zigzag.addFirst(current.val);
                }else{
                    zigzag.addLast(current.val);
                }
                if(current.left!=null){
                    que.offer(current.left);
                    }
                if(current.right!=null){
                    que.offer(current.right);
                }
            }
            level++;
            result.add(zigzag);
        }
        return result;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> result =new ArrayList<>();
        if(root==null) return result;
        boolean rightLeft=true;
        Deque<TreeNode> que=new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            ArrayList<Integer> ans=new ArrayList<>(size);
            for(int i=0;i<size;i++){
                if(!rightLeft){
                    TreeNode node=que.pollLast();
                    ans.add(node.val);
                    if(node.right!=null){
                        que.addFirst(node.right);
                    }if(node.left!=null){
                        que.addFirst(node.left);
                    }
                }else{
                    TreeNode node=que.pollFirst();
                    ans.add(node.val);
                    if(node.left!=null){
                        que.addLast(node.left);
                    }if(node.right!=null){
                        que.addLast(node.right);
                    }
                }
            }
            rightLeft=!rightLeft;
            result.add(ans);
        }
        return result;
    }
}
//================================================================================================================================
/**
107. Binary Tree Level Order Traversal II
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. 
(i.e., from left to right, level by level from leaf to root).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:
Input: root = [1]
Output: [[1]]
Example 3:
Input: root = []
Output: []
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> que =new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int lvlsize=que.size();
            ArrayList<Integer> lvlorder= new ArrayList<>();
            for(int i=0;i<lvlsize;i++){
                TreeNode node=que.poll();
                lvlorder.add(node.val);
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
            }
            result.add(0,lvlorder);
        }
        return result;
    }
}
//==========================================================================================================================================
