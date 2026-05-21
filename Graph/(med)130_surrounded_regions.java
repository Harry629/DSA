// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board.
// Such regions are completely enclosed by 'X' cells.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board.
// You do not need to return anything.

class Solution {
    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int a =0;a<board[0].length;a++){
            if(board[0][a]=='O'){
                dfs(board,m,n,0,a);
            }
        }
        for(int a =0;a<board[0].length;a++){
            if(board[m-1][a]=='O'){
                dfs(board,m,n,m-1,a);
            }
        }
        for(int a =0;a<board.length;a++){
            if(board[a][0]=='O'){
                dfs(board,m,n,a,0);
            }
        }
        for(int a =0;a<board.length;a++){
            if(board[a][n-1]=='O'){
                dfs(board,m,n,a,n-1);
            }
        }
        for(int a=0;a<board.length;a++){
            for(int b = 0;b<board[0].length;b++){
                if(board[a][b]=='O'){
                    board[a][b]='X';
                }
                if(board[a][b]=='#'){
                    board[a][b]='O';
                }
            }
        }

        
    }
    public boolean isValid(int i, int j, int m, int n){
        if(i>=0 && i<m && j>=0 && j<n){
            return true;
        }
        return false;
    }
    public void dfs(char[][] board, int m, int n,int i, int j){
        board[i][j] = '#';
        for(int k=0;k<4;k++){
            int row = i + x[k];
            int col = j+ y[k];
            if(isValid(row, col, m,n) && board[row][col]=='O'){
                dfs(board,m,n,row,col);
            }
        }
        return;
    }
}