/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    boolean isGreaterThanBoth(TreeNode curr, TreeNode p, TreeNode q){

        return curr!= null && curr.val> p.val && curr.val>q.val;
    }
    boolean isSmallerThanBoth(TreeNode curr, TreeNode p, TreeNode q){

        return curr!=null && curr.val < p.val && curr.val < q.val;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        

        TreeNode temp = root;
        TreeNode ans = temp;
        while(temp!=null ){

            ans = temp;

            if(isGreaterThanBoth(temp,p, q)){
                // ans = temp;
                temp = temp.left;
            }
            else if(isSmallerThanBoth(temp,p, q)){
                // ans = temp;
                temp = temp.right;
            }
            else break;

        }
        return ans;
    }
}
