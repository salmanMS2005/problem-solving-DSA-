/*
225. Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
*/
class MyStack {
    private Queue<Integer> first;

    public MyStack() {
        first=new LinkedList<>();
    }
    
    public void push(int x) {
        first.add(x);
        for(int i=0;i<first.size()-1;i++){
            first.add(first.poll());
        }
    }
    
    public int pop() {
        return first.poll();
    }
    
    public int top() {
        return first.peek();
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/*
232. Implement Queue using Stacks


Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
  */

class MyQueue {
    private Stack<Integer> stack1;   
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1=new Stack<>();   
        stack2=new Stack<>();   

    }
    
    public void push(int x){
        stack1.push(x);
    }
    
    public int pop() {
        peek();
        return stack2.pop();
    }
    
    public int peek() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


/*
20. Valid Parentheses

Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false
*/

class Solution {
    public boolean isValid(String s) {
     Stack<Character> stack = new Stack<>();
     for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
            stack.push(s.charAt(i));
        }
        if(s.charAt(i)==')'){
            if(stack.isEmpty() || stack.pop()!='('){
                return false;
            }
        }
        if(s.charAt(i)=='}'){
            if(stack.isEmpty() || stack.pop()!='{'){
                return false;
            }
        }
        if(s.charAt(i)==']'){
            if(stack.isEmpty() || stack.pop()!='['){
                return false;
            }
        }
     }
    return stack.isEmpty();
    }
}


/*
155. Min Stack

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
*/

class MinStack {
    private Stack<Long> stack;
    Long min;
    public MinStack() {
        stack=new Stack<>();
    }
    
    public void push(int value) {
        Long val=Long.valueOf(value);
       if(stack.isEmpty()){
        min=val;
        stack.push(val);
       }
       else{
        if(val<min){
            stack.push(2*val-min);
            min=val;
        }
        else{
            stack.push(val);
        }
       }
    }
    
    public void pop() {
        Long x=stack.peek();
        if(x<min){
            min=(2*min)-x;
            stack.pop();
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        Long x=stack.peek();
        if(x<min){
            return min.intValue();
        }
        else{
            return x.intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();  
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
