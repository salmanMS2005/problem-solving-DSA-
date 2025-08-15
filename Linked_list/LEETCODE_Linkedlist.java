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
/**
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
        ListNode dummy =new ListNode(-1);
        ListNode cur=dummy;
        
        int carry=0;
        
        while(l1!=null || l2!=null || carry==1){
            int tot=0;
            if(l1!=null){
                tot+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                tot+=l2.val;
                l2=l2.next;
            }
            tot+=carry;
            carry=(tot/10);
            ListNode node=new ListNode(tot%10);
            cur.next=node;
            cur=cur.next;
        }
        return dummy.next;
    }
}
//========================================================================================
/**
160. Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1:


The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.

Custom Judge:

The inputs to the judge are given as follows (your program is not given these inputs):

intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
listA - The first linked list.
listB - The second linked list.
skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.

 

Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
Output: Intersected at '8'
Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.

Constraints:

The number of nodes of listA is in the m.
The number of nodes of listB is in the n.
1 <= m, n <= 3 * 104
1 <= Node.val <= 105
0 <= skipA <= m
0 <= skipB <= n
intersectVal is 0 if listA and listB do not intersect.
intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1=headA;
        ListNode cur2=headB;
        int cnt1=0;
        int cnt2=0;
        while(cur1 != null){
            cnt1++;
            cur1=cur1.next;
        }
        while(cur2 != null){
            cnt2++;
            cur2=cur2.next;
        }
        cur1 = headA;
        cur2 = headB;
        
        int diff=Math.abs(cnt1-cnt2);
        if(cnt1>cnt2){
            cur1=mover(cur1,diff);
        }else{
           cur2= mover(cur2,diff);
        }
        while(cur1 != null && cur2!=null){
            if(cur1==cur2){
                return cur1;
            }
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return null;
    }
    private ListNode mover(ListNode node,int diff){
        while(diff>0){
            if(node==null){
                return null;
            }else{
                node=node.next;
            }
            diff--;
        }

        return node;
    }
}
//========================================================================================
/*
Add 1 to a Linked List Number
Difficulty: MediumAccuracy: 31.91%Submissions: 328K+Points: 4Average Time: 20m
You are given a linked list where each element in the list is a node and have an integer data. You need to add 1 to the number formed by concatinating all the list node numbers together and return the head of the modified linked list. 

Note: The head represents the first element of the given array.

Examples :

Input: LinkedList: 4->5->6
Output: 457

Explanation: 4->5->6 represents 456 and when 1 is added it becomes 457. 
Input: LinkedList: 1->2->3
Output: 124
 
Explanation:  1->2->3 represents 123 and when 1 is added it becomes 124. 
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= len(list) <= 105
0 <= list[i] <= 9


class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        // code here.
        if(head==null) return head;
        
        head=reverse(head);
        Node cur=head;
        
        int carry=1;
        while(cur!=null){
            cur.data=cur.data+carry;
            if(cur.data>9){
                cur.data=0;
                carry=1;
            }else{
                carry=0;
            }
            cur=cur.next;
        }
        
        head=reverse(head);
        if(carry==1){
            Node st=new Node(1);
            st.next=head;
            return st;
        }
        return head;
        
    }
    private Node reverse(Node node){
        Node prev=null;
        Node pres=node;
        Node next=node.next;
        
        while(next!=null){
            pres.next=prev;
            prev=pres;
            pres=next;
            next=next.next;
        }
        pres.next=prev;
        return pres;
    }
}
//========================================================================================

/* Structure of Doubly Linked List
Delete all occurrences of a given key in a doubly linked list
Difficulty: MediumAccuracy: 50.04%Submissions: 57K+Points: 4Average Time: 30m
You are given the head_ref of a doubly Linked List and a Key. Your task is to delete all occurrences of the given key if it is present and return the new DLL.

Example1:

Input: 
2<->2<->10<->8<->4<->2<->5<->2
2
Output: 
10<->8<->4<->5
Explanation: 
All Occurences of 2 have been deleted.

Example2:

Input: 
9<->1<->3<->4<->5<->1<->8<->4
9
Output: 
1<->3<->4<->5<->1<->8<->4
Explanation: 
All Occurences of 9 have been deleted.
Your Task:

Complete the function void deleteAllOccurOfX(struct Node** head_ref, int key), which takes the reference of the head pointer and an integer value key. Delete all occurrences of the key from the given DLL.

Expected Time Complexity: O(N).

Expected Auxiliary Space: O(1).

Constraints:

1<=Number of Nodes<=105

0<=Node Value <=109

class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/
class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        // Write your code here
        Node dummy= new Node();
        dummy.data=-1;
        dummy.next=head;
        head.prev=dummy;
        
        Node cur=dummy;
        Node mainNode=head;
        Node nextNode=mainNode.next;
        
        while(mainNode!=null){
            if (mainNode.data == x) {
                cur.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = cur;
                    nextNode = nextNode.next;
                } else {
                    nextNode = null;
                }
                mainNode = cur.next;
            } else {
                cur = cur.next;
                mainNode = mainNode.next;
                if (nextNode != null) {
                    nextNode = nextNode.next;
                }
            }
        }
        return dummy.next;
    }
}
//========================================================================================
/*
Find pairs with given sum in doubly linked list
Difficulty: EasyAccuracy: 66.01%Submissions: 91K+Points: 2Average Time: 10m
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 
Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        Node first=head;
        Node last= lastnode(first);
        
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        
        while(first!= null && last!=null && first.prev!=last && first != last){
            if(first.data + last.data == target){
                list.add(new ArrayList<>(Arrays.asList(first.data,last.data)));
                first = first.next;
                last = last.prev;
            }
            else if(first.data + last.data > target){
                last=last.prev;
            }
            else if(first.data + last.data < target){
                first=first.next;
            }
        }
        return list;
    }
    private static Node lastnode(Node node){
        while(node.next!=null){
            node=node.next;
        }
        return node;
    }
}
//=============================================================================================================
/*
Remove duplicates from a sorted doubly linked list
Difficulty: EasyAccuracy: 50.36%Submissions: 68K+Points: 2Average Time: 10m
Given a doubly linked list of n nodes sorted by values, the task is to remove duplicate nodes present in the linked list.

Example 1:

Input:
n = 6
1<->1<->1<->2<->3<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of node with value 1 is 
retained, rest nodes with value = 1 are deleted.
Example 2:

Input:
n = 7
1<->2<->2<->3<->3<->4<->4
Output:
1<->2<->3<->4
Explanation:
Only the first occurance of nodes with values 2,3 and 4 are 
retained, rest repeating nodes are deleted.
Your Task:
You have to complete the method removeDuplicates() which takes 1 argument: the head of the linked list.  Your function should return a pointer to a linked list with no duplicate element.

Constraint:
1 <= n <= 105
Expected Time Complexity: O(n)
Expected Space Complexity: O(1)
*/
// User function Template for Java

class Solution {
    Node removeDuplicates(Node head) {
        // Code Here.
        Node cur=head;
        
        
        while(cur!=null && cur.next!=null){
            Node nextNode=cur.next;
            while(nextNode!=null && cur.data == nextNode.data){
                
                nextNode=nextNode.next;
                
            }
            cur.next=nextNode;
            
            if(nextNode !=null) nextNode.prev=cur;
            
            cur=cur.next;
        }
        return head;
    }
}
//========================================================================================================
/*
Flattening a Linked List
Difficulty: MediumAccuracy: 51.53%Submissions: 192K+Points: 4Average Time: 40m
Given a linked list containing n head nodes where every node in the linked list contains two pointers:
(i) next points to the next node in the list.
(ii) bottom pointer to a sub-linked list where the current node is the head.
Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on their data.
Your task is to flatten the linked list such that all the nodes appear in a single level while maintaining the sorted order.

Note:
1. ↓ represents the bottom pointer and -> represents the next pointer.
2. The flattened list will be printed using the bottom pointer instead of the next pointer.

Examples:

Input:

Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
Explanation: 
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
Input:
 
Output: 5-> 7-> 8-> 10-> 19-> 22-> 28-> 30-> 50
Explanation:
Bottom pointer of 5 is pointing to 7.
Bottom pointer of 7 is pointing to 8.
Bottom pointer of 8 is pointing to 10 and so on.
Constraints:
0 <= n <= 100
1 <= number of nodes in sub-linked list(mi) <= 50
1 <= node->data <= 104
*/
class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        // code here
        if(root==null || root.next==null) return root;
        
        Node mergeHead=flatten(root.next);
        root=merge(root,mergeHead);
        return root;
    }
    static Node merge(Node t1,Node t2){
        Node dummy=new Node(-1);
        Node cur=dummy;
        
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                cur.bottom=t1;
                cur=t1;
                t1=t1.bottom;
            }else{
                cur.bottom=t2;
                cur=t2;
                t2=t2.bottom;
            }
            cur.next=null;
        }
        if(t1!=null){
            cur.bottom=t1;
        }else{
            cur.bottom=t2;
        }
        
        if(dummy.bottom!=null) dummy.bottom.next=null;
        
        return dummy.bottom;
    }
}
//===============================================================================================================
