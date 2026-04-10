// Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

// For each node at position (row, col), its left and right children will be at positions
// (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

// The vertical order traversal of a binary tree is a list of top-to-bottom orderings for
// each column index starting from the leftmost column and ending on the rightmost column.
// There may be multiple nodes in the same row and same column. In such a case, sort these
// nodes by their values.

// Return the vertical order traversal of the binary tree.

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
    int minPos =0;
    int maxPos =0;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root ==null){
            return new ArrayList<>();
        }
         // write your code here
        //  1. calculate minPos, maxPos
        //  1.1-> noOfVerticalLevles = maxPos-minPos+1
        // 2. ArrayList<ArrayList<Integer>> ->
        // 3. Pair class -> TreeNode, int verticalPos
        // 4 LEVEL ORDER traversal
        // 4.1 Insert the node val into ArrayList based on vertical pos
        updatePos(root,0);
        int noOfVerticalLevles = maxPos-minPos+1;
        List<List<Pair>> vertical = new ArrayList<>();
        for(int i=0;i<noOfVerticalLevles;i++){
            vertical.add(new ArrayList<>());
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0, - minPos));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int col = curr.col;
            int row = curr.row;
            vertical.get(col).add(new Pair(node, row, col));
            if(node.left != null){
                q.add(new Pair(node.left, row+1,col-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, row+1,col+1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(List<Pair> list: vertical){
            Collections.sort(list, (a,b)->{
                if(a.row == b.row){
                    return a.node.val - b.node.val; // sort by value
                }
                return a.row-b.row; //sort by row
            });
            List<Integer> colList = new ArrayList<>();
            for (Pair p : list) {
                colList.add(p.node.val);
            }
            result.add(colList);
        }
        return result;
    }
    public void updatePos(TreeNode root, int position){
        if(root ==null){
            return;
        }
        minPos = Math.min(minPos, position);
        maxPos = Math.max(maxPos, position);

        updatePos(root.left, position-1);
        updatePos(root.right, position+1);
    }
}
class Pair{
    int row;
    int col;
    TreeNode node;
    public Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}