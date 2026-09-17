/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. Base cases: if root is null, or matches p or q, return root
        if (root == null || root == p || root == q) {
            return root;
        }
        
        // 2. Recursively search left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // 3. If both left and right returns are non-null, p and q are in separate subtrees
        // This means the current root is their lowest common ancestor
        if (left != null && right != null) {
            return root;
        }
        
        // 4. Otherwise, return the non-null child (or null if both were null)
        return left != null ? left : right;
    }
}