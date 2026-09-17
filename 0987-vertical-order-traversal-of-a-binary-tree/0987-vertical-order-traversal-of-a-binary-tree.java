import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
    
    // Helper class to store node details: row, column, and value
    private static class NodeInfo {
        int row;
        int col;
        int val;
        
        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> list = new ArrayList<>();
        
        // 1. Traverse the tree and record coordinates (row, col) for each node
        dfs(root, 0, 0, list);
        
        // 2. Sort the nodes based on the problem's rules:
        //    - First by column (left to right)
        //    - Then by row (top to bottom)
        //    - Finally by node value (ascending if row and col are the same)
        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            } else if (a.row != b.row) {
                return Integer.compare(a.row, b.row);
            } else {
                return Integer.compare(a.val, b.val);
            }
        });
        
        // 3. Group the sorted nodes into columns for the final output
        List<List<Integer>> result = new ArrayList<>();
        if (list.isEmpty()) {
            return result;
        }
        
        int prevCol = Integer.MIN_VALUE;
        List<Integer> currentColList = null;
        
        for (NodeInfo node : list) {
            if (node.col != prevCol) {
                currentColList = new ArrayList<>();
                result.add(currentColList);
                prevCol = node.col;
            }
            currentColList.add(node.val);
        }
        
        return result;
    }
    
    private void dfs(TreeNode node, int row, int col, List<NodeInfo> list) {
        if (node == null) {
            return;
        }
        
        // Store current node's coordinates and value
        list.add(new NodeInfo(row, col, node.val));
        
        // Recurse left: row increases by 1, column decreases by 1
        dfs(node.left, row + 1, col - 1, list);
        
        // Recurse right: row increases by 1, column increases by 1
        dfs(node.right, row + 1, col + 1, list);
    }
}