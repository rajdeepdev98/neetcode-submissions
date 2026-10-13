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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>>ans = new ArrayList<>();

        Deque<TreeNode>queue = new ArrayDeque<>();

        if(root!=null)queue.offer(root);
        else return ans;

        while(!queue.isEmpty()){

            int levelCnt = queue.size();

            List<Integer>levelList = new ArrayList<>();

            for(int i = 0;i<levelCnt;i++){

                TreeNode node = queue.poll();

                levelList.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            ans.add(levelList);
        }
        return ans;

        
    }
}
