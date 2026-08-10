You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can sell and buy the stock multiple times on the same day, ensuring you never hold more than one share of the stock.
Find and return the maximum profit you can achieve.

---------------------------- recursion and dp --------------------------------------------------------------------------------
  class Solution {
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        int[][] dp = new int[n+1][3];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxP(prices, 0, 2,dp);
    }
    public int maxP(int[] prices, int i, int k,int[][] dp){
        if(i==n) return dp[i][k]=0;
        if(dp[i][k]!=-1) return dp[i][k];
        if(k==2){
            int buy = maxP(prices, i+1, k-1,dp) - prices[i];
            int skip = maxP(prices, i+1, k,dp);
            return dp[i][k]=Math.max(skip, buy);
        }else{
            int sell= maxP(prices, i+1, k+1,dp) + prices[i];
            int skip = maxP(prices, i+1,k,dp);
            return dp[i][k]=Math.max(sell, skip);
        }
    }
}

