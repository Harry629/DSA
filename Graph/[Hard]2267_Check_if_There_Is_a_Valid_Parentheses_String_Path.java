// A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:

// It is ().
// It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
// It can be written as (A), where A is a valid parentheses string.
// You are given an m x n matrix of parentheses grid. A valid parentheses string path in the grid is a path satisfying all of the following conditions:

// The path starts from the upper left cell (0, 0).
// The path ends at the bottom-right cell (m - 1, n - 1).
// The path only ever moves down or right.
// The resulting parentheses string formed by the path is valid.
// Return true if there exists a valid parentheses string path in the grid. Otherwise, return false.

------------------------------------------ Code --------------------------------------------------------------------
  class Solution {
    int[] x = {0, 1};
    int[] y = {1,0};
    Queue<Pair> q = new LinkedList<>();

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] dp = new boolean[m+1][n+1][m+n];
        
        if(grid[0][0]=='('){
            q.add(new Pair(0,0,1));
            dp[0][0][1]= true;
        }
        while(!q.isEmpty()){
            int s = q.size();
            while(s-- > 0){
                Pair p = q.poll();
                int row = p.row;
                int col = p.col;
                int count = p.count;
                for(int i=0;i<2;i++){
                    int newRow = row + x[i];
                    int newCol = col + y[i];
                    int newCount =0;
                    if(valid(newRow, newCol,grid.length,grid[0].length)){
                        if(grid[newRow][newCol]==')'){
                            newCount = count -1;
                            if(newCount>=0 && dp[newRow][newCol][newCount]!= true){
                                q.add(new Pair(newRow, newCol, newCount));
                                dp[newRow][newCol][newCount]= true;
                            }
                        }else if(grid[newRow][newCol]=='('){
                            newCount = count+1;
                            if(dp[newRow][newCol][newCount]!= true){
                                q.add(new Pair(newRow,newCol, newCount));
                                dp[newRow][newCol][newCount]= true;
                            }
                        }
                    }
                    if(newRow == grid.length-1 && newCol == grid[0].length-1){
                        if(newCount ==0){
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    class Pair{
        int row;
        int col;
        int count;
        Pair(int row, int col, int count){
            this.row = row;
            this.col= col;
            this.count = count;
        }
    }
    public boolean valid(int i, int j, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        return true;
    }
}
  
