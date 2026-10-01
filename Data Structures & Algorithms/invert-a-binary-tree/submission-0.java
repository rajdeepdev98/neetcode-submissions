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
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)return root;
        else{

            TreeNode left = root.left;
            TreeNode right = root.right;
            TreeNode temp = left;
            left = right;
            right = temp;
            root.left = left;
            root.right = right;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
