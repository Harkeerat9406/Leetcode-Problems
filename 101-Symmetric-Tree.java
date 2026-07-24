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
    public boolean dfs(TreeNode leftTree, TreeNode rightTree)
    {
        if(leftTree==null && rightTree==null)
            return true;
        
        if(leftTree==null || rightTree==null)
            return false;
        
        if(leftTree.val!=rightTree.val) 
            return false;
        
        boolean inner= dfs(leftTree.right, rightTree.left);
        boolean outer= dfs(leftTree.left, rightTree.right);

        return inner && outer;
    }
    
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }
}