/*LEETCODE :83. Remove Duplicates from Sorted List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.*/

// SOLUTION:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode temp=head;
      while(temp!=null && temp.next!=null){
        if(temp.val==temp.next.val){
            temp.next=temp.next.next;
        }
        else{
            temp=temp.next;
        }
      }
      return head;
    }
}


/* LEETCODE : 21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list. */

//SOLUTION :

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummyhead = new ListNode();
        ListNode current=dummyhead;
        
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                current.next=list1;
                list1=list1.next;
                current=current.next;
            }else{
                current.next=list2;
                list2=list2.next;
                current=current.next;
            }
        }
        if(list1!=null) current.next=list1;
        if(list2!=null) current.next=list2;
        return dummyhead.next;
    }
}


/*
141. Linked List Cycle

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
*/

//SOLUTION:

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}


/*
LEETCODE 142. Linked List Cycle II

Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.
*/


//SOLUTION:

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode f = head;
        ListNode s=head;
        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
            if(f==s){
                s=head;
                while(s!=f){
                    f=f.next;
                    s=s.next;
                }
                return s;
            }
        }
        return null;     
    }
}



/*
LEETCODE : 876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
*/
//SOLUTION:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;

        while(f!=null && f.next!=null){
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
}


/*
LEETCODE : 148. Sort List

Given the head of a linked list, return the list after sorting it in ascending order.
*/
//SOLUTION:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)    {
            return head;
        }
        ListNode mid=middle(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);

        return merge(left,right);
    }
     public ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummyhead = new ListNode();
        ListNode current=dummyhead;
        
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                current.next=list1;
                list1=list1.next;
                current=current.next;
            }else{
                current.next=list2;
                list2=list2.next;
                current=current.next;
            }
        }
        if(list1!=null) current.next=list1;
        if(list2!=null) current.next=list2;
        return dummyhead.next;
    }

    //spliting the linked list into two equal halfs:
    public ListNode middle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    ListNode prev = null;

    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    if (prev != null) {
        prev.next = null;
    }
    return slow;
}

}


/*
LEETCODE : 206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution206 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode prev=null;
        ListNode pres=head;
        ListNode next = pres.next;
        
        while(pres!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            if(next!=null){
            next=next.next;}
        }
        return prev;
    }
}


/*


92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode prev=null;
        ListNode current=head;

        
        for(int i=0;current!=null && i<left-1;i++){
            prev=current;
            current=current.next;
        }
        ListNode last = prev;
        ListNode newEnd=current;

        ListNode next=current.next;
        for(int i=0;current !=null && i<right-left+1;i++){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null){
                next=next.next;
            }
        }

        if(last!=null){
            last.next=prev;
        }else{
            head=prev;
        }

        newEnd.next=current;
        return head;
        }
    }



/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
Example 1:
Input: head = [1,2,2,1]
Output: true
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution234 {
    public ListNode ReverseList(ListNode head){
        if(head==null) return head;
        ListNode prev=null;
        ListNode pres=head;
        ListNode next=pres.next;

        while(pres!=null){
        pres.next=prev;
        prev=pres;
        pres=next;
        if(next!=null){
            next=next.next;
        }
        }
        return prev;
    }
    public ListNode middleNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid=middleNode(head);
        ListNode Secondhead=ReverseList(mid);
        ListNode Reversehead=Secondhead;

        while(head!=null && Reversehead!=null){
            if(head.val != Reversehead.val){
                break;
            }
            head=head.next;
            Reversehead=Reversehead.next;
        }
        ReverseList(Reversehead);

        return head==null || Reversehead==null;
    }
}

/*

143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]


SOLUTION:
*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution143 {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        ListNode headFirst=head;
        ListNode mid=middleNode(head);
        ListNode headSecond=ReverseList(mid);
        
        while(headFirst !=null && headSecond!=null ){
            
            ListNode temp=headFirst.next;
            headFirst.next=headSecond;
            headFirst=temp;
            
            temp=headSecond.next;
            headSecond.next=headFirst;
            headSecond=temp;
        }
        if(headFirst!=null){
            headFirst.next=null;
        }
    }


    public ListNode middleNode(ListNode head){
            ListNode fast=head;
            ListNode slow=head;

            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
    }

    public ListNode ReverseList(ListNode head){
        if(head==null) return head;
        ListNode prev=null;
        ListNode pres=head;
        ListNode next=pres.next;

        while(pres!=null){
        pres.next=prev;
        prev=pres;
        pres=next;
        if(next!=null){
            next=next.next;
        }
        }
        return prev;
    }
        
}

/*
25. Reverse Nodes in k-Group
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head==null){
            return head;
        }
        int length=getLength(head);
        int count=length/k;

        ListNode prev=null;
        ListNode curr=head;

        while(count>0){
            ListNode newEnd=curr;
            ListNode last=prev;

            ListNode next=curr.next;
            for(int i=0; curr!=null && i<k;i++){
                curr.next=prev;
                prev=curr;
                curr=next;
                if(next!=null){
                    next=next.next;
                }
            }
            if(last!=null){
                last.next=prev;
            }else{
                head=prev;
            }
            newEnd.next=curr;
            prev=newEnd;

            if(curr==null){
                break;
            }
            count--;
        }
        return head;
    }
    
    public int getLength(ListNode head) {
		ListNode node = head;
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}

}


/*
61. Rotate List
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null|| head.next==null || k<=0){ 
            return head;
        }
        ListNode last=head;
        int length=1;

        while(last.next!=null){
            last=last.next;
            length++;
        }
        last.next=head;

        int rotation=k%length;
        
        ListNode newLast=head;
        for(int i=0;i<length-rotation-1;i++){
            newLast=newLast.next;
        }
        head=newLast.next;
        newLast.next=null;

        return head;
    }
}

//=======================================================================================================================
/* 
Sort a linked list of 0s, 1s and 2s
Difficulty: MediumAccuracy: 60.75%Submissions: 260K+Points: 4Average Time: 30m
Given the head of a linked list where nodes can contain values 0s, 1s, and 2s only. Your task is to rearrange the list so that all 0s appear at the beginning, followed by all 1s, and all 2s are placed at the end.

Examples:

Input: head = 1 → 2 → 2 → 1 → 2 → 0 → 2 → 2

Output: 0 → 1 → 1 → 2 → 2 → 2 → 2 → 2

Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of the list, and 1s in between.
Input: head = 2 → 2 → 0 → 1

Output: 0 → 1 → 2 → 2

Explanation: After arranging all the 0s, 1s and 2s in the given format, the output will be 0 → 1 → 2 → 2.
Constraints:
1 ≤ no. of nodes ≤ 106
0 ≤ node->data ≤ 2

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // code here
        if(head==null || head.next==null) return head;
        
        Node zeroHead=null;
        Node oneHead=null;
        Node twoHead=null;
        
        Node zerop=null;
        Node onep=null;
        Node twop=null;
        
        Node cur=head;
        
        while(cur!=null){
            if(zeroHead==null && cur.data==0){
                zeroHead=cur;
                zerop=zeroHead;
            }
            
            else if(oneHead==null && cur.data==1){
                oneHead=cur;
                onep=oneHead;
            }
            
            else if(twoHead==null && cur.data==2){
                twoHead=cur;
                twop=twoHead;
            }
            
            
            else if(cur.data==0){
                zerop.next=cur;
                zerop=cur;
            }
            
            else if(cur.data==1){
                onep.next=cur;
                onep=cur;
            }
            
            else if(cur.data==2){
                twop.next=cur;
                twop=cur;
            }
            
            cur=cur.next;
        }
        if(zeroHead!=null ){
            if(oneHead!=null){
                zerop.next=oneHead;
            }else{
                zerop.next=twoHead;
            }
        }
        if(oneHead!= null){
            onep.next=twoHead;
        }
        if(twoHead!=null){
            twop.next=null;
        }

        if(zeroHead!=null) return zeroHead;
        if(oneHead!=null) return oneHead;
        return twoHead;
    }
}
//=======================================================================================================================
/**
328. Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.
Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106


 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
       if(head==null) return null;
       if(head.next==null) return head;

       ListNode evenHead=head.next;
       ListNode oddTail=head;
       
       ListNode odd=head;
       ListNode even=head.next;

       while(odd.next!=null && even.next!=null){
           odd.next=odd.next.next;
           even.next=even.next.next;
           
           odd=odd.next;
           oddTail=odd;
           even=even.next;
       }
       oddTail.next=evenHead;
       return head;
    }
}
//=======================================================================================================================
