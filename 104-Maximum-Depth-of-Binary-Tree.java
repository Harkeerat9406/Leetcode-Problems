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
    int ans=0;
    public void dfs(TreeNode root, int depth)
    {
        if(root==null)
            return;
        
        depth= depth+1;
        ans= Math.max(ans, depth);

        dfs(root.left, depth);
        dfs(root.right, depth);
    }

    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;

        dfs(root, 0);
        return ans;
    }
}