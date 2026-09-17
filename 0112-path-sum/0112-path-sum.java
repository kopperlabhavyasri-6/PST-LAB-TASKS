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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. Base case: If the root is null, no path exists
        if (root == null) {
            return false;
        }
        
        // 2. If it's a leaf node, check if its value matches the remaining target sum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        // 3. Subtract current node's value from targetSum and recurse down left and right subtrees
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}

