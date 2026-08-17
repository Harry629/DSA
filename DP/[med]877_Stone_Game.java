Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row.
This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.

-------------------------------- dp ---------------------------------------------
  class Solution {
    int n;
    public boolean stoneGame(int[] piles) {
        n= piles.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        int alice = solve(piles, 0, n-1,dp);
        int sum =0;
        for(int i: piles){
            sum += i;
        }
        int bob = sum - alice;
        return alice>bob;
    }
    public int solve(int[] piles, int i, int j, int[][] dp){
        if(i>=n || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int take_i = piles[i] + Math.min(solve(piles, i+2, j,dp), solve(piles, i+1, j-1,dp));
        int take_j = piles[j] + Math.min(solve(piles, i+1,j-1,dp), solve(piles, i,j-2,dp));
        return dp[i][j] = Math.max(take_i, take_j);
    }
}
