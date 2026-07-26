// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// You may assume that you have an infinite number of each kind of coin.

class Solution {
    static final int INF = 1000000000;
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = coinCount(coins.length-1, amount, coins,dp);
        if(ans >= INF ) return -1;
        return ans;
    }
    public int coinCount(int idx, int amount, int[] coins, int[][] dp){
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        if(idx==0){
            if(amount%coins[idx]==0){
                return dp[idx][amount] = amount/coins[idx];
            }
            return dp[idx][amount] = INF;
        }
        int notTake = coinCount(idx-1,amount, coins,dp);
        int take = INF;
        if(coins[idx] <= amount){
            take = 1 + coinCount(idx, amount- coins[idx], coins,dp);
        }
        return dp[idx][amount] = Math.min(notTake, take);
    }
}
