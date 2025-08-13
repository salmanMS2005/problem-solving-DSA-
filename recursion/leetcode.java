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
