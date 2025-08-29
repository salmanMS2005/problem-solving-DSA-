/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
class Solution {
    int lengthOfLongestSubstring(String s) {
        map<char,int> count;
        int start = 0;
        int end = 0;
        int ans = 0;
        while (end < s.size()) {
            count[s[end]]++;
            while (count[s[end]] > 1) {
                count[s[start]]--;
                start++;
            }
            ans = max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}
//=============================================================================================
/*
1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
*/
//sliding window 2 pointer O(2n)
/*class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,zeros=0,maxlen=0,len=0;
        while(r<nums.length) {
            if(nums[r]==0) zeros++;
            while(zeros>k){
                if(nums[l]==0) zeros--;
                l++;
            }
            len=r-l+1;
            maxlen=Math.max(len,maxlen);
            r++;
        }
        return maxlen;
    }
}*/
//O(n)
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,r=0,zeros=0,maxlen=0,len=0;
        while(r<nums.length) {
            if(nums[r]==0) zeros++;
            if(zeros>k){
                if(nums[l]==0) zeros--;
                l++;
            }
            if(zeros<=k){
                    len=r-l+1;
                    maxlen=Math.max(len,maxlen);
                }
            r++;
        }
        return maxlen;
    }
}
//=============================================================================================
/*
904. Fruit Into Baskets

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.

 

Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
 

Constraints:

1 <= fruits.length <= 105
0 <= fruits[i] < fruits.length
*/
class Solution {
    public int totalFruit(int[] fruits) {
        int l=0,r=0,maxlen=0;
        Map<Integer,Integer> map=new HashMap<>();

        while(r<fruits.length){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            if(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            if(map.size()<=2){
                maxlen=Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
//=================================================================================================================
/*
1248. Count Number of Nice Subarrays
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

 

Example 1:

Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.
Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16
 

Constraints:

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)- helper(nums,k-1);
    }
    static int helper(int[] arr,int k){
        if(k<0) return 0;

        int l=0,r=0;
        int count=0;
        int sum=0;
        while(r<arr.length){

            sum+=(arr[r]%2);

            while(sum>k){
                sum-=(arr[l]%2);
                l++;
            }
            count+=(r-l)+1;
            r++;
        }
        return count;
    }
}
//===========================================================================================================
/*
1358. Number of Substrings Containing All Three Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 
*/
class Solution {
    public int numberOfSubstrings(String s) {
      int[] arr={-1,-1,-1};
      int cnt=0;
      for(int r=0;r<s.length();r++)  
      {
        arr[s.charAt(r)-'a']=r;
        if(arr[0]!=-1 && arr[1]!=-1 && arr[2]!=-1 )
        {
            cnt+=(1+Math.min(arr[0],Math.min(arr[1],arr[2])));
        }
      }
      return cnt;
    }
}
//================================================================================================
/*
930. Binary Subarrays With Sum
Solved
Medium
Topics
premium lock icon
Companies
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 

Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15
 

Constraints:

1 <= nums.length <= 3 * 104
nums[i] is either 0 or 1.
0 <= goal <= nums.length
*/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal) - helper(nums,goal-1);
    }
    public int helper(int[] nums, int goal) {
        if(goal<0) return 0;
        int l=0,r=0,sum=0;
        int count=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            
            count+=(r-l+1);
            
            r++;
        }
        return count;
    }
}
//====================================================================================
/*
1423. Maximum Points You Can Obtain from Cards
Solved
Medium
Topics
premium lock icon
Companies
Hint
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 

Constraints:

1 <= cardPoints.length <= 105
1 <= cardPoints[i] <= 104
1 <= k <= cardPoints.length
*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=0,r=0;
        int lsum=0;
        int totsum=0;
        int rsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            lsum+=cardPoints[i];
        }
        maxsum=lsum;
        int n=cardPoints.length-1;
        
        for(int j=k-1;j>=0;j--){
            lsum-=cardPoints[j];
            rsum+=cardPoints[n];
            totsum=lsum+rsum;
            n--;
            maxsum=Math.max(maxsum,totsum);
            
        }
        return maxsum;
    }
}
//=====================================================================================================
/*
 Longest Substring with At Most K Distinct Characters

Problem statement
You are given a string 'str' and an integer ‘K’. Your task is to find the length of the largest substring with at most ‘K’ distinct characters.

For example:
You are given ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= K <= 26
1 <= |str| <= 10^6

The string str will contain only lowercase alphabets.    

Time Limit: 1 sec
Note:
You do not need to print anything. It has already been taken care of. Just implement the function.
Sample Input 1:
2
2
abbbbbbc
3
abcddefg
Sample Output 1:
7
4
Explanation:
For the first test case, ‘str’ = ‘abbbbbbc’ and ‘K’ = 2, then the substrings that can be formed are [‘abbbbbb’, ‘bbbbbbc’]. Hence the answer is 7.

For the second test case, ‘str’ = ‘abcddefg’ and ‘K’ = 3, then the substrings that can be formed is [‘cdde’, ‘ddef’]. Hence the answer is 4.
Sample Input 2:
2
3
aaaaaaaa
1
abcefg
Sample Output 2:
8   
1   


Hints:
1. Try to think of a brute force approach.
2. Try to think of a two-pointer solution.
*/
import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String str) {
		// Write your code here
		int l=0,r=0,maxlen=Integer.MIN_VALUE;
		HashMap<Character,Integer> map=new HashMap<>();
		while(r<str.length()){
            map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);

			while(map.size()>k){
				int key=map.get(str.charAt(l));
				map.put(str.charAt(l),key-1);

				if(map.get(str.charAt(l))==0){
					map.remove(str.charAt(l));
				}

				l++;
			}
			maxlen=Math.max(r-l+1,maxlen);
			r++;
		}
		return maxlen;
	}

}
//=========================================================================================
/*
992. Subarrays with K Different Integers
Solved
Hard
Topics
premium lock icon
Companies
Hint
Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
A subarray is a contiguous part of an array.

 

Example 1:

Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
Example 2:

Input: nums = [1,2,1,3,4], k = 3
Output: 3
Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

Constraints:

1 <= nums.length <= 2 * 104
1 <= nums[i], k <= nums.length
*/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
    private int helper(int[] nums,int k){
        int l=0,r=0,cnt=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                int key=map.get(nums[l]);
                map.put(nums[l],key-1);
                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}
//===============================================================================================================
