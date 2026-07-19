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
    int count=0;
    public int postOrder(TreeNode root)
    {
        if(root==null)
            return Integer.MIN_VALUE;

        if(root.left==null && root.right==null)
        {
            count++;
            return root.val;
        }

        int maxLeft= postOrder(root.left);
        int maxRight= postOrder(root.right);

        if(root.val >= maxLeft && root.val >= maxRight)
            count++;

        return Math.max(root.val, Math.max(maxLeft, maxRight));
    }
    
    public int countDominantNodes(TreeNode root) {
        postOrder(root);
        return count;
    }
}