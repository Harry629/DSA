You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.

 

Example 1:

Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].


  class Solution {
    int n;
    int[][] dp = new int[1001][1001];
    public int rec(int[][] nums, int n, int i,int p){
        if(i>=n){
            return 0;
        }
        if(p!=-1 && dp[i][p]!=-1) return dp[i][p];
        int take =0;
        if(p==-1 || nums[i][0]> nums[p][1]){
            take = 1+  rec(nums,n,i+1,i);
        }
        int skip = rec(nums,n,i+1,p);
        if(p!=-1){
            dp[i][p]=Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
    public int findLongestChain(int[][] pairs) {
        int n= pairs.length;
        Arrays.sort(pairs, (a,b)-> {
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }else{
                return Integer.compare(a[1],b[1]);
            }
        });
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(pairs,n,0,-1);

    }
}
