import java.util.List;
import java.util.ArrayList;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            dfs(root, "", result);
        }
        return result;
    }
    
    private void dfs(TreeNode node, String currentPath, List<String> result) {
        // 1. Build the path string
        if (currentPath.isEmpty()) {
            currentPath = Integer.toString(node.val);
        } else {
            currentPath = currentPath + "->" + node.val;
        }
        
        // 2. If it's a leaf node, add the completed path to our result list
        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }
        
        // 3. Recursively traverse left and right subtrees if they exist
        if (node.left != null) {
            dfs(node.left, currentPath, result);
        }
        if (node.right != null) {
            dfs(node.right, currentPath, result);
        }
    }
}