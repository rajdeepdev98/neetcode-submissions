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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);

        ListNode n1 = l1;
        ListNode n2 = l2;

        int carry = 0;

        ListNode temp = res;

        while(n1!=null && n2!=null){

            int sum = n1.val+n2.val + carry;

            temp.next = new ListNode(sum%10);
            temp = temp.next;

            carry = sum/10;

            n1 = n1.next;
            n2 = n2.next;


        }

        while(n1!=null){

            int sum = n1.val + carry;
            temp.next = new ListNode(sum%10);
            temp = temp.next;

            carry = sum/10;

            n1 = n1.next;

        }

        while (n2!=null){

            int sum = n2.val + carry;
            temp.next = new ListNode(sum%10);
            temp = temp.next;

            carry = sum/10;

            n2 = n2.next;
        }
        if(carry!=0)temp.next = new ListNode(carry);

        return res.next;
        
    }
}
