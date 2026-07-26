// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

// You may assume that you have an infinite number of each kind of coin.

// The final answer is guaranteed to fit into a signed 32-bit integer.

class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans= coin(amount, coins, coins.length-1,dp);
        return ans;
    }
    public int coin(int amount, int[] coins, int idx,int[][] dp){
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        if(idx==0){
            if(amount % coins[idx]==0){
                return dp[idx][amount]= 1;
            }
            return dp[idx][amount]= 0;
        }
        int notTake = coin(amount, coins, idx-1,dp);
        int take = 0;
        if(amount >= coins[idx]){
            take = coin(amount-coins[idx], coins, idx,dp);
        }
        if(amount ==0){
            return dp[idx][amount]=1;
        }
        return dp[idx][amount]=take + notTake;
    }
}
