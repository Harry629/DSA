// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the
// number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// -----answer---------

class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid, grid.length, grid[0].length, i,j,visited);
                }
            }
        }
        return count;
    }
    public boolean valid(int i,int j,int m, int n){
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        return true;
    }
    public void dfs(char[][] grid, int m,int n, int i, int j, boolean[][] visited){
        visited[i][j]= true;
        for(int k=0;k<4;k++){
            int row = i+ x[k];
            int col = j+ y[k];
            if(valid(row, col, m, n) && grid[row][col]=='1' && !visited[row][col]){
                dfs(grid,m, n, row, col, visited);
            }
        }
        return;
    }
}