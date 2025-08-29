/*
678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
 

Constraints:

1 <= s.length <= 100
s[i] is '(', ')' or '*'.
*/
class Solution {
    public boolean checkValidString(String s) {
        int min=0;
        int max=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                min++;
                max++;
            }else if(s.charAt(i)==')'){
                min--;
                max--;
            }else{
                min--;
                max++; 
            }
            if(max<0) return false;
            if(min<0) min=0;
            
        }
        
        return min==0;
    }
}

/*
Inside the loop
add min and max if ( 
, subtracting min and max if ),
if * then we sub min and add max by 1

after the loop we check if min is <0 then make it to 0, and check if max is <0 then returning 
boolean as true or false 

taking the range [min,max] max should not be <0;
*/

//======================================================================================================================================================

/*
860. Lemonade Change

At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

 

Example 1:

Input: bills = [5,5,5,10,20]
Output: true
Explanation: 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
Example 2:

Input: bills = [5,5,10,10,20]
Output: false
Explanation: 
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give the change of $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.
 

Constraints:

1 <= bills.length <= 105
bills[i] is either 5, 10, or 20.
*/
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;

        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if(five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
//======================================================================================================================================================
/*
455. Assign Cookies

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

 

Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:

Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
 

Constraints:

1 <= g.length <= 3 * 104
0 <= s.length <= 3 * 104
1 <= g[i], s[j] <= 231 - 1
*/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i=0,j=0;

        while(i<g.length && j<s.length){
            if(s[j] >= g[i]){
                i++;
            }
                j++;  
        }
        return i;
    }
}
//======================================================================================================================================================
/*

Code
Test Result
Testcase
Testcase
55. Jump Game
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
*/
class Solution {
    public boolean canJump(int[] nums) {
        int cover=0;
        for(int i=0;i<nums.length;i++){
            if(i>cover) return false;
            cover=Math.max(cover,i+nums[i]);
        }
        return true;
    }
}
//======================================================================================================================================================
/*
45. Jump Game II
Solved
Medium
Topics
premium lock icon
Companies
You are given a 0-indexed array of integers nums of length n. You are initially positioned at index 0.

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at index i, you can jump to any index (i + j) where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach index n - 1. The test cases are generated such that you can reach index n - 1.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*/
class Solution {
    public int jump(int[] nums) {
     int last=nums.length-1,jump=0,coverage=0,lstjumpidx=0;
     if(nums.length==1)
     return 0;
        for (int i = 0;i<=nums.length-1;i++)
        {
            coverage=Math.max(coverage,i+nums[i]);
            if(i==lstjumpidx)
            {
                lstjumpidx=coverage;
                jump++;
            
        
                if(coverage>=last){
                    return jump;
                }

            }
        }
        return jump;
    }
}
//======================================================================================================================================================
/*
135. Candy

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
*/
class Solution {
    public int candy(int[] ratings) {
        int sum=1,i=1,peak=1,down=0;
        int n=ratings.length;
        while(i<n){
            if(i<n && ratings[i]==ratings[i-1]){
                sum+=1;
                peak=1;
                down=0;
                i++;
                continue;
            }
            peak=1;
            while(i<n && ratings[i]>ratings[i-1]){
                peak++;
                sum+=peak;
                i++;
            }
            down=0;
            while(i<n && ratings[i]<ratings[i-1]){
                down++;
                sum+=down;
                i++;
            }
            down++;
            if(down>peak){
                sum+=(down-peak);
            }
        }
        return sum;
    }
}
//=======================================================================================================================
/*
Fractional Knapsack
Difficulty: MediumAccuracy: 32.46%Submissions: 358K+Points: 4Average Time: 20m
Given two arrays, val[] and wt[] , representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.
Return the maximum value as a double, rounded to 6 decimal places.

Examples :

Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
Output: 240.000000
Explanation: By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240
Input: val[] = [500], wt[] = [30], capacity = 10
Output: 166.670000
Explanation: Since the item’s weight exceeds capacity, we take a fraction 10/30 of it, yielding value 166.670000.
Constraints:
1 ≤ val.size = wt.size ≤ 105
1 ≤ capacity ≤ 109
1 ≤ val[i], wt[i] ≤ 104


*/


class item{
    int val;
    int weight;
    public item(int val,int weight){
        this.val=val;
        this.weight=weight;
    }
}
class itemComparator implements Comparator<item>{
    @Override
    public int compare(item a,item b){
        double r1=(double)a.val/  (double)a.weight;
        double r2=(double)b.val/ (double)b.weight;
        if(r1<r2) return 1;
        else if(r1>r2) return -1;
        else return 0;
    }
}
class Solution {
    double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        item[] arr=new item[val.length];
        for(int i=0;i<val.length;i++){
            arr[i]=new item(val[i],wt[i]);
        }
        Arrays.sort(arr, new itemComparator());
        
        int curwt=0;
        double finalval=0.0;
        
        for(int i=0;i<val.length;i++){
            if(curwt+arr[i].weight<=capacity){
                finalval+=arr[i].val;
                curwt+=arr[i].weight;
            }else{
                int rem=capacity-curwt;
                finalval+=((double)arr[i].val/(double)arr[i].weight) * rem;
                break;
            }
        }
        return finalval;
    }
}
//========================================================================================================
/*
Minimum number of Coins
Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10 } and a target value n. Find the minimum number of coins and/or notes needed to make the change for Rs n. 

Examples:

Input: n = 39
Output: 6
Explaination: 39 can be formed using 3 coins of 10 rupees, 1 coin of 5 rupees and 2 coins of 2 rupees so minimum coins required are 6.
Input: n = 121
Output: 13
Explaination: 121 can be formed using 12 coins of 10 rupees and 1 coin of 1 rupees.
Constraints:
1 ≤ n ≤ 106
*/
class Solution {
    public int findMin(int n) {
        // code here
        int[] arr={1,2,5,10};
        int count=0;
        
        for(int i=arr.length-1;i>=0;i--){
            while(arr[i]<=n){
                n-=arr[i];
                count++;
            }
        }
        return count;
    }
}
//=================================================================================================================
/*
57. Insert Interval

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;

        ArrayList<int[]> res=new ArrayList<>();
        int i=0;
        while(i<n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        res.add(newInterval);
        while(i<n && intervals[i][1]>newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
//================================================================================================================
/*
56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.


Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> ans= new ArrayList<>();

        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if( intervals[i][0]<= end)
            {
                end=Math.max(end,intervals[i][1]);
            }
            else
            {
                ans.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
//=====================================================================================================================
/*
56. Merge Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]> ans= new ArrayList<>();

        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if( intervals[i][0]<= end)
            {
                end=Math.max(end,intervals[i][1]);
            }
            else
            {
                ans.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[ans.size()][]);
    }
}
//==============================================================================================================
/*
435. Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.


Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 

Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
-5 * 104 <= starti < endi <= 5 * 104
*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int ans=0;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1]-b[1];
            }
        });
        int lastend=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<lastend){
                ans++;
            }else{
                lastend=intervals[i][1];
            }
        }
        return ans;
    }
}
//===============================================================================================================================
