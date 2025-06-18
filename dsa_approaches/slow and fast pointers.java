/*
LEETCODE  : 202. Happy Number

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.*/

class Solution {
    public boolean isHappy(int n) {
        int s=n;
        int f=n;
        do{
           s=findsquare(s);
           f=findsquare(findsquare(f));
        }while(s!=f);
        if(s==1) return true;
        return false;
    }
    public int findsquare(int number){
        int val=0;
        while(number>0){
            int rem=number%10;
            val+=rem*rem;
            number/=10;
        }
        return val;
    }
}
