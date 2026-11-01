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
    public boolean hasCycle(ListNode head) {
        if(head == null)return false;
        


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy.next;
        while(slow!= null && fast!=null && fast.next!=null && slow!=fast ){

            slow = slow.next;
            fast = fast.next.next;

        }
        return slow == fast && slow!=null;
    }
}
