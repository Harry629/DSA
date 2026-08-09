You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

------------------ recursion and dp-------------------------
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
    public int maxP(int[] prices, int i, int k, int[][] dp){
        if(i==n) return dp[i][k]= 0;
        if(k==0) return dp[i][k]=0;
        if( dp[i][k]!= -1) return dp[i][k];
        if(k==2){
            int take = maxP(prices, i+1, k-1,dp) - prices[i];
            int skip = maxP(prices, i+1,k,dp);
            return dp[i][k]=Math.max(take,skip);
        }
        else{
            int take = maxP(prices, i+1, k-1,dp) + prices[i];
            int skip = maxP(prices, i+1, k,dp);
            return dp[i][k]=Math.max(take,skip);
        }
        
    }
}


-------------------------- tabulation ----------------------------------

class Solution {
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        int[][] dp = new int[n+1][3];
        for(int j=0;j<3;j++){
            dp[n][j]=0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<3;j++){
                if(j==2){
                    dp[i][j]= Math.max(dp[i+1][j-1]- prices[i], dp[i+1][j]);
                }else{
                    dp[i][j]= Math.max(dp[i+1][j-1]+prices[i], dp[i+1][j]);
                }
            }
        }
        return dp[0][2];
    }
    
}
