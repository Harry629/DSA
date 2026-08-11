// Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
// Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
// You should perform the cuts in order, you can change the order of the cuts as you wish.
// The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will
// be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example 
// for a better explanation.
// Return the minimum total cost of the cuts.

------------- recursion and dp ---------------------------
  class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length+2;
        int[] arr = new int[m];
        arr[0]=0;
        System.arraycopy(cuts, 0, arr, 1, cuts.length);
        arr[m-1]=n;
        Arrays.sort(arr);
        int[][] dp = new int[m][m];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return minC(n,arr, 1, arr.length-2, dp);
    }
    public int minC(int n, int[] cuts, int i, int j, int[][] dp){
        if(i>j) return 0;
        int res = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<=j;k++){
            int cost = cuts[j+1]-cuts[i-1];
            int r = cost + minC(n, cuts,i,k-1,dp)+ minC(n, cuts, k+1,j,dp);
            res = Math.min(r, res);
        }
        return dp[i][j]=res;
    }
}
