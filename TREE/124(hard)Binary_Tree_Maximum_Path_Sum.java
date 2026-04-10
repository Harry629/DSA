// A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in
// the sequence has an edge connecting them. A node can only appear in the sequence at most once.
//  Note that the path does not need to pass through the root.

// The path sum of a path is the sum of the node's values in the path.

// Given the root of a binary tree, return the maximum path sum of any non-empty path.

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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return ans;
    }
    public int maxPathSumUtil(TreeNode root){
        if(root == null){
            return 0;
        }
        int lstSum = maxPathSumUtil(root.left);
        int rstSum = maxPathSumUtil(root.right);

        int maxSumFromOneSide = root.val+Math.max(lstSum, rstSum);
        maxSumFromOneSide = Math.max(root.val , maxSumFromOneSide);
        int sumThroughRoot = root.val + rstSum + lstSum;
        ans = Math.max(ans, Math.max(sumThroughRoot, maxSumFromOneSide));

        return maxSumFromOneSide;
    }
}