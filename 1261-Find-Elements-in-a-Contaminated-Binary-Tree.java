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
class FindElements {
    TreeNode root;
    HashSet<Integer> set= new HashSet<>();

    public void recover(TreeNode root)
    {
        if(root==null)
            return;
        
        if(root.left!=null)
        {
            root.left.val= root.val * 2 + 1;
            set.add(root.left.val);
        }
        
        if(root.right!=null)
        {
            root.right.val= root.val * 2 + 2;
            set.add(root.right.val);
        }
        
        recover(root.left);
        recover(root.right);
    }

    public FindElements(TreeNode root) {
        this.root= root;
        root.val= 0;
        set.add(0);
        recover(root);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */