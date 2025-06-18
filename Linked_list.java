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
class Solution {
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

class Solution {
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
