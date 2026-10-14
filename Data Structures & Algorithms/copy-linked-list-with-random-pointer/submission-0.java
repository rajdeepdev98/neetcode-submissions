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


        HashMap<Node, Node>oldToNew = new HashMap<>();

        Node temp = head;
        Node dummy = new Node(0);
        Node prev = dummy;

        while(temp!=null){

            Node curr = new Node(temp.val);

            oldToNew.put(temp,curr);
            prev.next = curr;

            prev = curr;
            temp = temp.next;




        }


        temp = head;
        while(temp!=null){

            Node newNode = oldToNew.get(temp);

            Node randomOld = temp.random;
            if(randomOld!=null){
                newNode.random = oldToNew.get(randomOld);
            }
            temp = temp.next;
        }
        return dummy.next;


        

        
        
    }
}
