Given two positive integers n and x.
Return the number of ways n can be expressed as the sum of the xth power of unique positive integers, in other words, the number of sets of unique integers
[n1, n2, ..., nk] where n = n1x + n2x + ... + nkx.
Since the result can be very large, return it modulo 109 + 7.
For example, if n = 160 and x = 3, one way to express n is n = 23 + 33 + 53.

  Example 1:

Input: n = 10, x = 2
Output: 1
Explanation: We can express n as the following: n = 32 + 12 = 10.
It can be shown that it is the only way to express 10 as the sum of the 2nd power of unique integers.

  class Solution {
    int m = 1000000007;
    int[][] dp = new int[301][301];
    public int numberOfWays(int n, int x) {
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return solve(n,1,x);
    }
    public int solve(int n, int num,int x){
        if(n==0){
            return 1;
        }
        if(n< (int)Math.pow(num,x) || n<num || n<0){
            return 0;
        } 
        if(dp[n][num]!= -1) return dp[n][num];
        int take = solve(n-(int)Math.pow(num,x),num+1,x);
        int skip = solve(n, num+1,x);

        return dp[n][num]=(take+skip)%m;
    }
}
