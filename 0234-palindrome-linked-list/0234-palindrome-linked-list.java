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
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list= new ArrayList<>();
        while(head!=null)
        {
            list.add(head.val);
            head=head.next;
        }

        int right=list.size()-1;
        for(int left=0 ; left<right; left++)
        {
            if(!list.get(left).equals(list.get(right)))
            {
                return false;
            }
            right--;
        }
        return true;
    }
}