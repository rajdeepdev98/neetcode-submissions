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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        int cnt = 0;
        while(curr!=null){
            cnt++;
            curr = curr.next;
        }

        System.out.println(cnt);

        int no = cnt - n+1;
        curr = head;

        if(no == 1){
            return head.next;
        }

        for(int i = 2;i<=no;i++){

            prev = curr;
            curr = curr.next;
            next = curr.next;
        }   

        // System.out.println("val = "+curr.val + " prev = "+prev.val);

        // if(next!=null){

            prev.next = next;
        // }

        return head;

    }
}
