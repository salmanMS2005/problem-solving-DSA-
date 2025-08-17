/*
50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104
*/

class Solution {
    public double myPow(double x, int n) {
        return helper(x, (long) n);
    }
    private double helper(double x, long n) {
        if(n==0) return 1;
        if(n<0) return 1.0/helper(x,-n);

        if(n%2==1)  return x* helper(x*x,(n-1)/2);
        else return helper(x*x,n/2);
    }
}
//===================================================================================================================
/*
Sort a stack
Difficulty: MediumAccuracy: 69.19%Submissions: 155K+Points: 4Average Time: 20m
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:

Input:
Stack: 3 2 1
Output: 3 2 1
Example 2:

Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
Your Task: 
You don't have to read input or print anything. Your task is to complete the function sort() which sorts the elements present in the given stack. (The sorted stack is printed by the driver's code by popping the elements of the stack.)

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
1<=N<=100
*/
/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if(s.size()<=1) return s;
        
        if(s.isEmpty()) return s;
        
        int num=s.pop();
        
        sort(s);
        
        helper(s,num);
        
        return s;
    }
    
    static void helper(Stack<Integer> s,int num){
        if(s.isEmpty()){
            s.push(num);
            return;
        }
        int top=s.peek();
        
        if(top>num){
            int n=s.pop();
            helper(s,num);
            s.push(n);
        }
        if(top<=num){
            s.push(num);
            return;
        }
    }
}
//======================================================================================================================
/*
Reverse a Stack
Difficulty: MediumAccuracy: 80.5%Submissions: 114K+Points: 4Average Time: 20m
You are given a stack St. You have to reverse the stack using recursion.

Example 1:

Input: St = [3,2,1,7,6]
Output: [6,7,1,2,3]
Explanation: Input stack after reversing will look like the stack in the output.
Example 2:

Input: St = [4,3,9,6]
Output: [6,9,3,4]
Explanation: Input stack after reversing will look like the stack in the output.
Constraints:
1 ≤ stack.size ≤ 104
0 ≤ stack.element ≤ 103
*/

class Solution {
    static void reverse(Stack<Integer> St) {
        // code here
        if(St.isEmpty()) return;
        
        int num=St.pop();
        
        reverse(St);
        placeFirst(St,num);
    }
    static void placeFirst(Stack<Integer> st, int num){
        if(st.isEmpty()){
            st.push(num);
            return;
        }
        int n=st.pop();
        placeFirst(st,num);
        st.push(n);
    }
}
//=================================================================================================
/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

*/
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>  res=new ArrayList<>();
        String p="";
        helper(0,0,p,res,n);
        return res;
    }
    static void helper(int open,int close,String p,ArrayList<String> ans,int n){
        if(open==n && close == n) {
            ans.add(p);
            return;
        }
        if(open<n){
            p+='(';
            helper(open+1,close,p,ans,n);
            p=p.substring(0,p.length()-1);
        }
        if(close<open){
            p+=')';
            helper(open,close+1,p,ans,n);
            p=p.substring(0,p.length()-1);
        }
    }
}
//==================================================================================================================
/*
Generate all binary strings
Difficulty: MediumAccuracy: 63.9%Submissions: 30K+Points: 4Average Time: 20m
Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

A binary string is that string which contains only 0 and 1.

Example 1:

Input:
N = 3
Output:
000 , 001 , 010 , 100 , 101
Explanation:
None of the above strings contain consecutive 1s. "110" is not an answer as it has '1's occuring consecutively. 
Your Task:

You don't need to read input or print anything. Your task is to complete the function generateBinaryStrings() which takes an integer N as input and returns a list of all valid binary strings in lexicographically increasing order.

Expected Time Complexity: O(2N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 20
*/
// User function Template for Java

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> ans=new ArrayList<>();
        helper("",n,ans);
        return ans;
    }
    static void helper(String p,int n,List<String> ans){
        if(p.length()==n){
            ans.add(p);
            return;
        }
        
        helper(p+"0",n,ans);
        
        if(p.length()==0 || p.charAt(p.length()-1)=='0'){
            helper(p+"1",n,ans);
        }
    }
}
//===============================================================================================
/*
78. Subsets
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> subset= new ArrayList<>();
        helper(ans,nums,subset,0);
        return ans;
    }
    static void helper(List<List<Integer>> ans,int[] nums,List<Integer> subset,int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        helper(ans,nums,subset,index+1);

        subset.remove(subset.size()-1);
        helper(ans,nums,subset,index+1);
    }
}
//=======================================================================================================
/*
40. Combination Sum II
Solved
Medium
Topics
premium lock icon
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(0,candidates,ans,target,new ArrayList<>());
        return ans;
    }
    static void helper(int ind,int[] arr,List<List<Integer>> ans,int target,ArrayList<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            helper(i+1,arr,ans,target-arr[i],ds);
            ds.remove(ds.size()-1);
        }
    }
}
//==========================================================================================
/*
39. Combination Sum
Solved
Medium
Topics
premium lock icon
Companies
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        helper(0,candidates,target,ans,new ArrayList<>());
        return ans;
        
    }
    static void helper(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            helper(ind,arr,target-arr[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        helper(ind+1,arr,target,ans,ds);
    }
}
//==============================================================================================================
/*
Subset Sums
Difficulty: MediumAccuracy: 72.55%Submissions: 171K+Points: 4
Given a array arr of integers, return the sums of all subsets in the list.  Return the sums in any order.

Examples:

Input: arr[] = [2, 3]
Output: [0, 2, 3, 5]
Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
Input: arr[] = [1, 2, 1]
Output: [0, 1, 1, 2, 2, 3, 3, 4]
Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the element 2), and their combinations.
Input: arr[] = [5, 6, 7]
Output: [0, 5, 6, 7, 11, 12, 13, 18]
Explanation: The possible subset sums are 0 (no elements), 5, 6, 7, and their combinations.
Constraints:
1 ≤ arr.size() ≤ 15
0 ≤ arr[i] ≤ 104
*/
// User function Template for Java//User function Template for Java
class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        helper(0,arr,ans,0);
        return ans;
    }
    static void helper(int ind,int[] arr,ArrayList<Integer> ans,int count){
         if(ind==arr.length){
             ans.add(count);
             return;
         }
         count+=arr[ind];
         helper(ind+1,arr,ans,count);
         count-=arr[ind];
         helper(ind+1,arr,ans,count);
    }
}
//=======================================================================================================
/*
90. Subsets II

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,ans,new ArrayList<>());
        return ans;
    }
    static void helper(int ind,int[] nums,List<List<Integer>> ans,List<Integer> ds){

        ans.add(new ArrayList<>(ds));

        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            helper(i+1,nums,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}
//================================================================================================
/*
216. Combination Sum III

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
*/
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(n< k*(k+1)/2) return new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(1,k,n,ans,new ArrayList<>());
        return ans;
    }
    static void helper(int nums,int k,int n,List<List<Integer>> ans,List<Integer> ds){
        if(n==0 && k==0){
            ans.add(new ArrayList(ds));
            return;
        }
        for(int i=nums;i<=9;i++){
            if(i>n || k<=0) break;
                
            ds.add(i);
            helper(i+1,k-1,n-i,ans,ds);
            ds.remove(ds.size()-1);
        }
    }
}
//================================================================================================================
/*
131. Palindrome Partitioning
Solved
Medium
Topics
premium lock icon
Companies
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/
class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> ans=new ArrayList<>() ;
       helper(0,s,ans,new ArrayList<>());
       return ans;
    }
    static void helper(int ind,String s,List<List<String>> ans,ArrayList<String> ds){
        if(ind==s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                ds.add(s.substring(ind,i+1));
                helper(i+1,s,ans,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
//================================================================================
