You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:


You should build the array arr which has the following properties:

arr has exactly n integers.
1 <= arr[i] <= m where (0 <= i < n).
After applying the mentioned algorithm to arr, the value search_cost is equal to k.
Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 109 + 7.

 

Example 1:

Input: n = 2, m = 3, k = 1
Output: 6
Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]

  class Solution {
    int N,M,K;
    int MOD = 1000000007;
    int[][][] dp = new int[51][51][101];
    public int solve(int idx, int searchCost, int maxSoFar){
        if(idx==N){
            if(searchCost ==K) return 1;
            return 0;
        }
        if(dp[idx][searchCost][maxSoFar]!= -1)
            return dp[idx][searchCost][maxSoFar];
        int result =0;
        for(int i=1;i<=M;i++){
            
            if(i>maxSoFar){
                result = (result+solve(idx+1, searchCost+1, i))%MOD;
            }else{
                result =(result+ solve(idx+1, searchCost, maxSoFar)) %MOD;
            }
        }
        return dp[idx][searchCost][maxSoFar]=result % MOD;
    } 
    public int numOfArrays(int n, int m, int k) {
        N=n;
        M=m;
        K=k;
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0,0,0);
    }
}
