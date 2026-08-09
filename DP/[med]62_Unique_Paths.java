// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

// The test cases are generated so that the answer will be less than or equal to 2 * 109.

//   --------------------- recursion and dp -----------------------------

  class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return numOfWays(0,0,m-1, n-1, dp);
    }
    public int numOfWays(int i, int j, int m, int n,int[][] dp){
        if(i<0 || j<0 || i>m || j>n) return 0;
        if(dp[i][j]!= -1) return dp[i][j];
        if(i==m && j == n) return dp[i][j]=1;
        int tL = numOfWays(i,j+1, m, n,dp);
        int tD = numOfWays(i+1, j, m, n,dp);
        return dp[i][j]=tL + tD;
    }
}

--------------------- tabulation --------------------------- 

  class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<m;i++){
            dp[i][n-1]= 1;
        }
        for(int j=0;j<n;j++){
            dp[m-1][j]=1;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i<0 || i>=m-1 || j<0 || j>=n-1){
                    continue;
                }
                else{
                    dp[i][j]= dp[i+1][j]+ dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
