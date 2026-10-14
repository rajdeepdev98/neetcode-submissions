/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create copies and interleave them
        Node curr = head;

        while (curr != null) {
            Node copy = new Node(curr.val);

            copy.next = curr.next;
            curr.next = copy;

            curr = copy.next;
        }

        // Step 2: Assign random pointers to copied nodes
        curr = head;

        while (curr != null) {
            Node copy = curr.next;

            if (curr.random != null) {
                copy.random = curr.random.next;
            }

            curr = copy.next;
        }

        // Step 3: Separate the original and copied lists
        curr = head;
        Node copyHead = head.next;

        while (curr != null) {
            Node copy = curr.next;

            curr.next = copy.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
            }

            curr = curr.next;
        }

        return copyHead;
    }
}