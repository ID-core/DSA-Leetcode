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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;

        // splitting the list to halves
        ListNode slow= head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        // slow is the missle point here

        // reversing second half
        ListNode second= slow.next;
        slow.next=null;

        ListNode prev=null;
        while(second!=null)
        {
            ListNode nextNode=second.next;
            second.next=prev;
            prev=second;
            second=nextNode;
        }

        // merging both list alternatively
        ListNode first= head;
        second= prev;
        while(second!=null)
        {
            ListNode temp1=first.next;
            ListNode temp2=second.next;
            first.next=second;
            second.next=temp1;

            first=temp1;
            second=temp2;
        }
    }
}