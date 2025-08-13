Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

-------------- Using Memoization -------------
  class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < dp.length; i++) {
        Arrays.fill(dp[i], -1);
        }
        return rec(nums,n,0,-1,dp);
    }
    int rec(int[] nums, int n, int i,int p,int[][] dp){
        if(i>=n){
            return 0;
        }
        if(p!=-1 && dp[i][p]!=-1) return dp[i][p];
        int take =0;
        if(p==-1 || nums[i]> nums[p]){
            take = 1+  rec(nums,n,i+1,i,dp);
        }
        int skip = rec(nums,n,i+1,p,dp);
        if(p!=-1){
            dp[i][p]=Math.max(take, skip);
        }
        return Math.max(take, skip);
    }
}

------------------- Using Bottom-Up Approach -------------------------------

  class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] t = new int[nums.length];
        Arrays.fill(t,1);
        int max = 1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    t[i]= Math.max(t[i],t[j]+1);
                    max = Math.max(max,t[i]);
                }
            }
        }
        return max;
    }
}
