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
    public boolean isSymmetric(TreeNode root) {
        // If the tree is empty, it is symmetric
        if (root == null) {
            return true;
        }
        // Start checking mirror properties from the root's left and right children
        return isMirror(root.left, root.right);
    }
    
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // 1. If both nodes are null, they match
        if (t1 == null && t2 == null) {
            return true;
        }
        
        // 2. If only one node is null or their values don't match, it's not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) {
            return false;
        }
        
        // 3. Recursively check:
        // - Left child of t1 with right child of t2
        // - Right child of t1 with left child of t2
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}