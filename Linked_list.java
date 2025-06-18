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
